import { Component, OnInit } from '@angular/core';
import { AppService } from 'src/app/Appservice';
import { Orders } from '../model/order.model';
import { OrderService } from '../service/order.service';

@Component({
  selector: 'app-order-home',
  templateUrl: './order-home.component.html',
  styleUrls: ['./order-home.component.css']
})
export class OrderHomeComponent implements OnInit {

 uid :any = this.appService.userId;
 orderArry : Orders[];
 

  constructor(private orderService: OrderService , private appService:AppService) { }

  ngOnInit(): void {
    
    this.orderService.getAllOrders().subscribe(data=>{
        this.orderArry = data;
    });


  }

}
