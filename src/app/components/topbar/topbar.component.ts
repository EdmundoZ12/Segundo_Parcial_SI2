import { Component } from '@angular/core';
import { UsuarioService } from '../../services/usuario.service';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
@Component({
  selector: 'app-topbar',
  templateUrl: './topbar.component.html',
  styleUrls: ['./topbar.component.css']
})
export class TopbarComponent {

  public token:any = localStorage.getItem('token')
  public usuario:any={}
  public id:any={}
  constructor(
    private _userService:UsuarioService,
    private router: Router
  ){}

  ngOnInit(): void {
    const helper= new JwtHelperService();
    const decode=helper.decodeToken(this.token);
    this.id=decode.sub
    this.initdata()
  }


  initdata(){
    this._userService.getUsuario(this.id,this.token).subscribe(
      response=>{
        this.usuario=response
       
      }
    )
  }

  logout(){
    localStorage.clear()
    window.location.reload()
    this.router.navigate(['/']);
  }

}
