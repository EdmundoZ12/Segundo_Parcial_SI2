import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GLOBAL } from './GLOBAL';
import { JwtHelperService } from '@auth0/angular-jwt';


@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  public url=GLOBAL.url
  constructor(
    private  _http: HttpClient
  ) {}

  

  getUsuarios(token:any):Observable<any>{
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.get(this.url+'/api/usuario',{headers:headers})
  }

  login(data:any):Observable<any>{
    let headers= new HttpHeaders().set('Content-Type','application/json')
    return this._http.post(this.url+'/auth/login',data,{headers:headers})
  }

  createUsuario(data:any,token:any):Observable<any>{
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.post(this.url+'/api/usuario/create',data,{headers:headers})
  }
  
  
  getRol(token:any):Observable<any>{
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.get(this.url+'/api/rol',{headers:headers})
  }


  
  
  
  
}
