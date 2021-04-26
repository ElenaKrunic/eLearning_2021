
import { Student } from "./student";

export class FinancialCard {

    public id?:number;
	
	public initialState:number;
	
	public totalPayment:number;
	
	public  totalPayout:number;
	public totalCost:number;
    public student:Student;

    constructor(financialCardConf:FinancialCardInterface){
        this.id=financialCardConf.id;
        this.initialState=financialCardConf.initialState;
        this.totalPayment=financialCardConf.totalPayment;
        this.totalPayout=financialCardConf.totalPayout;
        this.totalCost=financialCardConf.totalCost;
        this.student=financialCardConf.student;
    }

	



}
interface FinancialCardInterface{
    id?:number;
    initialState:number;
    totalPayment:number;
    totalPayout:number;
    totalCost:number;
    student:Student;
}
