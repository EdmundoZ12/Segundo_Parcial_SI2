import { Component } from '@angular/core';
import { UsuarioService } from '../../../services/usuario.service';
import { AsistenciaService } from '../../../services/asistencia.service';
import { Router } from '@angular/router';

declare var toastr:any;
@Component({
  selector: 'app-licencias',
  templateUrl: './licencias.component.html',
  styleUrl: './licencias.component.css'
})
export class LicenciasComponent {

  public userID=localStorage.getItem('userID');
  public token=localStorage.getItem('token');
  public licencia:any={}
  public btn_load=false;  
  public materias:Array<any>=[]
  public materia:any={}
  constructor(
    private _usuarioService:UsuarioService,
    private asistenciaService:AsistenciaService,
    private router:Router
  ) {}

  ngOnInit(): void {
    this.caragarMaterias()
  }


  caragarMaterias(){
    this._usuarioService.obtenerDocenteMateria(this.userID,this.token).subscribe(
      response=>{
        this.materias=response
        console.log(response)
      },
      error=>{
        console.log(error)
      }
    )
  }
  registrar(){
    this.licencia.nro_registro=this.userID
    this.licencia.id_grupo=this.materia.id_grupo
    this.licencia.cod_materia=this.materia.cod_materia

    this.asistenciaService.solicitarLicencia(this.licencia,this.token).subscribe(
      response=>{
        console.log(response)
        toastr.success('Licencia solicitada correctamente')
        this.licencia={}
      },
      error=>{
        console.log(error)
        toastr.success('Licencia solicitada correctamente')
        this.router.navigate(['/areaPersonal'])
      }
    )

  }

}
