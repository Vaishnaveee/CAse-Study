import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../product-home/model/product.model';
import { ProductserviceService } from '../service/product.service';

@Component({
  selector: 'app-post-product',
  templateUrl: './post-product.component.html',
  styleUrls: ['./post-product.component.css']
})
export class PostProductComponent implements OnInit {


  constructor(private http:HttpClient, private actRoute: ActivatedRoute , private productService: ProductserviceService) { }
onSubmit(data)
{
  this.http.post('http://localhost:1002/product/' ,data)
  .subscribe((result)=>{
    console.warn("result",result)
  })
  console.warn(data);
}
  ngOnInit(): void {
  }
}