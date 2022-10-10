import { Component, OnInit } from '@angular/core';
import { AppService } from 'src/app/Appservice';
import { Product } from '../../product/product-home/model/product.model';
import {  ProductserviceService } from '../../product/service/product.service';

@Component({
  selector: 'app-navbar-home',
  templateUrl: './navbar-home.component.html',
  styleUrls: ['./navbar-home.component.css']
})
export class NavbarHomeComponent implements OnInit {
product:Product[];
  constructor(private appService: AppService,private productService: ProductserviceService) { }
  loggedIn:boolean;
  username:string;
  count:number;
  ngOnInit(): void {

    let status = localStorage.getItem('isLoggedIn');
        if(status){
            this.loggedIn = true;
            let token = localStorage.getItem('token');
            token = atob(token);
            this.username = token.split(":")[0];
        }
        else{
            this.loggedIn = false;
        }

        this.appService.cart_product.subscribe(data=>{
          this.product=data;
          this.count=this.product.length;
        });

  }

  onLogOut(){
    localStorage.removeItem('token');
    localStorage.removeItem('isLoggedIn');
    this.loggedIn = false;
  }


}
