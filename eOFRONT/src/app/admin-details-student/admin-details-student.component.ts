import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from '../students/student.service';

@Component({
  selector: 'app-admin-details-student',
  templateUrl: './admin-details-student.component.html',
  styleUrls: ['./admin-details-student.component.css']
})
export class AdminDetailsStudentComponent implements OnInit {

  currentStudent: any | null; 
  message = ''; 
  form!: FormGroup; 
  submitted=false; 

  constructor(private studentService: StudentService, private route: ActivatedRoute, private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.message = '';
    this.getStudent(this.route.snapshot.paramMap.get('id'));
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

  getStudent(id: any) : void {
    this.studentService.get(id)
    .subscribe(
      data => {
        this.currentStudent = data; 
        console.log(data); 
      }, 
      error => {
        console.log(error);
      }
    );
  }
  
  updateStudent(): void {
    this.studentService.update(this.currentStudent.id, this.currentStudent)
    .subscribe(
      response => {
        console.log(response); 
      },
      error => {
        console.log(error);
      }
    );
  }

  deleteStudent() : void {
    this.studentService.delete(this.currentStudent.id)
    .subscribe(
      response => {
        console.log(response); 
        this.router.navigate(['/students']);
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
