import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpResponse, HttpClient, HttpHeaders } from '@angular/common/http';
import { PreexamObligation } from '../model/preexam-obligation';
import { AuthenticationService } from '../login/authentication.service';

const baseUrl = "https://localhost:8443/api/preexamObligations"; 

@Injectable({
  providedIn:'root'
})
export class PreexamObligationService {

  private path="api/preexamObligation";

  constructor(private http: HttpClient, private authService: AuthenticationService) { }

  //Elena
  ///////////////////////////////////////////////////////////
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
