import { Identifiers } from "@angular/compiler";

export class Professor implements ProfessorInterface {
    
    public id?: number;
    public firstName: string;
    public lastName: string;

    constructor(professorCfg:ProfessorInterface){
        this.id= professorCfg.id;
        this.firstName= professorCfg.firstName;
        this.lastName= professorCfg.lastName;

    }

}

interface ProfessorInterface{
    id?: number;
    firstName: string;
    lastName: string;
}
