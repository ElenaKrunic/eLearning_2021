import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { switchMap } from 'rxjs/operators';
import { AuthenticationService } from 'src/app/login/authentication.service';
import { Course } from 'src/app/model/course';

@Component({
  selector: 'app-navbar-professor',
  templateUrl: './navbar-professor.component.html',
  styleUrls: ['./navbar-professor.component.css']
})
export class NavbarProfessorComponent implements OnInit {
 
  constructor(private router: Router,private authService:AuthenticationService,private route:ActivatedRoute,private location:Location) { 
      }


  ngOnInit(): void {

  }

  logout() {
		this.authService.logOut();
		
	}
  goBack(): void {
    this.location.back();
  }

 
	

}
