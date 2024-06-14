import { Component } from '@angular/core';
import { UsuarioService } from '../../../services/usuario.service';
import { ActivatedRoute } from '@angular/router';
import { MateriaService } from '../../../services/materia.service';
import e, { response } from 'express';

@Component({
  selector: 'app-var-materia-docente',
  templateUrl: './var-materia-docente.component.html',
  styleUrl: './var-materia-docente.component.css'
})
export class VarMateriaDocenteComponent {

  public token = localStorage.getItem('token');
  public id=localStorage.getItem('userID');
  public docente:any={}
  public materias: Array<any> = [];
  public page=1
  public pageSize=8
  public btn_state_load=false
  public load_data=true
  public cod:any
  public idGrupo:any
  public horarios:Array<any>=[]
  
  constructor(
    private usuarioService: UsuarioService,
    private route:ActivatedRoute,
    private materiaService:MateriaService
  ){}

  ngOnInit(){
    this.getDocente()
    this.getDocenteMateria()
  }

  getDocente(){
    this.usuarioService.getUsuario(this.id, this.token).subscribe(
      (response) => {
        this.docente = response;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  getDocenteMateria() {
    this.usuarioService.obtenerDocenteMateria(this.id, this.token).subscribe(
      (response) => {
    
        this.materias = response;
        console.log(this.materias)
        this.load_data=false
      },
      (error) => {
        console.log(error);
      }
    );
  }

  setItem(item:any){
    console.log(item)
    this.cod=item.cod_materia
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
