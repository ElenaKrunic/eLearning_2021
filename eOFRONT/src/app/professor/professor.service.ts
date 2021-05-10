import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpResponse, HttpClient } from '@angular/common/http';
import { Course } from '../model/course';
import { Student } from '../model/student';
import { Professor } from '../model/professor';

@Injectable()
export class ProfessorService {

  private path="api/professors"

  constructor(private http: HttpClient) { }

    private RegenerateData = new Subject<void>();

    RegenerateData$ = this.RegenerateData.asObservable();

    announceChange() {
        this.RegenerateData.next();
    }

    getProfessor(id:number):Observable<HttpResponse<Professor[]>>{
      const url=`${this.path}/{id}`;
      return this.http.get<Professor[]>(url, {observe: 'response'});
    } 


    getProfessorStudents(professorId:number): Observable<HttpResponse<Student[]>> {
      const url=`${this.path}/{professorId}/professorStudents`;
      return this.http.get<Student[]>(url, {observe: 'response'});
    }

}
