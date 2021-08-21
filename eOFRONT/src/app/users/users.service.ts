import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Authority } from '../model/authority';
import { User } from '../model/user';

const baseUrl = "https://localhost:8443/api/users"; 

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http: HttpClient) { }

  getAll(params: any): Observable<any> {
    return this.http.get<any>(baseUrl, { params });
  }
  
  get(id: number): Observable<any>{
    return this.http.get(`${baseUrl}/${id}`);
  }

  create(data: any) : Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(id: number, data: any) : Observable<any>{
     return this.http.put(`${baseUrl}/${id}`, data);
  }
 
  editUser(user: User): Observable<HttpResponse<User>> {
    return this.http.put<User>(baseUrl, user, {observe: 'response'});
  }

  delete(id: number) : Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }

  getUnassignedAuthorities(username: string): Observable<HttpResponse<Authority[]>> {
    const url = `${baseUrl}/${username}/unassigned-authorities`;
    return this.http.get<Authority[]>(url, {observe: 'response'});
}
  
}
