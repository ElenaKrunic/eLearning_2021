import { FinancialCard } from "./financial-card";

export class Payment implements PaymentInterface{
    public id?: number;
	public dateOfPayment: string;
	public paymentDescription: string;
	public paymentAmount: number;
   
    constructor(paymentConf:PaymentInterface){
        this.id=paymentConf.id;
        this.dateOfPayment=paymentConf.dateOfPayment;
        this.paymentDescription=paymentConf.paymentDescription;
        this.paymentAmount=paymentConf.paymentAmount;
        }
}
interface PaymentInterface{
    id?:number;
    dateOfPayment:string;
    paymentDescription:string;
    paymentAmount:number;
  
}