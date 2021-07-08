export class Payout implements PayoutInterface {
    public  id?:number;
	
	public dateOfPayOut:Date ;
	
	public  descriptionPayOut:String;
	
	public  payOutAmount:number;
	constructor(paymentConf:PayoutInterface){
        this.id=paymentConf.id;
        this.dateOfPayOut=paymentConf.dateOfPayOut;
        this.descriptionPayOut=paymentConf.descriptionPayOut;
        this.payOutAmount=paymentConf.payOutAmount;
    }
}

interface PayoutInterface{
    id?:number;
    dateOfPayOut:Date;
    descriptionPayOut:String;
    payOutAmount:number;

}