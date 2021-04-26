import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpResponse, HttpClient } from '@angular/common/http';
import { Student } from '../model/student';
import { Exam } from '../model/exam';
import { FinancialCard } from '../model/financial-card';
import { Payment } from '../model/payment';
import { Payout } from '../model/payout';
import { Enrollment } from '../model/enrollment';
@Injectable()
export class StudentService {

  private path="api/student"

  constructor(private http: HttpClient) { }

    private RegenerateData = new Subject<void>();

    RegenerateData$ = this.RegenerateData.asObservable();

    announceChange() {
        this.RegenerateData.next();
    }

    getStudentsExams(id:number): Observable<HttpResponse<Exam[]>> {
        const url=`${this.path}/${id}/exams`;
        return this.http.get<Exam[]>(url, {observe: 'response'});
    }

   getStudentFinancialCard(id: number): Observable<HttpResponse<FinancialCard>> {
        const url = `${this.path}/${id}/financial-card`;
        return this.http.get<FinancialCard>(url, {observe: 'response'});

    }
    getStudentPayment(id: number): Observable<HttpResponse<Payment[]>> {
      const url = `${this.path}/${id}/payment`;
      return this.http.get<Payment[]>(url, {observe: 'response'});
      
  }
  getStudentPayout(id: number): Observable<HttpResponse<Payout[]>> {
    const url = `${this.path}/${id}/payout`;
    return this.http.get<Payout[]>(url, {observe: 'response'});
    
}
getStudentDocument(id: number): Observable<HttpResponse<Document[]>> {
  const url = `${this.path}/${id}/document`;
  return this.http.get<Document[]>(url, {observe: 'response'});
  
}
getStudentEnrollment(id: number): Observable<HttpResponse<Enrollment[]>> {
  const url = `${this.path}/${id}/enrollment`;
  return this.http.get<Enrollment[]>(url, {observe: 'response'});
  
}


}
