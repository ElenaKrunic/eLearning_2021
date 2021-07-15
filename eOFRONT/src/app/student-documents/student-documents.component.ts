import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { AuthenticationService } from '../login/authentication.service';
import { Location } from '@angular/common';
import { StudentService } from '../students/student.service';
import { switchMap } from 'rxjs/operators';

import { Student } from '../model/student';


@Component({
  selector: 'app-student-documents',
  templateUrl: './student-documents.component.html',
  styleUrls: ['./student-documents.component.css']
})
export class StudentDocumentsComponent implements OnInit {
  documents:Document[];
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
  
 
  constructor(private studentService: StudentService, private router: Router,private authService:AuthenticationService,private route:ActivatedRoute,private location:Location) { 
  
  }

  getMe():void{
    this.studentService.getStudentMe().subscribe( student => (this.student = student));

  }
  
  ngOnInit(): void {
    this.getDocuments(this.student);

  }
  getDocuments(student:Student){
    this.studentService.getStudentDocument(this.student).subscribe(res=>this.documents=this.documents)

  }
 
  

  goBack(): void {
    this.location.back();
  }

  }

