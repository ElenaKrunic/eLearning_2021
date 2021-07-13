import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../login/authentication.service';
import { Payment } from '../model/payment';
import { StudentService } from '../students/student.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
   payments?: Payment[];

    //  subscription: Subscription;

  constructor(private studentService: StudentService, private router: Router,private authService:AuthenticationService) {
    //  this.subscription = studentService.RegenerateData$.subscribe(() =>
    //   //  this.getPayment(studentId?:number)

    //  );
   }

  ngOnInit(): void {
    // this.getPayment(studentId);
  }

  getPayment(studentId:any)
  {
    this.studentService.getStudentPayment(studentId);
  }

}
