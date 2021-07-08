import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Course } from '../model/course';

@Injectable()
export class CoursesService {

  private path="api/courses"

  constructor(private http: HttpClient) { }

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
