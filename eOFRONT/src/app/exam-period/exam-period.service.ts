import { Injectable } from '@angular/core';
import { HttpResponse, HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { ExamPeriod } from '../model/exam-period';

@Injectable({
  providedIn: 'root'
})

export class ExamPeriodService {

  private examPeriodUrl = "api/examPeriod"; 

  constructor(private http: HttpClient) { }

  //??
  private RegenerateData = new Subject<void>(); 

  RegenerateData$ = this.RegenerateData.asObservable();

  announceChange(){
    this.RegenerateData.next();
  }

  getExamPeriods() : Observable<HttpResponse<ExamPeriod[]>> {
    return this.http.get<ExamPeriod[]>(this.examPeriodUrl, {observe: 'response'});
  }

  getExamPeriod(id: number) : Observable<HttpResponse<ExamPeriod>> {
    const url = `${this.examPeriodUrl}/${id}`;
    return this.http.get<ExamPeriod>(url, {observe: 'response'});
  }

  addExamPeriod(examPeriod: ExamPeriod) : Observable<HttpResponse<ExamPeriod>> {
    return this.http.post<ExamPeriod>(this.examPeriodUrl, examPeriod, {observe: 'response'});
  }

  editExamPeriod(examPeriod: ExamPeriod) : Observable<HttpResponse<ExamPeriod>> {
    return this.http.put<ExamPeriod>(this.examPeriodUrl, examPeriod, {observe: 'response'});
  }

  deleteExamPeriod(id : number): Observable<HttpResponse<any>> {
    const url = `${this.examPeriodUrl}/${id}`;
    return this.http.delete<any>(url, {observe: 'response'});
  }

}
