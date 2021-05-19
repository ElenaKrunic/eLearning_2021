import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JwtserviceutilsService } from '../jwtservice/jwtserviceutils.service';

@Injectable({
	providedIn: 'root'
})
export class AuthenticationService {
	private readonly loginPath = '/api/login';


	constructor(
		private http: HttpClient,
		private jwtUtilsService:JwtserviceutilsService
	) { }

	login(username:string,password:string): Observable<boolean> {
		var headers:HttpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

		return this.http.post(this.loginPath, JSON.stringify({username,password}), {headers}).map((res:any)=>
		{
			let token=res&&res['token'];
			if (token){
				localStorage.setItem('currentUser',JSON.stringify({
					username:username,
					roles:this.jwtUtilsService.getRoles(token),
					token:token.split(' ')[1]
				}));
			}
			return true;
		}
			else{
				return false;
		}
		
	})


	logout(): Observable<any> {
		return this.http.get('api/logOut', {headers: this.headers, responseType: 'text'});
	}

	isLoggedIn(): boolean {
		if (!localStorage.getItem("user")) {
				return false;
		}
		return true;
	}


}
