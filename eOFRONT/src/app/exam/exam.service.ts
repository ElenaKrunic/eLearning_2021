import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpResponse, HttpClient } from '@angular/common/http';import { Exam } from '../model/exam';
const baseUrl = "https://localhost:8443/api/exams"; 
@Injectable()
export class ExamService {

  private path="api/exams"
 
  constructor(private http: HttpClient) { }

    private RegenerateData = new Subject<void>();

    RegenerateData$ = this.RegenerateData.asObservable();

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
