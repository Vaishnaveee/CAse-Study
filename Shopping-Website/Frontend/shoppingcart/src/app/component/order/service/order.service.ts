import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Orders } from "../model/order.model";

@Injectable({
    providedIn: 'root'
})

export class OrderService{

    getAllOrderApi: string;
    postOrderApi: string;
    getOrderApi:string;

    constructor(private http:HttpClient){
        this.getAllOrderApi = "http://localhost:1004/order/allorders";
        this.getOrderApi = "http://localhost:1004/order/getorder/"
        this.postOrderApi = "http://localhost:1004/order/addorder/";
    }

    // public getOrderById(oid:number):Observable<Orders[]>{
    //     return this.http.get<Orders[]>(this.getOrderApi+oid);
    // }

    public getAllOrders():Observable<Orders[]>{
        return this.http.get<Orders[]>(this.getAllOrderApi);
    }

    public postOrder(order:Orders,aid:number):Observable<Orders>{
        return this.http.post<Orders>(this.postOrderApi+aid,order);
    }

    public getOrderByUserId(uid:number):Observable<Orders[]>{
        return this.http.get<Orders[]>(this.getOrderApi+ uid);
    }


}