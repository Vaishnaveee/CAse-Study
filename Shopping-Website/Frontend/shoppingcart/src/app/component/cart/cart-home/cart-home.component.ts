import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AppService } from 'src/app/Appservice';
import { Cart } from '../model/cart.model';
import { Product } from '../model/product.model';
import { CartServiceService } from '../service/cart-service.service';

@Component({
  selector: 'app-cart-home',
  templateUrl: './cart-home.component.html',
  styleUrls: ['./cart-home.component.css']
})
export class CartHomeComponent implements OnInit {
cart:Cart[];
products:Product[];


cartId :number = Number(localStorage.getItem("cartId"));

  constructor(private http:HttpClient,private cartService:CartServiceService, private appService: AppService,private actRoute: ActivatedRoute) { }

  ngOnInit(): void {

   
  }
   
  

  getAllCarts(){
    this.cartService.getAllCarts().subscribe(data=>{
      this.cart=data;
      console.log(this.cart);
     }
     
     )
  }

  
    
  

  getProductFromCart(){
    
    this.cartService.getProductByCartId(this.cartId).subscribe(data=>{
          this.products=data;
          console.log(this.products)
        },
        error=>{
          //this.errorMsg='not found'
        }
        );
    }
    
  

  deleteItemsByCartId(){
    
        this.cartService.deleteItemsByCartId(this.cartId)
        .subscribe(data=>{
          this.products=[];

        },
        error=>{
         // this.errorMsg='not found'
        }
        );
      }
    
      deleteItem(data){
    
        this.cartService.deleteItem(this.cartId,data)
        .subscribe(data1=>{
          this.products=data1;
        },
        error=>{
         // this.errorMsg='not found'
        }
        );
      }
      
        
  }



 


