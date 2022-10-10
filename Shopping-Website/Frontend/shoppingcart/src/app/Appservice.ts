import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class AppService{

  loggedIn = new BehaviorSubject<boolean>(false);

  userId = new BehaviorSubject<number>(0);
  walletId = new BehaviorSubject<number>(0);
  productId = new BehaviorSubject<number>(0);
  cartId = new BehaviorSubject<number>(0);
  orderId = new BehaviorSubject<number>(0);
  addressId = new BehaviorSubject<number>(0);

  pId = new BehaviorSubject<number>(0);
//  cartId = new BehaviorSubject<number>(0);


  cart_product=new BehaviorSubject([]);
  


}