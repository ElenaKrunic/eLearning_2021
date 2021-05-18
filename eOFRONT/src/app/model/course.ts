import { Identifiers } from "@angular/compiler";
export class Course implements CourseInterface {

    public id?: number;
    public title: string;
    public courseCode: string;
    public startDate: Date;
    public endDate: Date;
    public ECTS: number;

    constructor(courseCfg:CourseInterface) {
        this.id= courseCfg.id;
        this.title= courseCfg.title;
        this.courseCode= courseCfg.courseCode;
        this.startDate= courseCfg.startDate;
        this.endDate= courseCfg.endDate;
        this.ECTS= courseCfg.ECTS;
    }


}

interface CourseInterface {
    id?:number;
    title: string;
    courseCode: string;
    startDate: Date;
    endDate: Date;
    ECTS: number;

}
