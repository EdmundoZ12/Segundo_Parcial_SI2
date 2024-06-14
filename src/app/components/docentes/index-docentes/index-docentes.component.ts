import { Component } from '@angular/core';
import { UsuarioService } from '../../../services/usuario.service';

@Component({
  selector: 'app-index-docentes',
  templateUrl: './index-docentes.component.html',
  styleUrl: './index-docentes.component.css'
})
export class IndexDocentesComponent {

  public token:any = localStorage.getItem('token');
  public usuarios: Array<any> = [];
  public page=1
  public pageSize=8
  public btn_state_load=false
  public load_data=true

  constructor(
    private usuarioService: UsuarioService,
  
  ){}

  ngOnInit(): void {
    this.iniciarDatos()
   
  }


  iniciarDatos(){
    this.usuarioService.getUsuarios(this.token).subscribe(
      response=>{
        console.log(response)
        this.usuarios = response.filter((usuario: any) => usuario.rol.id === 2);
        console.log(this.usuarios)
        console.log(this.usuarios.length)
        this.load_data=false
     
      })
   
  }

}
