import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthenticationService } from '../login/authentication.service';
import { Authority } from '../model/authority';
import { User } from '../model/user';

const baseUrl = "https://localhost:8443/api/users"; 

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http: HttpClient,
    private authService: AuthenticationService) { }

  getAll(params: any): Observable<any> {
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    return this.http.get<any>(baseUrl, { params , headers:headers});
  }
  
  get(id: number): Observable<any>{
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    return this.http.get(`${baseUrl}/${id}`, {headers: headers} );
  }

  create(data: any) : Observable<any> {
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    return this.http.post(baseUrl, data, {headers:headers});
  }

  update(id: number, data: any) : Observable<any>{
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
     return this.http.put(`${baseUrl}/${id}`, data, {headers:headers});
  }
 
  editUser(user: User): Observable<HttpResponse<User>> {
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    return this.http.put<User>(baseUrl, user, {observe: 'response', headers: headers});
  }

  delete(id: number) : Observable<any> {
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    return this.http.delete(`${baseUrl}/${id}`, {headers: headers});
  }

  deleteAll(): Observable<any> {
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    return this.http.delete(baseUrl, {headers:headers});
  }

  getUnassignedAuthorities(username: string): Observable<HttpResponse<Authority[]>> {
    const url = `${baseUrl}/${username}/unassigned-authorities`;
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    return this.http.get<Authority[]>(url, {observe: 'response', headers:headers});
}
  
getLoggedUser(): Observable<User> {
  //const url = `${baseUrl}/loggedUser`;
  //return this.http.get<User>(url);
  const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
  return this.http.get<User>(baseUrl + "/loggedUser", {headers: headers});

}

}