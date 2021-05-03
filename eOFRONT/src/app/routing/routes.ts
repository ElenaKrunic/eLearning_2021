import { Routes } from "@angular/router";
import { LoginComponent } from "../login/login.component";
import { RoleGuard } from "../login/role.service";

export const routes: Routes = [
	{
		path: 'login',
		component: LoginComponent,
		canActivate: [RoleGuard],
		data: {expectedRoles: 'ADMIN|STUDENT|PROFFESOR'}
	},
	
];

