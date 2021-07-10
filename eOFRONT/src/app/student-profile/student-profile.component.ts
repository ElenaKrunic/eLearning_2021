import { Component, Input, OnInit } from '@angular/core';
import { Student } from '../model/student';
import { Location } from '@angular/common';
import { ActivatedRoute, Params } from '@angular/router';
import { StudentService } from '../students/student.service';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-student-profile',
  templateUrl: './student-profile.component.html',
  styleUrls: ['./student-profile.component.css']
})

export class StudentProfileComponent implements OnInit {
 
  student:Student;
  constructor(private location:Location,private studentService: StudentService, private route: ActivatedRoute) {}
   

  ngOnInit(): void {
    this.getStudentDetails();
  }

  getStudentDetails() {
    this.studentService.getStudent().subscribe( res=>this.student=res.body);
  }
  goBack(): void {
    this.location.back();
  }

}
