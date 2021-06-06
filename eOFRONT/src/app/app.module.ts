import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { CommonModule } from '@angular/common';
import { AppRoutingModule } from './routing/app-routing.module';
import { AppComponent } from './app.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { StudentsComponent } from './students/students.component';
import { LoginComponent } from './login/login.component';
import { PreexamObligationComponent } from './preexam-obligation/preexam-obligation.component';
import { HeaderComponent } from './core/header/header.component';
import { FinancialcardStudentComponent } from './financialcard-student/financialcard-student.component';
import { NavbarProfessorComponent } from './core/navbar-professor/navbar-professor.component';
import { ProfessorCoursesComponent } from './professor-courses/professor-courses.component';
import { ProfessorStudentsComponent } from './professor-students/professor-students.component';
import { ProfessorProfileComponent } from './professor-profile/professor-profile.component';
import { ProfessorExamsComponent } from './professor-exams/professor-exams.component';
//import { ExamPeriodComponent } from './exam-period/exam-period.component';
import { PaymentComponent } from './payment/payment.component';
import { AdminExamPeriodComponent } from './admin-exam-period/admin-exam-period.component';
import { AdminFinancialCardComponent } from './admin-financial-card/admin-financial-card.component';
import { AdminPaymentComponent } from './admin-payment/admin-payment.component';
import { AdminPreexamObligationComponent } from './admin-preexam-obligation/admin-preexam-obligation.component';
import { AdminStudentComponent } from './admin-student/admin-student.component';
import { PayoutComponent } from './payout/payout.component';
import { StudentProfileComponent } from './student-profile/student-profile.component';
import { AdminExamComponent } from './admin-exam/admin-exam.component';
import { AdminDocumentsComponent } from './admin-documents/admin-documents.component';
import { AdminCourseComponent } from './admin-course/admin-course.component';
import { AdminProfessorsComponent } from './admin-professors/admin-professors.component';
import { AdminComponent } from './admin/admin.component';
import { MainComponent } from './main/main.component';
import { StudentExamsComponent } from './student-exams/student-exams.component';
import { StudentDocumentsComponent } from './student-documents/student-documents.component';
import { StudentEnrollmentComponent } from './student-enrollment/student-enrollment.component';
import { ExamPeriodDetailsComponent } from './exam-period-details/exam-period-details.component';

import { FinancialCardDetailsComponent } from './financial-card-details/financial-card-details.component';
import { PaymentDetailsComponent } from './payment-details/payment-details.component';
import { PreexamObligationDetailsComponent } from './preexam-obligation-details/preexam-obligation-details.component';
import { NavbarAdminComponent } from './core/navbar-admin/navbar-admin.component';
import { NavbarStudentComponent } from './core/navbar-student/navbar-student.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';



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
    //ExamPeriodComponent,
    PaymentComponent,
    AdminExamPeriodComponent,
    AdminFinancialCardComponent,
    AdminPaymentComponent,
    AdminPreexamObligationComponent,
    AdminStudentComponent,
    PayoutComponent,
    StudentProfileComponent,
    AdminExamComponent,
    AdminDocumentsComponent,
    AdminCourseComponent,
    AdminProfessorsComponent,
    AdminComponent,
    MainComponent,
    StudentExamsComponent,
    StudentDocumentsComponent,
    StudentEnrollmentComponent,
    NavbarAdminComponent,
    ExamPeriodDetailsComponent,
    FinancialCardDetailsComponent,
    PaymentDetailsComponent,
    PreexamObligationDetailsComponent,
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
		ReactiveFormsModule,
    BrowserAnimationsModule, // required animations module
		ToastrModule.forRoot(),
		HttpClientModule,
    NgbModule,
    CommonModule,
  ],


  bootstrap: [AppComponent]
})
export class AppModule { }
