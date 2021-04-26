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

    
    getExams(): Observable<HttpResponse<Exam[]>> {
  
      return this.http.get<Exam[]>(this.path, {observe: 'response'});
  }
}
