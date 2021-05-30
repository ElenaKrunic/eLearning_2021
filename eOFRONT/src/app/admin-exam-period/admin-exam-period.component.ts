import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { ExamPeriodService } from '../exam-period/exam-period.service';
import { ExamPeriod } from '../model/exam-period';

@Component({
  selector: 'app-admin-exam-period',
  templateUrl: './admin-exam-period.component.html',
  styleUrls: ['./admin-exam-period.component.css']
})
export class AdminExamPeriodComponent implements OnInit {

  examPeriods : ExamPeriod[];
  subscription : Subscription;

  constructor(private examPeriodService: ExamPeriodService, private router: Router) {
    this.getExamPeriods();
   }

  ngOnInit(): void {
    this.getExamPeriods();
  }

  getExamPeriods(){
    this.examPeriodService.getExamPeriods().subscribe(res =>
       this.examPeriods = res.body);
  }

  gotoAdd() : void {
    this.router.navigate(["/addExamPeriod"]);
  }

  gotoEdit(examPeriod : ExamPeriod) : void {
    this.router.navigate(['/editExamPeriod', examPeriod.id]);
  } 

  deleteExamPeriod(examPeriodId : number) : void {
    this.examPeriodService.deleteExamPeriod(examPeriodId).subscribe(
      () => this.getExamPeriods()
    );
  }
}
