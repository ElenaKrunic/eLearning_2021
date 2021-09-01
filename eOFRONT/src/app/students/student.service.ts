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
import { PreexamObligation } from '../model/preexam-obligation';

const baseUrl = "https://localhost:8443/api/student/students"; 
const baseUrl1="https://localhost:8443/api/student";
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
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    return this.http.get<any>(baseUrl, { params , headers:headers});
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

    getStudentsExams(student:Student): Observable<Exam[]> {

      const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    
      const url = `${baseUrl1}/${student.id}/exams`;
      return this.http.get<Exam[]>(url,{ headers:headers});
      
    }
    
    getStudentMe(): Observable<Student> {

    
        const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    
        return this.http.get<Student>(baseUrl1 + "/students/me", {headers: headers});
      
 
}
getMeAgain(): Observable<Student> {

    
  const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});

  return this.http.get<Student>(baseUrl1+"/students" + "/me", {headers: headers});


}

   getStudentFinancialCard(student:Student): Observable<FinancialCard> {
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    
    const url = `${baseUrl1}/${student.id}/financial-card`;
    return this.http.get<FinancialCard>(url,{ headers:headers});
    
    }
    getStudentPayment(student:Student): Observable<Payment[]> {
      const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    
      const url = `${baseUrl1}/${student.id}/financial-payment`;
      return this.http.get<Payment[]>(url,{ headers:headers});
      
  }

  getStudentPayout(student:Student): Observable<Payout[]> {
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    
    const url = `${baseUrl1}/${student.id}/financial-payout`;
    return this.http.get<Payout[]>(url,{ headers:headers});
      
 }
 getStudentPreexamObligation(student:Student,examid:number): Observable<PreexamObligation[]> {
  const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
  
  const url = `${baseUrl1}/${student.id}/preexamObligations/${examid}`;
  return this.http.get<PreexamObligation[]>(url,{ headers:headers});
    
}

getStudentDocument(student:Student): Observable<Document[]> {
  
  const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    
  const url = `${baseUrl1}/${student.id}/documents`;
  return this.http.get<Document[]>(url,{ headers:headers});
  
}
getStudentEnrollment(student:Student): Observable<Enrollment[]> {
  const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    
  const url = `${baseUrl1}/${student.id}/enrollments`;
  return this.http.get<Enrollment[]>(url,{ headers:headers});
 
}
registerExam(student:Student,examId:number): Observable<any> {
  const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    
  const url = `${baseUrl1}/${student.id}/register-exam/${examId}`;
  return this.http.post<any>(url,{ headers:headers});
 
}


}
