import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UsersService } from '../users/users.service';

@Component({
  selector: 'app-admin-details-user',
  templateUrl: './admin-details-user.component.html',
  styleUrls: ['./admin-details-user.component.css']
})
export class AdminDetailsUserComponent implements OnInit {

  currentUser: any | null;
  message = ''; 
  form!: FormGroup; 
  submitted = false;

  constructor(private userService: UsersService,
    private route: ActivatedRoute, 
    private router: Router, 
    private formBuilder: FormBuilder) {this.currentUser = {}; }

  ngOnInit(): void {
    this.message = '';
    this.getUser(this.route.snapshot.paramMap.get('id'));
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
  }

  getUser(id: any) : void {
    this.userService.get(id)
    .subscribe(
      data => {
        this.currentUser = data; 
        console.log(data); 
      }, 
      error => {
        console.log(error);
      }
    );
  }
  
  updateUser(): void {
    this.userService.update(this.currentUser.id, this.currentUser)
    .subscribe(
      response => {
        console.log(response); 
        this.message =  "You successfully updated user!";
      },
      error => {
        console.log(error);
      }
    );
  }

  deleteUser() : void {
    this.userService.delete(this.currentUser.id)
    .subscribe(
      response => {
        console.log(response); 
        this.message =  "You successfully deleted user!";
        this.router.navigate(['/users']);
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

  onReset(): void {
    this.submitted = false;
    this.form.reset();
  }


}
