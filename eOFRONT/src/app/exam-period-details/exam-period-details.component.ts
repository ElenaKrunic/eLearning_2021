import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { ExamPeriodService } from '../exam-period/exam-period.service';
import { ExamPeriod } from '../model/exam-period';


@Component({
  selector: 'app-exam-period-details',
  templateUrl: './exam-period-details.component.html',
  styleUrls: ['./exam-period-details.component.css']
})
export class ExamPeriodDetailsComponent implements OnInit {

  examPeriod: ExamPeriod = new ExamPeriod({
    name: '',
    startDate : '', 
    endDate: '',
    paymentAmount : 0
  });

  mode: string = 'ADD';

  constructor(private examPeriodService: ExamPeriodService, private route: ActivatedRoute, private location: Location, private router : Router) { }

  ngOnInit(): void {
    if (this.route.snapshot.params['id']) {
      this.route.params.pipe(switchMap((params : Params) => 
      this.examPeriodService.getExamPeriod(+params['id'])))
      .subscribe(res => {
        this.examPeriod = res.body; 
      });
    }
  }

  save() : void {
    this.mode == 'ADD' ? this.add() : this.edit();
  }

  private add(): void {
    this.examPeriodService.addExamPeriod(this.examPeriod)
    .subscribe(res => {
      this.examPeriodService.announceChange();
      this.goBack();
    });
  }

  goBack(): void {
    this.location.back();
  }

  private edit() : void {
    this.examPeriodService.editExamPeriod(this.examPeriod)
    .subscribe(examPeriod => {
      this.examPeriodService.announceChange();
      this.goBack();
    });
  }
}
