import { Component, OnInit } from '@angular/core';
import { Course } from '../model/course';
import { CoursesService } from '../courses/courses.service';


import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-admin-add-course',
  templateUrl: './admin-add-course.component.html',
  styleUrls: ['./admin-add-course.component.css']
})
export class AdminAddCourseComponent implements OnInit {


  course: Course = new Course({
    title: '',
    courseCode: '',
    startDate : new Date(), 
    endDate: new Date(),
    ects : 0
  });

  form!: FormGroup;
  submitted = false; 
  constructor(private courseService: CoursesService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      title: [
        '',
        [
          Validators.required, 
          Validators.minLength(5),
          Validators.maxLength(20)
        ] 
      ],
      courseCode:['',Validators.required],
      startDate: ['', Validators.required], 
      endDate: ['', Validators.required],
      ects: [0, Validators.required]
    });
  }

  get f(): { [key: string]: AbstractControl} { return this.form.controls;}

  saveCourse() {
    const data = {
      title : this.course.title,
      courseCode : this.course.courseCode,
      startDate : this.course.startDate,
      endDate : this.course.endDate, 
      ects: this.course.ects
    }; 

    this.courseService.create(data)
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

  newCourse(){
    this.submitted = false; 
    this.course = {
      title: '', 
      courseCode:'',
      startDate: new Date(),
      endDate: new Date(),
      ects: 0
    };
  }

  onSubmit(): void {
    this.submitted = true;

    if (this.form.invalid) {
      return;
    }

    console.log(JSON.stringify(this.form.value, null, 2));
  }

  onReset(): void {
    this.submitted = false;
    this.form.reset();
  }
  }


