import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpResponse, HttpClient, HttpHeaders } from '@angular/common/http';import { Exam } from '../model/exam';
import { AuthenticationService } from '../login/authentication.service';
const baseUrl = "https://localhost:8443/api/exams/exams"; 
const baseUrl1="https://localhost:8443/api/exams";
@Injectable()
export class ExamService {

  private path="api/exams"
 
  constructor(private http: HttpClient,private authService:AuthenticationService) { }

    private RegenerateData = new Subject<void>();

    RegenerateData$ = this.RegenerateData.asObservable();

    getAll(params: any): Observable<any> {
      const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
      return this.http.get<any>(baseUrl, { params , headers:headers});
   }
  
    get(id: number): Observable<any>{
      const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
     
      return this.http.get(`${baseUrl}/${id}`, { headers:headers });
    }
  
    create(data: any) : Observable<any> {
      return this.http.post(baseUrl1, data);
    }
  
    update(id: number, data: any) : Observable<any>{
       return this.http.put(`${baseUrl1}/${id}`, data);
    }
  
    delete(id: number) : Observable<any> {
      return this.http.delete(`${baseUrl1}/${id}`);
    }

    announceChange() {
        this.RegenerateData.next();
    }
    addExam(exam: Exam) : Observable<HttpResponse<Exam>> {
      return this.http.post<Exam>(this.path, exam, {observe: 'response'});
    }
    editExam(exam: Exam) : Observable<HttpResponse<Exam>> {
      return this.http.put<Exam>(this.path, exam, {observe: 'response'});
    }
    deleteExam(id : number): Observable<HttpResponse<any>> {
      const url = `${this.path}/${id}`;
      return this.http.delete<any>(url, {observe: 'response'});
    }
    getExams(): Observable<HttpResponse<Exam[]>> {
  
      return this.http.get<Exam[]>(this.path, {observe: 'response'});
  }
}
