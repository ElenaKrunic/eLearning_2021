import { HttpHeaders } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, Subscription } from 'rxjs';
import { AuthenticationService } from '../login/authentication.service';
import { FinancialCard } from '../model/financial-card';
import { StudentService } from '../students/student.service';
import { FinancialcardService } from './financialcard.service';

@Component({
  selector: 'app-financialcard-student',
  templateUrl: './financialcard-student.component.html',
  styleUrls: ['./financialcard-student.component.css']
})
export class FinancialcardStudentComponent implements OnInit {

   financialcards?: FinancialCard[];

  //  subscription: Subscription;

  

   constructor(private studentService: StudentService, private router: Router,private authService:AuthenticationService) {
    //  this.subscription = studentService.RegenerateData$.subscribe(() =>
    //   //  this.getFinancialCard(studentId?:number)

    //  );
   }

	ngOnInit() {
    // this.getFinancialCard(studentId:number);
  }
  getFinancialCard(studentId:number)
    {
      this.studentService.getStudentFinancialCard(studentId);
    }

}
