import { Enrollment } from "./enrollment";
import { ExamPeriod } from "./exam-period";

export class Exam implements ExamInterface {

    public id?:number;
	
	public  grade:number;
	
	public  points:number;
	
	public examDate:Date;
    public examPeriod:ExamPeriod;
	
	public status:boolean;
	public enrollment:Enrollment;
    constructor(examConf:ExamInterface)
    {
        this.id=examConf.id;
        this.grade=examConf.grade;
        this.points=examConf.points;
        this.status=examConf.status;
        this.examDate=examConf.examDate; 
  //      this.enrollment=examConf.enrollment;
      //  this.examPeriod=examConf.examPeriod;
        

    }
}

interface ExamInterface{
    id?:number;
    grade:number;
    points:number;
    examDate:Date;
    status:boolean;
    enrollment:Enrollment;
    examPeriod:ExamPeriod;

}