import { Component, OnInit } from '@angular/core';
import { ExamPeriodService } from '../exam-period/exam-period.service';
import { ExamPeriod } from '../model/exam-period';

@Component({
  selector: 'app-admin-list-exam-period',
  templateUrl: './admin-list-exam-period.component.html',
  styleUrls: ['./admin-list-exam-period.component.css']
})
export class AdminListExamPeriodComponent implements OnInit {

  examPeriods: any; 
  currentExamPeriod: null | any; 
  currentIndex = -1; 
  name = '';

  constructor(private examPeriodService: ExamPeriodService) { }

  ngOnInit(): void {
    this.retrieveExamPeriods(); 
  }

  retrieveExamPeriods() : void {
    this.examPeriodService.getAll()
    .subscribe(
      data => {
        this.examPeriods = data;
        console.log(data); 
      },
      error => {
        console.log(error);
      }
    );
  }

  refreshList(): void {
    this.retrieveExamPeriods();
    this.currentIndex = -1; 
    this.currentExamPeriod= null;
  }

  setActiveExamPeriod(examPeriod : null | any, index=-1) : void {
    this.currentExamPeriod = examPeriod;
    this.currentIndex = index;
  }
  
}
