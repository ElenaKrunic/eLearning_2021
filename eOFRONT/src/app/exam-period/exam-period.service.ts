import { Injectable } from '@angular/core';
import { HttpResponse, HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { ExamPeriod } from '../model/exam-period';

const baseUrl = "https://localhost:8443/api/examPeriods"; 

@Injectable({
  providedIn: 'root'
})

export class ExamPeriodService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(baseUrl); 
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

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }

  findByName(name: string) : Observable<any> { 
    return this.http.get(`${baseUrl}?name=${name}`);
  }

  private RegenerateData = new Subject<void>(); 

  RegenerateData$ = this.RegenerateData.asObservable();

  announceChange(){
    this.RegenerateData.next();
  }

  getExamPeriods() : Observable<HttpResponse<ExamPeriod[]>> {
    return this.http.get<ExamPeriod[]>(baseUrl, {observe: 'response'});
  }

  getExamPeriod(id: number) : Observable<HttpResponse<ExamPeriod>> {
    const url = `${baseUrl}/${id}`;
    return this.http.get<ExamPeriod>(url, {observe: 'response'});
  }

  addExamPeriod(examPeriod: ExamPeriod) : Observable<HttpResponse<ExamPeriod>> {
    return this.http.post<ExamPeriod>(baseUrl, examPeriod, {observe: 'response'});
  }

  editExamPeriod(examPeriod: ExamPeriod) : Observable<HttpResponse<ExamPeriod>> {
    return this.http.put<ExamPeriod>(baseUrl, examPeriod, {observe: 'response'});
  }

  updateExamPeriod(id: number, data: any) : Observable<any> {
    return this.http.put(`$examPeriodUrl/${id}`, data);
  }

  deleteExamPeriod(id : number): Observable<HttpResponse<any>> {
    const url = `${baseUrl}/${id}`;
    return this.http.delete<any>(url, {observe: 'response'});
  }

}
