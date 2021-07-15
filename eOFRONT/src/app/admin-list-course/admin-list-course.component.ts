import { Component, OnInit } from '@angular/core';
import { CoursesService } from '../courses/courses.service';
import { Course } from '../model/course';


@Component({
  selector: 'app-admin-list-course',
  templateUrl: './admin-list-course.component.html',
  styleUrls: ['./admin-list-course.component.css']
})
export class AdminListCourseComponent implements OnInit {


  courses: Course[] = [];
  currentCourse: Course; 
  currentIndex = -1; 
  title = '';
  page = 1;
  count = 0;
  pageSize = 3;
  pageSizes = [3, 6, 9];

  constructor(private cService: CoursesService) { }

  ngOnInit(): void {
    this.retrieveCourses(); 
  }

  getRequestParams(searchName: string, page: number, pageSize: number): any {
    let params: any = {};

    if (searchName) {
      params[`title`] = searchName;
    }

    if (page) {
      params[`page`] = page - 1;
    }

    if (pageSize) {
      params[`size`] = pageSize;
    }

    return params;
  }

  retrieveCourses(): void {
    const params = this.getRequestParams(this.title, this.page, this.pageSize);

    this.cService.getAll(params)
    .subscribe(
      response => {
        const { courses, totalItems } = response;
        this.courses = courses;
        this.count = totalItems;
        console.log(response);
      },
      error => {
        console.log(error);
      });
  }

  handlePageChange(event: number): void {
    this.page = event;
    this.retrieveCourses();
  }

  handlePageSizeChange(event: any): void {
    this.pageSize = event.target.value;
    this.page = 1;
    this.retrieveCourses();
  }

  refreshList(): void {
    this.retrieveCourses();
    this.currentIndex = -1; 
    this.currentCourse= null;
  }

  setActiveCourse(course : null | any, index=-1) : void {
    this.currentCourse = course;
    this.currentIndex = index;
  }

  searchName(): void {
    this.page = 1;
    this.retrieveCourses();
  }
  


}
