import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { AuthenticationService } from '../login/authentication.service';
import { Payment } from '../model/payment';

const baseUrl = "https://localhost:8443/api/payments"; 

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  private paymentUrl = "api/payment";

  constructor(private http: HttpClient, private authService: AuthenticationService) { }

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

  private RegenerateData = new Subject<void>();

  RegenerateData$ = this.RegenerateData.asObservable();

  announceChange(){
    this.RegenerateData.next();
  }

  getPayments() : Observable<HttpResponse<Payment[]>> {
    return this.http.get<Payment[]>(this.paymentUrl, {observe: 'response'});
  }

  getPayment(id: number) : Observable<HttpResponse<Payment>> {
    const url = `${this.paymentUrl}/${id}`;
    return this.http.get<Payment>(url, {observe: 'response'});
  }

  addPayment(payment: Payment) : Observable<HttpResponse<Payment>> {
    return this.http.post<Payment>(this.paymentUrl, payment, {observe: 'response'});
  }

  editPayment(payment: Payment) : Observable<HttpResponse<Payment>> {
    return this.http.put<Payment>(this.paymentUrl, payment, {observe: 'response'});
  }

  deletePayment(id: number) : Observable<HttpResponse<Payment>> {
    const url = `${this.paymentUrl}/${id}`;
    return this.http.delete<any>(url, {observe: 'response'});
  }
}
