import { Component } from '@angular/core';
import { MateriaService } from '../../../services/materia.service';

@Component({
  selector: 'app-index-grupo',
  templateUrl: './index-grupo.component.html',
  styleUrl: './index-grupo.component.css'
})
export class IndexGrupoComponent {

  public load_data = true;
  public page=1
  public pageSize=6
  public token = localStorage.getItem('token');
  public grupos:Array<any> = []

  constructor(
    private grupoService: MateriaService
  ){}

  ngOnInit(): void {
    this.getGrupos()
  }

  getGrupos(){
    this.grupoService.getGrupos(this.token).subscribe(
      response => {
        this.load_data = false
        this.grupos = response
      },
      error => {
        console.log(error)
      }
    )
  }


}
