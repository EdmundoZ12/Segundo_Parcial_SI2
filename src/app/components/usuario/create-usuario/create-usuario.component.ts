import { Component } from '@angular/core';
import { UsuarioService } from '../../../services/usuario.service';
import { Router } from '@angular/router';
declare var toastr:any
@Component({
  selector: 'app-create-usuario',
  templateUrl: './create-usuario.component.html',
  styleUrl: './create-usuario.component.css'
})
export class CreateUsuarioComponent {
  
 
  public usuario:any={}

  public token=localStorage.getItem('token')
  public btn_load=false
  public roles:any=[]
 
  constructor(
    private usuarioService: UsuarioService,
    private _router:Router,
    
  ){}

  ngOnInit(){
   this.initData()
  }

  initData(){
    this.usuarioService.getRol(this.token).subscribe(
      response=>{
        
        this.roles=response
      }
    )
  }
  



  registrar(){
  
      console.log(this.usuario)
      this.usuario.password=this.usuario.ci
      this.usuarioService.createUsuario(this.usuario,this.token).subscribe(
        response=>{
          console.log(response)
          toastr.success('Usuario creado correctamente')
          
        })
    
  }

}
