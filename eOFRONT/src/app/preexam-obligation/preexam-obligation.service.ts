import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpResponse, HttpClient } from '@angular/common/http';
import { PreexamObligation } from '../model/preexam-obligation';


@Injectable()
export class PreexamObligationService {

  private path="api/preexamObligation"

  constructor(private http: HttpClient) { }

    private RegenerateData = new Subject<void>();

    RegenerateData$ = this.RegenerateData.asObservable();

    announceChange() {
        this.RegenerateData.next();
    }
    getAllPreexamObligations(): Observable<HttpResponse<PreexamObligation[]>> {
  
        return this.http.get<PreexamObligation[]>(this.path, {observe: 'response'});
    }
   

}
