import { Component } from '@angular/core';
import { ModuloService } from '../../../services/modulo.service';

@Component({
  selector: 'app-index-modulo',
  templateUrl: './index-modulo.component.html',
  styleUrl: './index-modulo.component.css'
})
export class IndexModuloComponent {

  public load_data = true;
  
  public page=1
  public pageSize=8
  public token = localStorage.getItem('token');
  public modulos:Array<any> = []

  constructor(
    private _moduloService:ModuloService
  ) { }

  ngOnInit(): void {
    this.initData()
  }

  initData(){
    this._moduloService.getModulo(this.token).subscribe(
      response=>{
        this.load_data = false;
        console.log(response)
        this.modulos = response
      },
      error=>{
        console.log(error)
      }
    )
  }

}
