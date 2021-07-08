import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { AuthenticationService } from '../login/authentication.service';
import { Course } from '../model/course';
import { ProfessorService } from '../professor/professor.service';

@Component({
  selector: 'app-professor-courses',
  templateUrl: './professor-courses.component.html',
  styleUrls: ['./professor-courses.component.css']
})
export class ProfessorCoursesComponent implements OnInit {
  courses:Course[] ;
  constructor(private professorService: ProfessorService, private router: Router,private authService:AuthenticationService, private route:ActivatedRoute, private location:Location ) { }

  ngOnInit(): void {
    if(this.route.snapshot.params['courseId']) {
      this.route.params.pipe(switchMap((params : Params) =>
      this.professorService.getProfsesorCourses(+params['courseId'])))
      .subscribe(res => {
        this.courses = res;
        
      });
  }

  }
  goBack(): void {
    this.location.back();
  }
}
