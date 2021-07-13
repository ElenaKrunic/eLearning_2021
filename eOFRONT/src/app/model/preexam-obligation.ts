import { Identifiers } from "@angular/compiler";
import { Exam } from "./exam";
import { PreexamObligationType } from "./preexam-obligation-type";
import { PreexamObligationStatus } from "./preexam-obligation-status";

export class PreexamObligation implements preexamObligationInterface {

    public id?:number;
	public points:number;
	public location:String;
	public dateOfObligation:String;
	public passed:boolean; 
	public exam:Exam;
	public preexamObligationType:PreexamObligationType;
	public preexamObligationStatus:PreexamObligationStatus;

	constructor(preexamObligationCfg:preexamObligationInterface){
        this.id= preexamObligationCfg.id;
        this.points= preexamObligationCfg.points;
        this.location= preexamObligationCfg.location;
		this.dateOfObligation= preexamObligationCfg.dateOfObligation;
	//	this.passed= preexamObligationCfg.passed;
	//	this.exam= preexamObligationCfg.exam;
	//	this.preexamObligationType= preexamObligationCfg.preexamObligationType;
	//	this.preexamObligationStatus= preexamObligationCfg.preexamObligationStatus;

    }
}
interface preexamObligationInterface{
	id?: number;
    points: number;
    location: String;
    dateOfObligation:String;
   // passed:boolean;
   // exam:Exam;
   // preexamObligationType:PreexamObligationType;
   // preexamObligationStatus:PreexamObligationStatus;
}