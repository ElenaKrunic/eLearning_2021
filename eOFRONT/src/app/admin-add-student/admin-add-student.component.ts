import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Student } from '../model/student';
import { StudentService } from '../students/student.service';

@Component({
  selector: 'app-admin-add-student',
  templateUrl: './admin-add-student.component.html',
  styleUrls: ['./admin-add-student.component.css']
})
export class AdminAddStudentComponent implements OnInit {

  student : Student = new Student({
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

  form!: FormGroup;
  submitted = false; 

  constructor(private studentService: StudentService, private formBuilder: FormBuilder) { }

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
      UMNC: [
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
    });
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

  newStudent(){
    this.submitted = false; 
    this.student = {
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
}
