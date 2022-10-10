import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarHomeComponent } from './component/navbar/navbar-home/navbar-home.component';
import { ProfileHomeComponent } from './component/profile/profile-home/profile-home.component';
import { CartHomeComponent } from './component/cart/cart-home/cart-home.component';
import { OrderHomeComponent } from './component/order/order-home/order-home.component';
import { ProductHomeComponent } from './component/product/product-home/product-home.component';
import { WalletHomeComponent } from './component/wallet/wallet-home/wallet-home.component';
import { LoginComponent } from './component/profile/login/login.component';
import { FormsModule} from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule} from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AdminComponent } from './component/profile/admin/admin.component';

import { FooterHomeComponent } from './component/footer/footer-home/footer-home.component';

import { CategoryHomeComponent } from './component/product/category/category-home/category-home.component';
import { CartItemComponent } from './component/cart/cart-item/cart-item.component';
import { ReviewComponent } from './component/product/review/review.component';
import { PostProductComponent } from './component/product/post-product/post-product.component';
import { AddressHomeComponent } from './component/address/address-home/address-home.component';
import { AddOrderComponent } from './component/order/add-order/add-order.component';

@NgModule({
  declarations: [
    AppComponent,
    ProfileHomeComponent,
    CartHomeComponent,
    OrderHomeComponent,
    ProductHomeComponent,
    WalletHomeComponent,
    LoginComponent,
    AdminComponent,
    CategoryHomeComponent,
    FooterHomeComponent,
      CartItemComponent,
      NavbarHomeComponent,
      ReviewComponent,
      PostProductComponent,
      AddressHomeComponent,
      AddOrderComponent


  ],
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
