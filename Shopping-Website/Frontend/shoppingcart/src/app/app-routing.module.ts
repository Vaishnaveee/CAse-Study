import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartHomeComponent } from './component/cart/cart-home/cart-home.component';
import { CartItemComponent } from './component/cart/cart-item/cart-item.component';
import { OrderHomeComponent } from './component/order/order-home/order-home.component';
import { CategoryHomeComponent } from './component/product/category/category-home/category-home.component';
import { ProductHomeComponent } from './component/product/product-home/product-home.component';
import { ReviewComponent } from './component/product/review/review.component';
import { AdminComponent } from './component/profile/admin/admin.component';
import { LoginComponent } from './component/profile/login/login.component';
import { ProfileHomeComponent } from './component/profile/profile-home/profile-home.component';
import { WalletHomeComponent } from './component/wallet/wallet-home/wallet-home.component';
import { PostProductComponent } from './component/product/post-product/post-product.component';
import { AddressHomeComponent } from './component/address/address-home/address-home.component';
import { AddOrderComponent } from './component/order/add-order/add-order.component';


const routes: Routes = [
  {path:'', component: CategoryHomeComponent},
  {path:'cart', component: CartHomeComponent},
  {path:'order', component: OrderHomeComponent},
  {path:'profile', component: ProfileHomeComponent},
  {path:'wallet', component: WalletHomeComponent},
  {path:'storeaddress',component:AddressHomeComponent},
  {path:'login', component: LoginComponent},
  {path:'cart-item', component: CartItemComponent},
  {path:'admin', component: AdminComponent},
  {path:'product/:cid', component:ProductHomeComponent },
  {path:'product/review/:pid', component:ReviewComponent },
  {path:'cart/:pid', component:CartHomeComponent},
  {path:'product',component:PostProductComponent},
  //{path:'storeaddress/:cid',component:AddressComponent}
  {path:'addorder',component:AddOrderComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
