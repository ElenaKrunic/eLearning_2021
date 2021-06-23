import { localizedString } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent {

// <<<<<<< HEAD
//   	// public roles: string[]=[];
// 	// currentUser:any;
// 	// constructor(private router: Router) {}
// =======


//   public role?: string;
// >>>>>>> f721dbc5c2f5a7c192403527e84cf48f156e698c

// 	// // checkRole() {
// 	// // 	const item = localStorage.getItem('currentUser');

// 	// // 	if (!item) {
// 	// // 		this.router.navigate(['login']);
// 	// // 		this.role = undefined;
// 	// // 		return;
// 	// // 	}

// 	// // 	const jwt: JwtHelperService = new JwtHelperService();
// 	// // 	this.role = jwt.decodeToken(item).roles[0];
// 	// // }
// 	// ngOnInit(){
// 	// 	this.roles=this.getCurrentUser.roles();
// 	// 	this.currentUser=this.getCurrentUser();

// 	// }
// 	// getCurrentUser(){
// 	// 	if(localStorage.getItem('currentUser')){
// 	// 		return JSON.parse(localStorage.currentUser);
// 	// 	}
// 	// 	else{
// 	// 		return false;
// 	// 	}

// 	// }
}
