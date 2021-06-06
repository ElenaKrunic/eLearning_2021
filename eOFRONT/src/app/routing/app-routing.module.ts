import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminExamPeriodComponent } from '../admin-exam-period/admin-exam-period.component';
import { AdminFinancialCardComponent } from '../admin-financial-card/admin-financial-card.component';
import { AdminPaymentComponent } from '../admin-payment/admin-payment.component';
import { AdminPreexamObligationComponent } from '../admin-preexam-obligation/admin-preexam-obligation.component';
import { AdminStudentComponent } from '../admin-student/admin-student.component';
import { ExamPeriodDetailsComponent } from '../exam-period-details/exam-period-details.component';
import { FinancialCardDetailsComponent } from '../financial-card-details/financial-card-details.component';
import { FinancialcardStudentComponent } from '../financialcard-student/financialcard-student.component';
import { MainComponent } from '../main/main.component';
import { Professor } from '../model/professor';
import { PaymentDetailsComponent } from '../payment-details/payment-details.component';
import { PaymentComponent } from '../payment/payment.component';
import { PayoutComponent } from '../payout/payout.component';
import { PreexamObligationDetailsComponent } from '../preexam-obligation-details/preexam-obligation-details.component';
import { ProfessorProfileComponent } from '../professor-profile/professor-profile.component';
import { StudentDetailsComponent } from '../student-details/student-details.component';
import { StudentProfileComponent } from '../student-profile/student-profile.component';
import { StudentsComponent } from '../students/students.component';

const routes: Routes = [
  { path: 'financialCard', component: FinancialcardStudentComponent },
  { path: 'studentProfile', component: StudentProfileComponent },
  {path: 'professorProfile', component: ProfessorProfileComponent},
  { path: 'studentPayment', component: PaymentComponent },
  { path: 'studentPayout', component: PayoutComponent },
  { path: 'main', component: MainComponent },
  { path: 'addExamPeriod', component: ExamPeriodDetailsComponent},
  { path : 'editExamPeriod/:id', component: ExamPeriodDetailsComponent},
  { path: 'addFinancialCard', component: FinancialCardDetailsComponent},
  { path : 'editFinancialCard/:id', component: FinancialCardDetailsComponent},
  { path: 'addPreexamObligation', component: PreexamObligationDetailsComponent},
  { path: 'editPreexamObligation/:id', component: PreexamObligationDetailsComponent},
  { path: 'addStudent', component: StudentDetailsComponent},
  { path: 'editStudent/:id', component: StudentDetailsComponent},
  { path: 'addPayment', component: PaymentDetailsComponent},
  { path: 'editPayment/:id', component: PaymentDetailsComponent}
  // { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash: true})
  ],
  exports: [RouterModule]
  
})
export class AppRoutingModule { }



