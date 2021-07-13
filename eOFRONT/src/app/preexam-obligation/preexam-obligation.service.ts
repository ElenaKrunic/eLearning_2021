import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpResponse, HttpClient } from '@angular/common/http';
import { PreexamObligation } from '../model/preexam-obligation';

const baseUrl = "https://localhost:8443/api/preexamObligations"; 

@Injectable({
  providedIn:'root'
})
export class PreexamObligationService {

  private path="api/preexamObligation";

  constructor(private http: HttpClient) { }

  //Elena
  ///////////////////////////////////////////////////////////
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

  ///////////////////////////////////////////////////////////

    private RegenerateData = new Subject<void>();

    RegenerateData$ = this.RegenerateData.asObservable();

    announceChange() {
        this.RegenerateData.next();
    }

    getPreexamObligation(id: number) : Observable<HttpResponse<PreexamObligation>> {
        const url = `${this.path}/${id}`;
        return this.http.get<PreexamObligation>(url, {observe: 'response'});
    }

    getAllPreexamObligations(): Observable<HttpResponse<PreexamObligation[]>> {
        return this.http.get<PreexamObligation[]>(this.path, {observe: 'response'});
    }
   
    addPreexamObligation(preexamObligation: PreexamObligation) : Observable<HttpResponse<PreexamObligation>> {
        return this.http.post<PreexamObligation>(this.path, preexamObligation, {observe: 'response'});
    }

    editPreexamObligation(preexamObligation: PreexamObligation) : Observable<HttpResponse<PreexamObligation>> {
        return this.http.put<PreexamObligation>(this.path, preexamObligation, {observe: 'response'});
    }

    deletePreexamObligation(id: number) : Observable<HttpResponse<any>> {
        const url = `${this.path}/${id}`;
        return this.http.delete<any>(url, {observe: 'response'})
    }

}
