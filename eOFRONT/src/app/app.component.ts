import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {



	public roles: string[]=[];
	currentUser:any;
	constructor(private router: Router) {}

	// checkRole() {
	// 	const item = localStorage.getItem('currentUser');

	// 	if (!item) {
	// 		this.router.navigate(['login']);
	// 		this.role = undefined;
	// 		return;
	// 	}

	// 	const jwt: JwtHelperService = new JwtHelperService();
	// 	this.role = jwt.decodeToken(item).roles[0];
	// }
	ngOnInit(){
		this.roles=this.getCurrentUser().roles;
		this.currentUser=this.getCurrentUser();

	}
	getCurrentUser(){
		if(localStorage.getItem('currentUser')){
			return JSON.parse(localStorage.currentUser);
		}
		else{
			return false;
		}

	}


}
