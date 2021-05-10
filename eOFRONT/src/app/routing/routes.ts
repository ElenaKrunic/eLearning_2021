import { Routes } from "@angular/router";
import { FinancialcardStudentComponent } from "../financialcard-student/financialcard-student.component";
import { LoginComponent } from "../login/login.component";
import { LoginGuard } from "../login/login.service";
import { RoleGuard } from "../login/role.service";
import { ProfessorExamsComponent } from "../professor-exams/professor-exams.component";
import { ProfessorProfileComponent } from "../professor-profile/professor-profile.component";
import { ProfessorStudentsComponent } from "../professor-students/professor-students.component";

export const routes: Routes = [
	{
		path: 'financialcard',
		component: FinancialcardStudentComponent,
		canActivate: [RoleGuard],
		data: {expectedRoles: 'ADMIN|STUDENT'}
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
	
];

