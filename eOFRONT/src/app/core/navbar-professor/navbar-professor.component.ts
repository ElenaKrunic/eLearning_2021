import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { switchMap } from 'rxjs/operators';
import { AuthenticationService } from 'src/app/login/authentication.service';
import { Course } from 'src/app/model/course';
import { ProfessorService } from 'src/app/professor/professor.service';

@Component({
  selector: 'app-navbar-professor',
  templateUrl: './navbar-professor.component.html',
  styleUrls: ['./navbar-professor.component.css']
})
export class NavbarProfessorComponent implements OnInit {
  courses: Course[];
  constructor(private professorService: ProfessorService, private router: Router,private authService:AuthenticationService,private route:ActivatedRoute,private location:Location) { 
      }


  ngOnInit(): void {
    if(this.route.snapshot.params['courseId']) {
      this.route.params.pipe(switchMap((params : Params) =>
      this.professorService.getProfsesorCourses(+params['courseId'])))
      .subscribe(res => {
        this.courses = res;
        
      });
    }
  }

  logout() {
		this.authService.logOut();
		
	}
  goBack(): void {
    this.location.back();
  }

 
	

}
