import { Identifiers } from "@angular/compiler";
import { FinancialCard } from "./financial-card";
import { TypeOfFinancing } from "./type-of-financing";
import { User } from "./user";


export class Student implements StudentInterface {
   	public id?:number;	
	public cardNumber:String;
	public firstName:String;
	public lastName:String;
	public phoneNumber:String;
	public email:String;
	public umnc:String;
	public startedCollegeIn:number;
	public modelNumber:number;
	public referenceNumber:String ;
	public accountNumber:String ;
	//testno 
	public cardAmount:number; 
    public  typeOfFinancing:TypeOfFinancing;
	public financialCards:FinancialCard;
    public user:User;

    
    constructor(studentCfg:StudentInterface)
	{	
		this.id = studentCfg.id;
		this.cardNumber = studentCfg.cardNumber;
        this.email=studentCfg.email;
        this.modelNumber=studentCfg.modelNumber;
        this.phoneNumber=studentCfg.phoneNumber;
        this.financialCards=studentCfg.financialCards;
        this.referenceNumber=studentCfg.referenceNumber;
        this.typeOfFinancing=studentCfg.typeOfFinancing;
        this.umnc=studentCfg.umnc;
        this.startedCollegeIn=studentCfg.startedCollegeIn;
        this.cardAmount=studentCfg.cardAmount;
        this.accountNumber=studentCfg.accountNumber;
		this.firstName = studentCfg.firstName;
		this.lastName = studentCfg.lastName;
        this.user=studentCfg.user;
	}
 
}
interface StudentInterface {
    id?: number;
    firstName: String;
    lastName: String;
    phoneNumber:String;
    cardNumber:String;
    email:String;
    umnc:String;
    startedCollegeIn:number;
    modelNumber:number;
    referenceNumber:String ;
    accountNumber:String ;
    typeOfFinancing:TypeOfFinancing;
    cardAmount:number;
    financialCards:FinancialCard;
    user:User
}
