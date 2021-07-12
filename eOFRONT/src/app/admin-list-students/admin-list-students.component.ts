import { Component, OnInit } from '@angular/core';
import { Student } from '../model/student';
import { StudentService } from '../students/student.service';

@Component({
  selector: 'app-admin-list-students',
  templateUrl: './admin-list-students.component.html',
  styleUrls: ['./admin-list-students.component.css']
})
export class AdminListStudentsComponent implements OnInit {

  students : Student[] = []; 
  currentStudent: Student; 
  currentIndex = -1; 
  firstName = '' ;
  lastName = ''; 

  page = 1;
  count = 0;
  pageSize = 3;
  pageSizes = [3, 6, 9];

  constructor(private studentService: StudentService) { }

  ngOnInit(): void {
    this.retrieveStudents();
  }

  getRequestParams(searchFirstName: string, page: number, pageSize: number): any {
    let params: any = {};

    if (searchFirstName) {
      params[`firstName`] = searchFirstName;
    }

    if (page) {
      params[`page`] = page - 1;
    }

    if (pageSize) {
      params[`size`] = pageSize;
    }

    return params;
  }

  retrieveStudents() : void {
    const params = this.getRequestParams(this.firstName, this.page, this.pageSize);
    this.studentService.getAll(params)
    .subscribe(
      response => {
        const { students, totalItems } = response;
        this.students = students;
        this.count = totalItems;
        console.log(response);
      },
      error => {
        console.log(error);
      });
  }

  handlePageChange(event: number): void {
    this.page = event;
    this.retrieveStudents();
  }

  handlePageSizeChange(event: any): void {
    this.pageSize = event.target.value;
    this.page = 1;
    this.retrieveStudents();
  }

  refreshList(): void {
    this.retrieveStudents();
    this.currentIndex = -1; 
    this.currentStudent= null;
  }

  setActiveStudent(student : null | any, index=-1) : void {
    this.currentStudent = student;
    this.currentIndex = index;
  }

  searchFirstName(): void {
    this.page = 1;
    this.retrieveStudents();
  }

}
