import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpResponse, HttpClient, HttpHeaders } from '@angular/common/http';
import { Student } from '../model/student';
import { Exam } from '../model/exam';
import { FinancialCard } from '../model/financial-card';
import { Payment } from '../model/payment';
import { Payout } from '../model/payout';
import { Enrollment } from '../model/enrollment';
import { AuthenticationService } from '../login/authentication.service';

@Injectable()
export class StudentService {

  private path="api/student";

  constructor(private http: HttpClient,private authService:AuthenticationService) { }

    private RegenerateData = new Subject<void>();

    RegenerateData$ = this.RegenerateData.asObservable();

    announceChange() {
        this.RegenerateData.next();
    }

  getStudents(): Observable<HttpResponse<Student[]>> {
      return this.http.get<Student[]>(this.path, {observe: 'response'});
    }

  getStudent(id: number): Observable<HttpResponse<Student>> {
      const url = `${this.path}/${id}`;
      return this.http.get<Student>(url, {observe: 'response'});
    }

  addStudent(student: Student): Observable<HttpResponse<Student>> {
      return this.http.post<Student>(this.path, student, {observe: 'response'});
    }

  editStudent(student: Student): Observable<HttpResponse<Student>> {
      return this.http.put<Student>(this.path, student, {observe: 'response'});
    }

  deleteStudent(studentId: number): Observable<HttpResponse<any>> {
      const url = `${this.path}/${studentId}`;
      return this.http.delete<any>(url, {observe: 'response'});
    }

    getStudentsExams(id:number): Observable<Exam[]> {

            const headInfo={
              'Content - Type': 'application/json',
              'X-Auth-Token':"" + this.authService.getToken(),
                  }
            const requestOptions={
              headers:new HttpHeaders(headInfo)
            }

        const url=`${this.path}/${id}/exams`;
        return this.http.get<Exam[]>(url, requestOptions);
    }

   getStudentFinancialCard(id: number): Observable<FinancialCard> {
             const headInfo={
        'Content - Type': 'application/json',
        'X-Auth-Token':"" + this.authService.getToken(),
            }
            const requestOptions={
              headers:new HttpHeaders(headInfo)
            }
        const url = `${this.path}/${id}/financial-card`;
        return this.http.get<FinancialCard>(url,requestOptions);

    }
    getStudentPayment(id: number): Observable<Payment[]> {
            const headInfo={
              'Content - Type': 'application/json',
              'X-Auth-Token':"" + this.authService.getToken(),
                  }
            const requestOptions={
              headers:new HttpHeaders(headInfo)
            }
      const url = `${this.path}/${id}/payment`;
      return this.http.get<Payment[]>(url, requestOptions);
      
  }

  getStudentPayout(id: number): Observable<Payout[]> {
    const headInfo={
      'Content - Type': 'application/json',
      'X-Auth-Token':"" + this.authService.getToken(),
          }
          const requestOptions={
            headers:new HttpHeaders(headInfo)
          }
    const url = `${this.path}/${id}/payout`;
    return this.http.get<Payout[]>(url, requestOptions);  
 }

getStudentDocument(id: number): Observable<Document[]> {
  const headInfo={
    'Content - Type': 'application/json',
    'X-Auth-Token':"" + this.authService.getToken(),
        }
        const requestOptions={
          headers:new HttpHeaders(headInfo)
        }
  const url = `${this.path}/${id}/document`;
  return this.http.get<Document[]>(url, requestOptions);
  
}
getStudentEnrollment(id: number): Observable<Enrollment[]> {
  const headInfo={
    'Content - Type': 'application/json',
    'X-Auth-Token':"" + this.authService.getToken(),
        }
        const requestOptions={
          headers:new HttpHeaders(headInfo)
        }
  const url = `${this.path}/${id}/enrollment`;
  return this.http.get<Enrollment[]>(url, requestOptions);
  
}


}
