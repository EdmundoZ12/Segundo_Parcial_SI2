import { Component } from '@angular/core';
import { ModuloService } from '../../../services/modulo.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-modulo',
  templateUrl: './edit-modulo.component.html',
  styleUrl: './edit-modulo.component.css'
})
export class EditModuloComponent {

  public token = localStorage.getItem('token');
  public aulas: Array<any> = [];
  public page=1
  public pageSize=8
  public btn_state_load=false
  public load_data=true
  public id:any
  constructor(
    private moduloService: ModuloService,
    private route: ActivatedRoute
  ){}


  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id'];
    });
    this.initData()
  }


  initData(){
    this.moduloService.obtenerAulas(this.id,this.token).subscribe(
      response=>{
        this.aulas=response
        this.load_data=false
      },
      error=>{
        console.log(error)
        
      }
    )
  }


}
