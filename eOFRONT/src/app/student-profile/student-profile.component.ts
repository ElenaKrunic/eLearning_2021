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
      password: ""
    }
  };
  constructor(private location:Location,private studentService: StudentService, private route: ActivatedRoute) {}
   

 

  goBack(): void {
    this.location.back();
  }


 
  
 

  ngOnInit(): void {
    this.studentService.getStudentMe().subscribe( student => (this.student = student));
  }
}
