import { Component } from '@angular/core';
import { MateriaService } from '../../../services/materia.service';
import { Router } from '@angular/router';
import { response } from 'express';

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
      response => {
        console.log(response)
      },
      error => {
        console.log(error)
        this.btn_load = false;
        toastr.success('Materia registrada exitosamente', 'Materia Registrada');
          this._router.navigate(['/materia']);
      }
    )
  }
    
}
