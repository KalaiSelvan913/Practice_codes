import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { Page2Component } from './page2/page2.component';
import { AppRoutingModule } from './app-routing.module';
import { RegisterComponent } from './register/register.component';
import { ViewComponent } from './view/view.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { CommonComponent } from './common/common.component';
import { HeaderComponent } from './header/header.component';
import { SampleComponent } from './sample/sample.component';
import { FormsModule } from '@angular/forms';
import { TemplateDrivenFormComponent } from './template-driven-form/template-driven-form.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import { DemoComponent } from './demo/demo.component';
import { EditComponent } from './edit/edit.component';
import { NgxSpinnerModule } from "ngx-spinner"; 
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';


@NgModule({
  declarations: [ 
    AppComponent,
    LoginComponent,
    UserComponent,
    Page2Component, 
    RegisterComponent, ViewComponent,
     CommonComponent, HeaderComponent,
     SampleComponent, TemplateDrivenFormComponent,
      DemoComponent, EditComponent
  ],
  imports: [
    BrowserModule,

    // import HttpClientModule after BrowserModule.
    HttpClientModule,
    MatSliderModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FontAwesomeModule,
    FormsModule,
    BrowserAnimationsModule,
    NgxSpinnerModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
}) 
export class AppModule { }
