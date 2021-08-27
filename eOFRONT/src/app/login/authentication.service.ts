import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { ThisReceiver } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Observable, ObservableLike } from 'rxjs';
import { map } from 'rxjs/operators';
import { JwtserviceutilsService } from '../jwtservice/jwtserviceutils.service';
import { User } from '../model/user';

@Injectable({
	providedIn: 'root'
})
export class AuthenticationService {
	private readonly loginPath = '/api/login';

	constructor(
		private http: HttpClient,
		private jwtUtilsService:JwtserviceutilsService,
		private router: Router
	) { }

	login(username:string,password:string): Observable<boolean> {
		var headers:HttpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

		return this.http.post(this.loginPath, JSON.stringify({username,password}), {headers:headers,responseType:"text"})
		.pipe(map((res:any)=>{
			let token=res;
			if (token){
				localStorage.setItem('currentUser',JSON.stringify({
					username:username,
					roles:this.jwtUtilsService.getRoles(token),
					token:token
				}));
				return true;
			}else{
				return false;
			}
		}))		
	}

	getToken():String{
		var currentUser=JSON.parse(localStorage.getItem('currentUser') || '{}');
		var token =currentUser && currentUser.token;
		return token ? token: "";
	}

	logOut():void{
		localStorage.removeItem('currentUser');
		this.router.navigate(['']);
	}

	isLoggedIn():boolean{
		if(this.getToken() !='') return true;
		else return false;
	}

	getCurrentUser() : Observable<HttpResponse<User>>{
		if(localStorage.currentUser){
			return JSON.parse(localStorage.currentUser);
		}
		else{
			return undefined;
		}
	}

	getRole(): string {
		const item = localStorage.getItem('loggedUser'); 
		if (!item) {
			this.router.navigate(['']); 
			return '';
		}

		var jwt : JwtHelperService = new JwtHelperService(); 
		var loggedUser = jwt.decodeToken(item);
		return loggedUser;
	}
}
