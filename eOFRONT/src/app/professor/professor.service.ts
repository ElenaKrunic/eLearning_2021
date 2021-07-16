import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpResponse, HttpClient, HttpHeaders } from '@angular/common/http';
import { Course } from '../model/course';
import { Student } from '../model/student';
import { Professor } from '../model/professor';
import { AuthenticationService } from '../login/authentication.service';
import { Exam } from '../model/exam';
const path = "https://localhost:8443/api/professors"; 

@Injectable()
export class ProfessorService {


  constructor(private http: HttpClient, private authService:AuthenticationService) { }

    private RegenerateData = new Subject<void>();

    RegenerateData$ = this.RegenerateData.asObservable();

    announceChange() {
        this.RegenerateData.next();
    }
    addProfessor(professor: Professor): Observable<HttpResponse<Professor>> {
      return this.http.post<Professor>(path, professor, {observe: 'response'});
    }

  editProfessor(professor: Professor): Observable<HttpResponse<Professor>> {
      return this.http.put<Professor>(path, professor, {observe: 'response'});
    }

  deleteProfessor(professorId: number): Observable<HttpResponse<any>> {
      const url = `${path}/${professorId}`;
      return this.http.delete<any>(url, {observe: 'response'});
    }
    getProfessors(): Observable<HttpResponse<Professor[]>> {
      return this.http.get<Professor[]>(path, {observe: 'response'});
    }

    getProfessor(id:number):Observable<HttpResponse<Professor[]>>{
      const url=`${path}/{id}`;
      return this.http.get<Professor[]>(url, {observe: 'response'});
    } 

    getMe(){
      
      const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    
      return this.http.get<Professor>(path+"/me", {headers: headers});
    
    }
    getProfessorStudents(professor:Professor): Observable<Student[]> {
      const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
      const url = `${path}/${professor.id}/professorStudents`;
    
      return this.http.get<Student[]>(url, {headers: headers});
        }

    getProfessorsCourses(professor:Professor): Observable<Course> {
      const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
      const url = `${path}/${professor.id}/proffesorCourses`;
    
      return this.http.get<Course>(url, {headers: headers});
     }
    getProfessorExams(professor:Professor): Observable<Exam[]> {
      const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
      const url = `${path}/${professor.id}/professorExams`;
    
      return this.http.get<Exam[]>(url, {headers: headers});
        }

}
