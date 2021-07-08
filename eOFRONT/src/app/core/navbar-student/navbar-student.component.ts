import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthenticationService } from 'src/app/login/authentication.service';

@Component({
  selector: 'app-navbar-student',
  templateUrl: './navbar-student.component.html',
  styleUrls: ['./navbar-student.component.css']
})
export class NavbarStudentComponent implements OnInit {

  constructor(
		private authenticationService: AuthenticationService,
		private toastr: ToastrService,
		private router: Router
	) { }

	ngOnInit() {
	}

	logout() {
		this.authenticationService.logOut();
	}

}
