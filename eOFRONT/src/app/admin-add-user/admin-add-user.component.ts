import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Params } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { Authority } from '../model/authority';
import { User } from '../model/user';
import { UsersService } from '../users/users.service';

@Component({
  selector: 'app-admin-add-user',
  templateUrl: './admin-add-user.component.html',
  styleUrls: ['./admin-add-user.component.css']
})
export class AdminAddUserComponent implements OnInit {

  user: User = new User({
    username: '', 
    password: '', 
    authorities: []
  });

  authorityName: string = '';
  unassignedAuthorities : Authority[] = [];

  form!: FormGroup;
  submitted = false; 

  constructor(private userService: UsersService,
    private formBuilder: FormBuilder) {
    
     }

  ngOnInit(): void {
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

  get f(): { [key: string]: AbstractControl} { return this.form.controls;}

  saveUser() {
    const data = {
      username : this.user.username,
      password : this.user.password
    }; 

    this.userService.create(data)
    .subscribe(
      response => {
        console.log(response); 
        this.submitted = true; 
      },
      error => {
        console.log(error);
      }
    );
  }

  newUser(){
    this.submitted = false; 
    this.user = {
      username: '', 
      password: '',
      authorities: []
    };
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

  removeAuthority(name:string) {
    var a:Authority[] = this.user.authorities.filter(a => a.name===name)
    this.user.authorities=this.user.authorities.filter(a => a.name!==name);
    this.unassignedAuthorities.push(a[0]);
    console.log(JSON.stringify(this.unassignedAuthorities));
  }

  assignAuthority() {
    const a = this.unassignedAuthorities.filter(a => a.name===this.authorityName)[0];
    if(a!==undefined){
      this.user.authorities.push(a);
      this.unassignedAuthorities=this.unassignedAuthorities.filter(a => a.name!==this.authorityName);
        }else{
      alert("Please select one of the roles!")
    }
  }
}
