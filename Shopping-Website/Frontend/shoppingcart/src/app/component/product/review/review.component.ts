import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Review } from '../product-home/model/Review';
import { ProductserviceService } from '../service/product.service';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {


  reviews: Review[];
  starNums: number[];
  pid:number;
  reviewArry:Review[];
  showReviewForm: boolean;
  username: string;
  reviewForm: FormGroup;
  review: Review;
  constructor(private actRoute: ActivatedRoute , private productService: ProductserviceService) { }

  ngOnInit(): void {
    this.username = atob(localStorage.getItem('token')).split(':')[0];
    this.reviewForm = new FormGroup({
      reviewText : new FormControl(''),
      rating: new FormControl(1)
    });
    this.showReviewForm = false;
    this.starNums =[0,0,0,0,0];
    this.actRoute.params.subscribe(params=>{
      this.pid=params.pid;
       this.productService.getReviewsByProductId(params.pid).subscribe(data=>{
            this.reviews=data;
            this.reviewArry = this.reviews;
            this.updateRatingCount();

       });
    });
  }

  filterReviews = (rating: number)=>{
     this.reviewArry = this.reviews.filter(r=>r.rating === rating);
  }

  showAllReviews = ()=>{
    this.reviewArry = this.reviews;
  }

  postReview(){
     this.showReviewForm =  !this.showReviewForm;

  }


  onPostReview(){
      this.review = {
        reviewText : this.reviewForm.value.reviewText,
        rating : this.reviewForm.value.rating,
        username : this.username
      }

      this.productService.postReview(this.review,this.pid)
      .subscribe(data=>{
          this.reviewArry.push(data);
          this.reviews = this.reviewArry;
          this.showReviewForm =  !this.showReviewForm;
          this.updateRatingCount();

      });
  }

  onReviewDelete(rid: number){
      this.productService.deleteReview(rid).subscribe(data=>{
        this.reviewArry = this.reviewArry.filter(r=>r.id !== rid);
        this.reviews = this.reviewArry;
        this.updateRatingCount();
      });
  }

  updateRatingCount(){
    this.starNums[0] = this.reviews.filter(r=>r.rating === 5).length;
    this.starNums[1] = this.reviews.filter(r=>r.rating === 4).length;
    this.starNums[2] = this.reviews.filter(r=>r.rating === 3).length;
    this.starNums[3] = this.reviews.filter(r=>r.rating === 2).length;
    this.starNums[4] = this.reviews.filter(r=>r.rating === 1).length;
  }

}
