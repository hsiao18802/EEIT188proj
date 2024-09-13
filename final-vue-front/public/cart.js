class CartRemoveButton extends HTMLElement {
  constructor() {
    super(),
      this.addEventListener("click", (event) => {
        event.preventDefault(),
          (
            this.closest("cart-items") || this.closest("cart-drawer-items")
          ).updateQuantity(this.dataset.index, 0);
      });
  }
}
customElements.define("cart-remove-button", CartRemoveButton);
class CartItems extends HTMLElement {
  constructor() {
    super(),
      (this.lineItemStatusElement =
        document.getElementById("shopping-cart-line-item-status") ||
        document.getElementById("CartDrawer-LineItemStatus"));
    const debouncedOnChange = debounce((event) => {
      this.onChange(event);
    }, ON_CHANGE_DEBOUNCE_TIMER);
    this.addEventListener("change", debouncedOnChange.bind(this));
  }
  cartUpdateUnsubscriber = void 0;
  connectedCallback() {
    this.cartUpdateUnsubscriber = subscribe(
      PUB_SUB_EVENTS.cartUpdate,
      (event) => {
        event.source !== "cart-items" && this.onCartUpdate();
      }
    );
  }
  disconnectedCallback() {
    this.cartUpdateUnsubscriber && this.cartUpdateUnsubscriber();
  }
  onChange(event) {
    this.updateQuantity(
      event.target.dataset.index,
      event.target.value,
      document.activeElement.getAttribute("name"),
      event.target.dataset.quantityVariantId
    );
  }
  onCartUpdate() {
    this.tagName === "CART-DRAWER-ITEMS"
      ? fetch(`${routes.cart_url}?section_id=cart-drawer`)
          .then((response) => response.text())
          .then((responseText) => {
            const html = new DOMParser().parseFromString(
                responseText,
                "text/html"
              ),
              selectors = ["cart-drawer-items", ".cart-drawer__footer"];
            for (const selector of selectors) {
              const targetElement = document.querySelector(selector),
                sourceElement = html.querySelector(selector);
              targetElement &&
                sourceElement &&
                targetElement.replaceWith(sourceElement);
            }
          })
          .catch((e) => {
            console.error(e);
          })
      : fetch(`${routes.cart_url}?section_id=main-cart-items`)
          .then((response) => response.text())
          .then((responseText) => {
            const sourceQty = new DOMParser()
              .parseFromString(responseText, "text/html")
              .querySelector("cart-items");
            this.innerHTML = sourceQty.innerHTML;
          })
          .catch((e) => {
            console.error(e);
          });
  }
  getSectionsToRender() {
    return [
      {
        id: "main-cart-items",
        section: document.getElementById("main-cart-items").dataset.id,
        selector: ".js-contents",
      },
      {
        id: "cart-icon-bubble",
        section: "cart-icon-bubble",
        selector: ".shopify-section",
      },
      {
        id: "cart-live-region-text",
        section: "cart-live-region-text",
        selector: ".shopify-section",
      },
      {
        id: "main-cart-footer",
        section: document.getElementById("main-cart-footer").dataset.id,
        selector: ".js-contents",
      },
    ];
  }
  updateQuantity(line, quantity, name, variantId) {
    this.enableLoading(line);
    const body = JSON.stringify({
      line,
      quantity,
      sections: this.getSectionsToRender().map((section) => section.section),
      sections_url: window.location.pathname,
    });
    fetch(`${routes.cart_change_url}`, { ...fetchConfig(), body })
      .then((response) => response.text())
      .then((state) => {
        const parsedState = JSON.parse(state),
          quantityElement =
            document.getElementById(`Quantity-${line}`) ||
            document.getElementById(`Drawer-quantity-${line}`),
          items = document.querySelectorAll(".cart-item");
        if (parsedState.errors) {
          (quantityElement.value = quantityElement.getAttribute("value")),
            this.updateLiveRegions(line, parsedState.errors);
          return;
        }
        this.classList.toggle("is-empty", parsedState.item_count === 0);
        const cartDrawerWrapper = document.querySelector("cart-drawer"),
          cartFooter = document.getElementById("main-cart-footer");
        cartFooter &&
          cartFooter.classList.toggle("is-empty", parsedState.item_count === 0),
          cartDrawerWrapper &&
            cartDrawerWrapper.classList.toggle(
              "is-empty",
              parsedState.item_count === 0
            ),
          this.getSectionsToRender().forEach((section) => {
            const elementToReplace =
              document
                .getElementById(section.id)
                .querySelector(section.selector) ||
              document.getElementById(section.id);
            elementToReplace.innerHTML = this.getSectionInnerHTML(
              parsedState.sections[section.section],
              section.selector
            );
          });
        const updatedValue = parsedState.items[line - 1]
          ? parsedState.items[line - 1].quantity
          : void 0;
        let message = "";
        items.length === parsedState.items.length &&
          updatedValue !== parseInt(quantityElement.value) &&
          (typeof updatedValue > "u"
            ? (message = window.cartStrings.error)
            : (message = window.cartStrings.quantityError.replace(
                "[quantity]",
                updatedValue
              ))),
          this.updateLiveRegions(line, message);
        const lineItem =
          document.getElementById(`CartItem-${line}`) ||
          document.getElementById(`CartDrawer-Item-${line}`);
        lineItem && lineItem.querySelector(`[name="${name}"]`)
          ? cartDrawerWrapper
            ? trapFocus(
                cartDrawerWrapper,
                lineItem.querySelector(`[name="${name}"]`)
              )
            : lineItem.querySelector(`[name="${name}"]`).focus()
          : parsedState.item_count === 0 && cartDrawerWrapper
          ? trapFocus(
              cartDrawerWrapper.querySelector(".drawer__inner-empty"),
              cartDrawerWrapper.querySelector("a")
            )
          : document.querySelector(".cart-item") &&
            cartDrawerWrapper &&
            trapFocus(
              cartDrawerWrapper,
              document.querySelector(".cart-item__name")
            ),
          publish(PUB_SUB_EVENTS.cartUpdate, {
            source: "cart-items",
            cartData: parsedState,
            variantId,
          });
      })
      .catch(() => {
        this.querySelectorAll(".loading-overlay").forEach((overlay) =>
          overlay.classList.add("hidden")
        );
        const errors =
          document.getElementById("cart-errors") ||
          document.getElementById("CartDrawer-CartErrors");
        errors.textContent = window.cartStrings.error;
      })
      .finally(() => {
        this.disableLoading(line);
      });
  }
  updateLiveRegions(line, message) {
    const lineItemError =
      document.getElementById(`Line-item-error-${line}`) ||
      document.getElementById(`CartDrawer-LineItemError-${line}`);
    lineItemError &&
      (lineItemError.querySelector(".cart-item__error-text").innerHTML =
        message),
      this.lineItemStatusElement.setAttribute("aria-hidden", !0);
    const cartStatus =
      document.getElementById("cart-live-region-text") ||
      document.getElementById("CartDrawer-LiveRegionText");
    cartStatus.setAttribute("aria-hidden", !1),
      setTimeout(() => {
        cartStatus.setAttribute("aria-hidden", !0);
      }, 1e3);
  }
  getSectionInnerHTML(html, selector) {
    return new DOMParser()
      .parseFromString(html, "text/html")
      .querySelector(selector).innerHTML;
  }
  enableLoading(line) {
    (
      document.getElementById("main-cart-items") ||
      document.getElementById("CartDrawer-CartItems")
    ).classList.add("cart__items--disabled");
    const cartItemElements = this.querySelectorAll(
        `#CartItem-${line} .loading-overlay`
      ),
      cartDrawerItemElements = this.querySelectorAll(
        `#CartDrawer-Item-${line} .loading-overlay`
      );
    [...cartItemElements, ...cartDrawerItemElements].forEach((overlay) =>
      overlay.classList.remove("hidden")
    ),
      document.activeElement.blur(),
      this.lineItemStatusElement.setAttribute("aria-hidden", !1);
  }
  disableLoading(line) {
    (
      document.getElementById("main-cart-items") ||
      document.getElementById("CartDrawer-CartItems")
    ).classList.remove("cart__items--disabled");
    const cartItemElements = this.querySelectorAll(
        `#CartItem-${line} .loading-overlay`
      ),
      cartDrawerItemElements = this.querySelectorAll(
        `#CartDrawer-Item-${line} .loading-overlay`
      );
    cartItemElements.forEach((overlay) => overlay.classList.add("hidden")),
      cartDrawerItemElements.forEach((overlay) =>
        overlay.classList.add("hidden")
      );
  }
}
customElements.define("cart-items", CartItems),
  customElements.get("cart-note") ||
    customElements.define(
      "cart-note",
      class extends HTMLElement {
        constructor() {
          super(),
            this.addEventListener(
              "change",
              debounce((event) => {
                const body = JSON.stringify({ note: event.target.value });
                fetch(`${routes.cart_update_url}`, { ...fetchConfig(), body });
              }, ON_CHANGE_DEBOUNCE_TIMER)
            );
        }
      }
    );
//# sourceMappingURL=/cdn/shop/t/1/assets/cart.js.map?v=4193034376803868811697839526
