import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { PreexamObligation } from '../model/preexam-obligation';
import { PreexamObligationService } from '../preexam-obligation/preexam-obligation.service';

@Component({
  selector: 'app-admin-preexam-obligation',
  templateUrl: './admin-preexam-obligation.component.html',
  styleUrls: ['./admin-preexam-obligation.component.css']
})
export class AdminPreexamObligationComponent implements OnInit {

  preexamObligations : PreexamObligation[];
  subscription : Subscription;

  constructor(private preexamObligationService : PreexamObligationService, private router : Router) { 
    this.getPreexamObligations();
  }

  ngOnInit(): void {
    this.getPreexamObligations();
  }

  getPreexamObligations(){
    this.preexamObligationService.getAllPreexamObligations().subscribe(res =>
      this.preexamObligations = res.body);
  }

  gotoAdd() : void {
    this.router.navigate(["/addPreexamObligation"]);
  }

  gotoEdit(preexamObligation: PreexamObligation): void {
    this.router.navigate(["/editPreexamObligation", preexamObligation.id]);
  }

  deletePreexamObligation(preexamObligationId: number) : void {
    this.preexamObligationService.deletePreexamObligation(preexamObligationId).subscribe(
      () => this.getPreexamObligations()
    );
  }
}
