import { Component, OnInit } from '@angular/core';
import { ExamService } from '../exam/exam.service';
import { Exam } from '../model/exam';

@Component({
  selector: 'app-admin-list-exam',
  templateUrl: './admin-list-exam.component.html',
  styleUrls: ['./admin-list-exam.component.css']
})
export class AdminListExamComponent implements OnInit {

  exams: Exam[] = [];
  currentExam: Exam; 
  currentIndex = -1; 
  name = '';

  page = 1;
  count = 0;
  pageSize = 3;
  pageSizes = [3, 6, 9];


  constructor(private examService: ExamService) { }

  ngOnInit(): void {
    this.retrieveExams(); 
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

  retrieveExams(): void {
    const params = this.getRequestParams(this.name, this.page, this.pageSize);

    this.examService.getAll(params)
    .subscribe(
      response => {
        const { exams, totalItems } = response;
        this.exams = exams;
        this.count = totalItems;
        console.log(response);
      },
      error => {
        console.log(error);
      });
  }

  handlePageChange(event: number): void {
    this.page = event;
    this.retrieveExams();
  }

  handlePageSizeChange(event: any): void {
    this.pageSize = event.target.value;
    this.page = 1;
    this.retrieveExams();
  }

  refreshList(): void {
    this.retrieveExams();
    this.currentIndex = -1; 
    this.currentExam= null;
  }

  setActiveExamPeriod(exam : null | any, index=-1) : void {
    this.currentExam = exam;
    this.currentIndex = index;
  }

  searchName(): void {
    this.page = 1;
    this.retrieveExams();
  }
  
}



