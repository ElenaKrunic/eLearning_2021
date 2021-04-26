import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentexamsComponent } from './studentexams/studentexams.component';
import { StudentpayoutsComponent } from './studentpayouts/studentpayouts.component';
import { StudentpaymentComponent } from './studentpayment/studentpayment.component';
import { StudentdocumentComponent } from './studentdocument/studentdocument.component';
import { StudentfinancialcardComponent } from './studentfinancialcard/studentfinancialcard.component';
import { StudentenrollmentComponent } from './studentenrollment/studentenrollment.component';
import { NekaNovaKomponentaComponent } from './neka-nova-komponenta/neka-nova-komponenta.component';
import { ModuleDirective } from './module.directive';
import { StudentComponent } from './student/student.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { StudentsComponent } from './students/students.component';
import { ProfessorListOfStudentsComponent } from './professor-list-of-students/professor-list-of-students.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentexamsComponent,
    StudentpayoutsComponent,
    StudentpaymentComponent,
    StudentdocumentComponent,
    StudentfinancialcardComponent,
    StudentenrollmentComponent,
    NekaNovaKomponentaComponent,
    ModuleDirective,
    StudentComponent,
    StudentDetailsComponent,
    StudentsComponent,
    ProfessorListOfStudentsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
