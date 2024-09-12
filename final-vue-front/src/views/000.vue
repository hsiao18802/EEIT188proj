<script setup>

</script>

<script type="application/ld+json">
{
  "@context": "https:\/\/schema.org",
  "@type": "Organization",
  "name": "InstaGear Outdoor Rentals",
  "url": "https:\/\/instagearoutdoors.com",
  "alternateName": "InstaGear Outdoor Rentals",
  "description": "InstaGear Outdoor Rentals",
  "logo": "https:\/\/instagearoutdoors.com\/wp-content\/uploads\/2022\/02\/cropped-4.png",
  "sameAs": [
    "https:\/\/www.facebook.com\/InstaGearOutdoors",
    "https:\/\/www.instagram.com\/instagearoutdoors\/"
  ],
  "contactPoint": [
    { "@type": "ContactPoint", "contactType": "customer support" }
  ]
}
</script>
<script type="text/javascript">
window._wpemojiSettings = {
  baseUrl: "https:\/\/s.w.org\/images\/core\/emoji\/14.0.0\/72x72\/",
  ext: ".png",
  svgUrl: "https:\/\/s.w.org\/images\/core\/emoji\/14.0.0\/svg\/",
  svgExt: ".svg",
  source: {
    concatemoji:
      "https:\/\/instagearoutdoors.com\/wp-includes\/js\/wp-emoji-release.min.js?ver=6.3.5",
  },
};
/*! This file is auto-generated */
!(function (i, n) {
  var o, s, e;
  function c(e) {
    try {
      var t = { supportTests: e, timestamp: new Date().valueOf() };
      sessionStorage.setItem(o, JSON.stringify(t));
    } catch (e) {}
  }
  function p(e, t, n) {
    e.clearRect(0, 0, e.canvas.width, e.canvas.height),
      e.fillText(t, 0, 0);
    var t = new Uint32Array(
        e.getImageData(0, 0, e.canvas.width, e.canvas.height).data
      ),
      r =
        (e.clearRect(0, 0, e.canvas.width, e.canvas.height),
        e.fillText(n, 0, 0),
        new Uint32Array(
          e.getImageData(0, 0, e.canvas.width, e.canvas.height).data
        ));
    return t.every(function (e, t) {
      return e === r[t];
    });
  }
  function u(e, t, n) {
    switch (t) {
      case "flag":
        return n(
          e,
          "\ud83c\udff3\ufe0f\u200d\u26a7\ufe0f",
          "\ud83c\udff3\ufe0f\u200b\u26a7\ufe0f"
        )
          ? !1
          : !n(
              e,
              "\ud83c\uddfa\ud83c\uddf3",
              "\ud83c\uddfa\u200b\ud83c\uddf3"
            ) &&
              !n(
                e,
                "\ud83c\udff4\udb40\udc67\udb40\udc62\udb40\udc65\udb40\udc6e\udb40\udc67\udb40\udc7f",
                "\ud83c\udff4\u200b\udb40\udc67\u200b\udb40\udc62\u200b\udb40\udc65\u200b\udb40\udc6e\u200b\udb40\udc67\u200b\udb40\udc7f"
              );
      case "emoji":
        return !n(
          e,
          "\ud83e\udef1\ud83c\udffb\u200d\ud83e\udef2\ud83c\udfff",
          "\ud83e\udef1\ud83c\udffb\u200b\ud83e\udef2\ud83c\udfff"
        );
    }
    return !1;
  }
  function f(e, t, n) {
    var r =
        "undefined" != typeof WorkerGlobalScope &&
        self instanceof WorkerGlobalScope
          ? new OffscreenCanvas(300, 150)
          : i.createElement("canvas"),
      a = r.getContext("2d", { willReadFrequently: !0 }),
      o = ((a.textBaseline = "top"), (a.font = "600 32px Arial"), {});
    return (
      e.forEach(function (e) {
        o[e] = t(a, e, n);
      }),
      o
    );
  }
  function t(e) {
    var t = i.createElement("script");
    (t.src = e), (t.defer = !0), i.head.appendChild(t);
  }
  "undefined" != typeof Promise &&
    ((o = "wpEmojiSettingsSupports"),
    (s = ["flag", "emoji"]),
    (n.supports = { everything: !0, everythingExceptFlag: !0 }),
    (e = new Promise(function (e) {
      i.addEventListener("DOMContentLoaded", e, { once: !0 });
    })),
    new Promise(function (t) {
      var n = (function () {
        try {
          var e = JSON.parse(sessionStorage.getItem(o));
          if (
            "object" == typeof e &&
            "number" == typeof e.timestamp &&
            new Date().valueOf() < e.timestamp + 604800 &&
            "object" == typeof e.supportTests
          )
            return e.supportTests;
        } catch (e) {}
        return null;
      })();
      if (!n) {
        if (
          "undefined" != typeof Worker &&
          "undefined" != typeof OffscreenCanvas &&
          "undefined" != typeof URL &&
          URL.createObjectURL &&
          "undefined" != typeof Blob
        )
          try {
            var e =
                "postMessage(" +
                f.toString() +
                "(" +
                [JSON.stringify(s), u.toString(), p.toString()].join(
                  ","
                ) +
                "));",
              r = new Blob([e], { type: "text/javascript" }),
              a = new Worker(URL.createObjectURL(r), {
                name: "wpTestEmojiSupports",
              });
            return void (a.onmessage = function (e) {
              c((n = e.data)), a.terminate(), t(n);
            });
          } catch (e) {}
        c((n = f(s, u, p)));
      }
      t(n);
    })
      .then(function (e) {
        for (var t in e)
          (n.supports[t] = e[t]),
            (n.supports.everything =
              n.supports.everything && n.supports[t]),
            "flag" !== t &&
              (n.supports.everythingExceptFlag =
                n.supports.everythingExceptFlag && n.supports[t]);
        (n.supports.everythingExceptFlag =
          n.supports.everythingExceptFlag && !n.supports.flag),
          (n.DOMReady = !1),
          (n.readyCallback = function () {
            n.DOMReady = !0;
          });
      })
      .then(function () {
        return e;
      })
      .then(function () {
        var e;
        n.supports.everything ||
          (n.readyCallback(),
          (e = n.source || {}).concatemoji
            ? t(e.concatemoji)
            : e.wpemoji && e.twemoji && (t(e.twemoji), t(e.wpemoji)));
      }));
})((window, document), window._wpemojiSettings);
</script>
<style type="text/css">
img.wp-smiley,
img.emoji {
  display: inline !important;
  border: none !important;
  box-shadow: none !important;
  height: 1em !important;
  width: 1em !important;
  margin: 0 0.07em !important;
  vertical-align: -0.1em !important;
  background: none !important;
  padding: 0 !important;
}
</style>
<style id="wpseopress-local-business-style-inline-css" type="text/css">
span.wp-block-wpseopress-local-business-field {
  margin-right: 8px;
}
</style>
<style id="classic-theme-styles-inline-css" type="text/css">
/*! This file is auto-generated */
.wp-block-button__link {
  color: #fff;
  background-color: #32373c;
  border-radius: 9999px;
  box-shadow: none;
  text-decoration: none;
  padding: calc(0.667em + 2px) calc(1.333em + 2px);
  font-size: 1.125em;
}
.wp-block-file__button {
  background: #32373c;
  color: #fff;
  text-decoration: none;
}
</style>
<style id="global-styles-inline-css" type="text/css">
body {
  --wp--preset--color--black: #000000;
  --wp--preset--color--cyan-bluish-gray: #abb8c3;
  --wp--preset--color--white: #ffffff;
  --wp--preset--color--pale-pink: #f78da7;
  --wp--preset--color--vivid-red: #cf2e2e;
  --wp--preset--color--luminous-vivid-orange: #ff6900;
  --wp--preset--color--luminous-vivid-amber: #fcb900;
  --wp--preset--color--light-green-cyan: #7bdcb5;
  --wp--preset--color--vivid-green-cyan: #00d084;
  --wp--preset--color--pale-cyan-blue: #8ed1fc;
  --wp--preset--color--vivid-cyan-blue: #0693e3;
  --wp--preset--color--vivid-purple: #9b51e0;
  --wp--preset--gradient--vivid-cyan-blue-to-vivid-purple: linear-gradient(
    135deg,
    rgba(6, 147, 227, 1) 0%,
    rgb(155, 81, 224) 100%
  );
  --wp--preset--gradient--light-green-cyan-to-vivid-green-cyan: linear-gradient(
    135deg,
    rgb(122, 220, 180) 0%,
    rgb(0, 208, 130) 100%
  );
  --wp--preset--gradient--luminous-vivid-amber-to-luminous-vivid-orange: linear-gradient(
    135deg,
    rgba(252, 185, 0, 1) 0%,
    rgba(255, 105, 0, 1) 100%
  );
  --wp--preset--gradient--luminous-vivid-orange-to-vivid-red: linear-gradient(
    135deg,
    rgba(255, 105, 0, 1) 0%,
    rgb(207, 46, 46) 100%
  );
  --wp--preset--gradient--very-light-gray-to-cyan-bluish-gray: linear-gradient(
    135deg,
    rgb(238, 238, 238) 0%,
    rgb(169, 184, 195) 100%
  );
  --wp--preset--gradient--cool-to-warm-spectrum: linear-gradient(
    135deg,
    rgb(74, 234, 220) 0%,
    rgb(151, 120, 209) 20%,
    rgb(207, 42, 186) 40%,
    rgb(238, 44, 130) 60%,
    rgb(251, 105, 98) 80%,
    rgb(254, 248, 76) 100%
  );
  --wp--preset--gradient--blush-light-purple: linear-gradient(
    135deg,
    rgb(255, 206, 236) 0%,
    rgb(152, 150, 240) 100%
  );
  --wp--preset--gradient--blush-bordeaux: linear-gradient(
    135deg,
    rgb(254, 205, 165) 0%,
    rgb(254, 45, 45) 50%,
    rgb(107, 0, 62) 100%
  );
  --wp--preset--gradient--luminous-dusk: linear-gradient(
    135deg,
    rgb(255, 203, 112) 0%,
    rgb(199, 81, 192) 50%,
    rgb(65, 88, 208) 100%
  );
  --wp--preset--gradient--pale-ocean: linear-gradient(
    135deg,
    rgb(255, 245, 203) 0%,
    rgb(182, 227, 212) 50%,
    rgb(51, 167, 181) 100%
  );
  --wp--preset--gradient--electric-grass: linear-gradient(
    135deg,
    rgb(202, 248, 128) 0%,
    rgb(113, 206, 126) 100%
  );
  --wp--preset--gradient--midnight: linear-gradient(
    135deg,
    rgb(2, 3, 129) 0%,
    rgb(40, 116, 252) 100%
  );
  --wp--preset--font-size--small: 13px;
  --wp--preset--font-size--medium: 20px;
  --wp--preset--font-size--large: 36px;
  --wp--preset--font-size--x-large: 42px;
  --wp--preset--spacing--20: 0.44rem;
  --wp--preset--spacing--30: 0.67rem;
  --wp--preset--spacing--40: 1rem;
  --wp--preset--spacing--50: 1.5rem;
  --wp--preset--spacing--60: 2.25rem;
  --wp--preset--spacing--70: 3.38rem;
  --wp--preset--spacing--80: 5.06rem;
  --wp--preset--shadow--natural: 6px 6px 9px rgba(0, 0, 0, 0.2);
  --wp--preset--shadow--deep: 12px 12px 50px rgba(0, 0, 0, 0.4);
  --wp--preset--shadow--sharp: 6px 6px 0px rgba(0, 0, 0, 0.2);
  --wp--preset--shadow--outlined: 6px 6px 0px -3px rgba(255, 255, 255, 1),
    6px 6px rgba(0, 0, 0, 1);
  --wp--preset--shadow--crisp: 6px 6px 0px rgba(0, 0, 0, 1);
}
:where(.is-layout-flex) {
  gap: 0.5em;
}
:where(.is-layout-grid) {
  gap: 0.5em;
}
body .is-layout-flow > .alignleft {
  float: left;
  margin-inline-start: 0;
  margin-inline-end: 2em;
}
body .is-layout-flow > .alignright {
  float: right;
  margin-inline-start: 2em;
  margin-inline-end: 0;
}
body .is-layout-flow > .aligncenter {
  margin-left: auto !important;
  margin-right: auto !important;
}
body .is-layout-constrained > .alignleft {
  float: left;
  margin-inline-start: 0;
  margin-inline-end: 2em;
}
body .is-layout-constrained > .alignright {
  float: right;
  margin-inline-start: 2em;
  margin-inline-end: 0;
}
body .is-layout-constrained > .aligncenter {
  margin-left: auto !important;
  margin-right: auto !important;
}
body
  .is-layout-constrained
  > :where(:not(.alignleft):not(.alignright):not(.alignfull)) {
  max-width: var(--wp--style--global--content-size);
  margin-left: auto !important;
  margin-right: auto !important;
}
body .is-layout-constrained > .alignwide {
  max-width: var(--wp--style--global--wide-size);
}
body .is-layout-flex {
  display: flex;
}
body .is-layout-flex {
  flex-wrap: wrap;
  align-items: center;
}
body .is-layout-flex > * {
  margin: 0;
}
body .is-layout-grid {
  display: grid;
}
body .is-layout-grid > * {
  margin: 0;
}
:where(.wp-block-columns.is-layout-flex) {
  gap: 2em;
}
:where(.wp-block-columns.is-layout-grid) {
  gap: 2em;
}
:where(.wp-block-post-template.is-layout-flex) {
  gap: 1.25em;
}
:where(.wp-block-post-template.is-layout-grid) {
  gap: 1.25em;
}
.has-black-color {
  color: var(--wp--preset--color--black) !important;
}
.has-cyan-bluish-gray-color {
  color: var(--wp--preset--color--cyan-bluish-gray) !important;
}
.has-white-color {
  color: var(--wp--preset--color--white) !important;
}
.has-pale-pink-color {
  color: var(--wp--preset--color--pale-pink) !important;
}
.has-vivid-red-color {
  color: var(--wp--preset--color--vivid-red) !important;
}
.has-luminous-vivid-orange-color {
  color: var(--wp--preset--color--luminous-vivid-orange) !important;
}
.has-luminous-vivid-amber-color {
  color: var(--wp--preset--color--luminous-vivid-amber) !important;
}
.has-light-green-cyan-color {
  color: var(--wp--preset--color--light-green-cyan) !important;
}
.has-vivid-green-cyan-color {
  color: var(--wp--preset--color--vivid-green-cyan) !important;
}
.has-pale-cyan-blue-color {
  color: var(--wp--preset--color--pale-cyan-blue) !important;
}
.has-vivid-cyan-blue-color {
  color: var(--wp--preset--color--vivid-cyan-blue) !important;
}
.has-vivid-purple-color {
  color: var(--wp--preset--color--vivid-purple) !important;
}
.has-black-background-color {
  background-color: var(--wp--preset--color--black) !important;
}
.has-cyan-bluish-gray-background-color {
  background-color: var(--wp--preset--color--cyan-bluish-gray) !important;
}
.has-white-background-color {
  background-color: var(--wp--preset--color--white) !important;
}
.has-pale-pink-background-color {
  background-color: var(--wp--preset--color--pale-pink) !important;
}
.has-vivid-red-background-color {
  background-color: var(--wp--preset--color--vivid-red) !important;
}
.has-luminous-vivid-orange-background-color {
  background-color: var(
    --wp--preset--color--luminous-vivid-orange
  ) !important;
}
.has-luminous-vivid-amber-background-color {
  background-color: var(
    --wp--preset--color--luminous-vivid-amber
  ) !important;
}
.has-light-green-cyan-background-color {
  background-color: var(--wp--preset--color--light-green-cyan) !important;
}
.has-vivid-green-cyan-background-color {
  background-color: var(--wp--preset--color--vivid-green-cyan) !important;
}
.has-pale-cyan-blue-background-color {
  background-color: var(--wp--preset--color--pale-cyan-blue) !important;
}
.has-vivid-cyan-blue-background-color {
  background-color: var(--wp--preset--color--vivid-cyan-blue) !important;
}
.has-vivid-purple-background-color {
  background-color: var(--wp--preset--color--vivid-purple) !important;
}
.has-black-border-color {
  border-color: var(--wp--preset--color--black) !important;
}
.has-cyan-bluish-gray-border-color {
  border-color: var(--wp--preset--color--cyan-bluish-gray) !important;
}
.has-white-border-color {
  border-color: var(--wp--preset--color--white) !important;
}
.has-pale-pink-border-color {
  border-color: var(--wp--preset--color--pale-pink) !important;
}
.has-vivid-red-border-color {
  border-color: var(--wp--preset--color--vivid-red) !important;
}
.has-luminous-vivid-orange-border-color {
  border-color: var(
    --wp--preset--color--luminous-vivid-orange
  ) !important;
}
.has-luminous-vivid-amber-border-color {
  border-color: var(--wp--preset--color--luminous-vivid-amber) !important;
}
.has-light-green-cyan-border-color {
  border-color: var(--wp--preset--color--light-green-cyan) !important;
}
.has-vivid-green-cyan-border-color {
  border-color: var(--wp--preset--color--vivid-green-cyan) !important;
}
.has-pale-cyan-blue-border-color {
  border-color: var(--wp--preset--color--pale-cyan-blue) !important;
}
.has-vivid-cyan-blue-border-color {
  border-color: var(--wp--preset--color--vivid-cyan-blue) !important;
}
.has-vivid-purple-border-color {
  border-color: var(--wp--preset--color--vivid-purple) !important;
}
.has-vivid-cyan-blue-to-vivid-purple-gradient-background {
  background: var(
    --wp--preset--gradient--vivid-cyan-blue-to-vivid-purple
  ) !important;
}
.has-light-green-cyan-to-vivid-green-cyan-gradient-background {
  background: var(
    --wp--preset--gradient--light-green-cyan-to-vivid-green-cyan
  ) !important;
}
.has-luminous-vivid-amber-to-luminous-vivid-orange-gradient-background {
  background: var(
    --wp--preset--gradient--luminous-vivid-amber-to-luminous-vivid-orange
  ) !important;
}
.has-luminous-vivid-orange-to-vivid-red-gradient-background {
  background: var(
    --wp--preset--gradient--luminous-vivid-orange-to-vivid-red
  ) !important;
}
.has-very-light-gray-to-cyan-bluish-gray-gradient-background {
  background: var(
    --wp--preset--gradient--very-light-gray-to-cyan-bluish-gray
  ) !important;
}
.has-cool-to-warm-spectrum-gradient-background {
  background: var(
    --wp--preset--gradient--cool-to-warm-spectrum
  ) !important;
}
.has-blush-light-purple-gradient-background {
  background: var(--wp--preset--gradient--blush-light-purple) !important;
}
.has-blush-bordeaux-gradient-background {
  background: var(--wp--preset--gradient--blush-bordeaux) !important;
}
.has-luminous-dusk-gradient-background {
  background: var(--wp--preset--gradient--luminous-dusk) !important;
}
.has-pale-ocean-gradient-background {
  background: var(--wp--preset--gradient--pale-ocean) !important;
}
.has-electric-grass-gradient-background {
  background: var(--wp--preset--gradient--electric-grass) !important;
}
.has-midnight-gradient-background {
  background: var(--wp--preset--gradient--midnight) !important;
}
.has-small-font-size {
  font-size: var(--wp--preset--font-size--small) !important;
}
.has-medium-font-size {
  font-size: var(--wp--preset--font-size--medium) !important;
}
.has-large-font-size {
  font-size: var(--wp--preset--font-size--large) !important;
}
.has-x-large-font-size {
  font-size: var(--wp--preset--font-size--x-large) !important;
}
.wp-block-navigation a:where(:not(.wp-element-button)) {
  color: inherit;
}
:where(.wp-block-post-template.is-layout-flex) {
  gap: 1.25em;
}
:where(.wp-block-post-template.is-layout-grid) {
  gap: 1.25em;
}
:where(.wp-block-columns.is-layout-flex) {
  gap: 2em;
}
:where(.wp-block-columns.is-layout-grid) {
  gap: 2em;
}
.wp-block-pullquote {
  font-size: 1.5em;
  line-height: 1.6;
}
</style>
<link
rel="stylesheet"
id="hello-elementor-theme-style-css"
href="static/css/theme.min.css"
type="text/css"
media="all"
/>
<link
rel="stylesheet"
id="hello-elementor-child-style-css"
href="static/css/style.css"
type="text/css"
media="all"
/>
<link
rel="stylesheet"
id="hello-elementor-css"
href="static/css/style.min-2.4.1.css"
type="text/css"
media="all"
/>
<link
rel="stylesheet"
id="elementor-icons-css"
href="static/css/elementor-icons.min.css"
type="text/css"
media="all"
/>
<link
rel="stylesheet"
id="elementor-frontend-css"
href="static/css/frontend.min-3.24.0.css"
type="text/css"
media="all"
/>
<link
rel="stylesheet"
id="swiper-css"
href="static/css/swiper.min.css"
type="text/css"
media="all"
/>
<link
rel="stylesheet"
id="e-swiper-css"
href="static/css/e-swiper.min.css"
type="text/css"
media="all"
/>
<link
rel="stylesheet"
id="elementor-post-40-css"
href="static/css/post-40.css"
type="text/css"
media="all"
/>
<link
rel="stylesheet"
id="wp_social_ninja_ig-css"
href="static/css/wp_social_ninja_ig.css"
type="text/css"
media="all"
/>
<link
rel="stylesheet"
id="elementor-pro-css"
href="static/css/frontend.min-3.24.01.css"
type="text/css"
media="all"
/>
<link
rel="stylesheet"
id="elementor-global-css"
href="static/css/global.css"
type="text/css"
media="all"
/>
<link
rel="stylesheet"
id="e-animations-css"
href="static/css/animations.min.css"
type="text/css"
media="all"
/>
<link
rel="stylesheet"
id="elementor-post-31-css"
href="static/css/post-31.css"
type="text/css"
media="all"
/>
<link
rel="stylesheet"
id="elementor-post-83-css"
href="static/css/post-83.css"
type="text/css"
media="all"
/>
<link
rel="stylesheet"
id="fluentform-elementor-widget-css"
href="static/css/fluent-forms-elementor-widget.css"
type="text/css"
media="all"
/>
<link
rel="stylesheet"
id="elementor-post-247-css"
href="static/css/post-247.css"
type="text/css"
media="all"
/>
<link
rel="stylesheet"
id="eael-general-css"
href="static/css/general.min.css"
type="text/css"
media="all"
/>
<link
rel="stylesheet"
id="wp_social_ninja_reviews-css"
href="static/css/wp_social_ninja_reviews.css"
type="text/css"
media="all"
/>
<link
rel="stylesheet"
id="google-fonts-1-css"
href="static/css/css-Roboto3A1002C100italic2C2002C200italic2C3002C300italic2C4002C400italic2C5002C500italic2C6002C600italic2C7002C700italic2C8002C800italic2C9002C900italif73f907b31a8f46a761ea3813630e4e9.css-Roboto3A1002C100italic2C2002C200italic2C3002C300italic2C4002C400italic2C5002C500italic2C6002C600italic2C7002C700italic2C8002C800italic2C9002C900italic7CRobotoSlab3A1002C100italic2C2002C200italic2C3002C300italic2C4002C400italic2C5002C500italic2C6002C600italic2C7002C700italic2C8002C800italic2C9002C900italic7CAnton3A1002C100italic2C2002C200italic2C3002C300italic2C4002C400italic2C5002C500italic2C6002C600italic2C7002C700italic2C8002C800italic2C9002C900italic7CDaysOne3A1002C100italic2C2002C200italic2C3002C300italic2C4002C400italic2C5002C500italic2C6002C600italic2C7002C700italic2C8002C800italic2C9002C900italic_auto_6.3.5.css"
type="text/css"
media="all"
/>
<link
rel="stylesheet"
id="elementor-icons-shared-0-css"
href="static/css/fontawesome.min.css"
type="text/css"
media="all"
/>
<link
rel="stylesheet"
id="elementor-icons-fa-regular-css"
href="static/css/regular.min.css"
type="text/css"
media="all"
/>
<link
rel="stylesheet"
id="elementor-icons-fa-solid-css"
href="static/css/solid.min.css"
type="text/css"
media="all"
/>
<link
rel="stylesheet"
id="elementor-icons-fa-brands-css"
href="static/css/brands.min.css"
type="text/css"
media="all"
/>
<link rel="preconnect" href="https://fonts.gstatic.com/" crossorigin />
<script
type="text/javascript"
src="static/js/jquery.min.js"
id="jquery-core-js"
></script>
<script
type="text/javascript"
src="static/js/jquery-migrate.min.js"
id="jquery-migrate-js"
></script>
<link
rel="https://api.w.org/"
href="https://instagearoutdoors.com/wp-json/"
/>
<link
rel="alternate"
type="application/json"
href="https://instagearoutdoors.com/wp-json/wp/v2/pages/31"
/>
<link
rel="EditURI"
type="application/rsd+xml"
title="RSD"
href="https://instagearoutdoors.com/xmlrpc.php?rsd"
/>
<meta name="generator" content="WordPress 6.3.5" />
<link rel="shortlink" href="https://instagearoutdoors.com/" />
<link
rel="alternate"
type="application/json+oembed"
href="https://instagearoutdoors.com/wp-json/oembed/1.0/embed?url=https%3A%2F%2Finstagearoutdoors.com%2F"
/>
<link
rel="alternate"
type="text/xml+oembed"
href="https://instagearoutdoors.com/wp-json/oembed/1.0/embed?url=https%3A%2F%2Finstagearoutdoors.com%2F&#038;format=xml"
/>
<script>
var booqableOptions = {
  company: "67dbaade-3b26-4665-9984-7b5754accc49",
  storeProvider: "wordpress",
};
</script>
<!-- Global site tag (gtag.js) - Google Analytics -->
<script
async
src="https://www.googletagmanager.com/gtag/js?id=G-KY3SCXQP4S"
></script>
<script>
window.dataLayer = window.dataLayer || [];
function gtag() {
  dataLayer.push(arguments);
}
gtag("js", new Date());

gtag("config", "G-KY3SCXQP4S");
</script>
<meta
name="generator"
content="Elementor 3.24.0; features: additional_custom_breakpoints; settings: css_print_method-external, google_font-enabled, font_display-auto"
/>
<style>
.e-con.e-parent:nth-of-type(n + 4):not(.e-lazyloaded):not(.e-no-lazyload),
.e-con.e-parent:nth-of-type(n + 4):not(.e-lazyloaded):not(.e-no-lazyload)
  * {
  background-image: none !important;
}
@media screen and (max-height: 1024px) {
  .e-con.e-parent:nth-of-type(n + 3):not(.e-lazyloaded):not(
      .e-no-lazyload
    ),
  .e-con.e-parent:nth-of-type(n + 3):not(.e-lazyloaded):not(
      .e-no-lazyload
    )
    * {
    background-image: none !important;
  }
}
@media screen and (max-height: 640px) {
  .e-con.e-parent:nth-of-type(n + 2):not(.e-lazyloaded):not(
      .e-no-lazyload
    ),
  .e-con.e-parent:nth-of-type(n + 2):not(.e-lazyloaded):not(
      .e-no-lazyload
    )
    * {
    background-image: none !important;
  }
}
</style>
<link
rel="icon"
href="https://instagearoutdoors.com/wp-content/uploads/2022/02/cropped-icon-color-32x32.png"
sizes="32x32"
/>
<link
rel="icon"
href="https://instagearoutdoors.com/wp-content/uploads/2022/02/cropped-icon-color-192x192.png"
sizes="192x192"
/>
<link
rel="apple-touch-icon"
href="https://instagearoutdoors.com/wp-content/uploads/2022/02/cropped-icon-color-180x180.png"
/>
<meta
name="msapplication-TileImage"
content="https://instagearoutdoors.com/wp-content/uploads/2022/02/cropped-icon-color-270x270.png"
/>
<style type="text/css" id="wp-custom-css">
.elementor-column
  .elementor-col-25
  .elementor-top-column
  .elementor-element
  .elementor-element-cdb58ad:after {
  margin: 0px !important;
  margin-right: 0px !important;
}

.elementor-element
  .elementor-element-947d64f
  .elementor-widget
  .elementor-widget-image {
  display: none !important;
}
@media only screen and (max-width: 767px) {
  .elementor:not(.elementor-bc-flex-widget) .elementor-widget-wrap {
    display: block !important;
  }
  .elementor-widget-container
    .elementor-social-icons-wrapper.elementor-grid {
    margin-left: 160% !important;
  }
}
body {
  overflow-x: hidden;
}
</style>
</head>
<body
class="home page-template-default page page-id-31 wp-custom-logo elementor-default elementor-kit-40 elementor-page elementor-page-31"
>
<div
data-elementor-type="header"
data-elementor-id="83"
class="elementor elementor-83 elementor-location-header"
data-elementor-post-type="elementor_library"
>
<section
  data-particle_enable="false"
  data-particle-mobile-disabled="false"
  class="elementor-section elementor-top-section elementor-element elementor-element-0e3960b elementor-section-boxed elementor-section-height-default elementor-section-height-default"
  data-id="0e3960b"
  data-element_type="section"
  data-settings='{"background_background":"classic"}'
>
  <div class="elementor-container elementor-column-gap-default">
    <div
      class="elementor-column elementor-col-100 elementor-top-column elementor-element elementor-element-7979583"
      data-id="7979583"
      data-element_type="column"
    >
      <div class="elementor-widget-wrap elementor-element-populated">
        <div
          class="elementor-element elementor-element-29479f9 elementor-widget elementor-widget-heading"
          data-id="29479f9"
          data-element_type="widget"
          data-widget_type="heading.default"
        >
          <div class="elementor-widget-container">
            <h6 class="elementor-heading-title elementor-size-default">
              We are a certified Mokwheel E-Bike Dealer
            </h6>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<section
  data-particle_enable="false"
  data-particle-mobile-disabled="false"
  class="elementor-section elementor-top-section elementor-element elementor-element-5ce33fd5 elementor-section-height-min-height elementor-section-content-middle elementor-hidden-desktop elementor-hidden-tablet elementor-hidden-mobile elementor-section-boxed elementor-section-height-default elementor-section-items-middle"
  data-id="5ce33fd5"
  data-element_type="section"
  data-settings='{"background_background":"classic"}'
>
  <div class="elementor-container elementor-column-gap-no">
    <div
      class="elementor-column elementor-col-50 elementor-top-column elementor-element elementor-element-42ff41c2"
      data-id="42ff41c2"
      data-element_type="column"
    >
      <div class="elementor-widget-wrap elementor-element-populated">
        <div
          class="elementor-element elementor-element-1fc57f0a elementor-icon-list--layout-inline elementor-mobile-align-center elementor-hidden-phone elementor-list-item-link-full_width elementor-widget elementor-widget-icon-list"
          data-id="1fc57f0a"
          data-element_type="widget"
          data-widget_type="icon-list.default"
        >
          <div class="elementor-widget-container">
            <ul class="elementor-icon-list-items elementor-inline-items">
              <li class="elementor-icon-list-item elementor-inline-item">
                <a href="tel:208-206-9011">
                  <span class="elementor-icon-list-icon">
                    <i aria-hidden="true" class="fas fa-phone"></i>
                  </span>
                  <span class="elementor-icon-list-text"
                    >208-206-9011</span
                  >
                </a>
              </li>
              <li class="elementor-icon-list-item elementor-inline-item">
                <a href="mailto:instagearoutdoors@gmail.com">
                  <span class="elementor-icon-list-icon">
                    <i aria-hidden="true" class="far fa-envelope"></i>
                  </span>
                  <span class="elementor-icon-list-text"
                    >instagearoutdoors@gmail.com</span
                  >
                </a>
              </li>
              <li class="elementor-icon-list-item elementor-inline-item">
                <span class="elementor-icon-list-icon">
                  <i aria-hidden="true" class="far fa-clock"></i>
                </span>
                <span class="elementor-icon-list-text"
                  >Mon - Sat: 9:00am - 6:00pm</span
                >
              </li>
              <li class="elementor-icon-list-item elementor-inline-item">
                <span class="elementor-icon-list-icon">
                  <i aria-hidden="true" class="fas fa-map-pin"></i>
                </span>
                <span class="elementor-icon-list-text"
                  >9 North Bridge Street, St. Anthony, Idaho</span
                >
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <div
      class="elementor-column elementor-col-50 elementor-top-column elementor-element elementor-element-5f15702d"
      data-id="5f15702d"
      data-element_type="column"
    >
      <div class="elementor-widget-wrap elementor-element-populated">
        <div
          class="elementor-element elementor-element-761b2481 e-grid-align-right elementor-shape-square e-grid-align-mobile-center elementor-grid-0 elementor-widget elementor-widget-social-icons"
          data-id="761b2481"
          data-element_type="widget"
          data-widget_type="social-icons.default"
        >
          <div class="elementor-widget-container">
            <div class="elementor-social-icons-wrapper elementor-grid">
              <span class="elementor-grid-item">
                <a
                  class="elementor-icon elementor-social-icon elementor-social-icon-facebook elementor-repeater-item-5646027"
                  target="_blank"
                >
                  <span class="elementor-screen-only">Facebook</span>
                  <i class="fab fa-facebook"></i>
                </a>
              </span>
              <span class="elementor-grid-item">
                <a
                  class="elementor-icon elementor-social-icon elementor-social-icon-instagram elementor-repeater-item-72bc942"
                  target="_blank"
                >
                  <span class="elementor-screen-only">Instagram</span>
                  <i class="fab fa-instagram"></i>
                </a>
              </span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<section
  data-particle_enable="false"
  data-particle-mobile-disabled="false"
  class="elementor-section elementor-top-section elementor-element elementor-element-69e20e48 elementor-section-content-middle elementor-section-boxed elementor-section-height-default elementor-section-height-default"
  data-id="69e20e48"
  data-element_type="section"
>
  <div class="elementor-container elementor-column-gap-no">
    <div
      class="elementor-column elementor-col-50 elementor-top-column elementor-element elementor-element-230de4c8"
      data-id="230de4c8"
      data-element_type="column"
    >
      <div class="elementor-widget-wrap elementor-element-populated">
        <div
          class="elementor-element elementor-element-31195d86 elementor-widget elementor-widget-theme-site-logo elementor-widget-image"
          data-id="31195d86"
          data-element_type="widget"
          data-widget_type="theme-site-logo.default"
        >
          <div class="elementor-widget-container">
            <a href="">
              <img
                fetchpriority="high"
                width="500"
                height="500"
                src="static/picture/Untitled-design-1.png"
                class="attachment-full size-full wp-image-1173"
                alt=""
                srcset="
                  https://instagearoutdoors.com/wp-content/uploads/2021/11/Untitled-design-1.png         500w,
                  https://instagearoutdoors.com/wp-content/uploads/2021/11/Untitled-design-1-300x300.png 300w,
                  https://instagearoutdoors.com/wp-content/uploads/2021/11/Untitled-design-1-150x150.png 150w
                "
                sizes="(max-width: 500px) 100vw, 500px"
              />
            </a>
          </div>
        </div>
      </div>
    </div>
    <div
      class="elementor-column elementor-col-50 elementor-top-column elementor-element elementor-element-1129c55c"
      data-id="1129c55c"
      data-element_type="column"
    >
      <div class="elementor-widget-wrap elementor-element-populated">
        <div
          class="elementor-element elementor-element-54235de7 elementor-nav-menu__align-justify elementor-nav-menu--stretch elementor-nav-menu--dropdown-tablet elementor-nav-menu__text-align-aside elementor-nav-menu--toggle elementor-nav-menu--burger elementor-widget elementor-widget-nav-menu"
          data-id="54235de7"
          data-element_type="widget"
          data-settings='{"full_width":"stretch","layout":"horizontal","submenu_icon":{"value":"&lt;i class=\"fas fa-caret-down\"&gt;&lt;\/i&gt;","library":"fa-solid"},"toggle":"burger"}'
          data-widget_type="nav-menu.default"
        >
          <div class="elementor-widget-container">
            <nav
              aria-label="Menu"
              class="elementor-nav-menu--main elementor-nav-menu__container elementor-nav-menu--layout-horizontal e--pointer-underline e--animation-fade"
            >
              <ul id="menu-1-54235de7" class="elementor-nav-menu">
                <li
                  class="menu-item menu-item-type-custom menu-item-object-custom current-menu-item current_page_item menu-item-home menu-item-36"
                >
                  <a
                    href=""
                    aria-current="page"
                    class="elementor-item elementor-item-active"
                    >Home</a
                  >
                </li>
                <li
                  class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-1142"
                >
                  <a href="all.html" class="elementor-item">Retail</a>
                  <ul class="sub-menu elementor-nav-menu--dropdown">
                    <li
                      class="menu-item menu-item-type-custom menu-item-object-custom menu-item-1143"
                    >
                      <a href="e-bikes.html" class="elementor-sub-item"
                        >e-Bikes</a
                      >
                    </li>
                    <li
                      class="menu-item menu-item-type-custom menu-item-object-custom menu-item-1144"
                    >
                      <a
                        href="backpacking-gear.html"
                        class="elementor-sub-item"
                        >Backpacking Gear</a
                      >
                    </li>
                    <li
                      class="menu-item menu-item-type-custom menu-item-object-custom menu-item-1145"
                    >
                      <a
                        href="hunting-fishing-gear.html"
                        class="elementor-sub-item"
                        >Fishing &#038; Hunting Gear</a
                      >
                    </li>
                    <li
                      class="menu-item menu-item-type-custom menu-item-object-custom menu-item-1146"
                    >
                      <a
                        href="winter-gear.html"
                        class="elementor-sub-item"
                        >Winter Gear</a
                      >
                    </li>
                  </ul>
                </li>
                <li
                  class="menu-item menu-item-type-custom menu-item-object-custom menu-item-334"
                >
                  <a href="shuttles.html" class="elementor-item"
                    >ATT Shuttle</a
                  >
                </li>
                <li
                  class="menu-item menu-item-type-custom menu-item-object-custom menu-item-332"
                >
                  <a href="rentals.html" class="elementor-item"
                    >Rentals</a
                  >
                </li>
                <li
                  class="menu-item menu-item-type-post_type menu-item-object-page menu-item-440"
                >
                  <a href="faq.html" class="elementor-item">FAQs</a>
                </li>
                <li
                  class="menu-item menu-item-type-custom menu-item-object-custom menu-item-333"
                >
                  <a href="adventure-guide.html" class="elementor-item"
                    >Adventure Guide</a
                  >
                </li>
              </ul>
            </nav>
            <div
              class="elementor-menu-toggle"
              role="button"
              tabindex="0"
              aria-label="Menu Toggle"
              aria-expanded="false"
            >
              <i
                aria-hidden="true"
                role="presentation"
                class="elementor-menu-toggle__icon--open eicon-menu-bar"
              ></i
              ><i
                aria-hidden="true"
                role="presentation"
                class="elementor-menu-toggle__icon--close eicon-close"
              ></i>
              <span class="elementor-screen-only">Menu</span>
            </div>
            <nav
              class="elementor-nav-menu--dropdown elementor-nav-menu__container"
              aria-hidden="true"
            >
              <ul id="menu-2-54235de7" class="elementor-nav-menu">
                <li
                  class="menu-item menu-item-type-custom menu-item-object-custom current-menu-item current_page_item menu-item-home menu-item-36"
                >
                  <a
                    href=""
                    aria-current="page"
                    class="elementor-item elementor-item-active"
                    tabindex="-1"
                    >Home</a
                  >
                </li>
                <li
                  class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-1142"
                >
                  <a href="all.html" class="elementor-item" tabindex="-1"
                    >Retail</a
                  >
                  <ul class="sub-menu elementor-nav-menu--dropdown">
                    <li
                      class="menu-item menu-item-type-custom menu-item-object-custom menu-item-1143"
                    >
                      <a
                        href="e-bikes.html"
                        class="elementor-sub-item"
                        tabindex="-1"
                        >e-Bikes</a
                      >
                    </li>
                    <li
                      class="menu-item menu-item-type-custom menu-item-object-custom menu-item-1144"
                    >
                      <a
                        href="backpacking-gear.html"
                        class="elementor-sub-item"
                        tabindex="-1"
                        >Backpacking Gear</a
                      >
                    </li>
                    <li
                      class="menu-item menu-item-type-custom menu-item-object-custom menu-item-1145"
                    >
                      <a
                        href="hunting-fishing-gear.html"
                        class="elementor-sub-item"
                        tabindex="-1"
                        >Fishing &#038; Hunting Gear</a
                      >
                    </li>
                    <li
                      class="menu-item menu-item-type-custom menu-item-object-custom menu-item-1146"
                    >
                      <a
                        href="winter-gear.html"
                        class="elementor-sub-item"
                        tabindex="-1"
                        >Winter Gear</a
                      >
                    </li>
                  </ul>
                </li>
                <li
                  class="menu-item menu-item-type-custom menu-item-object-custom menu-item-334"
                >
                  <a
                    href="shuttles.html"
                    class="elementor-item"
                    tabindex="-1"
                    >ATT Shuttle</a
                  >
                </li>
                <li
                  class="menu-item menu-item-type-custom menu-item-object-custom menu-item-332"
                >
                  <a
                    href="rentals.html"
                    class="elementor-item"
                    tabindex="-1"
                    >Rentals</a
                  >
                </li>
                <li
                  class="menu-item menu-item-type-post_type menu-item-object-page menu-item-440"
                >
                  <a href="faq.html" class="elementor-item" tabindex="-1"
                    >FAQs</a
                  >
                </li>
                <li
                  class="menu-item menu-item-type-custom menu-item-object-custom menu-item-333"
                >
                  <a
                    href="adventure-guide.html"
                    class="elementor-item"
                    tabindex="-1"
                    >Adventure Guide</a
                  >
                </li>
              </ul>
            </nav>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<section
  data-particle_enable="false"
  data-particle-mobile-disabled="false"
  class="elementor-section elementor-top-section elementor-element elementor-element-155a577 elementor-section-boxed elementor-section-height-default elementor-section-height-default"
  data-id="155a577"
  data-element_type="section"
>
  <div class="elementor-container elementor-column-gap-default">
    <div
      class="elementor-column elementor-col-100 elementor-top-column elementor-element elementor-element-3bfb6b8"
      data-id="3bfb6b8"
      data-element_type="column"
    >
      <div class="elementor-widget-wrap"></div>
    </div>
  </div>
</section>
</div>

<main
class="site-main post-31 page type-page status-publish has-post-thumbnail hentry"
role="main"
>
<div class="page-content">
  <div
    data-elementor-type="wp-page"
    data-elementor-id="31"
    class="elementor elementor-31"
    data-elementor-post-type="page"
  >
    <section
      data-particle_enable="false"
      data-particle-mobile-disabled="false"
      class="elementor-section elementor-top-section elementor-element elementor-element-cca8c9f elementor-section-height-min-height elementor-section-content-middle elementor-section-boxed elementor-section-height-default elementor-section-items-middle"
      data-id="cca8c9f"
      data-element_type="section"
      data-settings='{"background_background":"classic"}'
    >
      <div class="elementor-background-overlay"></div>
      <div class="elementor-container elementor-column-gap-default">
        <div
          class="elementor-column elementor-col-100 elementor-top-column elementor-element elementor-element-1e914a3c"
          data-id="1e914a3c"
          data-element_type="column"
        >
          <div class="elementor-widget-wrap elementor-element-populated">
            <div
              class="elementor-element elementor-element-79f5f55f elementor-widget elementor-widget-heading"
              data-id="79f5f55f"
              data-element_type="widget"
              data-widget_type="heading.default"
            >
              <div class="elementor-widget-container">
                <h5
                  class="elementor-heading-title elementor-size-default"
                >
                  InstaGear OUtdoor Co.
                </h5>
              </div>
            </div>
            <div
              class="elementor-element elementor-element-6224b7c elementor-widget elementor-widget-heading"
              data-id="6224b7c"
              data-element_type="widget"
              data-widget_type="heading.default"
            >
              <div class="elementor-widget-container">
                <h2
                  class="elementor-heading-title elementor-size-default"
                >
                  Adventure Elevated
                </h2>
              </div>
            </div>
            <div
              class="elementor-element elementor-element-69d8b843 elementor-mobile-align-center elementor-align-center elementor-widget elementor-widget-button"
              data-id="69d8b843"
              data-element_type="widget"
              data-widget_type="button.default"
            >
              <div class="elementor-widget-container">
                <div class="elementor-button-wrapper">
                  <a
                    class="elementor-button elementor-button-link elementor-size-sm elementor-animation-grow"
                    href="rentals.html"
                  >
                    <span class="elementor-button-content-wrapper">
                      <span class="elementor-button-text"
                        >BOOK YOUR ADVENTURE</span
                      >
                    </span>
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section
      data-particle_enable="false"
      data-particle-mobile-disabled="false"
      class="elementor-section elementor-top-section elementor-element elementor-element-7e9fb4e elementor-section-height-min-height elementor-section-boxed elementor-section-height-default elementor-section-items-middle"
      data-id="7e9fb4e"
      data-element_type="section"
      data-settings='{"background_background":"classic"}'
    >
      <div class="elementor-container elementor-column-gap-default">
        <div
          class="elementor-column elementor-col-100 elementor-top-column elementor-element elementor-element-fbc74af"
          data-id="fbc74af"
          data-element_type="column"
        >
          <div class="elementor-widget-wrap elementor-element-populated">
            <div
              class="elementor-element elementor-element-60997df elementor-widget elementor-widget-heading"
              data-id="60997df"
              data-element_type="widget"
              data-widget_type="heading.default"
            >
              <div class="elementor-widget-container">
                <h2
                  class="elementor-heading-title elementor-size-default"
                >
                  Eastern Idaho's top solution for E-Bikes &amp; Outdoor
                  Gear
                </h2>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section
      data-particle_enable="false"
      data-particle-mobile-disabled="false"
      class="elementor-section elementor-top-section elementor-element elementor-element-69d2786f elementor-section-content-middle elementor-section-boxed elementor-section-height-default elementor-section-height-default"
      data-id="69d2786f"
      data-element_type="section"
      data-settings='{"background_background":"classic"}'
    >
      <div class="elementor-container elementor-column-gap-no">
        <div
          class="elementor-column elementor-col-100 elementor-top-column elementor-element elementor-element-349e9584"
          data-id="349e9584"
          data-element_type="column"
        >
          <div class="elementor-widget-wrap elementor-element-populated">
            <section
              data-particle_enable="false"
              data-particle-mobile-disabled="false"
              class="elementor-section elementor-inner-section elementor-element elementor-element-1049a8f3 elementor-section-content-middle elementor-section-boxed elementor-section-height-default elementor-section-height-default"
              data-id="1049a8f3"
              data-element_type="section"
            >
              <div class="elementor-container elementor-column-gap-no">
                <div
                  class="elementor-column elementor-col-50 elementor-inner-column elementor-element elementor-element-5aa73297"
                  data-id="5aa73297"
                  data-element_type="column"
                >
                  <div
                    class="elementor-widget-wrap elementor-element-populated"
                  >
                    <div
                      class="elementor-element elementor-element-2a330847 elementor-position-top elementor-widget elementor-widget-image-box"
                      data-id="2a330847"
                      data-element_type="widget"
                      data-widget_type="image-box.default"
                    >
                      <div class="elementor-widget-container">
                        <div class="elementor-image-box-wrapper">
                          <figure class="elementor-image-box-img">
                            <img
                              decoding="async"
                              width="2048"
                              height="1365"
                              src="static/picture/RexRover-43.jpg"
                              class="attachment-full size-full wp-image-1180"
                              alt=""
                              srcset="
                                https://instagearoutdoors.com/wp-content/uploads/2024/04/RexRover-43.jpg           2048w,
                                https://instagearoutdoors.com/wp-content/uploads/2024/04/RexRover-43-300x200.jpg    300w,
                                https://instagearoutdoors.com/wp-content/uploads/2024/04/RexRover-43-1024x683.jpg  1024w,
                                https://instagearoutdoors.com/wp-content/uploads/2024/04/RexRover-43-768x512.jpg    768w,
                                https://instagearoutdoors.com/wp-content/uploads/2024/04/RexRover-43-1536x1024.jpg 1536w
                              "
                              sizes="(max-width: 2048px) 100vw, 2048px"
                            />
                          </figure>
                          <div class="elementor-image-box-content">
                            <h3 class="elementor-image-box-title">
                              E-Bike Sales
                            </h3>
                            <p class="elementor-image-box-description">
                              Discover the E-Bike Meant for you:
                              All-terrain, Mountain, Cargo, Trike,
                              Commuter and more. As Eastern Idaho's top
                              solution for E-Bikes we carry Mokwheel,
                              Addmotor, and Aventon E-Bikes and can
                              service your E-bike in shop.
                            </p>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div
                      class="elementor-element elementor-element-414401cc elementor-align-center elementor-widget elementor-widget-button"
                      data-id="414401cc"
                      data-element_type="widget"
                      data-widget_type="button.default"
                    >
                      <div class="elementor-widget-container">
                        <div class="elementor-button-wrapper">
                          <a
                            class="elementor-button elementor-button-link elementor-size-sm elementor-animation-grow"
                            href="all.html"
                          >
                            <span
                              class="elementor-button-content-wrapper"
                            >
                              <span class="elementor-button-text"
                                >Shop Online Here</span
                              >
                            </span>
                          </a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div
                  class="elementor-column elementor-col-50 elementor-inner-column elementor-element elementor-element-58de06f3"
                  data-id="58de06f3"
                  data-element_type="column"
                >
                  <div
                    class="elementor-widget-wrap elementor-element-populated"
                  >
                    <div
                      class="elementor-element elementor-element-3589d90a elementor-position-top elementor-widget elementor-widget-image-box"
                      data-id="3589d90a"
                      data-element_type="widget"
                      data-widget_type="image-box.default"
                    >
                      <div class="elementor-widget-container">
                        <div class="elementor-image-box-wrapper">
                          <figure class="elementor-image-box-img">
                            <img
                              decoding="async"
                              width="2560"
                              height="1707"
                              src="static/picture/shutterstock_565451494-scaled.jpg"
                              class="attachment-full size-full wp-image-240"
                              alt=""
                              srcset="
                                https://instagearoutdoors.com/wp-content/uploads/2022/02/shutterstock_565451494-scaled.jpg    2560w,
                                https://instagearoutdoors.com/wp-content/uploads/2022/02/shutterstock_565451494-300x200.jpg    300w,
                                https://instagearoutdoors.com/wp-content/uploads/2022/02/shutterstock_565451494-1024x683.jpg  1024w,
                                https://instagearoutdoors.com/wp-content/uploads/2022/02/shutterstock_565451494-768x512.jpg    768w,
                                https://instagearoutdoors.com/wp-content/uploads/2022/02/shutterstock_565451494-1536x1024.jpg 1536w,
                                https://instagearoutdoors.com/wp-content/uploads/2022/02/shutterstock_565451494-2048x1365.jpg 2048w
                              "
                              sizes="(max-width: 2560px) 100vw, 2560px"
                            />
                          </figure>
                          <div class="elementor-image-box-content">
                            <h3 class="elementor-image-box-title">
                              Gear Rental
                            </h3>
                            <p class="elementor-image-box-description">
                              Elevate your next adventure with top of the
                              line outdoor rentals. We have e-bikes,
                              backpacking gear, camping gear, outdoor
                              games, event supplies and more! Book gear
                              below!
                            </p>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div
                      class="elementor-element elementor-element-6d3866c elementor-align-center elementor-widget elementor-widget-button"
                      data-id="6d3866c"
                      data-element_type="widget"
                      data-widget_type="button.default"
                    >
                      <div class="elementor-widget-container">
                        <div class="elementor-button-wrapper">
                          <a
                            class="elementor-button elementor-button-link elementor-size-sm elementor-animation-grow"
                            href="rentals.html"
                          >
                            <span
                              class="elementor-button-content-wrapper"
                            >
                              <span class="elementor-button-text"
                                >Rent Gear Here</span
                              >
                            </span>
                          </a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </section>
          </div>
        </div>
      </div>
    </section>
    <section
      data-particle_enable="false"
      data-particle-mobile-disabled="false"
      class="elementor-section elementor-top-section elementor-element elementor-element-50587eff elementor-section-content-middle elementor-section-boxed elementor-section-height-default elementor-section-height-default"
      data-id="50587eff"
      data-element_type="section"
      data-settings='{"background_background":"classic"}'
    >
      <div class="elementor-background-overlay"></div>
      <div class="elementor-container elementor-column-gap-no">
        <div
          class="elementor-column elementor-col-50 elementor-top-column elementor-element elementor-element-51f6c353"
          data-id="51f6c353"
          data-element_type="column"
        >
          <div class="elementor-widget-wrap elementor-element-populated">
            <div
              class="elementor-element elementor-element-6de91718 elementor-widget elementor-widget-text-editor"
              data-id="6de91718"
              data-element_type="widget"
              data-widget_type="text-editor.default"
            >
              <div class="elementor-widget-container">
                <p>Easy and Convenient</p>
              </div>
            </div>
            <div
              class="elementor-element elementor-element-60a1e2bb elementor-widget-divider--view-line elementor-widget elementor-widget-divider"
              data-id="60a1e2bb"
              data-element_type="widget"
              data-widget_type="divider.default"
            >
              <div class="elementor-widget-container">
                <div class="elementor-divider">
                  <span class="elementor-divider-separator"> </span>
                </div>
              </div>
            </div>
            <div
              class="elementor-element elementor-element-265cdca8 elementor-widget elementor-widget-heading"
              data-id="265cdca8"
              data-element_type="widget"
              data-widget_type="heading.default"
            >
              <div class="elementor-widget-container">
                <h3
                  class="elementor-heading-title elementor-size-default"
                >
                  How Rentals Work
                </h3>
              </div>
            </div>
          </div>
        </div>
        <div
          class="elementor-column elementor-col-50 elementor-top-column elementor-element elementor-element-2f3d1ec0"
          data-id="2f3d1ec0"
          data-element_type="column"
        >
          <div class="elementor-widget-wrap elementor-element-populated">
            <div
              class="elementor-element elementor-element-678731c6 elementor-vertical-align-top elementor-widget elementor-widget-icon-box"
              data-id="678731c6"
              data-element_type="widget"
              data-widget_type="icon-box.default"
            >
              <div class="elementor-widget-container">
                <div class="elementor-icon-box-wrapper">
                  <div class="elementor-icon-box-content">
                    <h3 class="elementor-icon-box-title">
                      <span> 1. Reserve Your Gear </span>
                    </h3>

                    <p class="elementor-icon-box-description">
                      Make your reservation online or by phone.
                    </p>
                  </div>
                </div>
              </div>
            </div>
            <section
              data-particle_enable="false"
              data-particle-mobile-disabled="false"
              class="elementor-section elementor-inner-section elementor-element elementor-element-18dab70 elementor-section-boxed elementor-section-height-default elementor-section-height-default"
              data-id="18dab70"
              data-element_type="section"
            >
              <div
                class="elementor-container elementor-column-gap-default"
              >
                <div
                  class="elementor-column elementor-col-50 elementor-inner-column elementor-element elementor-element-f68681c"
                  data-id="f68681c"
                  data-element_type="column"
                >
                  <div
                    class="elementor-widget-wrap elementor-element-populated"
                  >
                    <div
                      class="elementor-element elementor-element-0b40249 elementor-align-left elementor-widget elementor-widget-button"
                      data-id="0b40249"
                      data-element_type="widget"
                      data-widget_type="button.default"
                    >
                      <div class="elementor-widget-container">
                        <div class="elementor-button-wrapper">
                          <a
                            class="elementor-button elementor-button-link elementor-size-sm"
                            href="rentals.html"
                          >
                            <span
                              class="elementor-button-content-wrapper"
                            >
                              <span class="elementor-button-text"
                                >Reserve Online</span
                              >
                            </span>
                          </a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div
                  class="elementor-column elementor-col-50 elementor-inner-column elementor-element elementor-element-5058bf7"
                  data-id="5058bf7"
                  data-element_type="column"
                >
                  <div
                    class="elementor-widget-wrap elementor-element-populated"
                  >
                    <div
                      class="elementor-element elementor-element-390cb2d elementor-widget elementor-widget-button"
                      data-id="390cb2d"
                      data-element_type="widget"
                      data-widget_type="button.default"
                    >
                      <div class="elementor-widget-container">
                        <div class="elementor-button-wrapper">
                          <a
                            class="elementor-button elementor-button-link elementor-size-sm"
                            href="tel:208-206-9011"
                          >
                            <span
                              class="elementor-button-content-wrapper"
                            >
                              <span class="elementor-button-text"
                                >Call 208-206-9011</span
                              >
                            </span>
                          </a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </section>
            <div
              class="elementor-element elementor-element-71cd2e41 elementor-vertical-align-top elementor-widget elementor-widget-icon-box"
              data-id="71cd2e41"
              data-element_type="widget"
              data-widget_type="icon-box.default"
            >
              <div class="elementor-widget-container">
                <div class="elementor-icon-box-wrapper">
                  <div class="elementor-icon-box-content">
                    <h3 class="elementor-icon-box-title">
                      <span> 2. Gear Delivery/Pick Up </span>
                    </h3>

                    <p class="elementor-icon-box-description">
                      Gear can be picked up at 19 North Bridge St. in St.
                      Anthony, Idaho or delivered to your private home or
                      vacation residence (*Delivery cannot be made on
                      Forest Service lands*). To arrange delivery, please
                      call 208-206-9011. Rental gear delivery is available
                      on a first come first served basis and will be
                      dropped off before 9AM and picked up between 6-8PM
                      unless otherwise arranged.
                    </p>
                  </div>
                </div>
              </div>
            </div>
            <div
              class="elementor-element elementor-element-6fa9c60b elementor-vertical-align-top elementor-widget elementor-widget-icon-box"
              data-id="6fa9c60b"
              data-element_type="widget"
              data-widget_type="icon-box.default"
            >
              <div class="elementor-widget-container">
                <div class="elementor-icon-box-wrapper">
                  <div class="elementor-icon-box-content">
                    <h3 class="elementor-icon-box-title">
                      <span> 3. Gear Return </span>
                    </h3>

                    <p class="elementor-icon-box-description">
                      All rentals are for a 24-hour period. Gear must be
                      returned inside of that period or an additional
                      rental period charge will be assessed. Unreturned
                      items and items left outside the InstaGear shop
                      after hours will incur additional fees.
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section
      data-particle_enable="false"
      data-particle-mobile-disabled="false"
      class="elementor-section elementor-top-section elementor-element elementor-element-b07a11a elementor-section-boxed elementor-section-height-default elementor-section-height-default"
      data-id="b07a11a"
      data-element_type="section"
      data-settings='{"background_background":"classic"}'
    >
      <div class="elementor-container elementor-column-gap-default">
        <div
          class="elementor-column elementor-col-100 elementor-top-column elementor-element elementor-element-2e13bc3"
          data-id="2e13bc3"
          data-element_type="column"
        >
          <div class="elementor-widget-wrap elementor-element-populated">
            <div
              class="elementor-element elementor-element-0f2cd1d elementor-widget elementor-widget-heading"
              data-id="0f2cd1d"
              data-element_type="widget"
              data-widget_type="heading.default"
            >
              <div class="elementor-widget-container">
                <h2
                  class="elementor-heading-title elementor-size-default"
                >
                  What Our Customers Say
                </h2>
              </div>
            </div>
            <div
              class="elementor-element elementor-element-5413e14 elementor-widget elementor-widget-shortcode"
              data-id="5413e14"
              data-element_type="widget"
              data-widget_type="shortcode.default"
            >
              <div class="elementor-widget-container">
                <div class="elementor-shortcode">
                  <div
                    id="wpsr-reviews-slider-317"
                    class="wpsr-reviews-317 wpsr-reviews-wrapper wpsr-feed-wrap wpsr_content wpsr-reviews-slider-wrapper wpsr-reviews-template-grid1 wpsr-reviews-layout-slider"
                    data-column="4"
                    data-slider_settings='{"autoplay":"false","autoplay_speed":3000,"slides_to_show":3,"spaceBetween":20,"responsive_slides_to_show":{"desktop":3,"tablet":2,"mobile":1},"slides_to_scroll":3,"responsive_slides_to_scroll":{"desktop":3,"tablet":2,"mobile":1},"navigation":"dot"}'
                  >
                    <div class="wpsr-container" style="">
                      <div class="wpsr-reviews-slider-wrapper-inner">
                        <div
                          class="wpsr-reviews-slider swiper-container"
                          tabindex="0"
                        >
                          <div class="swiper-wrapper">
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="0"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ACg8ocKEWp7rsnfOyO-HdPt1oPsoHajU7e5hk5ChqlZ9FQvVtYZHVw=s120-c-rp-mo-br100.png"
                                      alt="Janet Chambers"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Janet Chambers</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="4 months ago"
                                      class="wpsr-review-date"
                                    >
                                      May 1, 2024</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    We bought 2 awesome Mokwheel ebikes
                                    from Greg at InstaGear and that has
                                    widened our outdoor recreation. Great
                                    service from Greg and great prices!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="1"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ACg8ocKud3wYl9HETgONixb0nCq98kQb9J6-4mtUbOLHCSzOte1Ctw=s120-c-rp-mo-ba3-br100.png"
                                      alt="Aaron Dalling"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Aaron Dalling</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="4 months ago"
                                      class="wpsr-review-date"
                                    >
                                      April 29, 2024</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Greg was great to work with. I stopped
                                    in four times before making the
                                    decision on which ebikes to purchase.
                                    He was never pushy. Great place and
                                    great addition to our little town!!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="2"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ALV-UjWF09Q6kZs_z_ryTQwObeE9g09xQ7q7pz8AnnF-FMZEQ_9KjhyjaA=s120-c-rp-mo-br100.png"
                                      alt="Brooke Bailey"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Brooke Bailey</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="11 months ago"
                                      class="wpsr-review-date"
                                    >
                                      October 23, 2023</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Great environment. Super friendly and
                                    knowledgeable owner and staff. Great
                                    equipment to go enjoy the outdoors.
                                    Highly recommend renting or buying
                                    your equipment from InstaGear!!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="3"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ALV-UjX8iEbPrg5EcZowFK_u2EPmrPgdpFS9LHSgtqu9DgxexIRrJA_N=s120-c-rp-mo-br100.png"
                                      alt="Tom Jacobsen"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Tom Jacobsen</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="11 months ago"
                                      class="wpsr-review-date"
                                    >
                                      October 18, 2023</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    We rented some outdoor games for our
                                    4-H camp this summer, the kids loved
                                    the games! InstaGear was awesome to
                                    work with and very reasonably priced.
                                    We'll be back for more fun!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="4"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ACg8ocJxtEvTHSmBSeRR1V57f3yzX1bu4AG_DB0iE5YxgYAxKibw4A=s120-c-rp-mo-br100.png"
                                      alt="R G"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >R G</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="11 months ago"
                                      class="wpsr-review-date"
                                    >
                                      October 18, 2023</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    We rented electric scooters and
                                    e-bikes from InstaGear. Each time Greg
                                    was so helpful. He was thorough in
                                    explaining the use of them and safety.
                                    We were grateful for that because we
                                    seem to be a bit accident prone. We
                                    had a BLAST both times. We will
                                    definitely be back next summer.
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="5"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ALV-UjWM1zOesysw8XHUvet6IEeDVxwTvDDkPTOTTW4QCRflMqVfNJIi=s120-c-rp-mo-br100.png"
                                      alt="Carol Jones"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Carol Jones</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="11 months ago"
                                      class="wpsr-review-date"
                                    >
                                      October 17, 2023</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    It was very easy to reserve and rent
                                    games and equipment. The Company was
                                    very professional and helpful.
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="6"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ALV-UjXMeVPczKKc6T5cdjSMgiJm_94_9ON3Wjs6Vd7CB-c9E7Cm7ds=s120-c-rp-mo-br100.png"
                                      alt="Maleri Parker"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Maleri Parker</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="11 months ago"
                                      class="wpsr-review-date"
                                    >
                                      October 17, 2023</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    10/10 recommend for your rental needs.
                                    Greg had everything we needed for our
                                    rafting trip ready and waiting for us.
                                    They had life jackets for everyone
                                    infant on up! Made everything so easy
                                    and as little work for us as possible.
                                    We will definitely be renting again in
                                    the future!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="7"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ALV-UjVMBxFsmbysD8Wt88QawKsqqlyLgsz5FuVLN-drZTyWYfYtTeqw=s120-c-rp-mo-ba2-br100.png"
                                      alt="Nuel Donovan"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Nuel Donovan</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="1 year ago"
                                      class="wpsr-review-date"
                                    >
                                      August 31, 2023</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Greg was great; He was able to answer
                                    all my questions and pointed me in the
                                    right direction for the best Kayak to
                                    take on my trip. Thanks for your help,
                                    I will definitely be back!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="8"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ALV-UjVaxtcVWVAgZ2FEhkV3mi4OZkc2FjUNtdoPAh-PvIvzzpbqsCo=s120-c-rp-mo-br100.png"
                                      alt="Neal Cosmo"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Neal Cosmo</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="1 year ago"
                                      class="wpsr-review-date"
                                    >
                                      August 2, 2023</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Great deals and AMAZING service!! What
                                    more could you ask for in a business?
                                    Thx Greg for everything including
                                    insider local recommendations.
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="9"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ALV-UjUjUjlbqfa0OVM-ohLVRyoSfp8OWPAK5bwguCG9H0fn9uk1jx-D3A=s120-c-rp-mo-ba4-br100.png"
                                      alt="Jason Theisen"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Jason Theisen</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="1 year ago"
                                      class="wpsr-review-date"
                                    >
                                      July 23, 2023</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    So friendly and excited to help you
                                    have a great vacation experience! We
                                    will be back for sure. We rented a
                                    bunch of tubes and had a great time on
                                    the Henry's Fork of the Snake River...
                                    no pictures, sadly, my phone was in
                                    the dry bag we rented!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="10"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ALV-UjVI-azStak3LAYOyiE992c8intzYpC2oIMeVKDvZ7SBtVjzkklayA=s120-c-rp-mo-ba2-br100.png"
                                      alt="William Ebersohl"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >William Ebersohl</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="1 year ago"
                                      class="wpsr-review-date"
                                    >
                                      July 21, 2023</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    My teenage boys and I happened upon
                                    this outdoor adventure company on
                                    Google maps. The family that runs this
                                    shop is totally awesome and they took
                                    really good care of helping us plan
                                    some last minute fun. We did boat
                                    rentals and a shuttle ride for about 2
                                    hours on the river. Highly
                                    recommended!!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="11"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ALV-UjXmNZo-XYhcRYgGNh10JGqBgem_N17rli5MUMymg3nEij5FadWH=s120-c-rp-mo-br100.png"
                                      alt="Karen Hoag"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Karen Hoag</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="1 year ago"
                                      class="wpsr-review-date"
                                    >
                                      July 10, 2023</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    I contacted Greg about renting out
                                    some of his equipment for a float trip
                                    my group wanted to go on today which
                                    was Sunday. Even though he was closed
                                    he was more than happy to accommodate
                                    us and meet us at his shop Sunday
                                    morning. Everything was aired up and
                                    all was in working order. He helped us
                                    load up and met us back to the shop
                                    when we were finished with our day
                                    trip. Greg was excited to hear about
                                    our trip. We was very kind and
                                    pleasant to work with. Thank you so
                                    much for our experience
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="12"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ACg8ocLgEeNKEjDBx9j35tijya6cfBKEPo5mK91f84_LZmGIemSs-g=s120-c-rp-mo-br100.png"
                                      alt="Michelle Manwaring"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Michelle Manwaring</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="1 year ago"
                                      class="wpsr-review-date"
                                    >
                                      July 9, 2023</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    After hearing positive comments
                                    regarding InstaGear Outdoor Rentals,
                                    we decided to give them a try and
                                    rented e-bikes for a 4th of July
                                    family activity. When our group of
                                    five showed up, Greg greeted us and
                                    had the bikes and helmets ready to go.
                                    Some of us had never used an e-bike
                                    before but Greg walked us through
                                    everything. He gave us detailed
                                    instructions on the use of the bikes
                                    and made sure we were comfortable
                                    before we left the store. His
                                    friendly, positive attitude created a
                                    great experience for our family. If
                                    you are looking for fantastic customer
                                    service, great outdoor gear at
                                    reasonable prices and want to support
                                    a locally-owned business, I highly
                                    recommend InstaGear Outdoor Rentals.
                                    We are already planning another family
                                    adventure and will definitely rent
                                    from here again!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="13"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ACg8ocK12GoV0T1OxewRp3xTYULbrbhfN6iQhcxaFaAnsiZkHAt5Cg=s120-c-rp-mo-ba3-br100.png"
                                      alt="Chris B"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Chris B</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="1 year ago"
                                      class="wpsr-review-date"
                                    >
                                      July 6, 2023</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Extremely happy with rentals and with
                                    the service. They could not have been
                                    nicer and we will be using their
                                    service again next time we head to the
                                    warm river.
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="14"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ALV-UjXyY3hLEjVhsjaI5Ryg3Eb7MpsfcRkGPg8-6FJKzUGNQW38LYqGGA=s120-c-rp-mo-br100.png"
                                      alt="Amy Fleming"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Amy Fleming</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="1 year ago"
                                      class="wpsr-review-date"
                                    >
                                      June 21, 2023</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Greg was so amazing! My bike tire went
                                    flat on the Ashton-Tetonia trail and
                                    he brought me a replacement so I
                                    wasn’t stuck out there. He was really
                                    nice about it and I was so grateful
                                    for his help! I have rented from
                                    InstaGear Outdoor Rentals before, and
                                    I will continue to do so. They have
                                    all the gear you need and the service
                                    is top notch!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="15"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ALV-UjWdctxVww57VQLMNr52gfXqOzs1ngx_WsyglGZxwNacIkYUkEM=s120-c-rp-mo-br100.png"
                                      alt="Brandon Bair"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Brandon Bair</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="1 year ago"
                                      class="wpsr-review-date"
                                    >
                                      May 29, 2023</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Get your fishing license, worms, and
                                    any thing else you need!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="16"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ACg8ocIjNVSi66iilO4XmQzD7LtfukEqkvMO8zIT4UHsGcuBxvkCuQ=s120-c-rp-mo-br100.png"
                                      alt="kristine prindle"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >kristine prindle</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="1 year ago"
                                      class="wpsr-review-date"
                                    >
                                      May 18, 2023</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    We traveled from NY for the fishing,
                                    but left our poles at home. We called
                                    Instagear Outdoor Rentals to rent and
                                    although shop was under construction,
                                    they met us at the shop and rented us
                                    poles and other gear. They were very
                                    helpful and we had a great time!!
                                    Thanks
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="17"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ALV-UjWBXB4DwGKSDj4GiB_HAsieprbis37Ga-JZbHbQ8tMvbcFlBPI=s120-c-rp-mo-br100.png"
                                      alt="Jennifer Fowler"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Jennifer Fowler</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="1 year ago"
                                      class="wpsr-review-date"
                                    >
                                      May 18, 2023</span
                                    >
                                  </div>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="18"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ALV-UjU7NxaUaLQeoeOEW-2rKeNexe5q5jHRzQv8hdZTSg7ndWd_3WI=s120-c-rp-mo-br100.png"
                                      alt="Shaylyn Labra"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Shaylyn Labra</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="1 year ago"
                                      class="wpsr-review-date"
                                    >
                                      May 6, 2023</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    We rented the projector and the mini
                                    tents. It was super easy and great
                                    service! They did an awesome job
                                    setting up the tents for my daughters
                                    birthday party! Anytime we can use
                                    them we will!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="19"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ALV-UjWzqEwqK3VHjfJLl9OXmXlW6AlQxOpjXbYeq8yvRI9l61FBtRUs=s120-c-rp-mo-br100.png"
                                      alt="connie thorkelson"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >connie thorkelson</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="2 years ago"
                                      class="wpsr-review-date"
                                    >
                                      September 14, 2022</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    I have rented summer equipment from
                                    BYUI for years, but decided to try
                                    InstaGear. I wasn’t disappointed. They
                                    had the floating gear we needed. It
                                    was easy to pick up and drop off
                                    equipment. I can’t wait to do it all
                                    again next year.
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="20"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ALV-UjW5id8hmEShrMANfTg3QsjLdw8ImvAzpJdWYtsS94tIWHz_uLwTzQ=s120-c-rp-mo-ba4-br100.png"
                                      alt="Ryan &amp; Amanda Cook"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Ryan &amp; Amanda Cook</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="2 years ago"
                                      class="wpsr-review-date"
                                    >
                                      September 13, 2022</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Great place to rent kayaks!! They were
                                    a bargain price compared to others and
                                    they were so friendly and easy to work
                                    with!! They were so willing to make
                                    things work when my plans changed! I
                                    will rent from here every time!!!!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="21"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ALV-UjVXyJ30WLaVN1ARkBNRXcxsSfS43QPI9fztNT2Qz4L0uFP5zbao=s120-c-rp-mo-ba3-br100.png"
                                      alt="Brady Fielding"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Brady Fielding</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="2 years ago"
                                      class="wpsr-review-date"
                                    >
                                      September 6, 2022</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Great place to rent gear! Very helpful
                                    with tips for the journey you want to
                                    take as well.
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="22"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ACg8ocIPUiB0FdoWWYYDM4vQCKr2Q4xf687vaI1bPy9XECapWir71Q=s120-c-rp-mo-br100.png"
                                      alt="Michelle Poll"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Michelle Poll</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="2 years ago"
                                      class="wpsr-review-date"
                                    >
                                      August 2, 2022</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Super fast and ready to pick up our
                                    great and get it loaded! Gear was
                                    perfect and all 11 of us had a blast!!
                                    Definitely will use instaGear again
                                    for our outdoor fun! We even found
                                    lake creatures!! (Sorry no pictures
                                    kayaking, needed to keep the phone
                                    dry.)
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="23"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ALV-UjVePFZYg9U2GOb98Q1Pa7hIYcW-9-35Kr2u49p2VeWBaSECDWsC=s120-c-rp-mo-br100.png"
                                      alt="Mari Ann Birch"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Mari Ann Birch</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="2 years ago"
                                      class="wpsr-review-date"
                                    >
                                      July 28, 2022</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    I needed an extra kayak for just a few
                                    days. It was nice to have InstaGear
                                    Outdoor Rentals so close with ample
                                    inventory. Greg was friendly, the
                                    process was quick, and the price was
                                    fair. They had us in and out and on
                                    the river in no time. The best
                                    part...I don't have to store another
                                    kayak that will only be used a few
                                    times a year. I would whole-heartedly
                                    recommend them.
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="24"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ALV-UjUMu-_JGzMyeekYKo23jwFmEgomtE7dcfd8VZZmZbgD1e_vjgFU=s120-c-rp-mo-br100.png"
                                      alt="Kaitlyn Liebert"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Kaitlyn Liebert</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="2 years ago"
                                      class="wpsr-review-date"
                                    >
                                      July 27, 2022</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Very helpful, had tons of things to
                                    rent and told us some good places to
                                    go. Will be back again!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="25"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ACg8ocLx8Z9TwqTOIehr7lRAevjDhNT9FE3GF3EK2_PFrbiUIpnJmw=s120-c-rp-mo-br100.png"
                                      alt="Lori Williams"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Lori Williams</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="2 years ago"
                                      class="wpsr-review-date"
                                    >
                                      July 27, 2022</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    This place is great! He was able to
                                    hook us up with last-minute,
                                    affordable kayaks for the kids to use.
                                    He was super helpful in showing us a
                                    spot to take them as well. A very nice
                                    guy and a super place to do business!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="26"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ACg8ocKPeztc3N6tmaAKcSXRuSrc82JnBWF0D1bJU4iaTm0_dnPsAg=s120-c-rp-mo-br100.png"
                                      alt="Ken Robertson"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Ken Robertson</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="2 years ago"
                                      class="wpsr-review-date"
                                    >
                                      July 25, 2022</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    The Kayaks we rented worked great and
                                    were tons of fun. Prices were very
                                    reasonable. The process for drop off
                                    and pickup was easy. Would definitely
                                    recommend renting here.
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="27"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ACg8ocKKGYdL1DxcmnSJKjZWZ3RRFwBpQY86fkEiGD8ocHaGslXs6A=s120-c-rp-mo-br100.png"
                                      alt="Olivia Smith"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Olivia Smith</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="2 years ago"
                                      class="wpsr-review-date"
                                    >
                                      July 21, 2022</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Reserving the kayaks was easy and
                                    everything was ready for us when we
                                    showed up to pick them up, the
                                    equipment was all in great shape and
                                    drop off was just as easy as pick up!
                                    Will definitely be renting from her
                                    again!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="28"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ALV-UjWQFoT_fCQJlW01WlhiP9buoHf9pdNBbjUhgdo5LafFSZYNGw=s120-c-rp-mo-br100.png"
                                      alt="alan allen"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >alan allen</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="2 years ago"
                                      class="wpsr-review-date"
                                    >
                                      July 18, 2022</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Greg had everything we needed at
                                    InstaGrar Outdoor rentals. He was
                                    helpful, friendly and had everything
                                    ready for us when we need to pick up
                                    our gear. His shop has practically
                                    everything you’ll need to have a great
                                    outdoor experience year round.
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="29"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ACg8ocKYmPeem2VGirF49NosLNtjBazkAh0xcZux3uQHaGa-xilMew=s120-c-rp-mo-ba2-br100.png"
                                      alt="Matt Christensen"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Matt Christensen</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="2 years ago"
                                      class="wpsr-review-date"
                                    >
                                      July 18, 2022</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Rental was flawless. They called me
                                    the night before to verify if we
                                    needed the equipment inflated or not.
                                    Showed up and they had our rentals
                                    ready to go, helped us load it all in
                                    the trailer. Drop off went just as
                                    smoothly. 5 star facility for water
                                    fun rentals. GREAT JOB!!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="30"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ACg8ocJNxTtNK-NG4giRioq2CMtEzfWfXUWJJTkVC70YVQ0WEJOP6A=s120-c-rp-mo-br100.png"
                                      alt="Kendall Grant"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Kendall Grant</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="2 years ago"
                                      class="wpsr-review-date"
                                    >
                                      July 16, 2022</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Best gear rental ever. Professional,
                                    happy, reasonable. Oh, and check out
                                    the pottery they sell in the
                                    store—awesome stuff.
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="31"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ACg8ocLOzPwyYR1WDujrmy7A9bTN93ljulc0FfviPuo6P2_Orbdr2A=s120-c-rp-mo-br100.png"
                                      alt="Megan Beutler"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Megan Beutler</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="2 years ago"
                                      class="wpsr-review-date"
                                    >
                                      July 16, 2022</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Great experience!! They had ample
                                    amounts of gear to choose from at a
                                    very reasonable price. Very easy
                                    location to pick up and drop from. 10
                                    out of 10 would recommend!!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="32"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ACg8ocJ4giR3I_lJsSFvVftOJiZc_rWW0BW_OK_R9bM6AtHw5tTw7Q=s120-c-rp-mo-br100.png"
                                      alt="Lizzie Brown"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Lizzie Brown</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="2 years ago"
                                      class="wpsr-review-date"
                                    >
                                      July 15, 2022</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    We rented the 8 person instant tent
                                    and it was clean, easy to set up and
                                    the InstaGear location is easily
                                    accessible from the highway. Great
                                    prices for rentals. Would highly
                                    recommend and will definitely be
                                    renting more from here soon. Great
                                    place for easy rentals on your way to
                                    Island Park or Yellowstone.
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="33"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ACg8ocKSYG4sazyVIdwi1q9q_OuIwxbOkBvrVxehGDnkX1N7083Umw=s120-c-rp-mo-br100.png"
                                      alt="mckenna winger"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >mckenna winger</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="2 years ago"
                                      class="wpsr-review-date"
                                    >
                                      May 27, 2022</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    You guys are the absolute best!
                                    Definitely looking forward to a
                                    glamping adventure with the luxury
                                    tents this summer!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="34"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ALV-UjUtruid5pbPs3Zj9-z04Ckqgw78nyE6uIuJbF2WMosOfhoBLZ78=s120-c-rp-mo-br100.png"
                                      alt="Tanner Grant"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Tanner Grant</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="2 years ago"
                                      class="wpsr-review-date"
                                    >
                                      May 27, 2022</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    The owners of Instagear always make
                                    sure that my outdoor adventures are
                                    fun and stress free! I will always
                                    come back here for my future rentals.
                                    You guys are awesome!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="35"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ALV-UjXmj8-2b9fOo-3j821iROHCej-UnhNUFkF3n7jvTjLXYJAglz0J=s120-c-rp-mo-br100.png"
                                      alt="Tara McPherson"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Tara McPherson</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="2 years ago"
                                      class="wpsr-review-date"
                                    >
                                      May 16, 2022</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    They have such fun products. All the
                                    extras decor was so cute &amp; fun!
                                    They were nice and quick setup, plus
                                    not having to set it all up is a plus.
                                    We will be back!!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="36"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ALV-UjXVTzdR-73lzpNfi99jvlomZiYKgN4rXL4fUTd5fK7n35ShgNM=s120-c-rp-mo-br100.png"
                                      alt="Brooke Jubitz"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Brooke Jubitz</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="2 years ago"
                                      class="wpsr-review-date"
                                    >
                                      April 7, 2022</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Instagear is the best place to get
                                    your gear!! We’ve enjoyed countless
                                    adventures thanks to them. Not only do
                                    they have the gear you need but they
                                    also can tell you where to go! Best
                                    experience ever!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="37"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ACg8ocJdhCTHr-lS4tfvoJZixrwU4K_yp5pv49RWMCbeg9rtGTgWUA=s120-c-rp-mo-br100.png"
                                      alt="Sus Grant"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Sus Grant</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="2 years ago"
                                      class="wpsr-review-date"
                                    >
                                      March 16, 2022</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Love this place, and these people!
                                    Such great staff and Customer service!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="38"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ACg8ocIY61kPmf3fm6-u0ejCD1xBET-IXDdmlbXGgbUoR61oIGAM7Q=s120-c-rp-mo-br100.png"
                                      alt="Gloria Lusk"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Gloria Lusk</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="2 years ago"
                                      class="wpsr-review-date"
                                    >
                                      March 16, 2022</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    InstaGear Outdoor Rentals is the place
                                    to go! They are so great to work with
                                    and they really care about giving you
                                    a fun adventure. Greg and McKenzie
                                    took awesome care of us with our
                                    kayaking experience. We are excited to
                                    try out the other fun things they have
                                    to offer. I highly recommend them!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="39"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ALV-UjW0PgoNNsNQJP-A_6kzAvHiaj_tWLuuijE8PCqy5s3M8qR-0WWl=s120-c-rp-mo-br100.png"
                                      alt="Eric Evanson"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Eric Evanson</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="2 years ago"
                                      class="wpsr-review-date"
                                    >
                                      March 15, 2022</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    This company is the best place to rent
                                    outdoor equipment. I have had my fair
                                    share of outdoor adventures with the
                                    people behind this and I can say that
                                    they genuinely care about their
                                    customers’ experiences.
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="40"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ACg8ocJcBRE1rs90wt0LdbSY_1l48CvtzZMOHIZiH5ID4v9WzFSWpQ=s120-c-rp-mo-br100.png"
                                      alt="JeriLyn Owens"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >JeriLyn Owens</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="2 years ago"
                                      class="wpsr-review-date"
                                    >
                                      March 15, 2022</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Last summer, my family decided to go
                                    kayaking. It was kind of last minute
                                    and we were short a kayak so I decided
                                    to send a message to these guys. I
                                    thought to myself, we are planning on
                                    leaving in an hour, there is no way
                                    they will see our message before that.
                                    But they did! And there prices were so
                                    affordable! The whole process was
                                    smooth, quick and easy and we had a
                                    great time. We will definitely be
                                    renting from them again in the future!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="41"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ACg8ocLj_fIOxSyxxlZgsVhgMFFViK2jWyNfL_NU3OXPMJBmUmQcHQ=s120-c-rp-mo-br100.png"
                                      alt="Carly Cook"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Carly Cook</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="3 years ago"
                                      class="wpsr-review-date"
                                    >
                                      March 4, 2022</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Greg and the crew at InstaGear Outdoor
                                    Rentals are THE BEST! They took care
                                    of every detail of the trip and made
                                    it the most memorable experience for
                                    us. From kayaks to tents to camping
                                    gear, they have it all, and we
                                    couldn't recommend them more.
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-facebook"
                                style=""
                                data-index="42"
                                data-review_platform="facebook"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://www.facebook.com/101209281697636/reviews"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/picture-EAAGTJHJgNIMBAMM8umkkMkwZATHUWjHhiRfZBqo9mY0BcsZCxfOi12JlEPMPJiyUNJciRXE4FT4iFM1988Jy6Ylx6r81p1KSzsZCihx8d8sahq5zxtHyZCOTJlmmRDJnVbTZAGPEvvEc2VVthAzYbEwDb8OORyYWf1jRbIP38roMhs361ekeHHsmCBjzw0YyoZD_square_100_100.jpg"
                                      alt="Amber Steele"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-facebook-small.png"
                                      alt="facebook"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://www.facebook.com/101209281697636/reviews"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Amber Steele</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-recommends">
                                        <svg width="18" height="18">
                                          <path
                                            d="M9 14l-3.293 3.293A1 1 0 0 1 4 16.586V14h-.154c-1.337 0-1.822-.14-2.311-.4A2.726 2.726 0 0 1 .4 12.464c-.261-.488-.4-.973-.4-2.309v-6.31c0-1.336.14-1.821.4-2.31A2.726 2.726 0 0 1 1.536.4c.488-.261.973-.4 2.309-.4h10.31c1.336 0 1.821.14 2.31.4.49.262.873.646 1.134 1.135.262.489.401.974.401 2.31v6.31c0 1.336-.14 1.821-.4 2.31a2.726 2.726 0 0 1-1.135 1.134c-.489.262-.974.401-2.31.401H9zm0-5l1.454.765a.5.5 0 0 0 .726-.527l-.278-1.62 1.177-1.147a.5.5 0 0 0-.277-.853l-1.626-.236-.728-1.474a.5.5 0 0 0-.896 0l-.728 1.474-1.626.236a.5.5 0 0 0-.277.853l1.177 1.147-.278 1.62a.5.5 0 0 0 .726.527L9 9z"
                                          ></path>
                                        </svg>
                                        <span>recommends</span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="3 years ago"
                                      class="wpsr-review-date"
                                    >
                                      August 17, 2021</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    We rented a stand up paddle board for
                                    the day and we had a great
                                    experience!! Greg was very friendly
                                    and prompt with our rental request, he
                                    had us loaded up and ready to go with
                                    a quality paddle board in just
                                    minutes! You can’t beat the awesome
                                    customer service, convenient location
                                    and flexible hours!! I can’t wait to
                                    rent equipment from them again!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-facebook"
                                style=""
                                data-index="43"
                                data-review_platform="facebook"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://www.facebook.com/101209281697636/reviews"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/picture-EAAGTJHJgNIMBAMM8umkkMkwZATHUWjHhiRfZBqo9mY0BcsZCxfOi12JlEPMPJiyUNJciRXE4FT4iFM1988Jy6Ylx6r81p1KSzsZCihx8d8sahq5zxtHyZCOTJlmmRDJnVbTZAGPEvvEc2VVthAzYbEwDb8OORyYWf1jRbIP38roMhs361ekeHHsmCBjzw0YyoZD_square_100_1001.jpg"
                                      alt="Kennedi McOmber"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-facebook-small.png"
                                      alt="facebook"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://www.facebook.com/101209281697636/reviews"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Kennedi McOmber</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-recommends">
                                        <svg width="18" height="18">
                                          <path
                                            d="M9 14l-3.293 3.293A1 1 0 0 1 4 16.586V14h-.154c-1.337 0-1.822-.14-2.311-.4A2.726 2.726 0 0 1 .4 12.464c-.261-.488-.4-.973-.4-2.309v-6.31c0-1.336.14-1.821.4-2.31A2.726 2.726 0 0 1 1.536.4c.488-.261.973-.4 2.309-.4h10.31c1.336 0 1.821.14 2.31.4.49.262.873.646 1.134 1.135.262.489.401.974.401 2.31v6.31c0 1.336-.14 1.821-.4 2.31a2.726 2.726 0 0 1-1.135 1.134c-.489.262-.974.401-2.31.401H9zm0-5l1.454.765a.5.5 0 0 0 .726-.527l-.278-1.62 1.177-1.147a.5.5 0 0 0-.277-.853l-1.626-.236-.728-1.474a.5.5 0 0 0-.896 0l-.728 1.474-1.626.236a.5.5 0 0 0-.277.853l1.177 1.147-.278 1.62a.5.5 0 0 0 .726.527L9 9z"
                                          ></path>
                                        </svg>
                                        <span>recommends</span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="3 years ago"
                                      class="wpsr-review-date"
                                    >
                                      August 14, 2021</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Great service, great prices, and even
                                    greater people! Greg and McKenzie make
                                    this process quick and easy, so you
                                    can get out and enjoy the outdoors as
                                    soon as you can! Absolutely recommend!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="44"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ACg8ocLBd__MU6Yr3zEkOG54BUG3N4EgeEG1lDSOCPboClhjX7Ix6g=s120-c-rp-mo-br100.png"
                                      alt="Courtney Lusk"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Courtney Lusk</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="3 years ago"
                                      class="wpsr-review-date"
                                    >
                                      August 13, 2021</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    InstaGear Outdoor Rentals is owned by
                                    a local couple that really the love
                                    outdoors. They strive to provide a
                                    quality business for everyone from
                                    beginners to experts to enjoy. You can
                                    rent their gear in three different
                                    easy ways to save yourself from
                                    unnecessary complication. If you are
                                    looking for a fun adventure InstaGear
                                    Outdoor Rentals needs to be the first
                                    stop you make!
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-google"
                                style=""
                                data-index="45"
                                data-review_platform="google"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/ACg8ocKEWp7rsnfOyO-HdPt1oPsoHajU7e5hk5ChqlZ9FQvVtYZHVw=s120-c-rp-mo-br100.png"
                                      alt="Justin McOmber"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-google-small.png"
                                      alt="google"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://search.google.com/local/reviews?placeid=ChIJK3wA60puxCgRsksgUKzSg8E"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Justin McOmber</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-rating">
                                        <span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg></span
                                        ><span class="wpsr-star"
                                          ><svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            version="1.1"
                                            viewbox="0 0 1792 1792"
                                          >
                                            <path
                                              d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path></svg
                                        ></span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="3 years ago"
                                      class="wpsr-review-date"
                                    >
                                      August 13, 2021</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Amazing gear and even better people.
                                    These guys are a good family company
                                    that that provide quality gear with
                                    quality service. The price isn’t bad
                                    at all either. 10 / 10 would recommend
                                    to anyone wanting to go on a fun day
                                    out with the family, on a date, or
                                    even just a solo trip.
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-facebook"
                                style=""
                                data-index="46"
                                data-review_platform="facebook"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://www.facebook.com/101209281697636/reviews"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/picture-EAAGTJHJgNIMBAMM8umkkMkwZATHUWjHhiRfZBqo9mY0BcsZCxfOi12JlEPMPJiyUNJciRXE4FT4iFM1988Jy6Ylx6r81p1KSzsZCihx8d8sahq5zxtHyZCOTJlmmRDJnVbTZAGPEvvEc2VVthAzYbEwDb8OORyYWf1jRbIP38roMhs361ekeHHsmCBjzw0YyoZD_square_100_1002.jpg"
                                      alt="Justin McOmber"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-facebook-small.png"
                                      alt="facebook"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://www.facebook.com/101209281697636/reviews"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Justin McOmber</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-recommends">
                                        <svg width="18" height="18">
                                          <path
                                            d="M9 14l-3.293 3.293A1 1 0 0 1 4 16.586V14h-.154c-1.337 0-1.822-.14-2.311-.4A2.726 2.726 0 0 1 .4 12.464c-.261-.488-.4-.973-.4-2.309v-6.31c0-1.336.14-1.821.4-2.31A2.726 2.726 0 0 1 1.536.4c.488-.261.973-.4 2.309-.4h10.31c1.336 0 1.821.14 2.31.4.49.262.873.646 1.134 1.135.262.489.401.974.401 2.31v6.31c0 1.336-.14 1.821-.4 2.31a2.726 2.726 0 0 1-1.135 1.134c-.489.262-.974.401-2.31.401H9zm0-5l1.454.765a.5.5 0 0 0 .726-.527l-.278-1.62 1.177-1.147a.5.5 0 0 0-.277-.853l-1.626-.236-.728-1.474a.5.5 0 0 0-.896 0l-.728 1.474-1.626.236a.5.5 0 0 0-.277.853l1.177 1.147-.278 1.62a.5.5 0 0 0 .726.527L9 9z"
                                          ></path>
                                        </svg>
                                        <span>recommends</span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="3 years ago"
                                      class="wpsr-review-date"
                                    >
                                      August 13, 2021</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Amazing gear and even better people.
                                    These guys are a good family company
                                    that that provide quality gear with
                                    quality service. The price isn’t bad
                                    at all either. 10 / 10 would recommend
                                    to anyone wanting to go on a fun day
                                    out with the family, on a date, or
                                    even just a solo trip.
                                  </p>
                                </div>
                              </div>
                            </div>
                            <div class="swiper-slide" role="group">
                              <div
                                class="wpsr-review-template wpsr-review-template-one wpsr-review-template-facebook"
                                style=""
                                data-index="47"
                                data-review_platform="facebook"
                                data-product_thumbnail=""
                                data-product_name=""
                              >
                                <div class="wpsr-reviewer-image">
                                  <a
                                    class="wpsr-reviewer-image-url"
                                    target="_blank"
                                    rel="noopener noreferrer nofollow"
                                    href="https://www.facebook.com/101209281697636/reviews"
                                  >
                                    <img
                                      decoding="async"
                                      class="wpsr-reviewer-avatar"
                                      src="static/picture/picture-EAAGTJHJgNIMBAMM8umkkMkwZATHUWjHhiRfZBqo9mY0BcsZCxfOi12JlEPMPJiyUNJciRXE4FT4iFM1988Jy6Ylx6r81p1KSzsZCihx8d8sahq5zxtHyZCOTJlmmRDJnVbTZAGPEvvEc2VVthAzYbEwDb8OORyYWf1jRbIP38roMhs361ekeHHsmCBjzw0YyoZD_square_100_1003.jpg"
                                      alt="Brooke Brower Randall"
                                    />
                                  </a>
                                </div>
                                <div class="wpsr-review-header">
                                  <div class="wpsr-review-platform">
                                    <img
                                      loading="lazy"
                                      decoding="async"
                                      class="wpsr-review-platform-icon"
                                      width="20"
                                      height="20"
                                      src="static/picture/icon-facebook-small.png"
                                      alt="facebook"
                                    />
                                  </div>
                                  <div class="wpsr-review-info">
                                    <a
                                      class="wpsr-reviewer-name-url"
                                      target="_blank"
                                      rel="noopener noreferrer nofollow"
                                      href="https://www.facebook.com/101209281697636/reviews"
                                    >
                                      <span class="wpsr-reviewer-name"
                                        >Brooke Brower Randall</span
                                      >
                                    </a>
                                    <div
                                      data-rating="5"
                                      class="wpsr-rating-wrapper"
                                    >
                                      <div class="wpsr-recommends">
                                        <svg width="18" height="18">
                                          <path
                                            d="M9 14l-3.293 3.293A1 1 0 0 1 4 16.586V14h-.154c-1.337 0-1.822-.14-2.311-.4A2.726 2.726 0 0 1 .4 12.464c-.261-.488-.4-.973-.4-2.309v-6.31c0-1.336.14-1.821.4-2.31A2.726 2.726 0 0 1 1.536.4c.488-.261.973-.4 2.309-.4h10.31c1.336 0 1.821.14 2.31.4.49.262.873.646 1.134 1.135.262.489.401.974.401 2.31v6.31c0 1.336-.14 1.821-.4 2.31a2.726 2.726 0 0 1-1.135 1.134c-.489.262-.974.401-2.31.401H9zm0-5l1.454.765a.5.5 0 0 0 .726-.527l-.278-1.62 1.177-1.147a.5.5 0 0 0-.277-.853l-1.626-.236-.728-1.474a.5.5 0 0 0-.896 0l-.728 1.474-1.626.236a.5.5 0 0 0-.277.853l1.177 1.147-.278 1.62a.5.5 0 0 0 .726.527L9 9z"
                                          ></path>
                                        </svg>
                                        <span>recommends</span>
                                      </div>
                                    </div>
                                    <span
                                      data-time="3 years ago"
                                      class="wpsr-review-date"
                                    >
                                      August 12, 2021</span
                                    >
                                  </div>
                                </div>
                                <div
                                  class="wpsr-review-content"
                                  tabindex="0"
                                >
                                  <p
                                    class="wpsr_add_read_more wpsr_show_less_content"
                                    data-num-words-trim="32"
                                  >
                                    Best rental place I have ever rented
                                    from! Easy to work with for
                                    pick-up/drop-off, fair prices, and
                                    great gear! Not to mention super nice
                                    and fabulous service- quick response
                                    and I was even able to get a last
                                    minute rental. Definitely recommend
                                    100% and will be renting from them
                                    again 👍
                                  </p>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="wpsr-swiper-carousel-wrapper">
                          <div
                            class="wpsr-swiper-pagination swiper-pagination"
                            aria-label="Pagination"
                          ></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section
      data-particle_enable="false"
      data-particle-mobile-disabled="false"
      class="elementor-section elementor-top-section elementor-element elementor-element-4b633513 elementor-section-content-middle elementor-section-boxed elementor-section-height-default elementor-section-height-default"
      data-id="4b633513"
      data-element_type="section"
      data-settings='{"background_background":"classic"}'
    >
      <div class="elementor-background-overlay"></div>
      <div class="elementor-container elementor-column-gap-no">
        <div
          class="elementor-column elementor-col-100 elementor-top-column elementor-element elementor-element-516ef4a2"
          data-id="516ef4a2"
          data-element_type="column"
        >
          <div class="elementor-widget-wrap elementor-element-populated">
            <div
              class="elementor-element elementor-element-24e95322 elementor-widget elementor-widget-heading"
              data-id="24e95322"
              data-element_type="widget"
              data-widget_type="heading.default"
            >
              <div class="elementor-widget-container">
                <h4
                  class="elementor-heading-title elementor-size-default"
                >
                  FAQ
                </h4>
              </div>
            </div>
            <div
              class="elementor-element elementor-element-49ea618d elementor-widget elementor-widget-heading"
              data-id="49ea618d"
              data-element_type="widget"
              data-widget_type="heading.default"
            >
              <div class="elementor-widget-container">
                <h5
                  class="elementor-heading-title elementor-size-default"
                >
                  Most frequent questions and answers
                </h5>
              </div>
            </div>
            <section
              data-particle_enable="false"
              data-particle-mobile-disabled="false"
              class="elementor-section elementor-inner-section elementor-element elementor-element-17b6c6db elementor-section-content-middle elementor-section-boxed elementor-section-height-default elementor-section-height-default"
              data-id="17b6c6db"
              data-element_type="section"
            >
              <div
                class="elementor-container elementor-column-gap-default"
              >
                <div
                  class="elementor-column elementor-col-50 elementor-inner-column elementor-element elementor-element-643f3e6d"
                  data-id="643f3e6d"
                  data-element_type="column"
                >
                  <div
                    class="elementor-widget-wrap elementor-element-populated"
                  >
                    <div
                      class="elementor-element elementor-element-5f6c3b01 elementor-widget elementor-widget-accordion"
                      data-id="5f6c3b01"
                      data-element_type="widget"
                      data-widget_type="accordion.default"
                    >
                      <div class="elementor-widget-container">
                        <div class="elementor-accordion">
                          <div class="elementor-accordion-item">
                            <div
                              id="elementor-tab-title-1601"
                              class="elementor-tab-title"
                              data-tab="1"
                              role="button"
                              aria-controls="elementor-tab-content-1601"
                              aria-expanded="false"
                            >
                              <span
                                class="elementor-accordion-icon elementor-accordion-icon-right"
                                aria-hidden="true"
                              >
                                <span
                                  class="elementor-accordion-icon-closed"
                                  ><i
                                    class="far fa-arrow-alt-circle-right"
                                  ></i
                                ></span>
                                <span
                                  class="elementor-accordion-icon-opened"
                                  ><i
                                    class="far fa-arrow-alt-circle-right"
                                  ></i
                                ></span>
                              </span>
                              <a
                                class="elementor-accordion-title"
                                tabindex="0"
                                >How do I book a Shuttle for the Ashton to
                                Tetonia Bike Trail?</a
                              >
                            </div>
                            <div
                              id="elementor-tab-content-1601"
                              class="elementor-tab-content elementor-clearfix"
                              data-tab="1"
                              role="region"
                              aria-labelledby="elementor-tab-title-1601"
                            >
                              <p>
                                <span style="font-weight: 400"
                                  >We offer shuttle and delivery to both
                                  the ATT Bike trail as well as Harriman
                                  State Park. To book a shuttle or
                                  delivery you can schedule one online or
                                  by calling 208-206-9011.</span
                                >
                              </p>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div
                  class="elementor-column elementor-col-50 elementor-inner-column elementor-element elementor-element-78420092"
                  data-id="78420092"
                  data-element_type="column"
                >
                  <div
                    class="elementor-widget-wrap elementor-element-populated"
                  >
                    <div
                      class="elementor-element elementor-element-1fc9e8b9 elementor-widget elementor-widget-accordion"
                      data-id="1fc9e8b9"
                      data-element_type="widget"
                      data-widget_type="accordion.default"
                    >
                      <div class="elementor-widget-container">
                        <div class="elementor-accordion">
                          <div class="elementor-accordion-item">
                            <div
                              id="elementor-tab-title-5331"
                              class="elementor-tab-title"
                              data-tab="1"
                              role="button"
                              aria-controls="elementor-tab-content-5331"
                              aria-expanded="false"
                            >
                              <span
                                class="elementor-accordion-icon elementor-accordion-icon-right"
                                aria-hidden="true"
                              >
                                <span
                                  class="elementor-accordion-icon-closed"
                                  ><i
                                    class="far fa-arrow-alt-circle-right"
                                  ></i
                                ></span>
                                <span
                                  class="elementor-accordion-icon-opened"
                                  ><i
                                    class="far fa-arrow-alt-circle-right"
                                  ></i
                                ></span>
                              </span>
                              <a
                                class="elementor-accordion-title"
                                tabindex="0"
                                >Can you shuttle me back to my car?</a
                              >
                            </div>
                            <div
                              id="elementor-tab-content-5331"
                              class="elementor-tab-content elementor-clearfix"
                              data-tab="1"
                              role="region"
                              aria-labelledby="elementor-tab-title-5331"
                            >
                              <p>
                                <span style="font-weight: 400"
                                  >We can certainly provide one way
                                  shuttles for the Asthon to Tetonia Trail
                                  and return you and your bike to your
                                  car. </span
                                >
                              </p>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </section>
            <section
              data-particle_enable="false"
              data-particle-mobile-disabled="false"
              class="elementor-section elementor-inner-section elementor-element elementor-element-c4322d0 elementor-section-content-middle elementor-section-boxed elementor-section-height-default elementor-section-height-default"
              data-id="c4322d0"
              data-element_type="section"
            >
              <div
                class="elementor-container elementor-column-gap-default"
              >
                <div
                  class="elementor-column elementor-col-50 elementor-inner-column elementor-element elementor-element-9b299ab"
                  data-id="9b299ab"
                  data-element_type="column"
                >
                  <div
                    class="elementor-widget-wrap elementor-element-populated"
                  >
                    <div
                      class="elementor-element elementor-element-a94f76c elementor-widget elementor-widget-accordion"
                      data-id="a94f76c"
                      data-element_type="widget"
                      data-widget_type="accordion.default"
                    >
                      <div class="elementor-widget-container">
                        <div class="elementor-accordion">
                          <div class="elementor-accordion-item">
                            <div
                              id="elementor-tab-title-1771"
                              class="elementor-tab-title"
                              data-tab="1"
                              role="button"
                              aria-controls="elementor-tab-content-1771"
                              aria-expanded="false"
                            >
                              <span
                                class="elementor-accordion-icon elementor-accordion-icon-right"
                                aria-hidden="true"
                              >
                                <span
                                  class="elementor-accordion-icon-closed"
                                  ><i
                                    class="far fa-arrow-alt-circle-right"
                                  ></i
                                ></span>
                                <span
                                  class="elementor-accordion-icon-opened"
                                  ><i
                                    class="far fa-arrow-alt-circle-right"
                                  ></i
                                ></span>
                              </span>
                              <a
                                class="elementor-accordion-title"
                                tabindex="0"
                                >Can you deliver the gear to my adventure
                                location?</a
                              >
                            </div>
                            <div
                              id="elementor-tab-content-1771"
                              class="elementor-tab-content elementor-clearfix"
                              data-tab="1"
                              role="region"
                              aria-labelledby="elementor-tab-title-1771"
                            >
                              <p>
                                <span style="font-weight: 400"
                                  >Of course! We can deliver to any
                                  location (other than National Forest or
                                  BLM) accessible by pickup and trailer
                                  within an hour of St. Anthony,
                                  Idaho. </span
                                >
                              </p>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div
                  class="elementor-column elementor-col-50 elementor-inner-column elementor-element elementor-element-624f22a"
                  data-id="624f22a"
                  data-element_type="column"
                >
                  <div
                    class="elementor-widget-wrap elementor-element-populated"
                  >
                    <div
                      class="elementor-element elementor-element-ec94d47 elementor-widget elementor-widget-accordion"
                      data-id="ec94d47"
                      data-element_type="widget"
                      data-widget_type="accordion.default"
                    >
                      <div class="elementor-widget-container">
                        <div class="elementor-accordion">
                          <div class="elementor-accordion-item">
                            <div
                              id="elementor-tab-title-2481"
                              class="elementor-tab-title"
                              data-tab="1"
                              role="button"
                              aria-controls="elementor-tab-content-2481"
                              aria-expanded="false"
                            >
                              <span
                                class="elementor-accordion-icon elementor-accordion-icon-right"
                                aria-hidden="true"
                              >
                                <span
                                  class="elementor-accordion-icon-closed"
                                  ><i
                                    class="far fa-arrow-alt-circle-right"
                                  ></i
                                ></span>
                                <span
                                  class="elementor-accordion-icon-opened"
                                  ><i
                                    class="far fa-arrow-alt-circle-right"
                                  ></i
                                ></span>
                              </span>
                              <a
                                class="elementor-accordion-title"
                                tabindex="0"
                                >How frequently do ATT shuttles run?</a
                              >
                            </div>
                            <div
                              id="elementor-tab-content-2481"
                              class="elementor-tab-content elementor-clearfix"
                              data-tab="1"
                              role="region"
                              aria-labelledby="elementor-tab-title-2481"
                            >
                              <p>
                                <span style="font-weight: 400"
                                  >Shuttles operate on a reservation basis
                                  only. We prefer to have at least 1-weeks
                                  notice if possible. Inside of 48-hours
                                  there is no guarantee that we will be
                                  able to provide shuttle services to
                                  you. </span
                                >
                              </p>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </section>
            <div
              class="elementor-element elementor-element-964ba02 elementor-align-center elementor-widget elementor-widget-button"
              data-id="964ba02"
              data-element_type="widget"
              data-widget_type="button.default"
            >
              <div class="elementor-widget-container">
                <div class="elementor-button-wrapper">
                  <a
                    class="elementor-button elementor-button-link elementor-size-md"
                    href="faq.html"
                  >
                    <span class="elementor-button-content-wrapper">
                      <span class="elementor-button-text"
                        >Go To FAQ's</span
                      >
                    </span>
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section
      data-particle_enable="false"
      data-particle-mobile-disabled="false"
      class="elementor-section elementor-top-section elementor-element elementor-element-6f0a6c3 elementor-section-content-middle elementor-section-full_width elementor-section-height-default elementor-section-height-default"
      data-id="6f0a6c3"
      data-element_type="section"
    >
      <div class="elementor-container elementor-column-gap-no">
        <div
          class="elementor-column elementor-col-100 elementor-top-column elementor-element elementor-element-6c7b023b"
          data-id="6c7b023b"
          data-element_type="column"
        >
          <div class="elementor-widget-wrap elementor-element-populated">
            <div
              class="elementor-element elementor-element-444da2b elementor-widget elementor-widget-heading"
              data-id="444da2b"
              data-element_type="widget"
              data-widget_type="heading.default"
            >
              <div class="elementor-widget-container">
                <h2
                  class="elementor-heading-title elementor-size-default"
                >
                  Follow Us On Instagram!
                </h2>
              </div>
            </div>
            <div
              class="elementor-element elementor-element-881b0f6 elementor-widget elementor-widget-wp-social-ninja-instagram-widget"
              data-id="881b0f6"
              data-element_type="widget"
              data-widget_type="wp-social-ninja-instagram-widget.default"
            >
              <div class="elementor-widget-container">
                <div
                  id="wpsr-ig-feed-304"
                  class="wpsr-ig-feed-wrapper wpsr-feed-wrap wpsr_content wpsr-ig-feed-template1 wpsr-ig-feed-template-304 wpsr-instagram-slider-activate"
                  data-slider_settings='{"autoplay":"true","autoplay_speed":3000,"spaceBetween":null,"responsive_slides_to_show":{"desktop":5,"tablet":2,"mobile":1},"responsive_slides_to_scroll":{"desktop":1,"tablet":2,"mobile":1},"navigation":"none"}'
                  data-column="5"
                >
                  <div class="wpsr-container wpsr-insta-feed-304">
                    <div class="wpsr-ig-feed-wrapper-inner">
                      <div class="swiper-container" tabindex="0">
                        <div
                          class="swiper-wrapper wpsr-ig-all-feed wpsr_feeds wpsr-column-gap-"
                        >
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18026919131340192"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="0"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-0"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/458287116_18033347273335927_6190649239508075861_n.jpg"
                                  alt="Open 9-2 today! Have a great Labor Day!"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>5</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  Open 9-2 today! Have a great Labor Day!
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18456088105050869"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="1"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-1"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/457665848_18033225689335927_5859978615490136897_n.jpg"
                                  alt="These two worked hard this summer to save up their portion for these sweet rides! Thanks for picking InstaGear and our Mokwheel EBikes for your adventures! Have fun! #AdventureElevated #InstaGear #Mokwheel #EBikes"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>17</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  These two worked hard this summer to
                                  save up their portion for these sweet
                                  rides!...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18068751862575602"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="2"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-2"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/457247154_18032727548335927_4104190999424951440_n.jpg"
                                  alt="Huge thanks to Rod and Amy for choosing InstaGear for your new e-bikes! We’re excited to see all the adventures ahead. 🚴‍♂️ If you’re in the market for a home, make sure to connect with them over at Idaho’s Real Estate—they’ve got you covered on and off the trail! 🏠🚴‍♀️"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>21</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  Huge thanks to Rod and Amy for choosing
                                  InstaGear for your new e-bikes! We’re
                                  excited...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18015208277279493"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="3"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-3"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/456401318_18032118092335927_1230659943447444533_n.jpg"
                                  alt="Get ready for Streetfest fun tonight! 🎉 We’ll be serving up ice cold 32oz lemonades from 4-9 right in front of our shop 🍋🥶. So swing by, grab a refreshing drink, and while you’re here, don’t miss out on our killer Streetfest e-bike sale! 🚴‍♂️🔥 See you there!"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>9</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  Get ready for Streetfest fun tonight! 🎉
                                  We’ll be serving up ice cold 32oz
                                  lemonades...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18085444336488902"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="4"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-4"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/455920594_18031488776335927_1108934769865718516_n.jpg"
                                  alt="A huge shoutout to the Lundquists for rolling out in style with their brand new Mokwheel Obsidian and Basalt ST! 🎉🚴‍♂️🚴‍♀️ We can’t wait to hear about the adventures you two will tackle on those sweet rides! Thanks for supporting our shop and trusting us to get you road (or trail) ready! 🙌 Enjoy the ride, and let the good times roll! ✨ #NewWheelsWhoDis #EbikeSquad #AdventureTime #Mokwheel"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>17</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  A huge shoutout to the Lundquists for
                                  rolling out in style with their brand
                                  new...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="17976683906730647"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="5"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-5"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/454803810_18030655574335927_1130653266524917606_n.jpg"
                                  alt="“Ready to explore the great outdoors? 🚴‍♂️ Our e-bikes are fully charged and ready for your next adventure! Whether you’re hitting the trails or cruising around town, renting one of our e-bikes today is the perfect way to make the most of this beautiful day. Daily and hourly rentals available. Call now to reserve yours and let the adventure begin! 🌟 #EBikeAdventures #ExploreIdaho #RideToday”"
                                  loading="lazy"
                                />

                                <div
                                  class="wpsr-ig-post-type-icon wpsr-ig-post-type-CAROUSEL_ALBUM"
                                ></div>
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>14</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  “Ready to explore the great outdoors? 🚴‍♂️
                                  Our e-bikes are fully charged and ready
                                  for...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18032763697943794"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="6"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-6"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/454968784_18030590777335927_7265074242689509535_n.jpg"
                                  alt="🔥 Our Summer Clearance Sale is here, and it’s BIG! Get up to 50% off on all your summer essentials—e-bikes, backpacks, water gear, shoes, hats, water bottles, and more. 🌞 But hurry—these deals last only while supplies do! Don’t miss out on the best bargains of the season. Time to gear up and save big before it’s all gone! 🏃‍♂️💨 #SummerSale #ClearanceBlowout #GearUpAndGo"
                                  loading="lazy"
                                />

                                <div
                                  class="wpsr-ig-post-type-icon wpsr-ig-post-type-CAROUSEL_ALBUM"
                                ></div>
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>8</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  🔥 Our Summer Clearance Sale is here,
                                  and it’s BIG! Get up to 50% off...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18452303761020813"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="7"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-7"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/454355443_18030228734335927_2058289733510197775_n.jpg"
                                  alt="🌊🌲 Looking for the best spots to paddle board in Eastern Idaho? We’ve got you covered! Paddle boarding is a fun and easy way to enjoy the great outdoors, and we’ve got tons of paddleboards available for rent at just $29 per 24-hour period. Here are some amazing local spots to explore:

🏞️ **String Lake in the Tetons** – Enjoy stunning mountain views while paddling in crystal-clear waters.
🏞️ **Horseshoe Lake** – A serene and scenic spot perfect for a peaceful paddle.
🏞️ **Meadow Lake** – Discover the beauty of this hidden gem.
🏞️ **Teardrop Lake** – Ideal for a quiet and tranquil adventure.
🏞️ **Henry’s Fork** – Experience the thrill of paddle boarding on this iconic river.
🏞️ **Big Springs** – Paddle through clear waters and spot some wildlife.
🏞️ **Buffalo River** – A perfect spot for a relaxing day on the water.

Paddle boarding is easy for all skill levels, so grab your family and friends and hit the water! Visit us in Saint Anthony, Idaho, to rent your paddleboards and start your adventure today! 🌞🚣‍♂️ #PaddleBoarding #EasternIdahoAdventures #OutdoorFun #ExploreIdaho"
                                  loading="lazy"
                                />

                                <div
                                  class="wpsr-ig-post-type-icon wpsr-ig-post-type-CAROUSEL_ALBUM"
                                ></div>
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>11</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  🌊🌲 Looking for the best spots to
                                  paddle board in Eastern Idaho? We’ve got
                                  you...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18046990750884114"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="8"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-8"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/453906250_18029925407335927_3515943720801706623_n.jpg"
                                  alt="Thanks for supporting local,Leon! We hope you enjoy your new Mokwheel Basalt! Our new ebike sale drops today, come check it out and pick up a new adventure companion on a steal of a deal!!!
#summertime #playtime #ridemokwheel"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>11</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  Thanks for supporting local,Leon! We
                                  hope you enjoy your new Mokwheel Basalt!
                                  Our new ebike...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18106386571409700"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="9"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-9"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/452913707_18029124170335927_7648881574889879312_n.jpg"
                                  alt="Don’t forget our parade time hours tomorrow! We will be open from 8:30-9:30 for early pickup, closed for the parade, then open from the end of the parade until 6pm. Stop by and let us set you up with some Adventure Gear! Rafts, Ebikes, paddleboards, tubes, kayaks, yard games and more still available! 
#paradetime #pioneerday #adventuretime #saintanthony"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>35</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  Don’t forget our parade time hours
                                  tomorrow! We will be open from 8:30-9:30
                                  for early...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18446532460043641"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="10"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background VIDEO"
                                id="wpsr-video-play-10"
                              >
                                <video
                                  class="wpsr-ig-post-video"
                                  poster="https://scontent.cdninstagram.com/v/t51.29350-15/452730216_370738045781244_3108231789226268392_n.jpg?_nc_cat=100&#038;ccb=1-7&#038;_nc_sid=18de74&#038;_nc_ohc=p9BMlYv1B70Q7kNvgE6jptd&#038;_nc_ht=scontent.cdninstagram.com&#038;edm=AM6HXa8EAAAA&#038;_nc_gid=ApBLXRTCn4bi6jI6VZ4gjzF&#038;oh=00_AYABakefwqRPbuS5fwoix0esKYV_uFHHGCBsQ3qX97R_Ew&#038;oe=66E615C7"
                                >
                                  <source
                                    src="https://scontent.cdninstagram.com/o1/v/t16/f1/m86/FB467C04EB8C5D74531C95167A4E4B8A_video_dashinit.mp4?efg=eyJ2ZW5jb2RlX3RhZyI6InZ0c192b2RfdXJsZ2VuLmNsaXBzLnVua25vd24tQzMuNzIwLmRhc2hfYmFzZWxpbmVfMV92MSJ9&#038;_nc_ht=scontent.cdninstagram.com&#038;_nc_cat=111&#038;vs=457165950505382_645347069&#038;_nc_vs=HBksFQIYUmlnX3hwdl9yZWVsc19wZXJtYW5lbnRfc3JfcHJvZC9GQjQ2N0MwNEVCOEM1RDc0NTMxQzk1MTY3QTRFNEI4QV92aWRlb19kYXNoaW5pdC5tcDQVAALIAQAVAhg6cGFzc3Rocm91Z2hfZXZlcnN0b3JlL0dJT2gteG9PdEhob3pwWURBTHJCSzVMcWk3QnRicV9FQUFBRhUCAsgBACgAGAAbAYgHdXNlX29pbAExFQAAJoq3zoXanIpAFQIoAkMzLBdALWbpeNT99BgSZGFzaF9iYXNlbGluZV8xX3YxEQB1AAA%3D&#038;ccb=9-4&#038;oh=00_AYBCB1T6KOm0Vm_9u_zUa5FjIXjsNQr-IyHwWUsT_JgrjQ&#038;oe=66E227EB&#038;_nc_sid=1d576d"
                                    type="video/mp4"
                                  />
                                </video>

                                <div
                                  class="wpsr-ig-post-type-icon wpsr-ig-post-type-VIDEO"
                                ></div>
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>17</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  “Come check us out!” #rentals
                                  #ebikesales #service
                                  #adventureelevated🌟 #instagearoutdoorco
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="17877003390057121"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="11"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-11"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/452421299_18028750370335927_1350814690814369960_n.jpg"
                                  alt="Meet Kody, our summer adventure guide extraordinaire! 🌞 He’s been with us since the start of summer, bringing his passion for the outdoors to InstaGear. Whether you’re looking for the best floats or gear tips, Kody’s got you covered. Say hi when you see him around! #MeetKody #InstaGearAdventure #SummerFun"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>19</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>2</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  Meet Kody, our summer adventure guide
                                  extraordinaire! 🌞 He’s been with us
                                  since the start...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18239467702261979"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="12"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background VIDEO"
                                id="wpsr-video-play-12"
                              >
                                <video
                                  class="wpsr-ig-post-video"
                                  poster="https://scontent.cdninstagram.com/v/t51.29350-15/452608773_336953716144961_5107020740672955544_n.jpg?_nc_cat=106&#038;ccb=1-7&#038;_nc_sid=18de74&#038;_nc_ohc=ksN5CUEDtQUQ7kNvgHTeCap&#038;_nc_ht=scontent.cdninstagram.com&#038;edm=AM6HXa8EAAAA&#038;_nc_gid=ApBLXRTCn4bi6jI6VZ4gjzF&#038;oh=00_AYBYZeRu7FzZRbb9EphnjRE9lEx12NA5lKfaSI791R8Pdw&#038;oe=66E62C0E"
                                >
                                  <source
                                    src="https://scontent.cdninstagram.com/o1/v/t16/f1/m86/F548CFC4B62AB965EC18D728135688A6_video_dashinit.mp4?efg=eyJ2ZW5jb2RlX3RhZyI6InZ0c192b2RfdXJsZ2VuLmNsaXBzLnVua25vd24tQzMuNzIwLmRhc2hfYmFzZWxpbmVfMV92MSJ9&#038;_nc_ht=scontent.cdninstagram.com&#038;_nc_cat=107&#038;vs=8112447932147284_1277107801&#038;_nc_vs=HBksFQIYUmlnX3hwdl9yZWVsc19wZXJtYW5lbnRfc3JfcHJvZC9GNTQ4Q0ZDNEI2MkFCOTY1RUMxOEQ3MjgxMzU2ODhBNl92aWRlb19kYXNoaW5pdC5tcDQVAALIAQAVAhg6cGFzc3Rocm91Z2hfZXZlcnN0b3JlL0dEU085Um9lVGZhMFMzb0RBSVFYc284V2Z3STlicV9FQUFBRhUCAsgBACgAGAAbAYgHdXNlX29pbAExFQAAJuiQ7KTs3Z9BFQIoAkMzLBdAN9KwIMSbphgSZGFzaF9iYXNlbGluZV8xX3YxEQB1AAA%3D&#038;ccb=9-4&#038;oh=00_AYBkZdzsEE3sytDpwQHkKhkhQ7XXIUS_9A5AXJkxMOfDeQ&#038;oe=66E222BB&#038;_nc_sid=1d576d"
                                    type="video/mp4"
                                  />
                                </video>

                                <div
                                  class="wpsr-ig-post-type-icon wpsr-ig-post-type-VIDEO"
                                ></div>
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>15</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  Ever tried sandboarding at the Saint
                                  Anthony sand dunes? 🌞🏂 It’s the
                                  ultimate family adventure!...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="17919889772941828"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="13"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-13"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/451791314_18028299149335927_1034928819999706937_n.jpg"
                                  alt="A heartfelt thank you to everyone who has purchased bikes from us over the past month! Your support for our local family business means everything. 🚴‍♂️🚴‍♀️

Don’t miss out on our July Days Sale, offering the best deals of the summer through July 27th. Your continued support helps us keep bringing you top-quality bikes and gear. See you on the trails!

#SupportLocal #FamilyBusiness #ThankYou #BikeLife #JulyDaysSale #SummerSavings #InstaGearAdventure"
                                  loading="lazy"
                                />

                                <div
                                  class="wpsr-ig-post-type-icon wpsr-ig-post-type-CAROUSEL_ALBUM"
                                ></div>
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>31</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>1</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  A heartfelt thank you to everyone who
                                  has purchased bikes from us over the
                                  past...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="17891432528984303"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="14"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-14"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/451976241_18028246388335927_3307668521266371553_n.jpg"
                                  alt="Apologies for being MIA this past week, but we have an exciting reason why! 🎉 Say hello to the newest member of the InstaGear Adventure team, Tucker! We’ve been eagerly awaiting this bundle of joy, and he decided to join us a week  early! We and his siblings couldn’t be more thrilled. Plus, coming between the 4th of July and Pioneer Days is perfect timing on his part! 🍼✨

We are excited to get to introduce him to the amazing adventure lifestyle we get to live here in Idaho. On top of that, we can’t wait to share more adventures with you all!

#WelcomeTucker #InstaGearFamily #NewArrival #AdventureAwaits"
                                  loading="lazy"
                                />

                                <div
                                  class="wpsr-ig-post-type-icon wpsr-ig-post-type-CAROUSEL_ALBUM"
                                ></div>
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>110</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>15</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  Apologies for being MIA this past week,
                                  but we have an exciting reason why!
                                  🎉...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="17859001509196287"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="15"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-15"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/450622969_18027049139335927_2890880322953494783_n.jpg"
                                  alt="🚴‍♂️ Why Buy Your E-Bike Locally? 🚴‍♀️

One of the main reasons to buy your e-bikes through a local shop like InstaGear Outdoor Co. is the incredible support we provide after your purchase! We handle warranty work, tune-ups, basic repairs, and more to keep you rolling smoothly.

Check out this bike that fell off its rack and was dragged behind a vehicle. The handlebars and electronics were destroyed, but we’ll get it fixed up and back on the road in no time!

Plus, we include a free tune up within a year of your purchase! Support local and ride with confidence. 🌟

#SupportLocal #EBikes #BikeRepair #InstaGearOutdoorCo #ShopLocal"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>13</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>2</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  🚴‍♂️ Why Buy Your E-Bike Locally? 🚴‍♀️ One
                                  of the main reasons to buy your...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18001046354413149"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="16"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-16"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/450378208_1882516445563756_4737270350533979898_n.jpg"
                                  alt="Want to take your 24th of July get together to the next level??? 💥 Introducing Gaga Ball! 💥 

Never  heard of Gaga Ball? It’s a super fun, fast-paced game that’s similar to dodgeball, played in an inflatable octagonal pit. It’s fast. It’s fun. It’s sure to get you moving and laughing! Players use a bouncing ball to hit opponents below the knees, and the last person standing wins! Perfect for all ages and a hit at reunions, parties, and events. Up to 15 players at a go, this is the perfect game to bring young and older groups together.

Ready to add some Gaga fun to your next event? Contact us today to reserve the pit and get your game on! 🎈🏀

#pioneerdays #instagearoutdoors #gagaball #goodcleanfun #gogaga #getoutside

#GagaBall #FunGames #EventRentals #InstaGearOutdoorCo"
                                  loading="lazy"
                                />

                                <div
                                  class="wpsr-ig-post-type-icon wpsr-ig-post-type-CAROUSEL_ALBUM"
                                ></div>
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>25</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>3</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  Want to take your 24th of July get
                                  together to the next level??? 💥
                                  Introducing...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18303740962081770"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="17"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-17"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/449795623_844149810920552_3141242077880332193_n.jpg"
                                  alt="🎉 A big thank you to Caleb and Shalei of @bigjudsarcher for purchasing two e-bikes from us! 🚴‍♂️🚴‍♀️ We appreciate your support and are thrilled to be part of your adventures. Enjoy your rides this Fourth of July! 🇺🇸✨we will be down for a Big Jud Big Deal sometime soon!😉

#SupportLocal #EBikes #FourthOfJuly #AdventureTime #ThankYou"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>19</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  🎉 A big thank you to Caleb and Shalei
                                  of @bigjudsarcher for purchasing two
                                  e-bikes...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18017672903138234"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="18"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-18"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/449757210_3956269338031400_7085097138128283998_n.jpg"
                                  alt="Happy Fourth of July from InstaGear Outdoor Co.! 🎆 We’re open today from 9-4, so stop by and gear up for your holiday adventures. Plus, we’re kicking off our Fourth of July bike sale today! Have a fantastic day celebrating! #FourthOfJuly #InstaGearOutdoorCo #HolidayHours #OutdoorFun #BikeSale"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>12</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  Happy Fourth of July from InstaGear
                                  Outdoor Co.! 🎆 We’re open today from
                                  9-4, so...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18053219350655941"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="19"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background VIDEO"
                                id="wpsr-video-play-19"
                              >
                                <video
                                  class="wpsr-ig-post-video"
                                  poster="https://scontent.cdninstagram.com/v/t51.29350-15/449602933_842326197343188_3059716308434969283_n.jpg?_nc_cat=104&#038;ccb=1-7&#038;_nc_sid=18de74&#038;_nc_ohc=PD1SbgRzw2gQ7kNvgF_mNA-&#038;_nc_ht=scontent.cdninstagram.com&#038;edm=AM6HXa8EAAAA&#038;_nc_gid=ApBLXRTCn4bi6jI6VZ4gjzF&#038;oh=00_AYACQ8VaMUleZzEwM0TDpjmsYb2LObmFKq_Kvl5I4BIj6w&#038;oe=66E61E80"
                                >
                                  <source
                                    src="https://scontent.cdninstagram.com/o1/v/t16/f1/m86/FD4237385297E402F435CFA0C684FDA8_video_dashinit.mp4?efg=eyJ2ZW5jb2RlX3RhZyI6InZ0c192b2RfdXJsZ2VuLmNsaXBzLnVua25vd24tQzMuNzIwLmRhc2hfYmFzZWxpbmVfMV92MSJ9&#038;_nc_ht=scontent.cdninstagram.com&#038;_nc_cat=106&#038;vs=348862791401289_2474808303&#038;_nc_vs=HBksFQIYUmlnX3hwdl9yZWVsc19wZXJtYW5lbnRfc3JfcHJvZC9GRDQyMzczODUyOTdFNDAyRjQzNUNGQTBDNjg0RkRBOF92aWRlb19kYXNoaW5pdC5tcDQVAALIAQAVAhg6cGFzc3Rocm91Z2hfZXZlcnN0b3JlL0dEM1B3UnJ0Nm1HMllia0ZBTE1WUGg2UXdRRWpicV9FQUFBRhUCAsgBACgAGAAbAYgHdXNlX29pbAExFQAAJpTtrJqUzt8%2FFQIoAkMzLBdAPXdLxqfvnhgSZGFzaF9iYXNlbGluZV8xX3YxEQB1AAA%3D&#038;ccb=9-4&#038;oh=00_AYDcXZzNe4d9eDlyVdxYTx2i1Syl8Z8g1gJTIKrpf3eeXw&#038;oe=66E2244C&#038;_nc_sid=1d576d"
                                    type="video/mp4"
                                  />
                                </video>

                                <div
                                  class="wpsr-ig-post-type-icon wpsr-ig-post-type-VIDEO"
                                ></div>
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>12</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  Get your Fourth of July reservations in
                                  now! Our little guy has all the
                                  inflatables...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18037737988812074"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="20"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background VIDEO"
                                id="wpsr-video-play-20"
                              >
                                <video
                                  class="wpsr-ig-post-video"
                                  poster="https://scontent.cdninstagram.com/v/t51.29350-15/448885205_1181517093042987_394208307123993782_n.jpg?_nc_cat=103&#038;ccb=1-7&#038;_nc_sid=18de74&#038;_nc_ohc=dLyak4EKq9sQ7kNvgHQi9jt&#038;_nc_ht=scontent.cdninstagram.com&#038;edm=AM6HXa8EAAAA&#038;_nc_gid=ApBLXRTCn4bi6jI6VZ4gjzF&#038;oh=00_AYCyKjdkfby8zFLlxLw_9RYraG4MODkQI9dq4D4MZ3noug&#038;oe=66E61FCA"
                                >
                                  <source
                                    src="https://scontent.cdninstagram.com/o1/v/t16/f1/m82/08433B654DF40EF8C00AD4BEC36EEF84_video_dashinit.mp4?efg=eyJ2ZW5jb2RlX3RhZyI6InZ0c192b2RfdXJsZ2VuLmNsaXBzLnVua25vd24tQzMuNzIwLmRhc2hfYmFzZWxpbmVfMV92MSJ9&#038;_nc_ht=scontent.cdninstagram.com&#038;_nc_cat=108&#038;vs=2048786785515505_3038540664&#038;_nc_vs=HBksFQIYT2lnX3hwdl9yZWVsc19wZXJtYW5lbnRfcHJvZC8wODQzM0I2NTRERjQwRUY4QzAwQUQ0QkVDMzZFRUY4NF92aWRlb19kYXNoaW5pdC5tcDQVAALIAQAVAhg6cGFzc3Rocm91Z2hfZXZlcnN0b3JlL0dPTEF3QnBwem0zRVctZ0NBTmJ4cGYxeWE3bDRicV9FQUFBRhUCAsgBACgAGAAbAYgHdXNlX29pbAExFQAAJvLYl%2BPxy8g%2FFQIoAkMzLBdAU2Q5WBBiThgSZGFzaF9iYXNlbGluZV8xX3YxEQB1AAA%3D&#038;ccb=9-4&#038;oh=00_AYCJyIg3hbJkxzN8vTRoFFFfdYvoL8jJJFJa3kNH7DTN-Q&#038;oe=66E22A2A&#038;_nc_sid=1d576d"
                                    type="video/mp4"
                                  />
                                </video>

                                <div
                                  class="wpsr-ig-post-type-icon wpsr-ig-post-type-VIDEO"
                                ></div>
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>18</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  🌊🚤 Summer’s here, and that means fun
                                  on the water! But first, let’s make
                                  sure...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18024589400224430"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="21"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-21"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/448263184_978411374074790_2218164920751111880_n.jpg"
                                  alt="Big shoutout to the Deckers for snagging two awesome Mokwheel Basalt ST Ebikes! 🚲🎉 Check out their new wheels in front of the shop! Ready to roll into your next adventure? Come see us and join the ebike fun! Retail and rentals available! #InstaGearOutdoorCo #MokwheelBasaltST #EbikeLife"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>17</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>2</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  Big shoutout to the Deckers for snagging
                                  two awesome Mokwheel Basalt ST Ebikes!
                                  🚲🎉 Check...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18019228664362859"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="22"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background VIDEO"
                                id="wpsr-video-play-22"
                              >
                                <video
                                  class="wpsr-ig-post-video"
                                  poster="https://scontent.cdninstagram.com/v/t51.29350-15/448913944_1138894910562625_3919470759775447010_n.jpg?_nc_cat=109&#038;ccb=1-7&#038;_nc_sid=18de74&#038;_nc_ohc=ig-JXkOzGVsQ7kNvgHaTJjT&#038;_nc_ht=scontent.cdninstagram.com&#038;edm=AM6HXa8EAAAA&#038;_nc_gid=ApBLXRTCn4bi6jI6VZ4gjzF&#038;oh=00_AYAPbwEmMl6vL-_YUJ_pla8MOIsS1TJoBfN_MTqfT9AEuQ&#038;oe=66E626B1"
                                >
                                  <source
                                    src="https://scontent.cdninstagram.com/o1/v/t16/f1/m82/6840A8C79AEADAAEC74428D821B022B7_video_dashinit.mp4?efg=eyJ2ZW5jb2RlX3RhZyI6InZ0c192b2RfdXJsZ2VuLmNsaXBzLnVua25vd24tQzMuNzIwLmRhc2hfYmFzZWxpbmVfMV92MSJ9&#038;_nc_ht=scontent.cdninstagram.com&#038;_nc_cat=104&#038;vs=1589541514940902_2074529165&#038;_nc_vs=HBksFQIYT2lnX3hwdl9yZWVsc19wZXJtYW5lbnRfcHJvZC82ODQwQThDNzlBRUFEQUFFQzc0NDI4RDgyMUIwMjJCN192aWRlb19kYXNoaW5pdC5tcDQVAALIAQAVAhg6cGFzc3Rocm91Z2hfZXZlcnN0b3JlL0dJRTF3Qm9UajYxQlZFTWJBQ080bVVvSlNrbHpicV9FQUFBRhUCAsgBACgAGAAbAYgHdXNlX29pbAExFQAAJranpab%2F68w%2FFQIoAkMzLBdAIRDlYEGJNxgSZGFzaF9iYXNlbGluZV8xX3YxEQB1AAA%3D&#038;ccb=9-4&#038;oh=00_AYCvufPoTGhUoxbEkNsgVopXRbg1eEjwQafV-5A5hB8qag&#038;oe=66E23BEE&#038;_nc_sid=1d576d"
                                    type="video/mp4"
                                  />
                                </video>

                                <div
                                  class="wpsr-ig-post-type-icon wpsr-ig-post-type-VIDEO"
                                ></div>
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>38</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  🌊 I Googled my symptoms and it turns
                                  out I need more times like these!...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="17996844719460581"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="23"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-23"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/448713413_863163925828387_5006571456843087423_n.jpg"
                                  alt="🚴‍♂️ New Shuttle Program! 🚴‍♀️

Explore the Ashton-Tetonia Trail with our convenient shuttles! Perfect for full rides, shorter journeys, or one-way returns. Learn more about our shuttle program with our recent blog post, link below!

🛤️ Shuttle Options:

Ashton Drop Off/Pickup: $50
3/4 Shuttle to Judkins: $100
Full Shuttle to Tetonia: $125
1-Way Return Shuttle: $125
Harriman State Park Bike Delivery: $125
E-bikes for $59/day with a 60-80 mile range. Helmets required. Safe and fun for all!

Read more and plan your adventure! 🌲✨ 
https://instagearoutdoors.com/explore-the-ashton-tetonia-trail-with-instagear-outdoor-co/

📞 Call us: 208-206-9011
📍 Visit InstaGear Outdoor Co. in Saint Anthony

#BikingAdventure #ShuttleService #ExploreIdaho"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>8</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  🚴‍♂️ New Shuttle Program! 🚴‍♀️ Explore the
                                  Ashton-Tetonia Trail with our convenient
                                  shuttles! Perfect for...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18300840538092315"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="24"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-24"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/448419721_757253556320370_6224094326411216334_n.jpg"
                                  alt="Join us in welcoming AJ to the InstaGear Outdoor Co. adventure team! 🎉 AJ brings a wealth of knowledge in various outdoor activities, is quickly mastering our e-bikes, and always has a cheerful smile when you stop by the store. We’re thrilled to have him on board and can’t wait for you to meet him! 🚴‍♂️🌲 #WelcomeAJ #NewTeamMember #AdventureTeam #InstaGearOutdoorCo #OutdoorFun #EbikeExperts"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>34</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>1</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  Join us in welcoming AJ to the InstaGear
                                  Outdoor Co. adventure team! 🎉 AJ
                                  brings...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="17969240099728797"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="25"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background VIDEO"
                                id="wpsr-video-play-25"
                              >
                                <video
                                  class="wpsr-ig-post-video"
                                  poster="https://scontent.cdninstagram.com/v/t51.29350-15/448340121_349491827899521_8885211019624799230_n.jpg?_nc_cat=102&#038;ccb=1-7&#038;_nc_sid=18de74&#038;_nc_ohc=yjOWrTZww-cQ7kNvgESYm6j&#038;_nc_ht=scontent.cdninstagram.com&#038;edm=AM6HXa8EAAAA&#038;_nc_gid=ApBLXRTCn4bi6jI6VZ4gjzF&#038;oh=00_AYDqTKrTpdHMjrXX5kwPIJNP5Rny55OZGHGn5KO3vKUqeA&#038;oe=66E626DE"
                                >
                                  <source
                                    src="https://scontent.cdninstagram.com/o1/v/t16/f1/m82/5E42458A3382CA0E66984A07935A42BB_video_dashinit.mp4?efg=eyJ2ZW5jb2RlX3RhZyI6InZ0c192b2RfdXJsZ2VuLmNsaXBzLnVua25vd24tQzMuNzIwLmRhc2hfYmFzZWxpbmVfMV92MSJ9&#038;_nc_ht=scontent.cdninstagram.com&#038;_nc_cat=106&#038;vs=423443997337284_2604724456&#038;_nc_vs=HBksFQIYT2lnX3hwdl9yZWVsc19wZXJtYW5lbnRfcHJvZC81RTQyNDU4QTMzODJDQTBFNjY5ODRBMDc5MzVBNDJCQl92aWRlb19kYXNoaW5pdC5tcDQVAALIAQAVAhg6cGFzc3Rocm91Z2hfZXZlcnN0b3JlL0dJWFR1UnA5OTA4NW9KUURBUDg3bi0wM2pobFhicV9FQUFBRhUCAsgBACgAGAAbAYgHdXNlX29pbAExFQAAJtDS4ODB%2BYdAFQIoAkMzLBdAP7ul41P3zxgSZGFzaF9iYXNlbGluZV8xX3YxEQB1AAA%3D&#038;ccb=9-4&#038;oh=00_AYCD8jfC5WG8DfcFTzAWgv4X5lYaF67r1quwPnZYuv5bfQ&#038;oe=66E24C5C&#038;_nc_sid=1d576d"
                                    type="video/mp4"
                                  />
                                </video>

                                <div
                                  class="wpsr-ig-post-type-icon wpsr-ig-post-type-VIDEO"
                                ></div>
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>25</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  Good morning from Tetonia! 🌄 I’m out
                                  here providing a shuttle on the stunning
                                  Ashton...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18042376072880970"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="26"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-26"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/448260243_1524126741514033_1897288856490949212_n.jpg"
                                  alt="These folks drove almost two hours just to pick up some #mokwheel e-bikes from us! Yes, they are that good! Thank you so much for taking the time to come to our small town bike shop, we truly appreciate it! As a reminder, our Father’s Day bike sale is currently running, huge savings on everything in shop with more arriving daily! 
#rideelevated #adventureelevated #getoutside #yellowstone #stanthony #ashtontetoniatrail #fathersdaysale"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>14</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  These folks drove almost two hours just
                                  to pick up some #mokwheel e-bikes from
                                  us!...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18033567640994887"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="27"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background VIDEO"
                                id="wpsr-video-play-27"
                              >
                                <video
                                  class="wpsr-ig-post-video"
                                  poster="https://scontent.cdninstagram.com/v/t51.29350-15/448145776_1358948341440173_8553986378848312523_n.jpg?_nc_cat=102&#038;ccb=1-7&#038;_nc_sid=18de74&#038;_nc_ohc=Dl8DvYomO-sQ7kNvgGQ5qwS&#038;_nc_ht=scontent.cdninstagram.com&#038;edm=AM6HXa8EAAAA&#038;_nc_gid=ApBLXRTCn4bi6jI6VZ4gjzF&#038;oh=00_AYCUtrGeXWSTBd2M3a9-Zhz4tfNomdvAi4_9-S4dordpGg&#038;oe=66E63ACF"
                                >
                                  <source
                                    src="https://scontent.cdninstagram.com/o1/v/t16/f1/m82/1042089B5EEE21E4013E38EFD60AE0B9_video_dashinit.mp4?efg=eyJ2ZW5jb2RlX3RhZyI6InZ0c192b2RfdXJsZ2VuLmNsaXBzLnVua25vd24tQzMuNzIwLmRhc2hfYmFzZWxpbmVfMV92MSJ9&#038;_nc_ht=scontent.cdninstagram.com&#038;_nc_cat=102&#038;vs=1156314045491390_19242639&#038;_nc_vs=HBksFQIYT2lnX3hwdl9yZWVsc19wZXJtYW5lbnRfcHJvZC8xMDQyMDg5QjVFRUUyMUU0MDEzRTM4RUZENjBBRTBCOV92aWRlb19kYXNoaW5pdC5tcDQVAALIAQAVAhg6cGFzc3Rocm91Z2hfZXZlcnN0b3JlL0dIZld0aHBYYTM2SXVYUURBSWVnUmJXbHVVOFhicV9FQUFBRhUCAsgBACgAGAAbAYgHdXNlX29pbAExFQAAJoDL0bywlftAFQIoAkMzLBdANMQYk3S8ahgSZGFzaF9iYXNlbGluZV8xX3YxEQB1AAA%3D&#038;ccb=9-4&#038;oh=00_AYDFiy-hHgsd-NQZBW1upzxwKsTGWfBHJfEL3lduxVg1PQ&#038;oe=66E24938&#038;_nc_sid=1d576d"
                                    type="video/mp4"
                                  />
                                </video>

                                <div
                                  class="wpsr-ig-post-type-icon wpsr-ig-post-type-VIDEO"
                                ></div>
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>17</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  🌞 Warmer weather is here, and our
                                  bounce house and water slide bookings
                                  are heating...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18329195623135708"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="28"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-28"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/447966362_1108126020294851_2279234264781377133_n.jpg"
                                  alt="🌟 A huge thank you to Cameron and his friends for purchasing your e-bikes through InstaGear Outdoor Co.! 🌟 Their bikes are headed for some big adventures this week and are sure to help create some incredible photographs. 📸🚴‍♂️ 

We’re thrilled to be part of your journey and can’t wait to see where your new e-bikes take you and the photos you capture 📸 . Happy riding!

#ThankYou #EBikeAdventures #InstaGearOutdoorCo #BigAdventures #Mokwheel #IncrediblePhotography #HappyRiding"
                                  loading="lazy"
                                />

                                <div
                                  class="wpsr-ig-post-type-icon wpsr-ig-post-type-CAROUSEL_ALBUM"
                                ></div>
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>26</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  🌟 A huge thank you to Cameron and his
                                  friends for purchasing your e-bikes
                                  through...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18022206716332010"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="29"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-29"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/447919596_762730769090384_2836778811870265657_n.jpg"
                                  alt="🎣 Today is Free Fishing Day in Idaho! 🎣

No license needed—just grab your gear and enjoy a day on Idaho’s beautiful rivers and lakes! 🐟 Whether you’re an experienced angler or a first-timer, this is the perfect opportunity to dive in. Stop by InstaGear Outdoor Co. for all your fishing essentials and make the most of this special day! 🛶🏞️

#FreeFishingDay #IdahoFishing #InstaGearOutdoorCo #FamilyFun #ExploreIdaho #FishingGear"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>19</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  🎣 Today is Free Fishing Day in Idaho!
                                  🎣 No license needed—just grab your
                                  gear...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18045745867826300"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="30"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-30"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/447843429_993081762283004_7856535013924751952_n.jpg"
                                  alt="Check out this snapshot from one of our first shuttles to the breathtaking Ashton Tetonia Trail! 🌄 

Whether you’re planning a one-way return, a 3/4 adventure, or a full day of trailblazing, we’ve got the perfect shuttle and bike options for you. Don’t miss out on exploring this stunning trail with ease. Call us today to reserve your spot and get ready for an unforgettable ride! 🌟📞

#AshtonTetoniaTrail #InstaGearOutdoorCo #EBikeAdventures #TrailblazingFun #ShuttleService #ExploreIdaho #harrimanstatepark"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>28</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  Check out this snapshot from one of our
                                  first shuttles to the breathtaking
                                  Ashton Tetonia...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18315606649182354"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="31"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background VIDEO"
                                id="wpsr-video-play-31"
                              >
                                <video
                                  class="wpsr-ig-post-video"
                                  poster="https://scontent.cdninstagram.com/v/t51.29350-15/446209347_1147533306294438_2125843358110961209_n.jpg?_nc_cat=102&#038;ccb=1-7&#038;_nc_sid=18de74&#038;_nc_ohc=uSXmBqJ_9XIQ7kNvgF9VZTN&#038;_nc_ht=scontent.cdninstagram.com&#038;edm=AM6HXa8EAAAA&#038;_nc_gid=ApBLXRTCn4bi6jI6VZ4gjzF&#038;oh=00_AYCk93oAFWPn_cZ-d90harYjS4bv_5EIHqv8uVOPvq7y9w&#038;oe=66E6448B"
                                >
                                  <source
                                    src="https://scontent.cdninstagram.com/o1/v/t16/f2/m69/An8Dd6ppjJdZFKrNr0a0-oUGYirOSgBcobWYmTRgNgC2mRhwZExmgSyfuVm097haWTzya-mXkixFVCwqv5em_4zz?efg=eyJ2ZW5jb2RlX3RhZyI6InZ0c192b2RfdXJsZ2VuLmNsaXBzLnVua25vd24tQzMuNDMyLmRhc2hfYmFzZWxpbmVfM192MSJ9&#038;_nc_ht=scontent.cdninstagram.com&#038;_nc_cat=107&#038;vs=1215169826330818_791897461&#038;_nc_vs=HBksFQIYOnBhc3N0aHJvdWdoX2V2ZXJzdG9yZS9HTml5bVJxNmJGSlBTNGtCQUFnc04wRFU0MThPYnFDQkFBQUYVAALIAQAVAhg6cGFzc3Rocm91Z2hfZXZlcnN0b3JlL0dQS2hraHJ6WlFTTDkwZ0JBR0FyMm10R2NfeEVicUNCQUFBRhUCAsgBACgAGAAbAYgHdXNlX29pbAExFQAAJoDAq%2Buvh69BFQIoAkMzLBdAYnzlYEGJNxgSZGFzaF9iYXNlbGluZV8zX3YxEQB1AAA%3D&#038;ccb=9-4&#038;oh=00_AYB9XieC36wPRN3HBQg6MToMWKKEOVz6kFLOhn_zfwSr6g&#038;oe=66E24539&#038;_nc_sid=1d576d"
                                    type="video/mp4"
                                  />
                                </video>

                                <div
                                  class="wpsr-ig-post-type-icon wpsr-ig-post-type-VIDEO"
                                ></div>
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>18</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  Giveaway Winners!!! Thanks to everyone
                                  for participating and congratulations to
                                  our winners! Watch for an...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18027150658900273"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="32"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-32"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/446110828_1261458811503715_5867458061823453991_n.jpg"
                                  alt="Weekly Fishing Report from @hoffmans_flies 

Stoneflies are emerging in large numbers. Fast rocky water close to cover with big Flies will produce well. 
Flows @ Island Park: 775 cfs 
Flows @ Ashton: 1900 cfs

Flies
Dry Flies: Foam Salmonfly, Elk Hair Caddis
Nymphs: Pat’s Rubber Legs,  pheasant tail"
                                  loading="lazy"
                                />

                                <div
                                  class="wpsr-ig-post-type-icon wpsr-ig-post-type-CAROUSEL_ALBUM"
                                ></div>
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>11</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  Weekly Fishing Report from
                                  @hoffmans_flies Stoneflies are emerging
                                  in large numbers. Fast rocky water
                                  close...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18036299767777119"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="33"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-33"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/446100056_3822401937980275_2356870262720441223_n.jpg"
                                  alt="🌅 Good morning from the Fisherman’s Breakfast! 🌅

We’re here until noon, serving up free breakfast and fun! Swing by our booth to enter our drawing for awesome freebies and check out our amazing Mokwheel e-bikes. 🚴‍♂️✨

Come say hi to Hudson, who’s manning the booth and ready to help you with all your outdoor adventure needs. See you soon!

#FishermansBreakfast #InstaGearOutdoorCo #EbikeGiveaway #MokwheelEBikes #FreeBreakfast #OutdoorFun #CommunityEvent

—

![Picture of Hudson manning the booth]"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>27</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>3</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  🌅 Good morning from the Fisherman’s
                                  Breakfast! 🌅 We’re here until noon,
                                  serving up free...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18025649570504872"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="34"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-34"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/445418958_847443567400423_6981898168791709477_n.jpg"
                                  alt="🎉 Memorial Day Summer Giveaway! 🎉

Celebrate Memorial Day with InstaGear Outdoor Co. and enter to win an awesome Mokwheel E-Bike Rack valued at $499, perfect for all types of bikes, including fat-tired ones! 🚴‍♂️✨

Other amazing prizes include:
🌟 2 x Free e-bike rentals ($125 value)
🌟 A wireless electric bike pump ($99)

How to Enter:

Scan the QR code to enter. Bonus entries when you follow us on Instagram and Facebook, as well as when you tag two friends and share this post.

Join us tomorrow at the Fisherman&#039;s Breakfast and discover ways to enter even more!
Hurry, the giveaway ends on Memorial Day afternoon, with the drawing happening later that day! Don’t miss your chance to win and kick off your summer adventures in style! 🌞

#MemorialDayGiveaway #SummerAdventure #InstaGearOutdoorCo #EbikeRack #FishermansBreakfast #EnterToWin #OutdoorFun #BikeLife #stAnthony #Ashton #IslandPark #Mokwheel"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>20</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>24</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  🎉 Memorial Day Summer Giveaway! 🎉
                                  Celebrate Memorial Day with InstaGear
                                  Outdoor Co. and enter...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18224396236279249"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="35"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-35"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/445550962_1171127580703623_8114276794702001926_n.jpg"
                                  alt="This Memorial Day, explore nature and the beauty of spring in Yellowstone! 🌸🐻🌼 check out some of our recent adventure guru’s nature shoots of Yellowstones landscapes and baby animals. Whether hiking, biking, or soaking in views, adventure awaits. We’ve got all your camping and recreation gear needs covered—from tents to kayaks, InstaGear Outdoor Co. has it all. Embrace the beauty around us and create unforgettable memories with family and friends. 🌞🗺️ #MemorialDayAdventure #ExploreNature #SpringInYellowstone #BabyAnimals #InstaGearOutdoorCo #GetOutside #FamilyFun #CampingGear #OutdoorRecreation"
                                  loading="lazy"
                                />

                                <div
                                  class="wpsr-ig-post-type-icon wpsr-ig-post-type-CAROUSEL_ALBUM"
                                ></div>
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>19</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  This Memorial Day, explore nature and
                                  the beauty of spring in Yellowstone!
                                  🌸🐻🌼 check out...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="17855568999177524"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="36"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-36"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/445418207_1742030389931040_2412169838932498547_n.jpg"
                                  alt="A huge thank you to the Torgrimsons and their son for purchasing our Addmotor cargo e-bike—aka the “People Hauler”! 🚲👨‍👩‍👦 With a capacity for 2-3, your family adventures just got a major upgrade.

Thinking about hitting the trails this Memorial Day weekend? 🌞 Book a shuttle with us to the Ashton-Tetonia Trail! The weather’s looking perfect for an outdoor adventure. Don’t miss out!

#ThankYou #AddmotorCargoEBike #FamilyAdventures #AshtonTetoniaTrail #MemorialDayFun #InstaGearOutdoorCo"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>15</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  A huge thank you to the Torgrimsons and
                                  their son for purchasing our Addmotor
                                  cargo...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18289846804163588"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="37"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background VIDEO"
                                id="wpsr-video-play-37"
                              >
                                <video
                                  class="wpsr-ig-post-video"
                                  poster="https://scontent.cdninstagram.com/v/t51.29350-15/443887496_496064252857789_8804354719647999111_n.jpg?_nc_cat=100&#038;ccb=1-7&#038;_nc_sid=18de74&#038;_nc_ohc=ISScBwFM8pwQ7kNvgGa6baq&#038;_nc_ht=scontent.cdninstagram.com&#038;edm=AM6HXa8EAAAA&#038;_nc_gid=ApBLXRTCn4bi6jI6VZ4gjzF&#038;oh=00_AYAoQ8P6wepWYo1gDprY4y5zpkdjGKEw0FBPTPYJgS_Tag&#038;oe=66E636B3"
                                >
                                  <source
                                    src="https://scontent.cdninstagram.com/o1/v/t16/f1/m82/CC4A1204702F0B3DD9A07F9096055BA6_video_dashinit.mp4?efg=eyJ2ZW5jb2RlX3RhZyI6InZ0c192b2RfdXJsZ2VuLmNsaXBzLnVua25vd24tQzMuNzIwLmRhc2hfYmFzZWxpbmVfMV92MSJ9&#038;_nc_ht=scontent.cdninstagram.com&#038;_nc_cat=100&#038;vs=1939719266457757_3850223979&#038;_nc_vs=HBksFQIYT2lnX3hwdl9yZWVsc19wZXJtYW5lbnRfcHJvZC9DQzRBMTIwNDcwMkYwQjNERDlBMDdGOTA5NjA1NUJBNl92aWRlb19kYXNoaW5pdC5tcDQVAALIAQAVAhg6cGFzc3Rocm91Z2hfZXZlcnN0b3JlL0dHZTdYQnFqbC0xQnNJb0JBRG9DUG4xWkVBeFVicV9FQUFBRhUCAsgBACgAGAAbAYgHdXNlX29pbAExFQAAJtDemdLG9c1AFQIoAkMzLBdAQUQ5WBBiThgSZGFzaF9iYXNlbGluZV8xX3YxEQB1AAA%3D&#038;ccb=9-4&#038;oh=00_AYBS220PIH7CbUtJCsbw9FDYwE2Kulu0LlYdl0Yg0wYmww&#038;oe=66E249D2&#038;_nc_sid=1d576d"
                                    type="video/mp4"
                                  />
                                </video>

                                <div
                                  class="wpsr-ig-post-type-icon wpsr-ig-post-type-VIDEO"
                                ></div>
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>41</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  📣 Exciting News, InstaGear Community!
                                  📣 Everyone’s been wondering what’s next
                                  door—it’s The Table, a...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18050655229635399"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="38"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background VIDEO"
                                id="wpsr-video-play-38"
                              >
                                <video
                                  class="wpsr-ig-post-video"
                                  poster="https://scontent.cdninstagram.com/v/t51.29350-15/444505525_805784341514374_3635317187505103188_n.jpg?_nc_cat=111&#038;ccb=1-7&#038;_nc_sid=18de74&#038;_nc_ohc=tW6jdfzdj80Q7kNvgEI-FYD&#038;_nc_ht=scontent.cdninstagram.com&#038;edm=AM6HXa8EAAAA&#038;_nc_gid=ApBLXRTCn4bi6jI6VZ4gjzF&#038;oh=00_AYDVwwUyTEQPVI5EVUAAJOTIei8rbVvAEx8XTACiv-dISg&#038;oe=66E612B6"
                                >
                                  <source
                                    src="https://scontent.cdninstagram.com/o1/v/t16/f1/m82/61449A7BAEC1D3931C420F0EF640F1A3_video_dashinit.mp4?efg=eyJ2ZW5jb2RlX3RhZyI6InZ0c192b2RfdXJsZ2VuLmNsaXBzLnVua25vd24tQzMuNzIwLmRhc2hfYmFzZWxpbmVfMV92MSJ9&#038;_nc_ht=scontent.cdninstagram.com&#038;_nc_cat=104&#038;vs=420854660771819_2098517025&#038;_nc_vs=HBksFQIYT2lnX3hwdl9yZWVsc19wZXJtYW5lbnRfcHJvZC82MTQ0OUE3QkFFQzFEMzkzMUM0MjBGMEVGNjQwRjFBM192aWRlb19kYXNoaW5pdC5tcDQVAALIAQAVAhg6cGFzc3Rocm91Z2hfZXZlcnN0b3JlL0dQV2NjaG9NdXhHczhZZ05BQThya19MZWM4cFZicV9FQUFBRhUCAsgBACgAGAAbAYgHdXNlX29pbAExFQAAJsTo2eLAi41AFQIoAkMzLBdAVoAAAAAAABgSZGFzaF9iYXNlbGluZV8xX3YxEQB1AAA%3D&#038;ccb=9-4&#038;oh=00_AYAEg5VXMNCQ9fLtaiVlkQZs96cRPXdVRZIbAcdsDyKTsA&#038;oe=66E23222&#038;_nc_sid=1d576d"
                                    type="video/mp4"
                                  />
                                </video>

                                <div
                                  class="wpsr-ig-post-type-icon wpsr-ig-post-type-VIDEO"
                                ></div>
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>26</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>2</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  At InstaGear Outdoor Co., we’re proud to
                                  offer Idaho Fish and Game licensing and
                                  tags...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18058890679584751"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="39"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-39"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/435925657_841368458007934_8247199895600890164_n.jpg"
                                  alt="🌟 Join Our Team! 🌟 InstaGear Outdoor Co. is on the lookout for enthusiastic individuals to fill the role of Adventure Experience Coordinator (Part-time)! If you&#039;re passionate about the outdoors and love helping others make the most of their adventures, this could be the perfect opportunity for you! Check out the details below and apply today:

🔹 Job Title: Adventure Experience Coordinator (Part-time)
🔹 Position Overview: We&#039;re seeking someone dynamic to provide exceptional customer service in outdoor gear sales and rentals, maintain our shop fleet, assist with basic bike maintenance, facilitate outdoor skills camps, and ensure the smooth operation of our retail space.
🔹 Skills and Experience Required: CPR certification or ability to obtain, 1-2 years of customer service experience, Point of Sale experience, Valid driver&#039;s license, Preferred: Experience with bike maintenance, Variety of Outdoor Mountain Sports Skills
🔹 Compensation: Wage: $10-$15 per hour (depending on experience), Free use of rental gear on non-peak days, Free use of Bike Repair Station, 10% off retail items, $15 Commission per e-bike sold
🔹 Hours: Start Date: In the next two weeks, 10-30 hours per week (scheduled between 9:00am-6pm including Saturdays and Holidays)

If you&#039;re ready to embark on this exciting journey with us, apply now! Submit your resume and cover letter to Greg or McKenzie at InstaGear Outdoor Co. located at 19 N. Bridge Street in St. Anthony or email the documents to instagearoutdoors@gmail.com. Don&#039;t miss out on this opportunity to be part of our adventure-loving team! 🚲🏔️ #AdventureJob #JoinOurTeam"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>21</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  🌟 Join Our Team! 🌟 InstaGear Outdoor
                                  Co. is on the lookout for enthusiastic
                                  individuals...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="17906451353878258"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="40"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-40"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/436545889_483727377322500_4552498082673700863_n.jpg"
                                  alt="🚴‍♀️🌲 Planning your weekend adventure? The latest update from Idaho Parks and Rec on the Ashton to Tetonia Rails to Trail bike path is here! 🌟 Ready for some scenic biking? Head to Bitch Creek Trestle—there are a few small passable drifts between the Judkins lot and the trestle, but it’s mostly accessible! Conant Creek is also open from the Grainville lot, with some smaller drifts along the way. 🚵‍♂️ If you’re eyeing the entire trail, hold off for a week or two—sizeable drifts still block the Lamont area. Remember, if it’s muddy, steer clear and wait for better conditions. Happy trails! 🌿 #IdahoAdventures #RailsToTrails #OutdoorExploration #InstaGearOutdoorCo #AdventureElevated"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>20</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>1</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  🚴‍♀️🌲 Planning your weekend adventure?
                                  The latest update from Idaho Parks and
                                  Rec on the...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18055502752595254"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="41"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-41"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/441476096_1098038154823004_118513667344134501_n.jpg"
                                  alt="We will have the above adjusted hours tomorrow! One of our kiddos has made the choice to be baptized and we are excited to get to spend time celebrating her tomorrow morning! Thanks for your understanding and we hope to see you when we open!"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>12</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  We will have the above adjusted hours
                                  tomorrow! One of our kiddos has made
                                  the...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="17923238402883699"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="42"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background VIDEO"
                                id="wpsr-video-play-42"
                              >
                                <video
                                  class="wpsr-ig-post-video"
                                  poster="https://scontent.cdninstagram.com/v/t51.29350-15/441129259_805971224784982_2318767545983246699_n.jpg?_nc_cat=102&#038;ccb=1-7&#038;_nc_sid=18de74&#038;_nc_ohc=uMsb3U-K-ngQ7kNvgFmByUE&#038;_nc_ht=scontent.cdninstagram.com&#038;edm=AM6HXa8EAAAA&#038;_nc_gid=ApBLXRTCn4bi6jI6VZ4gjzF&#038;oh=00_AYC5K9fBri6YnUHBGwUCECDAAvE6s2YUk5ilvdKFCRcMFQ&#038;oe=66E647C2"
                                >
                                  <source
                                    src="https://scontent.cdninstagram.com/o1/v/t16/f1/m82/EF4D9E8AC7A0D08579000164AC86EA96_video_dashinit.mp4?efg=eyJ2ZW5jb2RlX3RhZyI6InZ0c192b2RfdXJsZ2VuLmNsaXBzLnVua25vd24tQzMuNzIwLmRhc2hfYmFzZWxpbmVfMV92MSJ9&#038;_nc_ht=scontent.cdninstagram.com&#038;_nc_cat=107&#038;vs=713241400779685_3865741209&#038;_nc_vs=HBksFQIYT2lnX3hwdl9yZWVsc19wZXJtYW5lbnRfcHJvZC9FRjREOUU4QUM3QTBEMDg1NzkwMDAxNjRBQzg2RUE5Nl92aWRlb19kYXNoaW5pdC5tcDQVAALIAQAVAhg6cGFzc3Rocm91Z2hfZXZlcnN0b3JlL0dCZ3ZUUnJDa0JXdW5pZ0VBTEFhcldNUkpHaDdicV9FQUFBRhUCAsgBACgAGAAbAYgHdXNlX29pbAExFQAAJs6b8pHx9IJAFQIoAkMzLBdANu7ZFocrAhgSZGFzaF9iYXNlbGluZV8xX3YxEQB1AAA%3D&#038;ccb=9-4&#038;oh=00_AYAhDAbBGbfStMrBhirHdG7fRkJADBSQ6Mi2t_cqjxlOpg&#038;oe=66E22447&#038;_nc_sid=1d576d"
                                    type="video/mp4"
                                  />
                                </video>

                                <div
                                  class="wpsr-ig-post-type-icon wpsr-ig-post-type-VIDEO"
                                ></div>
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>17</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  🌟 Buckle up for excitement with our
                                  latest addition: the Addmotor M-81 Cargo
                                  E-Bike! 🚲💨...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18037440922846459"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="43"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-43"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/440854547_831116562366457_3301719876497680077_n.jpg"
                                  alt="🌟 Exciting News Alert! 🌟

We&#039;re thrilled to announce that InstaGear Outdoor Co. has been approved as a vendor for the Idaho Parks and Recreation Department, offering E-Bike Rentals, Shuttles, and Bike Delivery services along the stunning Ashton to Tetonia Rails to Trails Trail and to Harriman State Park! 🚲⚡ This marks a new chapter for us, and we can&#039;t wait to provide countless amazing adventures along these scenic trails! 🌿

Pictured is info. on how things will work this summer, and trust us, it&#039;s going to be epic! 🌟 With reservations filling up fast, we highly recommend securing your spot early to ensure you don&#039;t miss out on the fun! 🎉 Let&#039;s make this summer one to remember! ☀️ #NewAdventureAwaits #IdahoTrails #AshtontoTetoniaTrail #ATT #InstaGear #AdventureElevated🌟"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>7</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  🌟 Exciting News Alert! 🌟 We're
                                  thrilled to announce that InstaGear
                                  Outdoor Co. has been...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="17921994938794682"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="44"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-44"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/440096569_1583531265819005_7420080807940802715_n.jpg"
                                  alt="🌸 Happy Mother’s Day to @maleriparker and family!🌺

A huge THANK YOU for choosing to celebrate your Mom with us during our Mother’s Day Sale! 🎉 We’re thrilled you picked up a Mokwheel Basalt ST – get ready for countless adventures ahead! 🚲✨

Our Mother’s Day E-bike Sale is in full swing, featuring up to 50% off select bike models while supplies last! Plus, don’t miss our amazing accessory packages:
- Basic Pack $99 ($300 value)
- Deluxe Pack $199 ($650 value)

And for those looking to double the fun, buy two Mokwheel ebikes and receive your choice of a bike hitch rack or pet/utility trailer for free (a $500 value)!

Hurry in this week to grab your preferred colors and models – this sale is only while supplies last! 🌟 #HappyMothersDay #EbikeAdventures 🌸 #InstaGearEBikes"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>46</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>3</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  🌸 Happy Mother’s Day to @maleriparker
                                  and family!🌺 A huge THANK YOU for
                                  choosing to...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18046673338724180"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="45"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-45"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/439647151_797608725584294_2478888937889215749_n.jpg"
                                  alt="Thanks for shopping with InstaGear Mr. Hathaway! That Mokwheel Basalts sure to get you to school on time and in style! 😉#GoCougars #SFHighSchool #InstaGear #Mokwheel #EBikes #AlmostSummer"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>21</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  Thanks for shopping with InstaGear Mr.
                                  Hathaway! That Mokwheel Basalts sure to
                                  get you to...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18006861041437703"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="46"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background VIDEO"
                                id="wpsr-video-play-46"
                              >
                                <video
                                  class="wpsr-ig-post-video"
                                  poster="https://scontent.cdninstagram.com/v/t51.29350-15/440332628_946642240580925_1297067707035754533_n.jpg?_nc_cat=102&#038;ccb=1-7&#038;_nc_sid=18de74&#038;_nc_ohc=oChvbf2rKB0Q7kNvgE7_SoB&#038;_nc_ht=scontent.cdninstagram.com&#038;edm=AM6HXa8EAAAA&#038;_nc_gid=ApBLXRTCn4bi6jI6VZ4gjzF&#038;oh=00_AYC_vwPA4GWbzCTBCA3IzZKES3iKHqZCk08KL2rpbMJ7Gg&#038;oe=66E619EB"
                                >
                                  <source
                                    src="https://scontent.cdninstagram.com/o1/v/t16/f1/m82/3048FDA8EC0B8F6D2D65160A1231BEA0_video_dashinit.mp4?efg=eyJ2ZW5jb2RlX3RhZyI6InZ0c192b2RfdXJsZ2VuLmNsaXBzLnVua25vd24tQzMuNzIwLmRhc2hfYmFzZWxpbmVfMV92MSJ9&#038;_nc_ht=scontent.cdninstagram.com&#038;_nc_cat=102&#038;vs=1511841066094489_1240302249&#038;_nc_vs=HBksFQIYT2lnX3hwdl9yZWVsc19wZXJtYW5lbnRfcHJvZC8zMDQ4RkRBOEVDMEI4RjZEMkQ2NTE2MEExMjMxQkVBMF92aWRlb19kYXNoaW5pdC5tcDQVAALIAQAVAhg6cGFzc3Rocm91Z2hfZXZlcnN0b3JlL0dGZEtMUnEzU0F4N2VUNEZBR1hyckg3OHJ6dGlicV9FQUFBRhUCAsgBACgAGAAbAYgHdXNlX29pbAExFQAAJq7r3LriyIFAFQIoAkMzLBdAQ4Q5WBBiThgSZGFzaF9iYXNlbGluZV8xX3YxEQB1AAA%3D&#038;ccb=9-4&#038;oh=00_AYC1sSRKwOfmHZvvAWxxggo8RtI80H3LZRlYA2DtaPX9VA&#038;oe=66E24410&#038;_nc_sid=1d576d"
                                    type="video/mp4"
                                  />
                                </video>

                                <div
                                  class="wpsr-ig-post-type-icon wpsr-ig-post-type-VIDEO"
                                ></div>
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>19</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  🌸 Celebrate Mom with our Mother’s Day
                                  Ebike Sale Kickoff! 🚲 Enjoy up to
                                  50%...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18276958357201279"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="47"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-47"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/439108904_1210449290326845_5165552748381853362_n.jpg"
                                  alt="🌟 A huge THANK YOU to these two for doubling the fun with their purchase of two Mokwheel Basalt STs! 🚲🚲 Your support means the world to us – here’s to endless adventures ahead! 🌿 #HappyRiding #Grateful 🌟#Mokwheel #InstaGear"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>29</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  🌟 A huge THANK YOU to these two for
                                  doubling the fun with their purchase...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18425424658027759"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="48"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background IMAGE"
                                id="wpsr-video-play-48"
                              >
                                <img
                                  decoding="async"
                                  class="wpsr-ig-post-img wpsr-show"
                                  src="static/picture/436341234_397032536438404_8875801597686018124_n.jpg"
                                  alt="🌿 Hey, InstaGear fam! 🌟Just a heads up – we’ll be taking a short break to soak up some quality family time until April 15th! 🌸 While we’re away, we’ll be dreaming up some exciting plans, especially for our e-bike enthusiasts! Get ready for a killer sale kickoff when we return, because we’ll be back and better than ever, ready to help you gear up for your outdoor adventures! 🚲 Until then, stay safe and keep exploring! 🌿 #FamilyTime #OutdoorAdventures 🌟"
                                  loading="lazy"
                                />
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>30</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  🌿 Hey, InstaGear fam! 🌟Just a heads up
                                  – we’ll be taking a short break...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                          <div
                            role="group"
                            class="wpsr-ig-post swiper-slide"
                            data-user_name="instagearoutdoors"
                            data-post_id="18026007260005814"
                            data-image_size="full"
                          >
                            <a
                              class="wpsr-ig-playmode"
                              target="_blank"
                              data-index="49"
                              data-playmode="popup"
                              data-template-id="304"
                              rel="noopener noreferrer"
                            >
                              <div
                                class="wpsr-ig-post-media wpsr-animated-background VIDEO"
                                id="wpsr-video-play-49"
                              >
                                <video
                                  class="wpsr-ig-post-video"
                                  poster="https://scontent.cdninstagram.com/v/t51.29350-15/435014327_419041114160228_6428329216570737724_n.jpg?_nc_cat=101&#038;ccb=1-7&#038;_nc_sid=18de74&#038;_nc_ohc=tLJAq0KcOc8Q7kNvgGkkFr_&#038;_nc_ht=scontent.cdninstagram.com&#038;edm=AM6HXa8EAAAA&#038;_nc_gid=ApBLXRTCn4bi6jI6VZ4gjzF&#038;oh=00_AYC7esPfLU-CVcPYqksPpeKPe8w4mGv1NkNnBLrHKPm1tg&#038;oe=66E62125"
                                >
                                  <source
                                    src="https://scontent.cdninstagram.com/o1/v/t16/f1/m82/6E43194503BEF99AB815E4DFB5ABFBAA_video_dashinit.mp4?efg=eyJ2ZW5jb2RlX3RhZyI6InZ0c192b2RfdXJsZ2VuLmNsaXBzLnVua25vd24tQzMuNzIwLmRhc2hfYmFzZWxpbmVfMV92MSJ9&#038;_nc_ht=scontent.cdninstagram.com&#038;_nc_cat=110&#038;vs=1101382407800594_133370164&#038;_nc_vs=HBksFQIYT2lnX3hwdl9yZWVsc19wZXJtYW5lbnRfcHJvZC82RTQzMTk0NTAzQkVGOTlBQjgxNUU0REZCNUFCRkJBQV92aWRlb19kYXNoaW5pdC5tcDQVAALIAQAVAhg6cGFzc3Rocm91Z2hfZXZlcnN0b3JlL0dQT3U2eG5WaHdTMXlDTUdBRkNJYjBEb2xqY0licV9FQUFBRhUCAsgBACgAGAAbAYgHdXNlX29pbAExFQAAJs7pjK%2Bih4xBFQIoAkMzLBdAMczMzMzMzRgSZGFzaF9iYXNlbGluZV8xX3YxEQB1AAA%3D&#038;ccb=9-4&#038;oh=00_AYBCtDbfWHRNlssiRl1eYBfJ9lOioWKHewn6cx7iVgwb3A&#038;oe=66E22C3C&#038;_nc_sid=1d576d"
                                    type="video/mp4"
                                  />
                                </video>

                                <div
                                  class="wpsr-ig-post-type-icon wpsr-ig-post-type-VIDEO"
                                ></div>
                              </div>
                            </a>
                            <div class="wpsr-ig-post-info">
                              <div class="wpsr-ig-post-statistics">
                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-like-count"
                                >
                                  <svg
                                    aria-label="Like"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z"
                                    ></path>
                                  </svg>
                                  <span>34</span>
                                </div>

                                <div
                                  class="wpsr-ig-post-single-statistic wpsr-ig-post-comment-comment"
                                >
                                  <svg
                                    aria-label="Comment"
                                    viewbox="0 0 48 48"
                                  >
                                    <path
                                      clip-rule="evenodd"
                                      d="M47.5 46.1l-2.8-11c1.8-3.3 2.8-7.1 2.8-11.1C47.5 11 37 .5 24 .5S.5 11 .5 24 11 47.5 24 47.5c4 0 7.8-1 11.1-2.8l11 2.8c.8.2 1.6-.6 1.4-1.4zm-3-22.1c0 4-1 7-2.6 10-.2.4-.3.9-.2 1.4l2.1 8.4-8.3-2.1c-.5-.1-1-.1-1.4.2-1.8 1-5.2 2.6-10 2.6-11.4 0-20.6-9.2-20.6-20.5S12.7 3.5 24 3.5 44.5 12.7 44.5 24z"
                                      fill-rule="evenodd"
                                    ></path>
                                  </svg>
                                  <span>0</span>
                                </div>
                              </div>

                              <div class="wpsr-ig-post-caption">
                                <p class="wpsr-ig-post-caption-text">
                                  🎉 A massive THANK YOU to everyone who
                                  joined us for our Big Spring Sale...
                                </p>
                              </div>
                              <div class="wpsr-ig-icon">
                                <svg
                                  viewbox="0 0 24 24"
                                  width="24"
                                  height="24"
                                  aria-label="Instagram"
                                >
                                  <path
                                    d="M17.1,1H6.9C3.7,1,1,3.7,1,6.9v10.1C1,20.3,3.7,23,6.9,23h10.1c3.3,0,5.9-2.7,5.9-5.9V6.9C23,3.7,20.3,1,17.1,1z
                              M21.5,17.1c0,2.4-2,4.4-4.4,4.4H6.9c-2.4,0-4.4-2-4.4-4.4V6.9c0-2.4,2-4.4,4.4-4.4h10.3c2.4,0,4.4,2,4.4,4.4V17.1z"
                                  ></path>
                                  <path
                                    d="M16.9,11.2c-0.2-1.1-0.6-2-1.4-2.8c-0.8-0.8-1.7-1.2-2.8-1.4c-0.5-0.1-1-0.1-1.4,0C10,7.3,8.9,8,8.1,9S7,11.4,7.2,12.7
                              C7.4,14,8,15.1,9.1,15.9c0.9,0.6,1.9,1,2.9,1c0.2,0,0.5,0,0.7-0.1c1.3-0.2,2.5-0.9,3.2-1.9C16.8,13.8,17.1,12.5,16.9,11.2z
                                  M12.6,15.4c-0.9,0.1-1.8-0.1-2.6-0.6c-0.7-0.6-1.2-1.4-1.4-2.3c-0.1-0.9,0.1-1.8,0.6-2.6c0.6-0.7,1.4-1.2,2.3-1.4
                              c0.2,0,0.3,0,0.5,0s0.3,0,0.5,0c1.5,0.2,2.7,1.4,2.9,2.9C15.8,13.3,14.5,15.1,12.6,15.4z"
                                  ></path>
                                  <path
                                    d="M18.4,5.6c-0.2-0.2-0.4-0.3-0.6-0.3s-0.5,0.1-0.6,0.3c-0.2,0.2-0.3,0.4-0.3,0.6s0.1,0.5,0.3,0.6c0.2,0.2,0.4,0.3,0.6,0.3
                              s0.5-0.1,0.6-0.3c0.2-0.2,0.3-0.4,0.3-0.6C18.7,5.9,18.6,5.7,18.4,5.6z"
                                  ></path>
                                </svg>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="wpsr-swiper-carousel-wrapper"></div>
                      <div class="wpsr-ig-footer wpsr-row"></div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section
      data-particle_enable="false"
      data-particle-mobile-disabled="false"
      class="elementor-section elementor-top-section elementor-element elementor-element-122d6c25 elementor-section-content-middle elementor-section-boxed elementor-section-height-default elementor-section-height-default"
      data-id="122d6c25"
      data-element_type="section"
      data-settings='{"background_background":"classic"}'
    >
      <div class="elementor-background-overlay"></div>
      <div class="elementor-container elementor-column-gap-no">
        <div
          class="elementor-column elementor-col-100 elementor-top-column elementor-element elementor-element-6f917c2c"
          data-id="6f917c2c"
          data-element_type="column"
        >
          <div class="elementor-widget-wrap elementor-element-populated">
            <div
              class="elementor-element elementor-element-2551fa5b elementor-widget elementor-widget-heading"
              data-id="2551fa5b"
              data-element_type="widget"
              data-widget_type="heading.default"
            >
              <div class="elementor-widget-container">
                <h4
                  class="elementor-heading-title elementor-size-default"
                >
                  Ready to Elevate<br />
                  Your Adventure?
                </h4>
              </div>
            </div>
            <div
              class="elementor-element elementor-element-136c711 elementor-align-center elementor-widget elementor-widget-button"
              data-id="136c711"
              data-element_type="widget"
              data-widget_type="button.default"
            >
              <div class="elementor-widget-container">
                <div class="elementor-button-wrapper">
                  <a
                    class="elementor-button elementor-button-link elementor-size-sm"
                    href="rentals.html"
                  >
                    <span class="elementor-button-content-wrapper">
                      <span class="elementor-button-text"
                        >LETS GET STARTED</span
                      >
                    </span>
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
  <div class="post-tags"></div>
</div>

<section id="comments" class="comments-area"></section>
<!-- .comments-area -->
</main>

<div
data-elementor-type="footer"
data-elementor-id="247"
class="elementor elementor-247 elementor-location-footer"
data-elementor-post-type="elementor_library"
>
<section
  data-particle_enable="false"
  data-particle-mobile-disabled="false"
  class="elementor-section elementor-top-section elementor-element elementor-element-4ba0085c elementor-section-boxed elementor-section-height-default elementor-section-height-default"
  data-id="4ba0085c"
  data-element_type="section"
  data-settings='{"background_background":"classic"}'
>
  <div class="elementor-background-overlay"></div>
  <div class="elementor-container elementor-column-gap-default">
    <div
      class="elementor-column elementor-col-100 elementor-top-column elementor-element elementor-element-e8814ae"
      data-id="e8814ae"
      data-element_type="column"
    >
      <div class="elementor-widget-wrap elementor-element-populated">
        <div
          class="elementor-element elementor-element-fa88c30 elementor-widget elementor-widget-image"
          data-id="fa88c30"
          data-element_type="widget"
          data-widget_type="image.default"
        >
          <div class="elementor-widget-container">
            <img
              width="2029"
              height="1977"
              src="static/picture/InstaGear-Logo-white.png"
              class="attachment-full size-full wp-image-1203"
              alt=""
              srcset="
                https://instagearoutdoors.com/wp-content/uploads/2022/02/InstaGear-Logo-white.png           2029w,
                https://instagearoutdoors.com/wp-content/uploads/2022/02/InstaGear-Logo-white-300x292.png    300w,
                https://instagearoutdoors.com/wp-content/uploads/2022/02/InstaGear-Logo-white-1024x998.png  1024w,
                https://instagearoutdoors.com/wp-content/uploads/2022/02/InstaGear-Logo-white-768x748.png    768w,
                https://instagearoutdoors.com/wp-content/uploads/2022/02/InstaGear-Logo-white-1536x1497.png 1536w
              "
              sizes="(max-width: 2029px) 100vw, 2029px"
            />
          </div>
        </div>
        <div
          class="elementor-element elementor-element-1929fc3f elementor-widget elementor-widget-heading"
          data-id="1929fc3f"
          data-element_type="widget"
          data-widget_type="heading.default"
        >
          <div class="elementor-widget-container">
            <h3 class="elementor-heading-title elementor-size-default">
              Ready For your next adventure?
            </h3>
          </div>
        </div>
        <section
          data-particle_enable="false"
          data-particle-mobile-disabled="false"
          class="elementor-section elementor-inner-section elementor-element elementor-element-ee38e1c elementor-section-boxed elementor-section-height-default elementor-section-height-default"
          data-id="ee38e1c"
          data-element_type="section"
        >
          <div class="elementor-container elementor-column-gap-default">
            <div
              class="elementor-column elementor-col-33 elementor-inner-column elementor-element elementor-element-c0ac092"
              data-id="c0ac092"
              data-element_type="column"
            >
              <div
                class="elementor-widget-wrap elementor-element-populated"
              >
                <div
                  class="elementor-element elementor-element-11d7029 elementor-widget elementor-widget-text-editor"
                  data-id="11d7029"
                  data-element_type="widget"
                  data-widget_type="text-editor.default"
                >
                  <div class="elementor-widget-container">
                    <span style="color: #ffffff"
                      ><b>Call or Text: </b></span
                    ><a style="color: white" href="tel:(208) 206-9011"
                      >(208) 206-9011</a
                    >
                    <span style="color: #ffffff"
                      ><b
                        ><br />
                        Email:
                      </b></span
                    ><a
                      style="color: white"
                      href="mailto:instagearoutdoors@gmail.com"
                      >instagearoutdoors@gmail.com</a
                    >
                  </div>
                </div>
              </div>
            </div>
            <div
              class="elementor-column elementor-col-33 elementor-inner-column elementor-element elementor-element-624e0e9"
              data-id="624e0e9"
              data-element_type="column"
            >
              <div
                class="elementor-widget-wrap elementor-element-populated"
              >
                <div
                  class="elementor-element elementor-element-41c8938 elementor-widget elementor-widget-text-editor"
                  data-id="41c8938"
                  data-element_type="widget"
                  data-widget_type="text-editor.default"
                >
                  <div class="elementor-widget-container">
                    <p>
                      <span style="color: #ffffff"><b>Address:</b></span
                      > 19 North Bridge Street,<br />St. Anthony, Idaho,
                      83445
                    </p>
                  </div>
                </div>
              </div>
            </div>
            <div
              class="elementor-column elementor-col-33 elementor-inner-column elementor-element elementor-element-c468080"
              data-id="c468080"
              data-element_type="column"
            >
              <div
                class="elementor-widget-wrap elementor-element-populated"
              >
                <div
                  class="elementor-element elementor-element-e678fdc elementor-widget elementor-widget-text-editor"
                  data-id="e678fdc"
                  data-element_type="widget"
                  data-widget_type="text-editor.default"
                >
                  <div class="elementor-widget-container">
                    <p>
                      <span style="color: #ffffff"
                        ><b>Business Hours:</b></span
                      ><a style="color: white"
                        ><br />T/W/R:<br />10:00am &#8211; 6:00pm
                        <br />F/S/M:<br />9am-6pm<br /></a
                      ><a
                        style="
                          color: white;
                          font-family: var(
                              --e-global-typography-text-font-family
                            ),
                            Sans-serif;
                          font-weight: var(
                            --e-global-typography-text-font-weight
                          );
                          background-color: #141519;
                          font-size: 1rem;
                        "
                        >Sunday: Closed</a
                      >
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>
        <div
          class="elementor-element elementor-element-bc39661 elementor-widget elementor-widget-text-editor"
          data-id="bc39661"
          data-element_type="widget"
          data-widget_type="text-editor.default"
        >
          <div class="elementor-widget-container">
            <p>
              <span style="color: #ffffff"
                >*Delivery available to privately owned properties and
                vacation homes</span
              >
            </p>
          </div>
        </div>
        <section
          data-particle_enable="false"
          data-particle-mobile-disabled="false"
          class="elementor-section elementor-inner-section elementor-element elementor-element-624663b elementor-section-boxed elementor-section-height-default elementor-section-height-default"
          data-id="624663b"
          data-element_type="section"
        >
          <div class="elementor-container elementor-column-gap-default">
            <div
              class="elementor-column elementor-col-33 elementor-inner-column elementor-element elementor-element-eef45b1"
              data-id="eef45b1"
              data-element_type="column"
            >
              <div
                class="elementor-widget-wrap elementor-element-populated"
              >
                <div
                  class="elementor-element elementor-element-219bf6d elementor-view-default elementor-widget elementor-widget-icon"
                  data-id="219bf6d"
                  data-element_type="widget"
                  data-widget_type="icon.default"
                >
                  <div class="elementor-widget-container">
                    <div class="elementor-icon-wrapper">
                      <a
                        class="elementor-icon"
                        href="http://instagram.com/instagearoutdoors"
                        target="_blank"
                      >
                        <i
                          aria-hidden="true"
                          class="fab fa-instagram"
                        ></i>
                      </a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div
              class="elementor-column elementor-col-33 elementor-inner-column elementor-element elementor-element-f5b3d64"
              data-id="f5b3d64"
              data-element_type="column"
            >
              <div
                class="elementor-widget-wrap elementor-element-populated"
              >
                <div
                  class="elementor-element elementor-element-55e993f elementor-view-default elementor-widget elementor-widget-icon"
                  data-id="55e993f"
                  data-element_type="widget"
                  data-widget_type="icon.default"
                >
                  <div class="elementor-widget-container">
                    <div class="elementor-icon-wrapper">
                      <a
                        class="elementor-icon"
                        href="http://facebook.com/instagearoutdoors"
                        target="_blank"
                      >
                        <i
                          aria-hidden="true"
                          class="fab fa-facebook-f"
                        ></i>
                      </a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div
              class="elementor-column elementor-col-33 elementor-inner-column elementor-element elementor-element-3aad73d"
              data-id="3aad73d"
              data-element_type="column"
            >
              <div
                class="elementor-widget-wrap elementor-element-populated"
              >
                <div
                  class="elementor-element elementor-element-2723738 elementor-view-default elementor-widget elementor-widget-icon"
                  data-id="2723738"
                  data-element_type="widget"
                  data-widget_type="icon.default"
                >
                  <div class="elementor-widget-container">
                    <div class="elementor-icon-wrapper">
                      <a
                        class="elementor-icon"
                        href="https://www.youtube.com/channel/UCD1h5SYAkqq21Va4ipqed1A"
                        target="_blank"
                      >
                        <i aria-hidden="true" class="fab fa-youtube"></i>
                      </a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
    </div>
  </div>
</section>
<section
  data-particle_enable="false"
  data-particle-mobile-disabled="false"
  class="elementor-section elementor-top-section elementor-element elementor-element-690cf43 elementor-section-boxed elementor-section-height-default elementor-section-height-default"
  data-id="690cf43"
  data-element_type="section"
  data-settings='{"background_background":"classic"}'
>
  <div class="elementor-container elementor-column-gap-default">
    <div
      class="elementor-column elementor-col-100 elementor-top-column elementor-element elementor-element-5829cd6"
      data-id="5829cd6"
      data-element_type="column"
    >
      <div class="elementor-widget-wrap elementor-element-populated">
        <div
          class="elementor-element elementor-element-8090c1a elementor-widget elementor-widget-heading"
          data-id="8090c1a"
          data-element_type="widget"
          data-widget_type="heading.default"
        >
          <div class="elementor-widget-container">
            <p class="elementor-heading-title elementor-size-default">
              © 2024. All Rights Reserved. InstaGear Outdoor Rentals. Site
              Inspired by
              <a href="https://inclinemarketing.com" target="_blank"
                >Incline Marketing Group</a
              >
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</div>

<script type="text/javascript">
const lazyloadRunObserver = () => {
  const lazyloadBackgrounds = document.querySelectorAll(
    `.e-con.e-parent:not(.e-lazyloaded)`
  );
  const lazyloadBackgroundObserver = new IntersectionObserver(
    (entries) => {
      entries.forEach((entry) => {
        if (entry.isIntersecting) {
          let lazyloadBackground = entry.target;
          if (lazyloadBackground) {
            lazyloadBackground.classList.add("e-lazyloaded");
          }
          lazyloadBackgroundObserver.unobserve(entry.target);
        }
      });
    },
    { rootMargin: "200px 0px 200px 0px" }
  );
  lazyloadBackgrounds.forEach((lazyloadBackground) => {
    lazyloadBackgroundObserver.observe(lazyloadBackground);
  });
};
const events = ["DOMContentLoaded", "elementor/lazyload/observe"];
events.forEach((event) => {
  document.addEventListener(event, lazyloadRunObserver);
});
</script>

<template lang="">
    <div>
        
    </div>
</template>

<style scoped>
    
</style>