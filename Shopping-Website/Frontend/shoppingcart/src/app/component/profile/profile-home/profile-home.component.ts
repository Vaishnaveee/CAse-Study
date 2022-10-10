import { Component, OnInit,NgZone } from '@angular/core';
import { FormControl, FormGroup, FormGroupDirective } from '@angular/forms';
import { Router } from '@angular/router';
import { AppService } from 'src/app/Appservice';
import { RegisterService } from '../login/service/register.service';
import { user } from './model/userdata';
import { AuthguardService } from './service/Authguard.service';
import { userRegister } from '../login/model/Register';

@Component({
  selector: 'app-profile-home',
  templateUrl: './profile-home.component.html',
  styleUrls: ['./profile-home.component.css']
})
export class ProfileHomeComponent implements OnInit {



  loginForm: FormGroup;
  users:any;
  errorMsg: string;
  user:user[];
  username:string;
  password1: any;
  guser:userRegister;
  user1:userRegister;


  constructor(private router: Router,
     private appService: AppService,
     private authservice:AuthguardService,ngZone:NgZone, private registerservice:RegisterService) {
      window['onSignIn'] = user =>ngZone.run(
        () => {
          this.afterSignUp(user);

        }
      );
     }

  ngOnInit(): void {

    this.authservice.getAllUser().subscribe(data=>{
      this.user=data;
      console.log(this.user);
    });

    this.loginForm = new FormGroup({
      username: new FormControl(''),
      password: new FormControl('')
    });
  }
  afterSignUp(googleUser){
    this.guser=googleUser;
    
    console.log(googleUser);
    

  }

  onFormSubmit(){
     let username = this.loginForm.value.username;
     let password = this.loginForm.value.password;


     // this.password1=this.user.find(u=>(atob(u.encrytedPassword)));
      this.user1  = this.user.find(u=> (u.userName === username || u.encrytedPassword === password));
    // this.username=atob(localStorage.getItem('token')).split(':')[0];
   // this.doctor = this.user.find(u=> (u.username === this.username));

     //console.log( this.did=this.doctor.doctors.id);

    // this.did=this.doctor.doctors.id;

console.log(this.user1);
     if(this.user1){
        localStorage.setItem("isLoggedIn","true");
        let token = btoa(username + ':' + password);
        localStorage.setItem("token", token);
        this.appService.loggedIn.next(true);
        console.log("INN");

        console.log("username :" + this.user1.username );
        console.log("userId" + this.user1.userId);

        localStorage.setItem("userId", (this.user1.userId).toString());

        this.registerservice.getWalletByUser(this.user1.userId).subscribe(data=>{
          localStorage.setItem("walletId", (data).toString());
        });


        this.registerservice.getCartByUser(this.user1.userId).subscribe(data=>{
          localStorage.setItem("cartId", (data).toString());
        });

        // this.registerservice.getWalletId(Number(localStorage.getItem("userId"))).subscribe(data=>{
        //   // this.appService.walletId.next(data);
        //   console.log(data);
        //   // localStorage.setItem("walletId", (data).toString());


        //   this.registerservice.getCartId(Number(localStorage.getItem("userId"))).subscribe(data=>{
        //     // this.appService.cartId.next(data);
        //     console.log(data);
        //     // localStorage.setItem("cartId", (data).toString());
        //   });

        // });



        this.router.navigateByUrl('/');
     }else{
        this.errorMsg = 'Invalid Credentials';
     }
  }


}

