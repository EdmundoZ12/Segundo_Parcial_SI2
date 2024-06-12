import { Injectable } from '@angular/core';
import { GLOBAL } from './GLOBAL';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class MateriaService {

  public url = GLOBAL.url;
  constructor(
    private _http: HttpClient
  ) { }


  getHorarios(token: any): Observable<any> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.get(this.url + '/api/horario', { headers: headers });
  }

  getGrupos(token: any): Observable<any> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.get(this.url + '/api/grupo', { headers: headers });
  }

  createGrupo(data: any, token: any): Observable<any> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.post(this.url + '/api/grupo/create', data, { headers: headers });
  }

}