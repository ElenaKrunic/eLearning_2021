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

    constructor(enrollmentCgf: EnrollmentInterface){
        this.id= enrollmentCgf.id;
        this.startDate= enrollmentCgf.startDate;
        this.endDate= enrollmentCgf.endDate;
        this.student= enrollmentCgf.student;
        this.courses= enrollmentCgf.courses;

    }

}

interface EnrollmentInterface{
    id?:number;
    startDate: Date;
    endDate: Date;
    student: Student;
    courses: Course;
}


