import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ExamPeriodService } from '../exam-period/exam-period.service';

@Component({
  selector: 'app-admin-details-exam-period',
  templateUrl: './admin-details-exam-period.component.html',
  styleUrls: ['./admin-details-exam-period.component.css']
})
export class AdminDetailsExamPeriodComponent implements OnInit {

  currentExamPeriod : any | null; 
  message = '';

  constructor(private examPeriodService: ExamPeriodService, private route : ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getExamPeriod(this.route.snapshot.paramMap.get('id'));
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
        this.message =  "Uspjesno ste izmijenili ispitni rok!";
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

  /*
  getExamPeriod(id: any) : void {
    this.examPeriodService.getExamPeriod(id)
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

  updateExamPeriod() : void {
    this.examPeriodService.updateExamPeriod(this.currentExamPeriod.id, this.currentExamPeriod)
    .subscribe(
      response => {
        console.log(response); 
        this.message = "Uspjesno ste izmijeniti ispitni rok!"; 
      },
      error => {
        console.log(error); 
      }
    );
  }

  deleteExamPeriod(): void {
    this.examPeriodService.deleteExamPeriod(this.currentExamPeriod.id)
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
  */

}
