import { Component } from '@angular/core';
import { ModuloService } from '../../../services/modulo.service';

@Component({
  selector: 'app-create-modulo',
  templateUrl: './create-modulo.component.html',
  styleUrl: './create-modulo.component.css'
})
export class CreateModuloComponent {

  public modulo:any={
    nombre:'',
    ubicacion:''
  }
  public token=localStorage.getItem('token')
  public btn_load=false
  public aula=''
  public aulas: Array<any>=[]


  constructor(
    private _moduloService:ModuloService
  ) { }

  ngOnInit(): void {
    this.initData()
  }

  initData(){
   
  }

  registrar (){
    this._moduloService.createModulo(this.modulo,this.token).subscribe(
      response=>{
        console.log(response)
        this.btn_load=false
        for(const item of this.aulas){
          let data={
            nro:parseInt(item),
            id_modulo:response.id
          }
          this._moduloService.createAula(data,this.token).subscribe(
            response=>{
              console.log(response)
            },
            error=>{
              console.log(error)
            }
          )
        }
          
      },
      error=>{
        console.log(error)
        this.btn_load=false
      }
    )
  }





  add(){
    if(this.aula){
      this.aulas.push(this.aula.trim())
      this.aula=''
    }
}


  remove(idx:any){
    this.aulas.splice(idx,1)
  }
}
