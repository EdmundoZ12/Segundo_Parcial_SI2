import { Component } from '@angular/core';
import { ModuloService } from '../../../services/modulo.service';
import { MateriaService } from '../../../services/materia.service';

@Component({
  selector: 'app-create-horario',
  templateUrl: './create-horario.component.html',
  styleUrl: './create-horario.component.css'
})
export class CreateHorarioComponent {
  public horarioCreate:any = {
   

  }
  public aulas:any = []
  public materias:any = []
  public grupos:any = []
  public horario:any = {}
  public btn_load=true
  public horarios:any = {
    id_aula: 0,
    dia: '',
    hora_inicio: '',
    hora_fin: ''
  }
  public horariosA:any = []
  constructor(
    private moduloService:ModuloService,
    private materiaService: MateriaService
  ){ }

  ngOnInit(): void {



  }

  cargarAulas(){}



  registrar(){}


  add(){}

  remove(idx:any){}
}
