import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { CategoryserviceService } from '../service/category.service';
import { Category } from './Category';

@Component({
  selector: 'app-category-home',
  templateUrl: './category-home.component.html',
  styleUrls: ['./category-home.component.css']
})
export class CategoryHomeComponent implements OnInit {

  /*
    Reach out to service(CategoryService) which will provide the data.
  */
    categories: Category[];
    errorMsg:string;

     constructor(private categoryService: CategoryserviceService) { }

     ngOnInit(): void {
       this.categoryService.getAllCategories().subscribe(data=>{
         this.categories = data;
       },
       error=>{
         this.errorMsg="Error in Loading Categories, Please contact Administrator";
       });
     }

}
