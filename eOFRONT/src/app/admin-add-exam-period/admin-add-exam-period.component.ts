import { Component, OnInit } from '@angular/core';
import { ExamPeriodService } from '../exam-period/exam-period.service';
import { ExamPeriod } from '../model/exam-period';

import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ValidationComponent } from '../validation/validation.component';

@Component({
  selector: 'app-admin-add-exam-period',
  templateUrl: './admin-add-exam-period.component.html',
  styleUrls: ['./admin-add-exam-period.component.css']
})
export class AdminAddExamPeriodComponent implements OnInit {

  examPeriod: ExamPeriod = new ExamPeriod({
    name: '',
    startDate : '', 
    endDate: '',
    paymentAmount : 0
  });

  form!: FormGroup;
  submitted = false; 

  constructor(private examPeriodService: ExamPeriodService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      name: [
        '',
        [
          Validators.required, 
          Validators.minLength(3),
          Validators.maxLength(13)
        ] 
      ],
      startDate: ['', Validators.required], 
      endDate: ['', Validators.required],
      paymentAmount: [0, Validators.required]
    });
  }

  get f(): { [key: string]: AbstractControl} { return this.form.controls;}

  saveExamPeriod() {
    const data = {
      name : this.examPeriod.name,
      startDate : this.examPeriod.startDate,
      endDate : this.examPeriod.endDate, 
      paymentAmount: this.examPeriod.paymentAmount
    }; 

    this.examPeriodService.create(data)
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

  newExamPeriod(){
    this.submitted = false; 
    this.examPeriod = {
      name: '', 
      startDate: '',
      endDate: '',
      paymentAmount: 445
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
