import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminExamPeriodComponent } from '../admin-exam-period/admin-exam-period.component';
import { AdminFinancialCardComponent } from '../admin-financial-card/admin-financial-card.component';
import { AdminPaymentComponent } from '../admin-payment/admin-payment.component';
import { AdminPreexamObligationComponent } from '../admin-preexam-obligation/admin-preexam-obligation.component';
import { AdminStudentComponent } from '../admin-student/admin-student.component';
import { FinancialcardStudentComponent } from '../financialcard-student/financialcard-student.component';
import { MainComponent } from '../main/main.component';
import { PaymentComponent } from '../payment/payment.component';
import { PayoutComponent } from '../payout/payout.component';
import { StudentProfileComponent } from '../student-profile/student-profile.component';
import { StudentsComponent } from '../students/students.component';



const routes: Routes = [
  { path: 'financialCard', component: FinancialcardStudentComponent },
  { path: 'studentProfile', component: StudentProfileComponent },
  { path: 'studentPayment', component: PaymentComponent },
  { path: 'studentPayout', component: PayoutComponent },
  { path: 'main', component: MainComponent },
  { path : 'adminExamPeriod', component: AdminExamPeriodComponent},
  { path: 'adminFinancialCard', component: AdminFinancialCardComponent},
  { path: 'adminPayment', component: AdminPaymentComponent},
  {path : 'adminPreexamObligation', component: AdminPreexamObligationComponent},
  {path: 'adminStudent', component: AdminStudentComponent}
  // { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash: true})
  ],
  exports: [RouterModule]
  
})
export class AppRoutingModule { }



