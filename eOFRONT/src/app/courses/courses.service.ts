import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Course } from '../model/course';

const baseUrl = "https://localhost:8443/api/courses"; 

@Injectable({
  providedIn: 'root'
})
export class CoursesService {

  private path="api/courses"

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
  
    delete(id: number) : Observable<any> {
      return this.http.delete(`${baseUrl}/${id}`);
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
