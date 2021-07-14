import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../login/authentication.service';
import { Payment } from '../model/payment';
import { Student } from '../model/student';
import { StudentService } from '../students/student.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  student:Student = {
    id: 1,
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
   payments?: Payment[];

   

  constructor(private studentService: StudentService, private router: Router,private authService:AuthenticationService) {
   
   }

  ngOnInit(): void {
    this.getPayment(this.student);
  }
  getMe():void{
    this.studentService.getStudentMe().subscribe( res => (this.student = res));
    console.log(this.student);
  }
  getPayment(student:Student){
    this.studentService.getStudentPayment(this.student).subscribe(res=>this.payments=res);
    console.log(this.payments);
  }

}
