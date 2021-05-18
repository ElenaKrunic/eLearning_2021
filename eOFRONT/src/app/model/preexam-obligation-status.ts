import { Identifiers } from "@angular/compiler";
import { PreexamObligation } from "./preexam-obligation";

export class PreexamObligationStatus implements PreexamObligationStatusInterface{

    public id?:number;
	
	public name:string;
	
	
	public code:string;

    public preexamObligation:PreexamObligation;

    constructor(preexamObligatinStatusCfg: PreexamObligationStatusInterface) {
        this.id= preexamObligatinStatusCfg.id;
        this.name= preexamObligatinStatusCfg.name;
        this.code= preexamObligatinStatusCfg.code;
        this.preexamObligation= preexamObligatinStatusCfg.preexamObligation;
    }

}
interface PreexamObligationStatusInterface{
    id?: number;
    name: string;
    code: string;
    preexamObligation: PreexamObligation;
}