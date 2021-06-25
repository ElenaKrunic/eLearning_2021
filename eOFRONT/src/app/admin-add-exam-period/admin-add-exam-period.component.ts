import { Component, OnInit } from '@angular/core';
import { ExamPeriodService } from '../exam-period/exam-period.service';
import { ExamPeriod } from '../model/exam-period';

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

  submitted = false; 

  constructor(private examPeriodService: ExamPeriodService) { }

  ngOnInit(): void {
  }

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

  /*
  saveExamPeriod() {
    const data = {
      name : this.examPeriod.name, 
      startDate : this.examPeriod.startDate,
      endDate : this.examPeriod.endDate, 
      paymentAmount: this.examPeriod.paymentAmount
    }; 

    this.examPeriodService.addExamPeriod(data)
    .subscribe(
      response => {
        console.log(response); 
        this.submitted = true; 
      },
      error => {
        console.log(error)
      }
    );
  }

  newExamPeriod(){
    this.submitted=false; 
    this.examPeriod = {
      name : '',
      startDate: '',
      endDate : '', 
      paymentAmount: 0
    };
  }

  */

}
