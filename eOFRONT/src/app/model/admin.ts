import { Identifiers } from "@angular/compiler";
export class Admin implements AdminInterface {
    
    public id?: number;

    constructor(adminCfg: AdminInterface){
        this.id= adminCfg.id;
    }

}

interface AdminInterface {
    id?:number;
}
