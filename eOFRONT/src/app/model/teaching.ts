import { Identifiers } from "@angular/compiler";
import { runInThisContext } from "node:vm";
import { Course } from "./course";
import { Professor } from "./professor";
import { TeachingType } from "./teaching-type";
export class Teaching implements TeachingInterface {
    
    public id?: number;
    public startDate: Date;
    public endDate: Date;
    public professor: Professor;
    public courses: Course;
    public teachingType: TeachingType;

    constructor(teachingCfg: TeachingInterface) {
        this.id= teachingCfg.id;
        this.startDate= teachingCfg.startDate;
        this.endDate= teachingCfg.endDate;
        this.professor= teachingCfg.professor;
        this.courses= teachingCfg.courses;
        this.teachingType= teachingCfg.teachingType;
    }

}

interface TeachingInterface {
    id?: number;
    startDate: Date;
    endDate: Date;
    professor: Professor;
    courses: Course;
    teachingType: TeachingType;
}
