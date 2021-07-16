import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminAddExamPeriodComponent } from '../admin-add-exam-period/admin-add-exam-period.component';
import { AdminAddFinancialCardComponent } from '../admin-add-financial-card/admin-add-financial-card.component';
import { AdminAddPaymentComponent } from '../admin-add-payment/admin-add-payment.component';
import { AdminAddPreexamObligationComponent } from '../admin-add-preexam-obligation/admin-add-preexam-obligation.component';
import { AdminAddStudentComponent } from '../admin-add-student/admin-add-student.component';
import { AdminDetailsExamPeriodComponent } from '../admin-details-exam-period/admin-details-exam-period.component';
import { AdminDetailsFinancialCardComponent } from '../admin-details-financial-card/admin-details-financial-card.component';
import { AdminDetailsPaymentComponent } from '../admin-details-payment/admin-details-payment.component';
import { AdminDetailsPreexamObligationComponent } from '../admin-details-preexam-obligation/admin-details-preexam-obligation.component';
import { AdminDetailsStudentComponent } from '../admin-details-student/admin-details-student.component';
import { AdminListExamPeriodComponent } from '../admin-list-exam-period/admin-list-exam-period.component';
import { AdminListFinancialCardComponent } from '../admin-list-financial-card/admin-list-financial-card.component';
import { AdminListPaymentComponent } from '../admin-list-payment/admin-list-payment.component';
import { AdminListPreexamObligationComponent } from '../admin-list-preexam-obligation/admin-list-preexam-obligation.component';
import { AdminListStudentsComponent } from '../admin-list-students/admin-list-students.component';
import { NavbarProfessorComponent } from '../core/navbar-professor/navbar-professor.component';
import { FinancialcardStudentComponent } from '../financialcard-student/financialcard-student.component';
import { LoginComponent } from '../login/login.component';
import { MainComponent } from '../main/main.component';
import { PaymentDetailsComponent } from '../payment-details/payment-details.component';
import { PaymentComponent } from '../payment/payment.component';
import { PayoutComponent } from '../payout/payout.component';
import { ProfessorCoursesComponent } from '../professor-courses/professor-courses.component';
import { ProfessorExamsComponent } from '../professor-exams/professor-exams.component';
import { ProfessorProfileComponent } from '../professor-profile/professor-profile.component';
import { ProfessorStudentsComponent } from '../professor-students/professor-students.component';
import { StudentDetailsComponent } from '../student-details/student-details.component';
import { StudentDocumentsComponent } from '../student-documents/student-documents.component';
import { StudentEnrollmentComponent } from '../student-enrollment/student-enrollment.component';
import { StudentExamsComponent } from '../student-exams/student-exams.component';
import { StudentProfileComponent } from '../student-profile/student-profile.component';

const routes: Routes = [
  { path: 'preexamObligations', component: AdminListPreexamObligationComponent},
  { path: 'preexamObligations/:id', component: AdminDetailsPreexamObligationComponent},
  { path: 'adminAddPreexamObligation', component: AdminAddPreexamObligationComponent},
  { path: 'financialCard', component: FinancialcardStudentComponent },
  { path: 'studentProfile', component: StudentProfileComponent },
  { path: 'payment', component: PaymentComponent },
  { path: 'payouts', component: PayoutComponent },
  { path: 'coursesForProfessor', component: ProfessorCoursesComponent },
  { path: 'studentEnrollments', component: StudentEnrollmentComponent },
  
  { path: 'studentExams', component: StudentExamsComponent },
  {path:'studentDocuments', component:StudentDocumentsComponent},
  {path: 'professorProfile', component: ProfessorProfileComponent},
  {path: 'studentsForProfessor', component: ProfessorStudentsComponent},
  {path: 'examsForProfessor', component: ProfessorExamsComponent},
 { path: 'studentsForProfessor', component: ProfessorStudentsComponent},
  { path: 'examsForProfessor', component: ProfessorExamsComponent},
  { path: 'studentPayment', component: PaymentComponent },
  { path: 'studentPayout', component: PayoutComponent },
  { path: 'main', component: MainComponent },
  { path: 'examPeriods', component: AdminListExamPeriodComponent },
  { path: 'examPeriods/:id', component: AdminDetailsExamPeriodComponent },
  { path: 'addExamPeriod', component: AdminAddExamPeriodComponent },
  { path: 'students', component: AdminListStudentsComponent },
  { path: 'students/:id', component: AdminDetailsStudentComponent },
  { path: 'adminAddsStudent', component: AdminAddStudentComponent },
  { path: 'financialCards', component: AdminListFinancialCardComponent},
  { path: 'financialCards/:id', component: AdminDetailsFinancialCardComponent}, 
  { path: 'adminAddFinancialCard', component: AdminAddFinancialCardComponent},
  { path: 'payments', component: AdminListPaymentComponent},
  { path: 'payments/:id', component: AdminDetailsPaymentComponent},
  { path: 'adminAddPayment', component: AdminAddPaymentComponent},
  { path: 'addStudent', component: StudentDetailsComponent},
  { path: 'editStudent/:id', component: StudentDetailsComponent},
  { path: 'addPayment', component: PaymentDetailsComponent},
  { path: 'editPayment/:id', component: PaymentDetailsComponent},
  { path: '**', component: LoginComponent },
  { path: 'professorCourses', component:NavbarProfessorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash: false})
  ],
  exports: [RouterModule]
  
})
export class AppRoutingModule { }



