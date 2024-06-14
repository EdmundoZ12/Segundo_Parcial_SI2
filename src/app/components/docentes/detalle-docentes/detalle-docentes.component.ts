import { Component } from '@angular/core';
import { UsuarioService } from '../../../services/usuario.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-detalle-docentes',
  templateUrl: './detalle-docentes.component.html',
  styleUrl: './detalle-docentes.component.css'
})
export class DetalleDocentesComponent {

  public token = localStorage.getItem('token');
  
  public docente:any={}
  public id=''
  public materias: Array<any> = [];
  public page=1
  public pageSize=8
  public btn_state_load=false
  public load_data=true


  constructor(
    private usuarioService: UsuarioService,
    private route:ActivatedRoute
  ) { }



  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = params['id'];
      this.getDocenteMateria()
      this.getDocente()
    });
    

  }

  getDocente(){
    this.usuarioService.getUsuario(this.id, this.token).subscribe(
      (response) => {
        this.docente = response;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  getDocenteMateria() {
    this.usuarioService.obtenerDocenteMateria(this.id, this.token).subscribe(
      (response) => {
    
        this.materias = response;
        this.load_data=false
      },
      (error) => {
        console.log(error);
      }
    );
  }

}
