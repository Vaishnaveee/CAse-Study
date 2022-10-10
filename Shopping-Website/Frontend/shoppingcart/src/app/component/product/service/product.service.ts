import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../product-home/model/product.model';
import { Review } from '../product-home/model/Review';


@Injectable({
  providedIn: 'root'
})
export class ProductserviceService {

  private getProductByCatIDApi : string;
  private getReviewByProductIDApi: string;
  private postReviewApi: string;
  private deleteReviewApi: string;
  private postProductByCartIDApi:string;
  private postProductApi:string;


  constructor(private http: HttpClient){
    this.getProductByCatIDApi ='http://localhost:1002/product/';
    this.getReviewByProductIDApi='http://localhost:1002/review/product/';
    this.postReviewApi='http://localhost:1002/review/';
    this.deleteReviewApi='http://localhost:1002/review/';
    this.postProductByCartIDApi="http://localhost:1003/cart/saveItem/";
    this.postProductApi='http://localhost:1002/product/'

  }
  public postProduct(product: Product, catId:number):Observable<Product>{

    return this.http.post<Product>(this.postProductApi+catId, product);
  }


  public getProductByCatId(catId:number) : Observable<Product[]>{

    return this.http.get<Product[]>(this.getProductByCatIDApi + catId);
  }

  public getReviewsByProductId(pid: number):Observable<Review[]> {

     return this.http.get<Review[]>(this.getReviewByProductIDApi+ pid);
  }

  public postReview(review: Review, pid: number):Observable<Review> {

     return this.http.post<Review>(this.postReviewApi + pid , review);
  }

  public deleteReview(rid: number):Observable<any> {

    return this.http.delete<any>(this.deleteReviewApi+rid);
  }

  public postProductByCartID(cId:number,pId:number):Observable<Product> {
    return this.http.post<Product>(this.postProductByCartIDApi + cId+"/"+ pId,{});
  }
 
}
