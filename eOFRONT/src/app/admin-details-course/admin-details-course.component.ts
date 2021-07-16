import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CoursesService } from '../courses/courses.service';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-admin-details-course',
  templateUrl: './admin-details-course.component.html',
  styleUrls: ['./admin-details-course.component.css']
})
export class AdminDetailsCourseComponent implements OnInit {
  
  currentCourse : any | null; 
  message = '';
  form!: FormGroup;
  submitted=false;

  constructor(private coursesService: CoursesService, private route : ActivatedRoute, private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.message = '';
    this.getCourse(this.route.snapshot.paramMap.get('id'));
    this.form = this.formBuilder.group({
      title: [
        '',
        [
          Validators.required, 
          Validators.minLength(4),
          Validators.maxLength(25)
        ] 
      ],
      courseCode:['', Validators.required],
      startDate: ['', Validators.required], 
      endDate: ['', Validators.required],
      ECTS: [0, Validators.required]
    });
  }

  getCourse(id: any) : void {
    this.coursesService.get(id)
    .subscribe(
      data => {
        this.currentCourse = data; 
        console.log(data); 
      }, 
      error => {
        console.log(error);
      }
    );
  }
  
  updateCourse(): void {
    this.coursesService.update(this.currentCourse.id, this.currentCourse)
    .subscribe(
      response => {
        console.log(response); 
        ;
      },
      error => {
        console.log(error);
      }
    );
  }

  deleteCourse() : void {
    this.coursesService.delete(this.currentCourse.id)
    .subscribe(
      response => {
        console.log(response); 
        this.router.navigate(['/courses']);
      }, 
      error => {
        console.log(error); 
      }
    );
  }

  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
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
