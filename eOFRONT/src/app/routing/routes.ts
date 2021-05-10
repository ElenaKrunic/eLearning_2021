import { Routes } from "@angular/router";
import { LoginComponent } from "../login/login.component";
import { LoginGuard } from "../login/login.service";
import { RoleGuard } from "../login/role.service";

export const routes: Routes = [

	
	{
		path: 'login',
		component: LoginComponent,
		canActivate: [LoginGuard],
	},
	
];

