import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from '../login/authentication.service';
import { Exam } from '../model/exam';
import { Student } from '../model/student';
import { StudentService } from '../students/student.service';

@Component({
  selector: 'app-student-exams',
  templateUrl: './student-exams.component.html',
  styleUrls: ['./student-exams.component.css']
})
export class StudentExamsComponent implements OnInit {

  exams?:Exam[];
  examId:number;
  student:Student;
  
  

  constructor(private studentService: StudentService, private route: ActivatedRoute, private router: Router,private authService:AuthenticationService,private location:Location) { 
    //  this.subscription = studentService.RegenerateData$.subscribe(() =>
    //   //  this.getExams(studentId?:number)

    //  );
  }

  
  
  ngOnInit(): void {
    this.studentService.getMeAgain().subscribe(res =>{( this.student=res)
      this.studentService.getStudentsExams(res).subscribe(res=>this.exams=res);

    });
 
  }

  // getUserUsername(){
  // //  this.studentService.getStudentUsername().subscribe(res=>this.student=this.student);
  // }

  // getStudentExams(studentId:number){
  //   this.studentService.getStudentsExams(this.student.id);

  // }


  register(examId:number) {
    // this.studentForRegister=this.studentService.getMeAgain().subscribe;
     this.studentService.registerExam(this.student,examId);
    
    console.log("Student"+this.student);
    console.log("Exam id"+examId )
  }
  goBack(): void {
    this.location.back();
  }

}
