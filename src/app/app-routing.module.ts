import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { LoginComponent } from './components/login/login.component';
import { IndexUsuarioComponent } from './components/usuario/index-usuario/index-usuario.component';
import { CreateUsuarioComponent } from './components/usuario/create-usuario/create-usuario.component';
import { IndexModuloComponent } from './components/modulo/index-modulo/index-modulo.component';
import { EditModuloComponent } from './components/modulo/edit-modulo/edit-modulo.component';
import { EditUsuarioComponent } from './components/usuario/edit-usuario/edit-usuario.component';
import { CreateModuloComponent } from './components/modulo/create-modulo/create-modulo.component';
import { IndexCarreraComponent } from './components/carrera/index-carrera/index-carrera.component';
import { CreateCarreraComponent } from './components/carrera/create-carrera/create-carrera.component';
import { IndexGestionComponent } from './components/gestion/index-gestion/index-gestion.component';
import { CreateGestionComponent } from './components/gestion/create-gestion/create-gestion.component';
import { IndexHorarioComponent } from './components/horario/index-horario/index-horario.component';
import { CreateHorarioComponent } from './components/horario/create-horario/create-horario.component';
import { IndexGrupoComponent } from './components/grupo/index-grupo/index-grupo.component';
import { CreateGrupoComponent } from './components/grupo/create-grupo/create-grupo.component';
import { IndexMateriaComponent } from './components/materia/index-materia/index-materia.component';
import { CreateMateriaComponent } from './components/materia/create-materia/create-materia.component';





const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'dashboard',component:DashboardComponent},
  
  {path:'usuarios',component:IndexUsuarioComponent},
  {path:'usuarios/create',component:CreateUsuarioComponent},
  {path:'usuarios/edit/:id',component:EditUsuarioComponent},

  {path:'modulos',component:IndexModuloComponent},
  {path:'modulos/create',component:CreateModuloComponent},
  {path:'modulos/:id',component:EditModuloComponent},

  {path:'carrera',component:IndexCarreraComponent},
  {path:'carrera/create',component:CreateCarreraComponent},
  
  {path:'gestion',component:IndexGestionComponent},
  {path:'gestion/create',component:CreateGestionComponent},

  {path:'horario',component:IndexHorarioComponent},
  {path:'horario/create',component:CreateHorarioComponent},

  {path:'grupo',component:IndexGrupoComponent},
  {path:'grupo/create',component:CreateGrupoComponent},

  {path:'materia',component:IndexMateriaComponent},
  {path:'materia/create',component:CreateMateriaComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
