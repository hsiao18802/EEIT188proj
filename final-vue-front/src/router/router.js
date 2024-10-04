import { createRouter, createWebHistory } from 'vue-router'

import Home from '@/views/Home.vue';





import Login from '@/secure/Login.vue';
import Register from '@/secure/Register.vue';
import MembersInfo from '@/members/MembersInfo.vue';
import ForgetPassword from '@/secure/ForgetPassword.vue';





//hsiao
import Cart from "@/views/pages/Cart.vue";
import Order from "@/views/pages/Order.vue";
import checkout from '@/views/pages/checkout.vue';
import memberOrder from '@/members/memberOrder.vue'
import OrderDetail from '@/components/orders/OrderDetail.vue';
import readyToPay from '@/views/pages/readyToPay.vue'
import PaymentCallback from '@/components/orders/payResult.vue';
import coupon from '@/components/orders/coupon.vue';
import discount from "@/views/pages/discount.vue";







// Lu's page
import ProductPage from '@/views/product_and_emp/ProductPage.vue';





// 錯誤頁面
import Unauthorized from '@/views/error/Unauthorized.vue';
import Forbidden from '@/views/error/Forbidden.vue';
import NotFound from '@/views/error/NotFound.vue';
import ReservedPlaceholder from '@/views/error/ReservedPlaceholder.vue';
import ContactUs from '@/views/ContactUs.vue';
import MemberChat from '@/views/MemberChat.vue';









const routes = [
  { path: "/", name: "home-link", component: Home, meta: { navbar: 'PublicNavbar' } },







  { path: "/secure/login", name: "secure-login-link", component: Login, meta: { navbar: 'PublicNavbar' } },
  { path: "/secure/register", name: "secure-register-link", component: Register, meta: { navbar: 'PublicNavbar' } },
  { path: "/secure/forget", name: "secure-forget-link", component: ForgetPassword, meta: { navbar: 'PublicNavbar' } },
  { path: "/members/info", name: "secure-membersinfo-link", component: MembersInfo, meta: { navbar: 'PublicNavbar' } },
  { path: "/contact", name: "contact-link", component: ContactUs, meta: { navbar: 'PublicNavbar' } },
  { path: "/support/memberchat", name: "memberchat-link", component: MemberChat, meta: { navbar: 'PublicNavbar' } },






  //hsiao
  { path: "/coupon", name: "coupon-link", component: coupon },
  { path: "/pages/Cart", name: "Cart-link", component: Cart, meta: { navbar: 'PublicNavbar' } },
  { path: "/pages/Order", name: "Order-link", component: Order, meta: { navbar: 'PublicNavbar' } },
  { path: "/pages/checkout", name: "checkout-link", component: checkout },
  { path: "/pages/readyToPay", name: "readyToPay-link", component: readyToPay },
  { path: "/PaymentCallback", name: "PaymentCallback-link", component: PaymentCallback },
  { path: "/pages/discount", name: "discount-link", component: discount },

  // { path: "/members/memberOrder", name: "memberOrderlink", component: memberOrder },
  {
    path: '/members/memberOrder',
    name: 'memberOrderlink',
    component: memberOrder,
  },
  {
    path: '/orders/OrderDetail/:orderId', // orderId 作為路由參數
    name: 'OrderDetail',
    component: OrderDetail,
  },





  // Lu's page

  { path: "/productpage", name: "productpage", component: ProductPage, meta: { navbar: 'PublicNavbar' } },





  // 錯誤頁面

  { path: "/401", name: "Unauthorized", component: Unauthorized, meta: { navbar: 'default', style: 'default' } },
  { path: "/403", name: "Forbidden", component: Forbidden, meta: { navbar: 'default', style: 'default' } },
  { path: "/reserved", name: "reserved", component: ReservedPlaceholder, meta: { navbar: 'default', style: 'default' } },
  { path: "/:pathMatch(.*)*", name: "NotFound", component: NotFound, meta: { navbar: 'default', style: 'default' } },





];


const router = createRouter({
  history: createWebHistory(),
  routes: routes,
});

router.beforeEach((to, from, next) => {
  if (['NotFound', 'Forbidden', 'Unauthorized'].includes(to.name) && from.meta.navbar) {
    to.meta.navbar = from.meta.navbar;
  }
  next();
})

export default router;