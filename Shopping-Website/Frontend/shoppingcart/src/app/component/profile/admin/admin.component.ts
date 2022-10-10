import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { userRegister } from '../login/model/Register';
import { AdminService } from './service/admin.service';


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {


  UserArray:userRegister[];
  formname:FormGroup;
  post:userRegister;
  resgiteruser:userRegister[];
  
  constructor(private adminservice:AdminService) { }

  ngOnInit(): void {


    this.adminservice.getuserApi().subscribe(data=>{
      this.UserArray=data;
    });


    this.formname = new FormGroup({
      firstname : new FormControl(''),
      lastname: new FormControl(''),
      email: new FormControl(''),
      username:new FormControl(''),
      password: new FormControl('')



    });
  }

  onPost(){

    this.post={
      firstname:this.formname.value.firstname,
      lastname:this.formname.value.lastname,
      email:this.formname.value.email,
    username:this.formname.value.username,
    encrytedPassword:this.formname.value.password


    }


 console.log(this.post);
 this.adminservice.Register(this.post).subscribe(data=>{
  console.log(this.resgiteruser.push(data));

  });

}

}
