import { Identifiers } from "@angular/compiler";

import { Course } from "./course";
import { Exam } from "./exam";
import { Student } from "./student";
export class Enrollment implements EnrollmentInterface {

    public id?:number;
    public startDate: Date;
    public endDate: Date;
    public student: Student;
    public courses: Course;
    public courseName:string;
   
    constructor(enrollmentCgf: EnrollmentInterface){
        this.id= enrollmentCgf.id;
        this.startDate= enrollmentCgf.startDate;
        this.endDate= enrollmentCgf.endDate;
        this.student= enrollmentCgf.student;
        this.courses= enrollmentCgf.courses;
       this.courseName=enrollmentCgf.courseName;
    }
  

}

interface EnrollmentInterface{
    courseName: string;
    id?:number;
    startDate: Date;
    endDate: Date;
    student: Student;
    courses: Course;
    
}


