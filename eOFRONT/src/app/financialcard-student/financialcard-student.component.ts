import { Location } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { AuthenticationService } from '../login/authentication.service';
import { FinancialCard } from '../model/financial-card';
import { Student } from '../model/student';
import { StudentService } from '../students/student.service';

@Component({
  selector: 'app-financialcard-student',
  templateUrl: './financialcard-student.component.html',
  styleUrls: ['./financialcard-student.component.css']
})
export class FinancialcardStudentComponent implements OnInit {
  student:Student ;
  // = {
  //   id: 0,
  //   firstName: "",
  //   phoneNumber:"",
  //   email:"",
  //   umnc:"",
  //   startedCollegeIn:0,
  //   modelNumber:0,
  //   referenceNumber:null,
  //   cardAmount:0,
  //   typeOfFinancing:{
  //     id:0,
  //     name:"",
  //     code:""
  //   },
  //   lastName: "",
  //   cardNumber: "",
  //   financialCards:{
  //     id:0,
  //     initialState:0,
  //     totalPayment:0,
  //     totalPayout:0,
  //     totalCost:0

  //   },
  //   accountNumber: "",
  //   user: {
  //     username: "",
  //     password: ""
  //   }
  // };
  financialCard: FinancialCard= {
    initialState : 0,
    totalPayment : 0,
    totalPayout: 0, 
    totalCost : 0,
    // student : null
  };
  
    

   constructor(private studentService: StudentService, private route: ActivatedRoute,private authService:AuthenticationService,private router:Router,private location:Location) {
    
   }
   
  //  getMe():void{
  //   this.studentService.getMeAgain().subscribe(res =>( this.student=res));
  //   console.log(this.student);
  // }
 

	 ngOnInit(): void {
    //  this.getMe();
    this.studentService.getMeAgain().subscribe(res =>{( this.student=res)
    
    this.studentService.getStudentFinancialCard(res).subscribe(res=>this.financialCard=res);
  });
    // this.getFinancialCard();
    }
  // getFinancialCard(){
  //   this.studentService.getStudentFinancialCard(this.student).subscribe(res=>this.financialCard=res);
  //   console.log(this.financialCard);
  // }
 
  goBack() : void {
    this.location.back();
  }

}
