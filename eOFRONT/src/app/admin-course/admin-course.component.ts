import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { CoursesService } from '../courses/courses.service';
import { Course } from '../model/course';

@Component({
  selector: 'app-admin-course',
  templateUrl: './admin-course.component.html',
  styleUrls: ['./admin-course.component.css']
})
export class AdminCourseComponent implements OnInit {

  courses : Course[];
  subscription : Subscription;

  constructor(private courseService: CoursesService, private router: Router) {
    this.getCourses();
   }

  ngOnInit(): void {
    this.getCourses();
  }
  getCourses(){
    this.courseService.getCourses().subscribe(res =>
      this.courses = res.body);
  }
  gotoAdd() : void {
    this.router.navigate(["/addCourse"]);
  }
  gotoEdit(course : Course) : void {
    this.router.navigate(['/editCourse', course.id]);
  } 
  deleteCourse(courseId : number) : void {
    this.courseService.deleteCourse(courseId).subscribe(
      () => this.getCourses()
    );
  }

}
