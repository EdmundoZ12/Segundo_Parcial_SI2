import { Component } from '@angular/core';
import { CarreraService } from '../../../services/carrera.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-materia-carrera',
  templateUrl: './materia-carrera.component.html',
  styleUrl: './materia-carrera.component.css'
})
export class MateriaCarreraComponent {
  public token = localStorage.getItem('token');
  public carrera: any = {};

  public id=''
  public materias: Array<any> = [];
  public page=1
  public pageSize=8
  public btn_state_load=false
  public load_data=true

  constructor(
    private _carreraService:CarreraService,
    private _route:ActivatedRoute,
    private _router:Router
  ) { }

  ngOnInit(){
    this._route.params.subscribe(params=>{
      this.id=params['id']
      this.cargarCarrera()
    this.cargarMaterias()
    })
    
    
  }

  cargarCarrera(){
    this._carreraService.getCarrera(this.id,this.token).subscribe(
      response=>{
        this.carrera=response
        console.log(this.carrera)
      },
      error=>{
        console.log(error)
      }
    )
  }

  cargarMaterias(){
    this._carreraService.getMateriasPorCarrera(this.id,this.token).subscribe(
      response=>{
        this.materias=response
       this.load_data=false
      },
      error=>{
        console.log(error)
      }
    )
  }


}
