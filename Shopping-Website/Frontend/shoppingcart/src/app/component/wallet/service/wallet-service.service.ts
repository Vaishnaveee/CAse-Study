import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppService } from 'src/app/Appservice';
import { Statement } from '../model/statement.model';
import { Wallet } from '../model/wallet.model';

@Injectable({
  providedIn: 'root'
})
export class WalletServiceService {


  activateAPI: string;
  statementWIDAPI: string;
  showStatement:string;
  deactivateAPI:string;
  useWalletMoneyAPI: string;
  getAllWalletApi:string;



  constructor(private http:HttpClient, private appService: AppService) {
    this.activateAPI="http://localhost:1000/wallet/activate/";
    this.deactivateAPI="http://localhost:1000/wallet/deactivate/";
    this.statementWIDAPI="http://localhost:1000/wallet/getStatementByWallet/"+this.appService.walletId.value;
    this.showStatement="http://localhost:1000/wallet/statement/allStatements";
    this.useWalletMoneyAPI="http://localhost:1000/wallet/getWalletMoney/56/";
    this.getAllWalletApi="http://localhost:1000/wallet/allWallets";
  }

  public activateWallet(wid: number){
    return this.http.get(this.activateAPI+wid);
  }

  public deactivateWallet(wid: number){
    return this.http.get(this.deactivateAPI+wid);
  }

  public getBalance(uid:number):Observable<number>{
    return this.http.get<number>("http://localhost:1000/wallet/getBalance/"+ Number(localStorage.getItem("userId")));
  }

  public getStatementByWalletId(): Observable<Statement[]>{
    return this.http.get<Statement[]>(this.statementWIDAPI);
  }

  public showAllStatements(): Observable<Wallet[]>{
    return this.http.get<Wallet[]>(this.showStatement);
  }

  public useWalletMoney(amount: number):Observable<number>{
    return this.http.get<number>(this.useWalletMoneyAPI+amount);
  }

  public getAllWallet():Observable<Wallet[]>{
    return this.http.get<Wallet[]>(this.getAllWalletApi);
  }

}


