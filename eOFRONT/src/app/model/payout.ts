export class Payout implements PayoutInterface {
    public  id?:number;
	
	public dateOfPayout:Date ;
	
	public  descriptionOfPayout:String;
	
	public  amountOfPayout:number;
	constructor(paymentConf:PayoutInterface){
        this.id=paymentConf.id;
        this.dateOfPayout=paymentConf.dateOfPayout;
        this.descriptionOfPayout=paymentConf.descriptionOfPayout;
        this.amountOfPayout=paymentConf.amountOfPayout;
    }
}

interface PayoutInterface{
    id?:number;
    dateOfPayout:Date;
    descriptionOfPayout:String;
    amountOfPayout:number;

}