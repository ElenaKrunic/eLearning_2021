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
    addProfessor(professor: Professor): Observable<HttpResponse<Professor>> {
      return this.http.post<Professor>(this.path, professor, {observe: 'response'});
    }

  editProfessor(professor: Professor): Observable<HttpResponse<Professor>> {
      return this.http.put<Professor>(this.path, professor, {observe: 'response'});
    }

  deleteProfessor(professorId: number): Observable<HttpResponse<any>> {
      const url = `${this.path}/${professorId}`;
      return this.http.delete<any>(url, {observe: 'response'});
    }
    getProfessors(): Observable<HttpResponse<Professor[]>> {
      return this.http.get<Professor[]>(this.path, {observe: 'response'});
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
