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

  createMateria(data: any, token: any): Observable<any> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.post(this.url + '/api/materia/create', data, { headers: headers });
  }

  getMaterias(token: any): Observable<any> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.get(this.url + '/api/materia', { headers: headers });
  }

  createHorario(data: any, token: any): Observable<any> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.post(this.url + '/api/horario/create', data, { headers: headers });
  }
  getMateriaGrupo(token: any): Observable<any> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.get(this.url + '/api/materia/grupos', { headers: headers });
  }

  obtenerHorarioGrupo(cod: any,idGrupo:any, token: any): Observable<any> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.get(this.url + `/api/horario/materia/${cod}/grupo/${idGrupo}`, { headers: headers });
  }
}
