import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AppService } from 'src/app/Appservice';
import { Orders } from '../model/order.model';
import { OrderService } from '../service/order.service';

@Component({
  selector: 'app-add-order',
  templateUrl: './add-order.component.html',
  styleUrls: ['./add-order.component.css']
})
export class AddOrderComponent implements OnInit {

  addOrder: FormGroup;
  cod:string;
  wallet:string;
  Order: Orders;
  modeOfPayment:any;
  aid:number = Number(localStorage.getItem("addressId"));
  orderAry:Orders[];

  constructor(private router:Router,private appService:AppService, private orderService:OrderService) { }

  ngOnInit(): void {

    this.orderService.getAllOrders().subscribe(data=>{
          this.orderAry=data;
    });
    
    this.addOrder = new FormGroup({
      
      cod: new FormControl(),
      wallet: new FormControl()
    });

  }

  onFormSubmit(){

    if(this.addOrder.value.cod){
      this.modeOfPayment=this.addOrder.value.cod;
    }
    else{
      this.modeOfPayment=this.addOrder.value.wallet;
    }

    this.Order={
      modeOfPayment : this.modeOfPayment,
      addressId: this.aid,
      orderStatus: "Processing"
    };
    
    console.log(this.Order);
    
    this.orderService.postOrder(this.Order,this.aid).subscribe(data=>{
      this.orderAry.push(data);
      
      localStorage.setItem("ordertId", (data.id).toString());
      this.router.navigateByUrl("/wallet");
    });


  
  }

}
