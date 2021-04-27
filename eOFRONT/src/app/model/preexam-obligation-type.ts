import { Identifiers } from "@angular/compiler";
export class PreexamObligationType implements PreexamObligationTypeInterface{

    public id?:number;
	
	public name:string;
	
	
	public code:string;

    constructor(preexamObligatinTypeCfg: PreexamObligationTypeInterface) {
        this.id= preexamObligatinTypeCfg.id;
        this.name= preexamObligatinTypeCfg.name;
        this.code= preexamObligatinTypeCfg.code;
    }

}
interface PreexamObligationTypeInterface{
    id?: number;
    name: string;
    code: string;
}