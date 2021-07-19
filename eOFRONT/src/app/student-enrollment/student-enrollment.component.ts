
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { AuthenticationService } from '../login/authentication.service';
import { Enrollment } from '../model/enrollment';
import { switchMap } from 'rxjs/operators';
import { StudentService } from '../students/student.service';
import { Student } from '../model/student';
import { Location } from '@angular/common';

@Component({
  selector: 'app-student-enrollment',
  templateUrl: './student-enrollment.component.html',
  styleUrls: ['./student-enrollment.component.css']
})
export class StudentEnrollmentComponent implements OnInit {
  
  enrollments: Enrollment[];
  student:Student = {
    id: 0,
    firstName: "",
    phoneNumber:"",
    email:"",
    umnc:"",
    startedCollegeIn:0,
    modelNumber:0,
    referenceNumber:null,
    cardAmount:0,
    typeOfFinancing:{
      id:0,
      name:"",
      code:""
    },
    lastName: "",
    cardNumber: "",
    financialCards:{
      id:0,
      initialState:0,
      totalPayment:0,
      totalPayout:0,
      totalCost:0

    },
    accountNumber: "",
    user: {
      username: "",
      password: "",
      authorities: []
    }
  };
  
   constructor(private studentService: StudentService, private router: Router,private authService:AuthenticationService,private route:ActivatedRoute,private location:Location) { 
  
  }
  // getMe():void{
  //   this.studentService.getMeAgain().subscribe(res =>( this.student=res));
  //   console.log(this.student);
  // }
  // getStudentEnrollment(student:Student){
  //   this.studentService.getStudentEnrollment(this.student).subscribe(res=>this.enrollments=res);
  // }

  ngOnInit(): void {
    this.studentService.getMeAgain().subscribe(res =>{( this.student=res)
      this.studentService.getStudentEnrollment(res).subscribe(res=>this.enrollments=res);

    });
   
    // this.getStudentEnrollment(this.student);
  }
  goBack(): void {
    this.location.back();
  }
  

}
