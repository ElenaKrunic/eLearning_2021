import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Interceptor } from './interceptors/intercept.service';


import { AppRoutingModule } from './routing/app-routing.module';
import { AppComponent } from './app.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { StudentsComponent } from './students/students.component';
import { LoginComponent } from './login/login.component';
import { PreexamObligationComponent } from './preexam-obligation/preexam-obligation.component';
import { HeaderComponent } from './core/header/header.component';
import { NavbarStudentComponent } from './core/navbar-student/navbar-student.component';
import { FinancialcardStudentComponent } from './financialcard-student/financialcard-student.component';
import { NavbarProfessorComponent } from './core/navbar-professor/navbar-professor.component';
import { ProfessorCoursesComponent } from './professor-courses/professor-courses.component';
import { ProfessorStudentsComponent } from './professor-students/professor-students.component';
import { ProfessorProfileComponent } from './professor-profile/professor-profile.component';
import { ProfessorExamsComponent } from './professor-exams/professor-exams.component';
import { ExamPeriodComponent } from './exam-period/exam-period.component';
import { PaymentComponent } from './payment/payment.component';
import { PayoutComponent } from './payout/payout.component';
import { StudentProfileComponent } from './student-profile/student-profile.component';


@NgModule({
  declarations: [
    AppComponent,
    StudentDetailsComponent,
    StudentsComponent,
    LoginComponent,
    PreexamObligationComponent,
    HeaderComponent,
    NavbarStudentComponent,
    FinancialcardStudentComponent,
    NavbarProfessorComponent,
    ProfessorCoursesComponent,
    ProfessorStudentsComponent,
    ProfessorProfileComponent,
    ProfessorExamsComponent,
    ExamPeriodComponent,
    PaymentComponent,
    PayoutComponent,
    StudentProfileComponent,
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
  providers: [{provide: HTTP_INTERCEPTORS, useClass: Interceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
