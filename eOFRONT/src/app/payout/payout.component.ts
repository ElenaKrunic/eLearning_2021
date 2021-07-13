import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../login/authentication.service';
import { Payout } from '../model/payout';
import { StudentService } from '../students/student.service';

@Component({
  selector: 'app-payout',
  templateUrl: './payout.component.html',
  styleUrls: ['./payout.component.css']
})
export class PayoutComponent implements OnInit {
   payouts?:Payout[];
   //  subscription: Subscription;
  constructor(private studentService: StudentService, private router: Router,private authService:AuthenticationService) { 
    //  this.subscription = studentService.RegenerateData$.subscribe(() =>
    //   //  this.getPayout(studentId?:number)

    //  );
  }

  ngOnInit(): void {
    // this.getPayout(studentId:number);
  }
  getPayout(studentId:number)
  {
    this.studentService.getStudentPayout(studentId);
  }
}
