import { Location } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../login/authentication.service';
import { Payout } from '../model/payout';
import { Student } from '../model/student';
import { StudentService } from '../students/student.service';

@Component({
  selector: 'app-payout',
  templateUrl: './payout.component.html',
  styleUrls: ['./payout.component.css']
})
export class PayoutComponent implements OnInit {
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
   payouts?:Payout[];
  constructor(private studentService: StudentService, private router: Router,private authService:AuthenticationService,private location:Location) { 
   
  }
  // getMe():void{
  //   this.studentService.getStudentMe().subscribe( res => (this.student = res));
  //   console.log(this.student);
  // }

  ngOnInit(): void {
    this.studentService.getStudentMe().subscribe( res => { (this.student = res)
      this.studentService.getStudentPayout(res).subscribe(res => this.payouts=res);
  
    });
    
   
  }
  goBack(): void {
    this.location.back();
  }
}
//   getPayout()
//   {
//     this.studentService.getStudentPayout(this.student).subscribe(res=>this.payouts=res);
//     console.log(this.payouts);  }
// }
