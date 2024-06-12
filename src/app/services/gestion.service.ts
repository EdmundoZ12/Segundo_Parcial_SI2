import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GLOBAL } from './GLOBAL';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GestionService {

  public url=GLOBAL.url
  constructor(
    private  _http: HttpClient
  ) {}


  getGestiones(token:any):Observable<any>{
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.get(this.url+'/api/gestion',{headers:headers})
  }

  createGestion(data:any,token:any):Observable<any>{
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.post(this.url+'/api/gestion/create',data,{headers:headers})
  }

  getTipoPerido(token:any):Observable<any>{
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.get(this.url+'/api/tipo-periodo',{headers:headers})
  }
  

}
