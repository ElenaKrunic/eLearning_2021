import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './routing/app-routing.module';
import { AppComponent } from './app.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { StudentsComponent } from './students/students.component';
import { LoginComponent } from './login/login.component';
import { PreexamObligationComponent } from './preexam-obligation/preexam-obligation.component';
// import {MatFormFieldModule} from "@angular/material/form-field"
// import {MatInputModule} from "@angular/material/input"

@NgModule({
  declarations: [
    AppComponent,
    StudentDetailsComponent,
    StudentsComponent,
    LoginComponent,

    PreexamObligationComponent,
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    // MatFormFieldModule,
    // MatInputModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
