import { Component, OnInit } from '@angular/core';
import { ExamService } from '../exam/exam.service';
import { Exam } from '../model/exam';

import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Enrollment } from '../model/enrollment';
import { ExamPeriod } from '../model/exam-period';

@Component({
  selector: 'app-admin-add-exam',
  templateUrl: './admin-add-exam.component.html',
  styleUrls: ['./admin-add-exam.component.css']
})
export class AdminAddExamComponent implements OnInit {

  exam: Exam = new Exam({
    grade: 5,
    points:0,
    examDate : new Date(), 
    status : true,

    examPeriod:null,
    enrollment:null



  });
  form!: FormGroup;
  submitted = false; 

  constructor(private examService: ExamService, private formBuilder: FormBuilder){ }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      
      grade: [5, Validators.required],
      points: [0, Validators.required],
      examDate: ['', Validators.required], 
      status: [true, Validators.required]
    });
  } get f(): { [key: string]: AbstractControl} { return this.form.controls;}

  saveExam() {
    const data = {
      grade : this.exam.grade,
      points : this.exam.points,
      examDate : this.exam.examDate, 
      status: this.exam.status
    }; 

    this.examService.create(data)
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

  newExam(){
    this.submitted = false; 
    this.exam = {
      grade: 5, 
      points: 0,
      examDate: new Date(),
      status: true,
      enrollment: null,
      examPeriod:null
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

}}
