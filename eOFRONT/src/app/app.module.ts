import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';


import { AppRoutingModule } from './routing/app-routing.module';
import { AppComponent } from './app.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { StudentsComponent } from './students/students.component';
import { LoginComponent } from './login/login.component';
import { PreexamObligationComponent } from './preexam-obligation/preexam-obligation.component';


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
    FormsModule,
		ReactiveFormsModule,
		BrowserAnimationsModule, // required animations module
		ToastrModule.forRoot(),
		HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
