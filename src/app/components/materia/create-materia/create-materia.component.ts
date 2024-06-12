import { Component } from '@angular/core';
import { MateriaService } from '../../../services/materia.service';
import { Router } from 'express';

@Component({
  selector: 'app-create-materia',
  templateUrl: './create-materia.component.html',
  styleUrl: './create-materia.component.css'
})
export class CreateMateriaComponent {
  public btn_load=false;
  materia:any = {}
  constructor(){}
  

  registrarMateria(){}
}
