import { Routes } from "@angular/router";
import { FinancialcardStudentComponent } from "../financialcard-student/financialcard-student.component";
import { LoginComponent } from "../login/login.component";
import { LoginGuard } from "../login/login.service";
import { RoleGuard } from "../login/role.service";

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
	
];

