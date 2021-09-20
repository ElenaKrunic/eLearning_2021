import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { AuthenticationService } from '../login/authentication.service';
import { Course } from '../model/course';

const baseUrl = "https://localhost:8443/api/courses/courses"; 

@Injectable({
  providedIn: 'root'
})
export class CoursesService {

  private path="api/courses"

  constructor(private http: HttpClient,private authService:AuthenticationService) { }

    
    getAll(params: any): Observable<any> {
      const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    return this.http.get<any>(baseUrl, { params , headers:headers});
  
    }
  
    get(id: number): Observable<any>{
      const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    return this.http.get(`${baseUrl}/${id}`, {headers:headers});
  }
  
    create(data: any) : Observable<any> {
      const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
      return this.http.post(baseUrl, data, {headers:headers});
     }
  
    update(id: number, data: any) : Observable<any>{
      const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
      return this.http.put(`${baseUrl}/${id}`, data, {headers:headers});
   }
  
    delete(id: number) : Observable<any> {
      const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    return this.http.delete(`${baseUrl}/${id}`, {headers:headers});
   }
  
    private RegenerateData = new Subject<void>();

    RegenerateData$ = this.RegenerateData.asObservable();
    
    announceChange() {
        this.RegenerateData.next();
    }
    addCourse(course: Course) : Observable<HttpResponse<Course>> {
      return this.http.post<Course>(this.path, course, {observe: 'response'});
    }
    editCourse(course: Course) : Observable<HttpResponse<Course>> {
      return this.http.put<Course>(this.path, course, {observe: 'response'});
    }
    deleteCourse(id : number): Observable<HttpResponse<any>> {
      const url = `${this.path}/${id}`;
      return this.http.delete<any>(url, {observe: 'response'});
    }
    getCourses(): Observable<HttpResponse<Course[]>> {
  
      return this.http.get<Course[]>(this.path, {observe: 'response'});
  }
   
}
