import { Component, OnInit } from '@angular/core';
import { ExamPeriodService } from '../exam-period/exam-period.service';
import { ExamPeriod } from '../model/exam-period';

@Component({
  selector: 'app-admin-list-exam-period',
  templateUrl: './admin-list-exam-period.component.html',
  styleUrls: ['./admin-list-exam-period.component.css']
})
export class AdminListExamPeriodComponent implements OnInit {

  examPeriods: ExamPeriod[] = [];
  currentExamPeriod: ExamPeriod; 
  currentIndex = -1; 
  name = '';

  page = 1;
  count = 0;
  pageSize = 3;
  pageSizes = [3, 6, 9];

  constructor(private examPeriodService: ExamPeriodService) { }

  ngOnInit(): void {
    this.retrieveExamPeriods(); 
  }

  getRequestParams(searchName: string, page: number, pageSize: number): any {
    let params: any = {};

    if (searchName) {
      params[`name`] = searchName;
    }

    if (page) {
      params[`page`] = page - 1;
    }

    if (pageSize) {
      params[`size`] = pageSize;
    }

    return params;
  }

  retrieveExamPeriods(): void {
    const params = this.getRequestParams(this.name, this.page, this.pageSize);

    this.examPeriodService.getAll(params)
    .subscribe(
      response => {
        const { examPeriods, totalItems } = response;
        this.examPeriods = examPeriods;
        this.count = totalItems;
        console.log(response);
      },
      error => {
        console.log(error);
      });
  }

  handlePageChange(event: number): void {
    this.page = event;
    this.retrieveExamPeriods();
  }

  handlePageSizeChange(event: any): void {
    this.pageSize = event.target.value;
    this.page = 1;
    this.retrieveExamPeriods();
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

  searchName(): void {
    this.page = 1;
    this.retrieveExamPeriods();
  }
  
}
