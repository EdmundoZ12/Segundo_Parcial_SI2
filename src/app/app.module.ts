import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { NgbPaginationModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { TopbarComponent } from './components/topbar/topbar.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http'; // Importa HttpClient en lugar de provideHttpClient y withFetch
import { LoginComponent } from './components/login/login.component';
import { IndexUsuarioComponent } from './components/usuario/index-usuario/index-usuario.component';
import { CreateUsuarioComponent } from './components/usuario/create-usuario/create-usuario.component';
import { EditUsuarioComponent } from './components/usuario/edit-usuario/edit-usuario.component';
import { IndexModuloComponent } from './components/modulo/index-modulo/index-modulo.component';
import { CreateModuloComponent } from './components/modulo/create-modulo/create-modulo.component';
import { EditModuloComponent } from './components/modulo/edit-modulo/edit-modulo.component';
import { IndexCarreraComponent } from './components/carrera/index-carrera/index-carrera.component';
import { CreateCarreraComponent } from './components/carrera/create-carrera/create-carrera.component';
import { IndexGestionComponent } from './components/gestion/index-gestion/index-gestion.component';
import { CreateGestionComponent } from './components/gestion/create-gestion/create-gestion.component';
import { CreateHorarioComponent } from './components/horario/create-horario/create-horario.component';
import { IndexHorarioComponent } from './components/horario/index-horario/index-horario.component';
import { IndexGrupoComponent } from './components/grupo/index-grupo/index-grupo.component';
import { IndexMateriaComponent } from './components/materia/index-materia/index-materia.component';
import { CreateMateriaComponent } from './components/materia/create-materia/create-materia.component';
import { CreateGrupoComponent } from './components/grupo/create-grupo/create-grupo.component';
import { AddMateriaCarreraComponent } from './components/carrera/add-materia-carrera/add-materia-carrera.component';
import { MateriaCarreraComponent } from './components/carrera/materia-carrera/materia-carrera.component';
import { IndexAreaComponent } from './components/areaPersonal/index-area/index-area.component';
import { IndexDocentesComponent } from './components/docentes/index-docentes/index-docentes.component';
import { MateriaDocentesComponent } from './components/docentes/materia-docentes/materia-docentes.component';
import { DetalleDocentesComponent } from './components/docentes/detalle-docentes/detalle-docentes.component';
import { VerDocenteComponent } from './components/areaPersonal/ver-docente/ver-docente.component';
import { LicenciasComponent } from './components/areaPersonal/licencias/licencias.component';




@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    TopbarComponent,
    DashboardComponent,
    LoginComponent,
    IndexUsuarioComponent,
    CreateUsuarioComponent,
    EditUsuarioComponent,
    IndexModuloComponent,
    CreateModuloComponent,
    EditModuloComponent,
    IndexCarreraComponent,
    CreateCarreraComponent,
    IndexGestionComponent,
    CreateGestionComponent,
    CreateHorarioComponent,
    IndexHorarioComponent,
    IndexGrupoComponent,
    IndexMateriaComponent,
    CreateMateriaComponent,
    CreateGrupoComponent,
    AddMateriaCarreraComponent,
    MateriaCarreraComponent,
    IndexAreaComponent,
    IndexDocentesComponent,
    MateriaDocentesComponent,
    DetalleDocentesComponent,
    VerDocenteComponent,
    LicenciasComponent
   

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbPaginationModule
  ],
  providers: [
    provideClientHydration(),
    { provide: HttpClient, useClass: HttpClient } // Usa HttpClient directamente y proporciona la clase HttpClient
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
