import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FinancialcardStudentComponent } from '../financialcard-student/financialcard-student.component';
import { MainComponent } from '../main/main.component';
import { StudentProfileComponent } from '../student-profile/student-profile.component';
import { StudentsComponent } from '../students/students.component';



const routes: Routes = [
  { path: 'financialCard', component: FinancialcardStudentComponent },
  { path: 'studentProfile', component: StudentProfileComponent },
  { path: 'main', component: MainComponent },
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash: true})
  ],
  exports: [RouterModule]
  
})
export class AppRoutingModule { }



