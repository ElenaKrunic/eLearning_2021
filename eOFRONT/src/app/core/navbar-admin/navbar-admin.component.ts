import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthenticationService } from 'src/app/login/authentication.service';

@Component({
  selector: 'app-navbar-admin',
  templateUrl: './navbar-admin.component.html',
  styleUrls: ['./navbar-admin.component.css']
})
export class NavbarAdminComponent implements OnInit {

  constructor(
    private authenticationService: AuthenticationService,
		private toastr: ToastrService,
		private router: Router
  ) { }

  ngOnInit(): void {
  }

  logout () {
    this.authenticationService.logOut();
    this.router.navigate(['/**']);
    alert("You have successfully logged out!")
  }

}
