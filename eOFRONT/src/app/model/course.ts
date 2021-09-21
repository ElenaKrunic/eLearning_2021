import { Identifiers } from "@angular/compiler";
import { Enrollment } from "./enrollment";
export class Course implements CourseInterface {

    public id?: number;
    public title: string;
    public courseCode: string;
    public startDate: Date;
    public endDate: Date;
    public ects: number;
    

    constructor(courseCfg:CourseInterface) {
        this.id= courseCfg.id;
        this.title= courseCfg.title;
        this.courseCode= courseCfg.courseCode;
        this.startDate= courseCfg.startDate;
        this.endDate= courseCfg.endDate;
        this.ects= courseCfg.ects;
    }


}

interface CourseInterface {
    id?:number;
    title: string;
    courseCode: string;
    startDate: Date;
    endDate: Date;
    ects: number;

}
