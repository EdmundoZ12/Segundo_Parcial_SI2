import { Component } from '@angular/core';
import { CarreraService } from '../../../services/carrera.service';
import { Router } from '@angular/router';
declare var toastr:any
@Component({
  selector: 'app-create-carrera',
  templateUrl: './create-carrera.component.html',
  styleUrl: './create-carrera.component.css'
})
export class CreateCarreraComponent {
  public carrera:any={
    
  }

  public token=localStorage.getItem('token')
  public btn_load=false
  public tipoCarreras: Array<any>=[]
  public modalidades: Array<any>=[]
  constructor(
    private carreraService: CarreraService,
    private router: Router
    
  ){}

  ngOnInit(){
    
    this.getTipoCarreras()
    this.getModalidades()
  
  }

  getTipoCarreras(){
    this.carreraService.getTipoCarreras(this.token).subscribe(
      response=>{
        this.tipoCarreras=response
      
      },
      error=>{
        console.log(error)
      }
    )
  }

  getModalidades(){
    this.carreraService.getModalidades(this.token).subscribe(
      response=>{
       console.log(response)
        this.modalidades=response
      },
      error=>{
        console.log(error)
      }
    )
  }
  



  registrar(){

    this.btn_load=true
    this.carrera.id_tcarrera=parseInt(this.carrera.id_tcarrera)
    this.carrera.id_modalidad=parseInt(this.carrera.id_modalidad)
    this.carreraService.createCarrera(this.carrera,this.token).subscribe(
      response=>{
        this.btn_load=false
        console.log(response)
      },
      error=>{
        this.btn_load=false
        console.log(error)
        toastr.success('Carrera creada con exito')
        this.router.navigate(['/carrera'])
      }
    )

  }
}
