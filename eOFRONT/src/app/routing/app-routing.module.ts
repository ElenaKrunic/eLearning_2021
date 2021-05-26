import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
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
  // { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash: true})
  ],
  exports: [RouterModule]
  
})
export class AppRoutingModule { }



