import { Component, Input, OnInit, ViewEncapsulation } from '@angular/core';
import { FormGroup, FormBuilder, Validators, NgForm } from '@angular/forms';
import { AuthenticationService } from './authentication.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { JwtserviceutilsService } from '../jwtservice/jwtserviceutils.service';
import { User } from '../model/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  encapsulation:ViewEncapsulation.None
})
export class LoginComponent implements OnInit {
	
	
	constructor(private authenticationService: AuthenticationService,private router: Router,
	)
	 {
	}

	ngOnInit() {
	}

	login(form:NgForm):void {
		var username:string=form.value.username;
		var password:string=form.value.password;
		this.authenticationService.login(username,password).subscribe(
			(loggedIn:boolean) =>{
				if(loggedIn){
					this.router.navigate(['']);
				}
			}
			
		)}

		
}
