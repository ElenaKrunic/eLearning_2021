import { Identifiers } from "@angular/compiler";
export class TeachingType implements TeachingTypeInterface {

    public id?: number;
    public name: string;
    public code: string;

    constructor(teachingTypeCgf: TeachingTypeInterface) {
        this.id= teachingTypeCgf.id;
        this.name= teachingTypeCgf.name;
        this.code= teachingTypeCgf.code;
    }
}

interface TeachingTypeInterface {
    id?: number;
    name: string;
    code: string;
}
