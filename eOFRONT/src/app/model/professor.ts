import { Identifiers } from "@angular/compiler";
import { User } from "./user";

export class Professor implements ProfessorInterface {
    
    public id?: number;
    public firstName: string;
    public lastName: string;
    public user:User;

    constructor(professorCfg:ProfessorInterface){
        this.id= professorCfg.id;
        this.firstName= professorCfg.firstName;
        this.lastName= professorCfg.lastName;
        this.user=professorCfg.user;
    }

}

interface ProfessorInterface{
    user: User;
    id?: number;
    firstName: string;
    lastName: string;
    
}
