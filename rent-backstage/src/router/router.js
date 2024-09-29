import { createRouter, createWebHistory } from 'vue-router'












import Home from '../views/Home.vue';
import CustomerSupport from '../views/CustomerSupport.vue';





// Lu's page

import EmployeeHome from '@/views/product_and_emp/EmpHome.vue';
import EmpProduct from '@/views/product_and_emp/emp_only/EmpProduct.vue';
import EmpAdd from '@/views/product_and_emp/emp_only/EmpAdd.vue';
import Login from '../secure/Login.vue';





// 錯誤頁面
import Unauthorized from '@/views/error/Unauthorized.vue';
import Forbidden from '@/views/error/Forbidden.vue';
import NotFound from '@/views/error/NotFound.vue';










const routes = [
 


  { path: "/customersupport", name: "customersupport-link", component: CustomerSupport, meta: { navbar: 'EmpNavbar', style: 'default' } },
  { path: "/emp/login", name: "emplogin-link", component: Login },
  { path: "/", name: "home-link", component: Home },













  // Lu's page


  { path: "/employee/emphome", name: EmployeeHome, component: EmployeeHome, meta: { navbar: 'EmpNavbar', style: 'default' } },
  { path: "/employee/empproduct", name: EmpProduct, component: EmpProduct, meta: { navbar: 'EmpNavbar', style: 'default' } },
  { path: "/employee/empadd", name: EmpAdd, component: EmpAdd, meta: { navbar: 'EmpNavbar', style: 'default' } },






  // 錯誤頁面

  { path: "/401", name: "Unauthorized", component: Unauthorized, meta: { navbar: 'default', style: 'default' } },
  { path: "/403", name: "Forbidden", component: Forbidden, meta: { navbar: 'default', style: 'default' } },
  // { path: "/reserved", name: "reserved", component: ReservedPlaceholder, meta: { navbar: 'default', style: 'default' } },
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