import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Payment } from '../model/payment';

const baseUrl = "https://localhost:8443/api/payments"; 

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  private paymentUrl = "api/payment";

  constructor(private http: HttpClient) { }

  /*
  getAll(): Observable<any> {
    return this.http.get(baseUrl); 
  }
  */
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

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
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
