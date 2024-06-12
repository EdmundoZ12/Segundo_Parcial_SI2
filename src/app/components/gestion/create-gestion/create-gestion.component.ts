import { Component } from '@angular/core';
import { GestionService } from '../../../services/gestion.service';
import { Router } from '@angular/router';

declare var toastr:any

@Component({
  selector: 'app-create-gestion',
  templateUrl: './create-gestion.component.html',
  styleUrl: './create-gestion.component.css'
})
export class CreateGestionComponent {

  public gestion:any={}

  public token=localStorage.getItem('token')
  public btn_load=false
  public tipoGestion: Array<any>=[]
  
  
  constructor(
    
    private gestionService: GestionService,
    private router: Router
    
  ){}

  ngOnInit(): void {
    this.cargarTipoPeriodo()
  }

  cargarTipoPeriodo(){
    this.gestionService.getTipoPerido(this.token).subscribe(
      response=>{
        this.tipoGestion=response
      },
      error=>{
        console.log(error)
      }
    )
  }


  registrar(){
    this.btn_load=true
    this.gestionService.createGestion(this.gestion,this.token).subscribe(
      response=>{
        toastr.success('Gestion creada correctamente')
        this.btn_load=false
        this.router.navigate(['/gestion'])
      },
      error=>{
        console.log(error)
        this.btn_load=false
        toastr.success('Gestion creada correctamente')
        this.router.navigate(['/gestion'])
      }
    )
  }

}
