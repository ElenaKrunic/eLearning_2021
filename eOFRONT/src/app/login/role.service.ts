import { HttpClient, HttpRequest, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Observable } from 'rxjs';
import { Authority } from '../model/authority';
import { User } from '../model/user';
import { AuthenticationService } from './authentication.service';

@Injectable({
	providedIn: 'root'
})
export class RoleGuard implements CanActivate {

	private baseUrl = 'api/users';

	constructor(
		public auth: AuthenticationService,
		public router: Router,
		private http: HttpClient
	) { }

	canActivate(route: ActivatedRouteSnapshot): boolean {
		const expectedRoles: string = route.data.expectedRoles;
		const token = localStorage.getItem("user");
		const jwt: JwtHelperService = new JwtHelperService();

		if (!token) {
			this.router.navigate(['/login']);
			return false;
		}

		const info = jwt.decodeToken(token);
		const roles: string[] = expectedRoles.split('|', 3);

		if (roles.indexOf(info.role[0].authority) === -1) {
			//this.router.navigate(['/financialcard']);
			this.router.navigate(['/payment']);
			return false;
		}
		return true;
	}

	getUnassignedAuthorities(username: string) : Observable<HttpResponse<Authority[]>> {
		const url = `${this.baseUrl}/${username}/unassigned-authorities`;
		return this.http.get<Authority[]>(url, {observe: 'response'});
	}

	addUser(user: User) : Observable<HttpResponse<User>> {
		return this.http.post<User>(this.baseUrl, user, {observe: 'response'});
	}
}