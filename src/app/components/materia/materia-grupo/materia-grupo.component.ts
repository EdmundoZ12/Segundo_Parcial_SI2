import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MateriaService } from '../../../services/materia.service';

@Component({
  selector: 'app-materia-grupo',
  templateUrl: './materia-grupo.component.html',
  styleUrl: './materia-grupo.component.css'
})
export class MateriaGrupoComponent {

  public token = localStorage.getItem('token');
  public page=1
  public cod=''
  public pageSize=8
  public btn_state_load=false
  public load_data=true
  public materias: Array<any> = [];
  public horarios:Array<any>=[]
  public ArrMaterias:Array<any>=[]
  public idGrupo:any
  constructor(
    private route:ActivatedRoute,
    private materiaService:MateriaService
  ){}

  ngOnInit(){
      this.route.params.subscribe(params => {
        this.cod = params['id'];
       console.log(this.cod)

      })
      this.cargarMaterias()
  }

  cargarMaterias(){
    this.materiaService.getMateriaGrupo(this.token).subscribe(
      (response) => {
        this.ArrMaterias = response;
        console.log(this.ArrMaterias)
        this.ArrMaterias.forEach((item:any) => {
          if(item.cod_materia==this.cod){
            this.materias.push(item)
          }
        });
        
        this.load_data=false
      },
      (error) => {
        console.log(error);
      }
    );
  }

  setItem(item:any){
   
    console.log(item)
    this.idGrupo=item.id_grupo
    this.materiaService.obtenerHorarioGrupo(this.cod,this.idGrupo, this.token).subscribe(
      response=>{
        console.log(response)
        this.horarios=response
      },error=>{
        console.log(error)
      })
  }
  

}
