import { Injectable } from "@angular/core";
import { Address } from "../../order/model/order.model";
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";

@Injectable({
    providedIn: 'root'
})

export class AddressService{

    postAddressApi:string;
    getAddressApi:string;

    constructor(private http:HttpClient){
       this.postAddressApi= "http://localhost:1004/order/storeaddress/";
       this.getAddressApi= "http://localhost:1004/order/getaddress";
    }

    public postAddress(address:Address,cid:number):Observable<Address>{
        
        return this.http.post<Address>(this.postAddressApi+cid,address);
    }

    public getAddress():Observable<Address[]>{
        return this.http.get<Address[]>(this.getAddressApi);
    }

}