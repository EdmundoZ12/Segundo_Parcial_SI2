import { Component, NgModule } from '@angular/core';
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
import { AuthGuard } from './guards/auth.guard';
import { MateriaCarreraComponent } from './components/carrera/materia-carrera/materia-carrera.component';
import { AddMateriaCarreraComponent } from './components/carrera/add-materia-carrera/add-materia-carrera.component';
import { IndexDocentesComponent } from './components/docentes/index-docentes/index-docentes.component';
import { MateriaDocentesComponent } from './components/docentes/materia-docentes/materia-docentes.component';
import { DetalleDocentesComponent } from './components/docentes/detalle-docentes/detalle-docentes.component';
import { IndexAreaComponent } from './components/areaPersonal/index-area/index-area.component';
import { VerDocenteComponent } from './components/areaPersonal/ver-docente/ver-docente.component';
import { LicenciasComponent } from './components/areaPersonal/licencias/licencias.component';
import { VarMateriaDocenteComponent } from './components/docente/var-materia-docente/var-materia-docente.component';
import { MateriaGrupoComponent } from './components/materia/materia-grupo/materia-grupo.component';





const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'dashboard',component:DashboardComponent,canActivate:[AuthGuard]},
  
  {path:'usuarios',component:IndexUsuarioComponent,canActivate:[AuthGuard]},
  {path:'usuarios/create',component:CreateUsuarioComponent,canActivate:[AuthGuard]},
  {path:'usuarios/edit/:id',component:EditUsuarioComponent,canActivate:[AuthGuard]},

  {path:'modulos',component:IndexModuloComponent,canActivate:[AuthGuard]},
  {path:'modulos/create',component:CreateModuloComponent,canActivate:[AuthGuard]},
  {path:'modulos/:id',component:EditModuloComponent,canActivate:[AuthGuard]},

  {path:'carrera',component:IndexCarreraComponent,canActivate:[AuthGuard]},
  {path:'carrera/create',component:CreateCarreraComponent,canActivate:[AuthGuard]},
  {path:'carrera/materia/:id',component:MateriaCarreraComponent,canActivate:[AuthGuard]},
  {path:'carrera/materia/addmateria/:id', component:AddMateriaCarreraComponent, canActivate:[AuthGuard]},
  {path:'gestion',component:IndexGestionComponent,canActivate:[AuthGuard]},
  {path:'gestion/create',component:CreateGestionComponent,canActivate:[AuthGuard]},

  {path:'horario',component:IndexHorarioComponent,canActivate:[AuthGuard]},
  {path:'horario/create',component:CreateHorarioComponent,canActivate:[AuthGuard]},

  {path:'grupo',component:IndexGrupoComponent,canActivate:[AuthGuard]},
  {path:'grupo/create',component:CreateGrupoComponent,canActivate:[AuthGuard]},

  {path:'materia',component:IndexMateriaComponent,canActivate:[AuthGuard]},
  {path:'materia/create',component:CreateMateriaComponent,canActivate:[AuthGuard]},

  {path:'docentes',component:IndexDocentesComponent,canActivate:[AuthGuard]},
  {path:'docentes/addmaterias',component:MateriaDocentesComponent,canActivate:[AuthGuard]},
  {path:'docentes/detalle/:id',component:DetalleDocentesComponent,canActivate:[AuthGuard]},

  {path:'areaPersonal',component:IndexAreaComponent,canActivate:[AuthGuard]},
  {path:'verAsistencias/:tipo',component:VerDocenteComponent,canActivate:[AuthGuard]},
  {path:'licencias',component:LicenciasComponent,canActivate:[AuthGuard]},
  {path:'materiasDocente',component:VarMateriaDocenteComponent,canActivate:[AuthGuard]},
  

  {path:'materia/grupo/:id',component:MateriaGrupoComponent,canActivate:[AuthGuard]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }