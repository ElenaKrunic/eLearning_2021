import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ExamService } from '../exam/exam.service';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Exam } from '../model/exam';

@Component({
  selector: 'app-admin-details-exam',
  templateUrl: './admin-details-exam.component.html',
  styleUrls: ['./admin-details-exam.component.css']
})
export class AdminDetailsExamComponent implements OnInit {

  constructor(private examService: ExamService, private route : ActivatedRoute, private router: Router, private formBuilder: FormBuilder) { }
  currentExam : Exam = {} as Exam; 
  message = '';
  form!: FormGroup;
  submitted=false;
  ngOnInit(): void {
    this.message = '';
    this.getExam(this.route.snapshot.paramMap.get('id'));
    this.form = this.formBuilder.group({
      
      points:[0, Validators.required],
      examDate: ['', Validators.required], 
      grade: [0, Validators.required],
      status:[true]
    });
  }

  getExam(id: any) : void {
    this.examService.get(id)
    .subscribe(
      data => {
        this.currentExam = data; 
        console.log(data); 
      }, 
      error => {
        console.log(error);
      }
    );
  }
  
  updateExam(): void {
    this.examService.update(this.currentExam.id, this.currentExam)
    .subscribe(
      response => {
        console.log(response); 
        this.message =  "You successfully updated exam !";
      },
      error => {
        console.log(error);
      }
    );
  }

  deleteExam() : void {
    this.examService.delete(this.currentExam.id)
    .subscribe(
      response => {
        console.log(response); 
        this.router.navigate(['/exams']);
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
