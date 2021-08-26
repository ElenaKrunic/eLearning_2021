import { Injectable } from '@angular/core';
import { HttpResponse, HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { ExamPeriod } from '../model/exam-period';
import { AuthenticationService } from '../login/authentication.service';

const baseUrl = "https://localhost:8443/api/examPeriods"; 

@Injectable({
  providedIn: 'root'
})

export class ExamPeriodService {

  constructor(private http: HttpClient,private authService: AuthenticationService) { }

  getAll(params: any): Observable<any> {
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    return this.http.get<any>(baseUrl, { params, headers:headers });
  }

  get(id: number): Observable<any>{
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    return this.http.get(`${baseUrl}/${id}`, {headers:headers});
  }

  create(data: any) : Observable<any> {
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    return this.http.post(baseUrl, data, {headers:headers});
  }

  update(id: number, data: any) : Observable<any>{
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
     return this.http.put(`${baseUrl}/${id}`, data, {headers:headers});
  }

  delete(id: number) : Observable<any> {
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    return this.http.delete(`${baseUrl}/${id}`, {headers:headers});
  }

  deleteAll(): Observable<any> {
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    return this.http.delete(baseUrl, {headers:headers});
  }

  findByName(name: string) : Observable<any> { 
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    return this.http.get(`${baseUrl}?name=${name}`, {headers:headers});
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
