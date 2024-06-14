import { Injectable } from '@angular/core';
import { GLOBAL } from './GLOBAL';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AsistenciaService {

  public url=GLOBAL.url
  constructor(
    private  _http: HttpClient
  ) {}


  
  getCarreras(token:any):Observable<any>{
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.get(this.url+'/api/carrera',{headers:headers})
  }


  getMateriaCercanas(id:any,token:any):Observable<any>{
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.get(this.url+'/api/docente-materia/horarios/'+id,{headers:headers})
  }

  marcarAsistencia(asistencia:any,token:any):Observable<any>{
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.post(this.url+'/api/asistencia/create',asistencia,{headers:headers})
  }

  obtenerAsistencias(id:any,token:any):Observable<any>{
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.get(this.url+'/api/docente-materia/asistencias/'+id,{headers:headers})
  }

  obtenerRetrasos(id:any,token:any):Observable<any>{
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.get(this.url+'/api/docente-materia/retrasos/'+id,{headers:headers})
  }

  obtenerFaltas(id:any,token:any):Observable<any>{
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.get(this.url+'/api/docente-materia/faltas/'+id,{headers:headers})
  }

  obtenerLicencias(id:any,token:any):Observable<any>{
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.get(this.url+'/api/docente-materia/licencias/'+id,{headers:headers})
  }

  solicitarLicencia(licencia:any,token:any):Observable<any>{
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this._http.post(this.url+'/api/asistencia/create/licencia',licencia,{headers:headers})
  }
 
}
