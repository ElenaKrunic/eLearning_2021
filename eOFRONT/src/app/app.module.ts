import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgxPaginationModule } from 'ngx-pagination'; 

import { CommonModule } from '@angular/common';
import { AppRoutingModule } from './routing/app-routing.module';
import { AppComponent } from './app.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { StudentsComponent } from './students/students.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './core/header/header.component';
import { FinancialcardStudentComponent } from './financialcard-student/financialcard-student.component';
import { NavbarProfessorComponent } from './core/navbar-professor/navbar-professor.component';
import { ProfessorCoursesComponent } from './professor-courses/professor-courses.component';
import { ProfessorStudentsComponent } from './professor-students/professor-students.component';
import { ProfessorProfileComponent } from './professor-profile/professor-profile.component';
import { ProfessorExamsComponent } from './professor-exams/professor-exams.component';
//import { ExamPeriodComponent } from './exam-period/exam-period.component';
import { PaymentComponent } from './payment/payment.component';
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
import { AdminAddExamPeriodComponent } from './admin-add-exam-period/admin-add-exam-period.component';
import { AdminDetailsExamPeriodComponent } from './admin-details-exam-period/admin-details-exam-period.component';
import { AdminListExamPeriodComponent } from './admin-list-exam-period/admin-list-exam-period.component';
import { AdminAddFinancialCardComponent } from './admin-add-financial-card/admin-add-financial-card.component';
import { AdminDetailsFinancialCardComponent } from './admin-details-financial-card/admin-details-financial-card.component';
import { AdminListFinancialCardComponent } from './admin-list-financial-card/admin-list-financial-card.component';
import { AdminAddPaymentComponent } from './admin-add-payment/admin-add-payment.component';
import { AdminDetailsPaymentComponent } from './admin-details-payment/admin-details-payment.component';
import { AdminListPaymentComponent } from './admin-list-payment/admin-list-payment.component';
import { AdminAddPreexamObligationComponent } from './admin-add-preexam-obligation/admin-add-preexam-obligation.component';
import { AdminDetailsPreexamObligationComponent } from './admin-details-preexam-obligation/admin-details-preexam-obligation.component';
import { AdminListPreexamObligationComponent } from './admin-list-preexam-obligation/admin-list-preexam-obligation.component';
import { AdminAddStudentComponent } from './admin-add-student/admin-add-student.component';
import { AdminDetailsStudentComponent } from './admin-details-student/admin-details-student.component';
import { AdminListStudentsComponent } from './admin-list-students/admin-list-students.component';
import { AdminDetailsPreexamObligationTypeComponent } from './admin-details-preexam-obligation-type/admin-details-preexam-obligation-type.component';
import { ValidationComponent } from './validation/validation.component';
import { ProfessorService } from './professor/professor.service';
import { StudentService } from './students/student.service';
import { AdminAddCourseComponent } from './admin-add-course/admin-add-course.component';
import { AdminAddExamComponent } from './admin-add-exam/admin-add-exam.component';
import { AdminAddProfessorComponent } from './admin-add-professor/admin-add-professor.component';
import { AdminDetailsExamComponent } from './admin-details-exam/admin-details-exam.component';
import { AdminDetailsCourseComponent } from './admin-details-course/admin-details-course.component';
import { AdminDetailsProfessorComponent } from './admin-details-professor/admin-details-professor.component';
import { AdminDetailsDocumentComponent } from './admin-details-document/admin-details-document.component';
import { AdminListCourseComponent } from './admin-list-course/admin-list-course.component';
import { AdminListExamComponent } from './admin-list-exam/admin-list-exam.component';
import { AdminListProfessorComponent } from './admin-list-professor/admin-list-professor.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentDetailsComponent,
    StudentsComponent,
    LoginComponent,
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
    AdminAddExamPeriodComponent,
    AdminDetailsExamPeriodComponent,
    AdminListExamPeriodComponent,
    AdminAddFinancialCardComponent,
    AdminDetailsFinancialCardComponent,
    AdminListFinancialCardComponent,
    AdminAddFinancialCardComponent,
    AdminDetailsFinancialCardComponent,
    AdminListFinancialCardComponent,
    AdminAddPaymentComponent,
    AdminDetailsPaymentComponent,
    AdminListPaymentComponent,
    AdminAddPaymentComponent,
    AdminDetailsPaymentComponent,
    AdminListPaymentComponent,
    AdminAddStudentComponent,
    AdminDetailsStudentComponent,
    AdminListStudentsComponent,
    AdminDetailsPreexamObligationTypeComponent,
    AdminListPreexamObligationComponent,
    AdminDetailsPreexamObligationComponent,
    AdminAddPreexamObligationComponent,
    AdminAddStudentComponent,
    AdminListStudentsComponent,
    NavbarProfessorComponent,

    AdminDetailsStudentComponent,
    ValidationComponent,
    AdminAddCourseComponent,
    AdminAddExamComponent,
    AdminAddProfessorComponent,
    AdminDetailsExamComponent,
    AdminDetailsCourseComponent,
    AdminDetailsProfessorComponent,
    AdminDetailsDocumentComponent,
    AdminListCourseComponent,
    AdminListExamComponent,
    AdminListProfessorComponent
  ],

  providers: [
    ProfessorService,
    StudentService
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
		ReactiveFormsModule,
    BrowserAnimationsModule, // required animations module
		ToastrModule.forRoot(),
		HttpClientModule,
    NgxPaginationModule,
    
    NgbModule,
    CommonModule,
  ],

  bootstrap: [AppComponent]
})
export class AppModule { }
