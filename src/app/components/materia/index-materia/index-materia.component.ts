import { Component } from '@angular/core';
import { MateriaService } from '../../../services/materia.service';
declare var toastr:any;
@Component({
  selector: 'app-index-materia',
  templateUrl: './index-materia.component.html',
  styleUrl: './index-materia.component.css'
})
export class IndexMateriaComponent {
  public token = localStorage.getItem('token');
  


  public materias: Array<any> = [];
  public page=1
  public pageSize=8
  public btn_state_load=false
  public load_data=true


  constructor(
    private _materiaService: MateriaService
  ) { }



  ngOnInit() {
    this.getMaterias();
  }

  getMaterias() {
    this._materiaService.getMaterias(this.token).subscribe(
      response => {
       this.materias=response
       this.load_data=false
      },
      error => {

        console.log(error);
      }
    );
  }

}
