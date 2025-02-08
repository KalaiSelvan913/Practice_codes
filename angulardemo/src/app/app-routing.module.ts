import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AppComponent } from './app.component';
import { Page2Component } from './page2/page2.component';
import { ViewComponent } from './view/view.component';
import { RegisterComponent } from './register/register.component';
import { CommonComponent } from './common/common.component';
import { SampleComponent } from './sample/sample.component';
import { TemplateDrivenFormComponent } from './template-driven-form/template-driven-form.component';
import { DemoComponent } from './demo/demo.component';
import { EditComponent } from './edit/edit.component';


const routes: Routes = [

  {path : "login", component : LoginComponent},
  { path: '',   redirectTo: '/login', pathMatch: 'full' },

  {
    path: 'common',
    component: CommonComponent, // this is the component with the <router-outlet> in the template
    children: [
      {
        path: 'register', // child route path
        component: RegisterComponent, // child route component that the router renders
      },
      {
        path: 'view',
        component: ViewComponent, // another child route component that the router renders
      },
      {
        path:'sample', component:SampleComponent,
      },
      {path:'edit', component:EditComponent},
    ],
  },
  {path:'register', component:RegisterComponent},
  {path:'templateform', component:TemplateDrivenFormComponent},
  {path:'demo', component:DemoComponent},
  {path:'page', component:Page2Component},
]

@NgModule({
  declarations: [],
  imports: [ RouterModule.forRoot(routes),CommonModule ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
