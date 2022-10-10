import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AppService } from 'src/app/Appservice';
import {  ProductserviceService } from '../service/product.service';
import { Product } from './model/product.model';

@Component({
  selector: 'app-product-home',
  templateUrl: './product-home.component.html',
  styleUrls: ['./product-home.component.css']
})
export class ProductHomeComponent implements OnInit {
  categoryId: number;
  products: Product[];
  errorMsg:string;
  cid: number;
  productArr:Product;
  cartId :number = Number(localStorage.getItem("cartId"));
  productIdArr: number[];


  constructor(private actRoute: ActivatedRoute, private productService: ProductserviceService,
    private appService: AppService) { }

  ngOnInit(): void {
    this.actRoute.params.subscribe(params=>{
      this.cid = params.cid;
      this.productService.getProductByCatId(params.cid).subscribe(data =>{
        this.products = data;
      },
      error=>{
        this.errorMsg = 'Error in Loading Products, Please contact administrator';
      });
    })
  }


 /* addToCart(){
    //extract the array out of subject
    let productArray=this.appService.cart_product.value;
    //push the product into extracted array;
    //productArray.push(product);
    //update the subject with new value of extracted array
    this.appService.cart_product.next(productArray);
  }*/

  productByCartId(data){

    this.productService.postProductByCartID(this.cartId,data).subscribe(data1=>{
    this.productArr=data1;
    console.log("1");
    console.log(data);
    console.log(data1);
    this.productIdArr.push(data);

    // localStorage.setItem("ProductIdArray",this.productIdArr.toString() );

    //let productArray=this.appService.cart_product.value;
    //this.appService.cart_product.next(productArray);
    
  });
    
}


  



}