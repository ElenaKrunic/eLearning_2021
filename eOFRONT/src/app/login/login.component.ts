import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthenticationService } from './authentication.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { JwtserviceutilsService } from '../jwtservice/jwtserviceutils.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
	public user;
	constructor(private authenticationService: AuthenticationService,private router: Router,
	) {
		this.user={};
	}

	ngOnInit() {
	}

	login():void {
		this.authenticationService.login(this.user.username,this.user.password).subscribe(
			(loggedIn:boolean) =>{
				if(loggedIn){
					this.router.navigate(["/main"]);
				}
			}
			
	}
}
