import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Exam } from '../model/exam';
import { PreexamObligation } from '../model/preexam-obligation';
import { PreexamObligationService } from '../preexam-obligation/preexam-obligation.service';

@Component({
  selector: 'app-admin-add-preexam-obligation',
  templateUrl: './admin-add-preexam-obligation.component.html',
  styleUrls: ['./admin-add-preexam-obligation.component.css']
})
export class AdminAddPreexamObligationComponent implements OnInit {

  preexamObligation: PreexamObligation = new PreexamObligation({
    dateOfObligation: null, 
    location : '',
    points: 0
  });
  submitted = false;
  form!: FormGroup;

  constructor(private preexamObligationService: PreexamObligationService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      dateOfObligation: [
        '',
        [
          Validators.required
        ] 
      ],
      location: ['', Validators.required], 
    });
  }

  get f(): { [key: string]: AbstractControl} { return this.form.controls;}

  savePreexamObligation(): void {
    const data = {
      dateOfObligation: this.preexamObligation.dateOfObligation,
      location: this.preexamObligation.location
    };

    this.preexamObligationService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  newPreexamObligation(): void {
    this.submitted = false;
    this.preexamObligation = {
     dateOfObligation: '',
     location: '',
     points: 0,
     passed: false, 
     exam: null,
     preexamObligationStatus: null, 
     preexamObligationType: null
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
