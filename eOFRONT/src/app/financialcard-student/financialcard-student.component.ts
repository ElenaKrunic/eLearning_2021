import { Location } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { AuthenticationService } from '../login/authentication.service';
import { FinancialCard } from '../model/financial-card';
import { StudentService } from '../students/student.service';

@Component({
  selector: 'app-financialcard-student',
  templateUrl: './financialcard-student.component.html',
  styleUrls: ['./financialcard-student.component.css']
})
export class FinancialcardStudentComponent implements OnInit {

  financialCard: FinancialCard = new FinancialCard({
    initialState : 0,
    totalPayment : 0,
    totalPayout: 0, 
    totalCost : 0,
    student : null
  });
  

   constructor(private studentService: StudentService, private route: ActivatedRoute,private authService:AuthenticationService,private router:Router,private location:Location) {
    
   }

	 ngOnInit(): void {
    if(this.route.snapshot.params['id']) {
      this.route.params.pipe(switchMap((params : Params) =>
      this.studentService.getStudentFinancialCard(+params['id'])))
      .subscribe(res => {
        this.financialCard = res;
      });
    }
  }
  goBack() : void {
    this.location.back();
  }

}
