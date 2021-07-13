import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
  student:Student;
  

  constructor(private studentService: StudentService, private router: Router,private authService:AuthenticationService) { 
    //  this.subscription = studentService.RegenerateData$.subscribe(() =>
    //   //  this.getExams(studentId?:number)

    //  );
  }

  ngOnInit(): void {
    // this.getStudentExams(this.student.id);
  }

  getUserUsername(){
  //  this.studentService.getStudentUsername().subscribe(res=>this.student=this.student);
  }

  getStudentExams(studentId:number){
    this.studentService.getStudentsExams(this.student.id);

  }

}
