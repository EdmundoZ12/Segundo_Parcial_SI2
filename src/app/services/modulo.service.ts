import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GLOBAL } from './GLOBAL';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ModuloService {

  public url=GLOBAL.url
  constructor(
    private  _http: HttpClient
  ) {}


  getModulo(token:any):Observable<any>{
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.get(this.url+'/api/modulo',{headers:headers})
  }

  createModulo(data:any,token:any):Observable<any>{
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.post(this.url+'/api/modulo/create',data,{headers:headers})
  }

  createAula(data:any,token:any):Observable<any>{
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.post(this.url+'/api/aula/create',data,{headers:headers})
  }

  obtenerAulas(id:any,token:any):Observable<any>{
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.get(this.url+'/api/modulo/aulas/'+id,{headers:headers})
  }

}
