import { Injectable } from '@angular/core';

import { HttpResponse, HttpClient } from '@angular/common/http';
import {Observable, Subject} from 'rxjs';
import { FinancialCard } from '../model/financial-card';


@Injectable({
  providedIn: 'root'
})
export class FinancialcardService {

  private financialCardUrl = "api/financialCard";
  
  constructor(private http: HttpClient) { }

  private RegenerateData = new Subject<void>();

  RegenerateData$ = this.RegenerateData.asObservable();

  announceChange() {
      this.RegenerateData.next();
  }

  getFinancialCards() : Observable<HttpResponse<FinancialCard[]>> {
    return this.http.get<FinancialCard[]>(this.financialCardUrl, {observe: 'response'});
  }

  getFinancialCard(id: number) : Observable<HttpResponse<FinancialCard>> {
    const url = `${this.financialCardUrl}/{$id}`;
    return this.http.get<FinancialCard>(url, {observe: 'response'});
  }

  addFinancialCard(financialCard: FinancialCard) : Observable<HttpResponse<FinancialCard>> {
    return this.http.post<FinancialCard>(this.financialCardUrl, financialCard, {observe: 'response'});
  }

  editFinancialCard(financialCard: FinancialCard) : Observable<HttpResponse<FinancialCard>> {
    return this.http.put<FinancialCard>(this.financialCardUrl, financialCard, {observe: 'response'});
  }

  deleteFinancialCard(id: number) : Observable<HttpResponse<any>> {
    const url = `${this.financialCardUrl}/${id}`;
    return this.http.delete<any>(url, {observe: 'response'});
  }
}
