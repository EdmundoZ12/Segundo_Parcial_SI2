import { Component } from '@angular/core';
import { UsuarioService } from '../../../services/usuario.service';
import { MateriaService } from '../../../services/materia.service';
import { GestionService } from '../../../services/gestion.service';

@Component({
  selector: 'app-materia-docentes',
  templateUrl: './materia-docentes.component.html',
  styleUrl: './materia-docentes.component.css'
})
export class MateriaDocentesComponent {

public token = localStorage.getItem('token'); 
public btn_load=false;
public docentes:Array<any> = []
public gestiones:Array<any> = []
public materias:Array<any> = []
public materia:any = {};
public materiaData:Array<any> = []
public asignacion:any = {}
   
  constructor(
    private usuarioService: UsuarioService,
    private materiaService: MateriaService,
    private gestionService: GestionService,
  ) {}

  ngOnInit(){
    this.cargarUsuarios();
    this.cargarGestiones();
    this.cargarMaterias();
  }

  cargarMaterias(){
    this.materiaService.getMateriaGrupo(this.token).subscribe(
      res => {
        this.materiaData = res;
        console.log(this.materiaData);
      },
      err => console.log(err)
    )  
  }
  cargarUsuarios(){
    this.usuarioService.getUsuarios(this.token).subscribe(
      res => {
        this.docentes = res.filter((usuario: any) => usuario.rol.id === 2);
      
      },
      err => console.log(err)
    )
  }
  cargarGestiones(){
    this.gestionService.getGestiones(this.token).subscribe(
      res => {
        this.gestiones = res;
       
      },
      err => console.log(err)
    )
  }

  add(){
    
      if(this.materia)
      {
         this.materias.push(this.materia);
          this.materia = {id_grupo: '', cod_materia: ''};
          
      }
  }

  remove(idx:any){
    this.materias.splice(idx, 1);
  }

  registrar(){
    this.asignacion.materias = this.materias;
    this.usuarioService.asignarDocenteMateria(this.asignacion, this.token).subscribe(
      res => {
        console.log(res);
      },
      err => console.log(err)
    )
  }




}
