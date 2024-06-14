import { Component } from '@angular/core';
import { AsistenciaService } from '../../../services/asistencia.service';

@Component({
  selector: 'app-index-area',
  templateUrl: './index-area.component.html',
  styleUrl: './index-area.component.css'
})
export class IndexAreaComponent {

  public token=localStorage.getItem('token')
  public id=localStorage.getItem('userID')
  public loadData=true
public modalidad:any;
mostrarMotivos:boolean=false; 
public asistencia:any={}
asistencias:Array<any>=[]
public materias:Array<any>=[]
public page=1
public pageSize=3
    
constructor(
  private asistenciaService:AsistenciaService,
){ }

ngOnInit(): void {

  this.getMateriaCercana()  

  
}



getMateriaCercana(){
  this.asistenciaService.getMateriaCercanas(this.id,this.token).subscribe(
    response=>{
     console.log(response)
      this.materias=response
      this.loadData=false
    },
    error=>{
      console.log(error)
    }
  )
}

setAsistencia(item:any){
  this.asistencia.nro_registro=this.id
  this.asistencia.id_horario=item.id_horario
  this.asistencia.id_grupo=item.id_grupo
  this.asistencia.cod_materia=item.cod_materia
  this.asistencia.modalidad='Presencial'
  


  console.log(this.asistencia)
  this.asistenciaService.marcarAsistencia(this.asistencia,this.token).subscribe(
    response=>{
      console.log(response)
    },
    error=>{
      console.log(error)
    }
  )
}
marcarAsistencia(){
     console.log(this.asistencia)
  }
}