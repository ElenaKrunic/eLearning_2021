import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent {



  public role?: string;

	constructor(private router: Router) {}

	checkRole() {
		const item = localStorage.getItem('user');

		if (!item) {
			this.router.navigate(['login']);
			this.role = undefined;
			return;
		}

		const jwt: JwtHelperService = new JwtHelperService();
		this.role = jwt.decodeToken(item).role[0];
	}

}
