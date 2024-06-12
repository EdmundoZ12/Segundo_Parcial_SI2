import { Component } from '@angular/core';
import { MateriaService } from '../../../services/materia.service';
import { Router } from '@angular/router';
declare var toastr:any
@Component({
  selector: 'app-create-grupo',
  templateUrl: './create-grupo.component.html',
  styleUrl: './create-grupo.component.css'
})
export class CreateGrupoComponent {
  public grupo:any={
 
  }
  public token=localStorage.getItem('token')
  public btn_load=false
 
  constructor(
    private grupoService: MateriaService,
    private router: Router
  ){}



  registrar(){
    this.btn_load=true
    this.grupoService.createGrupo(this.grupo,this.token).subscribe(
      response => {
        this.btn_load=false
        toastr.success('Grupo creado correctamente')
        console.log(response)
      },
      error => {
        this.btn_load=false
        toastr.success('Grupo creado correctamente')
        this.router.navigate(['/grupo'])
        console.log(error)
      }
    )


  }


}
