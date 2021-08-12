import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ExamPeriodService } from '../exam-period/exam-period.service';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-admin-details-exam-period',
  templateUrl: './admin-details-exam-period.component.html',
  styleUrls: ['./admin-details-exam-period.component.css']
})
export class AdminDetailsExamPeriodComponent implements OnInit {

  currentExamPeriod : any | null; 
  message = '';
  form!: FormGroup;
  submitted=false;

  constructor(private examPeriodService: ExamPeriodService, private route : ActivatedRoute, private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.message = '';
    this.getExamPeriod(this.route.snapshot.paramMap.get('id'));
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

  getExamPeriod(id: any) : void {
    this.examPeriodService.get(id)
    .subscribe(
      data => {
        this.currentExamPeriod = data; 
        console.log(data); 
      }, 
      error => {
        console.log(error);
      }
    );
  }
  
  updateExamPeriod(): void {
    this.examPeriodService.update(this.currentExamPeriod.id, this.currentExamPeriod)
    .subscribe(
      response => {
        console.log(response); 
        this.message =  "You successfully updated exam period!";
      },
      error => {
        console.log(error);
      }
    );
  }

  deleteExamPeriod() : void {
    this.examPeriodService.delete(this.currentExamPeriod.id)
    .subscribe(
      response => {
        console.log(response); 
        this.router.navigate(['/examPeriods']);
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
