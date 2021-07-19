import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { JwtserviceutilsService } from '../jwtservice/jwtserviceutils.service';
import { RoleGuard } from '../login/role.service';
import { Authority } from '../model/authority';
import { Student } from '../model/student';
import { User } from '../model/user';
import { StudentService } from '../students/student.service';

@Component({
  selector: 'app-admin-add-student',
  templateUrl: './admin-add-student.component.html',
  styleUrls: ['./admin-add-student.component.css']
})
export class AdminAddStudentComponent implements OnInit {

  student : Student = new Student({
    user: null,
    cardNumber : '',
    firstName: '', 
    lastName: '', 
    phoneNumber: '', 
    email: '', 
    umnc: '', 
    startedCollegeIn: 1999, 
    modelNumber: 2, 
    referenceNumber :'', 
    accountNumber : '', 
    cardAmount : 124223,
    typeOfFinancing : null, 
    financialCards: null

  });

  user: User; 
  authorityName: string = '';
  unassignedAuthorities: Authority[] = [];
  password = '';

  form!: FormGroup;
  submitted = false; 

  constructor(private studentService: StudentService,
     private formBuilder: FormBuilder,
     private roleService: RoleGuard,
     private location : Location) { 

      this.user = new User({
        id: 0, 
        username: '',
        password: '',
        authorities: []
      });
     }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      firstName: [
        '',
        [
          Validators.required, 
          Validators.minLength(3),
          Validators.maxLength(13)
        ] 
      ],
      lastName: [
        '',
        [
          Validators.required, 
          Validators.minLength(3),
          Validators.maxLength(13)
        ] 
      ],
      cardNumber: [
        '',
        [
          Validators.required, 
          Validators.minLength(3),
          Validators.maxLength(13)
        ] 
      ],
      phoneNumber: [
        '',
        [
          Validators.required, 
        ] 
      ],
      email: ['', [Validators.required, Validators.email]],
      umnc: [
        '',
        [
          Validators.required, 
          Validators.minLength(9),
          Validators.maxLength(13)
        ] 
      ],
      startedCollegeIn: [0, Validators.required], 
      modelNumber: [0, Validators.required],
      referenceNumber: ['', Validators.required],
      accountNumber: ['', Validators.required],
      cardAmount: [0, Validators.required] 
    });

    this.roleService.getUnassignedAuthorities('newUser').
        subscribe(res => {
          this.unassignedAuthorities = []; 
          this.unassignedAuthorities = res.body == null ? []:res.body;
        })
  }

  get f(): { [key: string]: AbstractControl} { return this.form.controls;}

  saveStudent() {
    const data = {
     cardNumber : this.student.cardNumber,
     firstName: this.student.firstName, 
     lastName: this.student.lastName, 
     phoneNumber: this.student.phoneNumber, 
     email: this.student.email, 
     umnc: this.student.umnc, 
     startedCollegeIn: this.student.startedCollegeIn, 
     modelNumber: this.student.modelNumber,  
     referenceNumber : this.student.referenceNumber, 
     accountNumber : this.student.accountNumber, 
     cardAmount : this.student.cardAmount,
     typeOfFinancing : this.student.typeOfFinancing, 
     financialCards: this.student.financialCards
    }; 

    this.studentService.create(data)
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

  saveUser() {
    this.user.password = this.password; 
    this.roleService.addUser(this.user)
    .subscribe(res => {
      this.goBack();
    });
 }

 goBack() : void {
   this.location.back();
 }

  newStudent(){
    this.submitted = false; 
    this.student = {
      user: null,
      cardNumber : '',
      firstName: '', 
      lastName: '', 
      phoneNumber: '', 
      email: '', 
      umnc: '', 
      startedCollegeIn: 1999, 
      modelNumber: 2, 
      referenceNumber :'', 
      accountNumber : '', 
      cardAmount : 124223,
      typeOfFinancing : null, 
      financialCards: null
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

  assignAuthority() {
    console.log("Authority: " + this.authorityName); 
    const a = this.unassignedAuthorities.filter(a => a.name === this.authorityName)[0];
    if(a!== undefined) {
      this.user.authorities.push(a);
      this.unassignedAuthorities = this.unassignedAuthorities.filter( a => a.name!==this.authorityName);
      console.log(JSON.stringify(this.unassignedAuthorities));
    }else {
      alert("Select authority for user!");
    }
  }

  removeAuthority(name: string) {
    var a:Authority[] = this.user.authorities.filter(a => a.name===name)
    this.user.authorities=this.user.authorities.filter(a => a.name!==name);
    this.unassignedAuthorities.push(a[0]);
    console.log(JSON.stringify(this.unassignedAuthorities));
  } 
}
