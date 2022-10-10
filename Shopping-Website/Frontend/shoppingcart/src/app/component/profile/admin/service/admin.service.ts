import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { userRegister } from '../../login/model/Register';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  RegisterApi:string;
  getalluser:string;
  constructor(private http:HttpClient) {
    this.RegisterApi="http://localhost:1001/user/user/admin";
    this.getalluser="http://localhost:1001/user/user1";
  }

  public Register(user:userRegister):Observable<userRegister>{

    return this.http.post<userRegister>(this.RegisterApi,user);
  }
  public getuserApi():Observable<userRegister[]>{
    return this.http.get<userRegister[]>(this.getalluser);
  }
}
