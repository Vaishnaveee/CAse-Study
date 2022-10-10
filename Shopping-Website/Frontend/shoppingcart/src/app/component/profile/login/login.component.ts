import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AppService } from 'src/app/Appservice';
import { Cart } from '../../cart/model/cart.model';
import { CartServiceService } from '../../cart/service/cart-service.service';
import { Wallet } from '../../wallet/model/wallet.model';
import { WalletServiceService } from '../../wallet/service/wallet-service.service';
import { userRegister } from './model/Register';
import { RegisterService } from './service/register.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  UserArray:userRegister[];
  Register:FormGroup;
  post:userRegister;
  resgiteruser:userRegister[];
  uid:number;
  walletArray:Wallet[];
  cartArray:Cart[];
 
  constructor(private registerservice:RegisterService, private appService: AppService
    ,private walletService:WalletServiceService,private cartService:CartServiceService,
    private router:Router) { }

  ngOnInit(): void {


    this.registerservice.getuserApi().subscribe(data=>{
      this.UserArray=data;
    });

    this.walletService.getAllWallet().subscribe(data=>{
        this.walletArray = data;
    });

    this.cartService.getAllCarts().subscribe(data=>{
        this.cartArray = data;
    });


    this.Register = new FormGroup({
      firstname : new FormControl(''),
      lastname: new FormControl(''),
      email: new FormControl(''),
      username:new FormControl(''),
      password: new FormControl('')



    });
  }

  onPost(){

    this.post={
      firstname:this.Register.value.firstname,
      lastname:this.Register.value.lastname,
      email:this.Register.value.email,
    username:this.Register.value.username,
    encrytedPassword:this.Register.value.password


    }


 console.log(this.post);



 this.registerservice.Register(this.post).subscribe(data=>{
    this.UserArray.push(data);
    // this.appService.userId.next(data.id);
    this.uid = data.userId;
    console.log("data" + data.userId);
    console.log("uid --- " + this.uid);
    
  });
  

  // this.registerservice.getWalletId(this.uid).subscribe(data=>{
  //   console.log("Inn");
  //   console.log(this.uid);
  //   this.walletArray.push(data);

    
    
  // });

//   this.registerservice.getWalletId(this.appService.userId.value).subscribe(data=>{
//     this.appService.walletId.next(data);
//   });

//   this.registerservice.getCartId(this.appService.userId.value).subscribe(data=>{
//     this.appService.cartId.next(data);
//   });

}

CreateWallet(){

  console.log("In")
  console.log("uid" + this.uid);
  this.registerservice.getWalletId(this.uid).subscribe(data=>{
    this.walletArray.push(data)
  });

  this.registerservice.getCartId(this.uid).subscribe(data=>{
    this.cartArray.push(data)
  });
  this.router.navigateByUrl("/profile");
  
}

}
