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
  examId:string;
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


  private register(examId:number,student:Student) {
    this.examId=this.route.snapshot.paramMap.get('id');
    
    this.studentService.registerExam(student,+this.examId);
    console.log("Student"+this.student);
    console.log("Exam id"+this.examId )
  }
  goBack(): void {
    this.location.back();
  }

}
