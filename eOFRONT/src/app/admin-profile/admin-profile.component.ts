import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, ActivationEnd, Router } from '@angular/router';
import { AuthenticationService } from '../login/authentication.service';
import { User } from '../model/user';
import { UsersService } from '../users/users.service';

@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent implements OnInit {

  user: User = {
    id: 0, 
    username: '',
    password: '',
    authorities: []
  };
  message = ' '; 
  form!: FormGroup; 
  submitted = false; 
  password = ' ';

  constructor(private userService: UsersService,
    private formBuilder: FormBuilder,
    private location: Location,
    private router: Router) {
      this.user;
  }

  ngOnInit(): void {
    //this.getUser();
    this.userService.getLoggedUser().subscribe( user => (this.user = user)); 
    
    this.form = this.formBuilder.group({
      username: [
        '',
        [
          Validators.required, 
          Validators.minLength(3),
          Validators.maxLength(13)
        ] 
      ],
      password: ['', Validators.required]
    });
    //alert(user.username);
    
  }

  getUser() : void{
    //this.authService.getCurrentUser();
    //this.authService.getCurrentUser();
    //this.userService.getLoggedUser().subscribe(res => {
      //this.user = res.body==null ? this.user:res.body;
      //this.user.password = '';
    //});
  }

  updateUser() : void {
    this.userService.update(this.user.id, this.user)
    .subscribe(
      response => {
        console.log(response); 
        this.message =  "You successfully updated user!";
        this.router.navigate(['']);
      },
      error => {
        console.log(error);
      }
    );
  }

  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

  onSubmit(): void {
    this.submitted = true;

    if (this.form.invalid) {
      return;
    }

    console.log(JSON.stringify(this.form.value, null, 2));
  }

  goBack(): void {
    this.location.back();
  }

}
