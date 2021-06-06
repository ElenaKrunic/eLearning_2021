import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Payment } from '../model/payment';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  private paymentUrl = "api/payment";

  constructor(private http: HttpClient) { }

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
