import { Component } from '@angular/core';
import { ModuloService } from '../../../services/modulo.service';
import { MateriaService } from '../../../services/materia.service';
declare var toastr:any;
@Component({
  selector: 'app-create-horario',
  templateUrl: './create-horario.component.html',
  styleUrl: './create-horario.component.css'
})
export class CreateHorarioComponent {
  public token = localStorage.getItem('token')
  public horarioCreate:any = {
   
  }
  public aulas:any = []
  public modulos:Array<any> = []
  public materias:Array<any> = []
  public grupos:any = []
  public btn_load=false
  public horario:any = {
    id_aula: 0,
    dia: '',
    hora_inicio: '',
    hora_fin: ''
  }

  public moduloID:any = 0 
  public horarios:Array<any> = []
  constructor(
    private moduloService:ModuloService,
    private materiaService: MateriaService
  ){ }

  ngOnInit(): void {
    this.cargarModulos()
    this.cargarMaterias()
    this.cargarGrupos()

  }

  cargarMaterias(){
    this.materiaService.getMaterias(this.token).subscribe(
      response => {
        this.materias = response
       
      },
      error => {
        console.log(error)
      }
    )
  }

  cargarGrupos(){
    this.materiaService.getGrupos(this.token).subscribe(
      response => {
        this.grupos = response
       
      },
      error => {
        console.log(error)
      }
    )
  }


  cargarModulos(){
    this.moduloService.getModulo(this.token).subscribe(
      response => {
        this.modulos = response
       
      },
      error => {
        console.log(error)
      }
    )
  }
  cargarAulas(){
    this.moduloService.obtenerAulas(this.moduloID,this.token).subscribe(
      response => {
        this.aulas = response
        console.log(this.aulas)
      },
      error => {
        console.log(error)
      }
    )
  }



  registrar(){
    this.horarioCreate.horarios = this.horarios
    this.materiaService.createHorario(this.horarioCreate,this.token).subscribe(
      response => {
        console.log(response)
      },
      error => {
        toastr.success('Horario creado exitosamente', 'Horario Creado')
        
        console.log(error)
      }
    )

  }


  add(){
    if(this.horario){
      this.horarios.push(this.horario)
      this.horario={
        id_aula: 0,
        dia: '',
        hora_inicio: '',
        hora_fin: ''
      }
    }
  }

  remove(idx:any){}
}
