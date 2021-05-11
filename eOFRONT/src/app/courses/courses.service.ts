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

    getProfsesorCourses(courseId:number): Observable<HttpResponse<Course[]>> {
      const url=`${this.path}/{courseId}/proffesorCourses`;
      return this.http.get<Course[]>(url, {observe: 'response'});
    }
}
