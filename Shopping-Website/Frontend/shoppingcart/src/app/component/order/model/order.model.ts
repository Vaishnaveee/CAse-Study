export interface Orders{
    id?: number;
    amountPaid? : number;
    modeOfPayment? : string;
    orderDate? : Date;
    orderStatus? : string;
    quantity? : number;
    addressId:number;
}

export interface Address{
    id?:number;
    cartId?:number;
    city?:string;
    flatNumber?:number;
    fullName?:string;
    mobileNumber?:string;
    pincode?:string;
    state?:string;
}