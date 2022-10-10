import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cart } from 'src/app/component/cart/model/cart.model';
import { Wallet } from 'src/app/component/wallet/model/wallet.model';
import { userRegister } from '../model/Register';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  RegisterApi:string;
  getalluser:string;
  getWalletIdAPI:string;
  postCartIdAPI:string;
  getAllCartApi:string;
  getUserApi :string;
  getWalletByUserApi:string;
  getCartByUserApi : string;

  constructor(private http:HttpClient) {
    this.RegisterApi="http://localhost:1001/user/users";
    this.getalluser="http://localhost:1001/user/user1";
    this.getWalletIdAPI="http://localhost:1005/wallet/saveWallet/";
    this.postCartIdAPI="http://localhost:1003/cart/addcart/";
    this.getAllCartApi="http://localhost:1003/cart/allcart";
    this.getUserApi = "http://localhost:1001/user/u/";
    this.getWalletByUserApi = "http://localhost:1005/wallet/";
    this.getCartByUserApi = "http://localhost:1003/cart/";

  }

  public getAllCarts():Observable<Cart[]>{
    return this.http.get<Cart[]>(this.getAllCartApi);
  }

  public Register(user:userRegister):Observable<userRegister>{

    return this.http.post<userRegister>(this.RegisterApi,user);
  }
  public getuserApi():Observable<userRegister[]>{
    return this.http.get<userRegister[]>(this.getalluser);
  }

  public getWalletId(uId: number):Observable<Wallet>{
    return this.http.get<Wallet>(this.getWalletIdAPI+uId);
  }

  public getCartId(uId: number):Observable<Cart>{
    return this.http.get<Cart>(this.postCartIdAPI + uId);
  }

  // public postCartId(uId:number):Observable<Cart>{
  //   return this.http.post<Cart>(this.getCartIdAPI + uId);
  // }

  public getUserByUsername(username:string):Observable<userRegister>{
    return this.http.get<userRegister>(this.getUserApi+username);
  }

  public getWalletByUser(uid:number):Observable<number>{
    return this.http.get<number>(this.getWalletByUserApi + uid);
  }

  public getCartByUser(uid:number):Observable<number>{
    return this.http.get<number>(this.getCartByUserApi + uid);
  }


}
