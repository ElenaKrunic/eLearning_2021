import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpResponse, HttpClient } from '@angular/common/http';import { Exam } from '../model/exam';

@Injectable()
export class ExamService {

  private path="api/exams"

  constructor(private http: HttpClient) { }

    private RegenerateData = new Subject<void>();

    RegenerateData$ = this.RegenerateData.asObservable();

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
