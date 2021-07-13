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
import { localizedString } from '@angular/compiler/src/output/output_ast';

const baseUrl = "https://localhost:8443/api/students"; 

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  id: any;
  studentId:any;

  constructor(private http: HttpClient,private authService:AuthenticationService) {
    
   }
  
  private RegenerateData = new Subject<void>();

  RegenerateData$ = this.RegenerateData.asObservable();
  
  announceChange() {
      this.RegenerateData.next();
  }

  //Elena
  //////////////////////////////////////////////////////////

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

 //////////////////////////////////////////////////////////////


  getStudents(): Observable<HttpResponse<Student[]>> {
      return this.http.get<Student[]>(baseUrl, {observe: 'response'});
    }

  getStudent(id:number): Observable<HttpResponse<Student>> {
      const url = `${baseUrl}/${id}`;
      return this.http.get<Student>(url, {observe: 'response'});
    }

  addStudent(student: Student): Observable<HttpResponse<Student>> {
      return this.http.post<Student>(baseUrl, student, {observe: 'response'});
    }

  editStudent(student: Student): Observable<HttpResponse<Student>> {
      return this.http.put<Student>(baseUrl, student, {observe: 'response'});
    }

  deleteStudent(id: number): Observable<HttpResponse<any>> {
      const url = `${baseUrl}/${id}`;
      return this.http.delete<any>(url, {observe: 'response'});
    }

    getStudentsExams(studentId:number): Observable<Exam[]> {

            const headInfo={
              'Content - Type': 'application/json',
              'X-Auth-Token':"" + this.authService.getToken(),
                  }
            const requestOptions={
              headers:new HttpHeaders(headInfo)
            }

        const url=`${baseUrl}/${studentId}/exams`;
        return this.http.get<Exam[]>(url, requestOptions);
    }
    
    getStudentMe(): Observable<Student> {

    
        const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    
        return this.http.get<Student>(baseUrl + "/me", {headers: headers});
      
 
}

   getStudentFinancialCard(studentId:number): Observable<FinancialCard> {
             const headInfo={
        'Content - Type': 'application/json',
        'X-Auth-Token':"" + this.authService.getToken(),
            }
            const requestOptions={
              headers:new HttpHeaders(headInfo)
            }
        const url = `${baseUrl}/${studentId}/financial-card`;
        return this.http.get<FinancialCard>(url,requestOptions);

    }
    getStudentPayment(studentId:number): Observable<Payment[]> {
            const headInfo={
              'Content - Type': 'application/json',
              'X-Auth-Token':"" + this.authService.getToken(),
                  }
            const requestOptions={
              headers:new HttpHeaders(headInfo)
            }
      const url = `${baseUrl}/${studentId}/payment`;
      return this.http.get<Payment[]>(url, requestOptions);
      
  }

  getStudentPayout(studentId:number): Observable<Payout[]> {
    const headInfo={
      'Content - Type': 'application/json',
      'X-Auth-Token':"" + this.authService.getToken(),
          }
          const requestOptions={
            headers:new HttpHeaders(headInfo)
          }
    const url = `${baseUrl}/${studentId}/payout`;
    return this.http.get<Payout[]>(url, requestOptions);  
 }

getStudentDocument(studentId:number): Observable<Document[]> {
  const headInfo={
    'Content - Type': 'application/json',
    'X-Auth-Token':"" + this.authService.getToken(),
        }
        const requestOptions={
          headers:new HttpHeaders(headInfo)
        }
  const url = `${baseUrl}/${studentId}/document`;
  return this.http.get<Document[]>(url, requestOptions);
  
}
getStudentEnrollment(studentId:number): Observable<Enrollment[]> {
  const headInfo={
    'Content - Type': 'application/json',
    'X-Auth-Token':"" + this.authService.getToken(),
        }
        const requestOptions={
          headers:new HttpHeaders(headInfo)
        }
  const url = `${baseUrl}/${studentId}/enrollment`;
  return this.http.get<Enrollment[]>(url, requestOptions);
  
}


}
