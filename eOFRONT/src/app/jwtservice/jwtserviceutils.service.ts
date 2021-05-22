import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class JwtserviceutilsService {

  constructor() { }

  getRoles(token:string){
    let jwtData=token.split('.')[1];
    let decodedJWTJsonData=window.atob(jwtData);
    let decodedJWTData=JSON.parse(decodedJWTJsonData);

    return [decodedJWTData.roles.split(':')[1]];

  }
}
