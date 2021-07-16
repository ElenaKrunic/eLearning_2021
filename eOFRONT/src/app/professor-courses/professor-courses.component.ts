import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { AuthenticationService } from '../login/authentication.service';
import { Course } from '../model/course';
import { Professor } from '../model/professor';
import { ProfessorService } from '../professor/professor.service';

@Component({
  selector: 'app-professor-courses',
  templateUrl: './professor-courses.component.html',
  styleUrls: ['./professor-courses.component.css']
})
export class ProfessorCoursesComponent implements OnInit {
  
  professor:Professor={
    id:0,
    firstName:"",
    lastName:"",
    user:{
      id:0,
      username:"",
      password:""
    }
  }
  course:Course ;
  constructor(private professorService: ProfessorService, private router: Router,private authService:AuthenticationService, private route:ActivatedRoute, private location:Location ) { }
  

  // getMe():void{
  //   this.professorService.getMe().subscribe(res =>( this.professor=res));
  //   console.log(this.professor);
  // }
  // getProfessorCourses(professor:Professor){
  //   this.professorService.getProfessorsCourses(this.professor).subscribe(res=>this.courses=res)
  // }
  ngOnInit(): void {
    this.professorService.getMe().subscribe(res =>{( this.professor=res)
      this.professorService.getProfessorsCourses(res).subscribe(res=>this.course=res)
 
    
    });
  
    // this.getProfessorCourses(this.professor);
    
  }

  
  goBack(): void {
    this.location.back();
  }
}
