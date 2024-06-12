import { Component } from '@angular/core';
import { MateriaService } from '../../../services/materia.service';
import { Router } from '@angular/router';

declare var toastr:any;

@Component({
  selector: 'app-create-materia',
  templateUrl: './create-materia.component.html',
  styleUrl: './create-materia.component.css'
})
export class CreateMateriaComponent {
  
  token = localStorage.getItem('token');
  public btn_load=false;
  materia:any = {}
  constructor(
    private _materiaService: MateriaService,
    private _router: Router
  ){}
  
  registrarMateria(){
    this.btn_load = true;
    this._materiaService.createMateria(this.materia, this.token).subscribe(
      error => {
        console.log(error);
        if(error.status == 200){
          toastr.success('Materia creada correctamente')
          this._router.navigate(['/materia']);

        }
      }
    )
  }
    
}
