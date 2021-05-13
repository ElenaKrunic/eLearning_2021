import { Routes } from "@angular/router";
import { NavbarStudentComponent } from "../core/navbar-student/navbar-student.component";
import { FinancialcardStudentComponent } from "../financialcard-student/financialcard-student.component";
import { LoginComponent } from "../login/login.component";
import { LoginGuard } from "../login/login.service";
import { RoleGuard } from "../login/role.service";
import { PaymentComponent } from "../payment/payment.component";
import { PayoutComponent } from "../payout/payout.component";
import { ProfessorExamsComponent } from "../professor-exams/professor-exams.component";
import { ProfessorProfileComponent } from "../professor-profile/professor-profile.component";
import { ProfessorStudentsComponent } from "../professor-students/professor-students.component";

export const routes: Routes = [
	{
		path: 'financialcard',
		component: FinancialcardStudentComponent,
		canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_ADMIN|ROLE_STUDENT'}
	},
	{
		path: 'payment',
		component: PaymentComponent,
		canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_STUDENT'}
	},
	{
		path: 'payout',
		component: PayoutComponent,
		canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_STUDENT'}
	},

	{
		path: 'login',
		component: LoginComponent,
		canActivate: [LoginGuard],
	},

	{
		path: 'exams',
		component: ProfessorExamsComponent,
		canActivate: [RoleGuard],
		data: {expectedRoles: 'ADMIN|PROFESSOR'}
	},

	{
		path: 'students',
		component: ProfessorStudentsComponent,
		canActivate: [RoleGuard],
		data: {expectedRoles: 'ADMIN|PROFESSOR'}
	},

	{
		path: 'profile',
		component: ProfessorProfileComponent,
		canActivate: [RoleGuard],
		data: {expectedRoles: 'ADMIN|PROFESSOR'}
	},
	{
		path: 'app-navbar-student',
		component: NavbarStudentComponent,
		canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_STUDENT'}
	},
	
	
];

