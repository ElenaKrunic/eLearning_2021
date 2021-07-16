import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { ExamService } from '../exam/exam.service';
import { Exam } from '../model/exam';
import { Professor } from '../model/professor';
import { ProfessorService } from '../professor/professor.service';

@Component({
  selector: 'app-professor-exams',
  templateUrl: './professor-exams.component.html',
  styleUrls: ['./professor-exams.component.css']
})
export class ProfessorExamsComponent implements OnInit {
  exams : Exam[];
  professor:Professor={
    firstName:"",
    lastName:"",
    user:{
      id:0,
      username:"",
      password:""
    }
  }

  constructor(private professorService: ProfessorService, private router: Router,private location:Location) {
    
  }
  // getMe():void{
  //   this.professorService.getMe().subscribe(res =>( this.professor=res));
  //   console.log(this.professor);
  // }
  // getProfessorExams(professor:Professor){
  //   this.professorService.getProfessorExams(this.professor).subscribe(res=>this.exams=res)
  // }
  ngOnInit(): void {
    this.professorService.getMe().subscribe(res =>{( this.professor=res)
      this.professorService.getProfessorExams(this.professor).subscribe(res=>this.exams=res)
 
    });
  
    // this.getProfessorExams(this.professor);

  }
// getProfessorStudents(professor:Professor){
//     this.professorService.getProfessorExams(this.professor).subscribe(res=>this.exams=res)
//   }
    
  goBack(): void {
    this.location.back();
  }
}
