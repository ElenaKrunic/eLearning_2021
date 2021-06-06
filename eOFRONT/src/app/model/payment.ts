import { FinancialCard } from "./financial-card";

export class Payment implements PaymentInterface{
    public id?:number;
	public  dateOfPayment:Date;
	public paymentDescription:String ;
	public paymentAmount:number;
    public financialCard:FinancialCard;

    constructor(paymentConf:PaymentInterface){
        this.id=paymentConf.id;
        this.dateOfPayment=paymentConf.dateOfPayment;
        this.paymentDescription=paymentConf.paymentDescription;
        this.paymentAmount=paymentConf.paymentAmount;
        this.financialCard=paymentConf.financialCard;
    }
}
interface PaymentInterface{
    id?:number;
    dateOfPayment:Date;
    paymentDescription:String;
    paymentAmount:number;
    financialCard:FinancialCard;
}