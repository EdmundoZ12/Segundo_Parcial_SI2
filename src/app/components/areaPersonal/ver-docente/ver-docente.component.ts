import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AsistenciaService } from '../../../services/asistencia.service';

@Component({
  selector: 'app-ver-docente',
  templateUrl: './ver-docente.component.html',
  styleUrl: './ver-docente.component.css'
})
export class VerDocenteComponent {

  public load_data=true
  public datos : Array<any> = []
  public categorias_const : Array<any> = []
  public filtro=''
  public page=1
  public pageSize=10
  public btn_state_load=false
  public token = localStorage.getItem('token');
  public userID=localStorage.getItem('userID')
  public active='Asistencias'


    constructor(
    private _router:Router,
    private route:ActivatedRoute,
    private _asistenciaService:AsistenciaService
    ){}

    ngOnInit(){
      this.route.params.subscribe(
        params=>{
          if(params['tipo']){
            this.active= params['tipo']
           this.initData()
          }else{
              this._router.navigate(['/verAsistencias',this.active])
          }
        }
      )
     
    }


    initData(){
      if(this.active=='Asistencias'){
        this._asistenciaService.obtenerAsistencias(this.userID,this.token).subscribe(
          response=>{
          
            this.datos=response
            console.log(this.datos)
            this.load_data=false
          },
          error=>{
            console.log(<any>error)
          }
        )
      }else if(this.active=='Retrasos'){
        this._asistenciaService.obtenerRetrasos(this.userID,this.token).subscribe(
          response=>{
          
            this.datos=response
            console.log(this.datos)
            this.load_data=false
          },
          error=>{
            console.log(<any>error)
          }
        
        )}else if(this.active=='Faltas'){
          this._asistenciaService.obtenerFaltas(this.userID,this.token).subscribe(
            response=>{
            
              this.datos=response
              console.log(this.datos)
              this.load_data=false
            },
            error=>{
              console.log(<any>error)
            }
          )}else if(this.active=='Licencias'){
            this._asistenciaService.obtenerLicencias(this.userID,this.token).subscribe(
              response=>{
              
                this.datos=response
                console.log(this.datos)
                this.load_data=false
              },
              error=>{
                console.log(<any>error)
              }
            )
          }
    }


   
  setClasificacion(value:any){
    this.active=value
    this._router.navigate(['/verAsistencias',this.active])
  }
}
