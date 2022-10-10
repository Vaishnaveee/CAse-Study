import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cart } from '../model/cart.model';
import { Items } from '../model/item.model';
import { Product } from '../model/product.model';

@Injectable({
  providedIn: 'root'
})
export class CartServiceService {
  activateAPI: string;
   getAllCartApi:string;
   deleteItemApi:string;
   getProductByCartIDApi:string;
   deleteItemByCartIdApi:string;
   

  constructor(private http:HttpClient) { 
   
    this.getAllCartApi="http://localhost:1003/cart/allcart";
    this.deleteItemApi="http://localhost:1003/cart/deleteItem/";
    this.getProductByCartIDApi="http://localhost:1003/cart/item/";
    this.deleteItemByCartIdApi="http://localhost:1003/cart/deleteItem/";
  }

 

  public getAllCarts():Observable<Cart[]>{
    return this.http.get<Cart[]>(this.getAllCartApi);
  }
  public deleteItem(cId:number,pId:number):Observable<Product[]>{
    return this.http.delete<Product[]>(this.deleteItemApi + cId +"/" + pId,{});
  }

  public getProductByCartId(catId:number):Observable<Product[]> {
    return this.http.get<Product[]>(this.getProductByCartIDApi+catId);
  }

  public deleteItemsByCartId(cId:number):Observable<Items[]>{
    return this.http.delete<Items[]>(this.deleteItemByCartIdApi+cId);
  }



  

}
