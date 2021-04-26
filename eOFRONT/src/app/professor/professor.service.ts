import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpResponse, HttpClient } from '@angular/common/http';
import { Course } from '../model/course';

@Injectable()
export class ProfessorService {

  private path="api/professors"

  constructor(private http: HttpClient) { }

    private RegenerateData = new Subject<void>();

    RegenerateData$ = this.RegenerateData.asObservable();

    announceChange() {
        this.RegenerateData.next();
    }

    getProffesorCourses(professorId:number): Observable<HttpResponse<Course[]>> {
      const url=`${this.path}/${professorId}/professorCourses`;
      return this.http.get<Course[]>(url, {observe: 'response'});
  }

}
