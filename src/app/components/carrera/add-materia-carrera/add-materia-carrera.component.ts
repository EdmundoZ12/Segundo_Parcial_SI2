import { Component } from '@angular/core';
import { MateriaService } from '../../../services/materia.service';
import { CarreraService } from '../../../services/carrera.service';
import { ActivatedRoute, Router } from '@angular/router';
declare var toastr:any;
@Component({
  selector: 'app-add-materia-carrera',
  templateUrl: './add-materia-carrera.component.html',
  styleUrl: './add-materia-carrera.component.css'
})
export class AddMateriaCarreraComponent {
  public id=''
  public token = localStorage.getItem('token');
  public materias: Array<any> = [];
  public  materia: any = {};
  public materiaData:Array<any> = [];
  public btn_load=false
  public materiaAdd:any = {};

  constructor(
    private materiaService: MateriaService,
    private carreraService: CarreraService,
    private route:ActivatedRoute,
    private router: Router

  ) { }

  ngOnInit(){
    this.route.params.subscribe(params => {
      this.id = params['id'];
      console.log(this.id);
    });
    this.cargarMaterias();
   
  }

  cargarMaterias(){
    this.materiaService.getMaterias(this.token).subscribe(
      response => {
        this.materiaData = response

      },
      error => {
        console.log(error);
      }
    );
  }

  registrar(){
    this.btn_load=true;
    this.materiaAdd.cod_carrera = this.id;
    this.materiaAdd.materias = this.materias;
    console.log(this.materiaAdd);
    this.carreraService.añadirMaterias(this.materiaAdd,this.token).subscribe(
      response => {
        
        this.router.navigate(['/carrera/materia/'+this.id]);
      },
      error => {
        console.log(error);
        toastr.success('Materias agredas exitosamente', 'Materias Agregadas');
        this.router.navigate(['/carrera/materia/'+this.id]);
      }
    );
  }

  add(){

    if(this.materia){
      this.materias.push(this.materia);
      this.materia = {};
 
    }
  }

  remove(idx:any){
    this.materias.splice(idx,1);

  }

}
