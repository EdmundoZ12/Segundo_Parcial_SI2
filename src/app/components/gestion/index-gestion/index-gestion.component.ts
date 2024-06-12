import { Component } from '@angular/core';
import { GestionService } from '../../../services/gestion.service';

@Component({
  selector: 'app-index-gestion',
  templateUrl: './index-gestion.component.html',
  styleUrl: './index-gestion.component.css'
})
export class IndexGestionComponent {
  public token = localStorage.getItem('token');
  


  public gestiones: Array<any> = [];
  public page=1
  public pageSize=3
  public btn_state_load=false
  public load_data=true

  constructor(
    private gestionService:GestionService,
    
  ) { }

  ngOnInit(): void {
    this.getGestiones()
    
  }

  getGestiones(){
    this.gestionService.getGestiones(this.token).subscribe(
      response=>{
        this.gestiones=response
        this.load_data=false
        console.log(this.gestiones)
      },
      error=>{
        console.log(error)
      }
    )
  }



}
