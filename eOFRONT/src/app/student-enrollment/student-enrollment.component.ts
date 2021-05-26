import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../login/authentication.service';
import { Document } from '../model/document';
import { StudentService } from '../students/student.service';

@Component({
  selector: 'app-student-enrollment',
  templateUrl: './student-enrollment.component.html',
  styleUrls: ['./student-enrollment.component.css']
})
export class StudentEnrollmentComponent implements OnInit {
  documents?: Document[];

  //  subscription: Subscription;
  constructor(private studentService: StudentService, private router: Router,private authService:AuthenticationService) { 
    //  this.subscription = studentService.RegenerateData$.subscribe(() =>
    //   //  this.getEnrollment(studentId?:number)

    //  );
  }

  ngOnInit(): void {
    // this.getEnrollment(studentId:number);
  }

  getEnrollment(studentId:number){
    this.studentService.getStudentEnrollment(studentId);
  }

}
