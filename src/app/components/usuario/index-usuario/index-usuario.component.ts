import { Component } from '@angular/core';
import { UsuarioService } from '../../../services/usuario.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-index-usuario',
  templateUrl: './index-usuario.component.html',
  styleUrl: './index-usuario.component.css'
})
export class IndexUsuarioComponent {
 
  public token:any = localStorage.getItem('token');
  public usuarios: Array<any> = [];
  public page=1
  public pageSize=8
  public btn_state_load=false
  public load_data=true

  constructor(
    private usuarioService: UsuarioService,
    private router: Router
  ){}

  ngOnInit(): void {
    this.iniciarDatos()
   
  }


  iniciarDatos(){
    this.usuarioService.getUsuarios(this.token).subscribe(
      response=>{
        console.log(response)
        this.usuarios=response
        console.log(this.usuarios)
        console.log(this.usuarios.length)
        this.load_data=false
     
      })
   
  }

}
