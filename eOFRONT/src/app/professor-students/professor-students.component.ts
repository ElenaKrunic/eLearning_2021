import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Professor } from '../model/professor';
import { Student } from '../model/student';
import { ProfessorService } from '../professor/professor.service';

@Component({
  selector: 'app-professor-students',
  templateUrl: './professor-students.component.html',
  styleUrls: ['./professor-students.component.css']
})
export class ProfessorStudentsComponent implements OnInit {
  students:Student [];
  professor:Professor={
    firstName:"",
    lastName:"",
    user:{
      id:0,
      username:"",
      password:"",
      authorities: []
    }
  }
  constructor(private professorService:ProfessorService,private location:Location,private router:Router) { }


  // getMe():void{
  //   this.professorService.getMe().subscribe(res =>( this.professor=res));
  //   console.log(this.professor);
  // }

  // getProfessorStudents(professor:Professor){
  //   this.professorService.getProfessorStudents(this.professor).subscribe(res=>this.students=res)
  // }
 
  ngOnInit(): void {
    this.professorService.getMe().subscribe(res =>{( this.professor=res)
      this.professorService.getProfessorStudents(res).subscribe(res=>this.students=res)
 
    });
 
    // this.getProfessorStudents(this.professor);
  }

  goBack() : void {
    this.location.back();
  }

}
