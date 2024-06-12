import { Component } from '@angular/core';
import { CarreraService } from '../../../services/carrera.service';

@Component({
  selector: 'app-index-carrera',
  templateUrl: './index-carrera.component.html',
  styleUrl: './index-carrera.component.css'
})
export class IndexCarreraComponent {

  public token = localStorage.getItem('token');
  


  public carreras: Array<any> = [];
  public page=1
  public pageSize=8
  public btn_state_load=false
  public load_data=true

  constructor(
    private _carreraService:CarreraService,
    
  ) { }


  ngOnInit(): void {
    this.getCarreras()
  }

  getCarreras(){
    this._carreraService.getCarreras(this.token).subscribe(
      response=>{
      this.carreras=response
      console.log(this.carreras.length)
      this.load_data=false
      },
      error=>{
        console.log(error)
      }
    )
  }

}
