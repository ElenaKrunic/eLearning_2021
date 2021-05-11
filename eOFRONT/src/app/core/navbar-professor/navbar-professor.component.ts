import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthenticationService } from 'src/app/login/authentication.service';

@Component({
  selector: 'app-navbar-professor',
  templateUrl: './navbar-professor.component.html',
  styleUrls: ['./navbar-professor.component.css']
})
export class NavbarProfessorComponent implements OnInit {

  constructor(
		private authenticationService: AuthenticationService,
		private toastr: ToastrService,
		private router: Router
	) { }


  ngOnInit(): void {
  }

  logout() {
		this.authenticationService.logout().subscribe(
			result => {
				localStorage.removeItem('user');
				this.toastr.success(result);
				this.router.navigate(['login']);
			},
			error => {
				this.toastr.error(error.error);
			}
		);
	}

 
	

}
