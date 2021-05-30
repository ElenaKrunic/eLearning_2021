import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { FinancialcardService } from '../financialcard-student/financialcard.service';
import { FinancialCard } from '../model/financial-card';

@Component({
  selector: 'app-admin-financial-card',
  templateUrl: './admin-financial-card.component.html',
  styleUrls: ['./admin-financial-card.component.css']
})
export class AdminFinancialCardComponent implements OnInit {

  financialCards : FinancialCard[];
  subscription : Subscription; 

  constructor(private financialCardService : FinancialcardService, private router : Router) { 
    this.getFinancialCards();
  }

  getFinancialCards(){
    this.financialCardService.getFinancialCards().subscribe(res =>
      this.financialCards = res.body);
  }

  ngOnInit(): void {
    this.getFinancialCards();
  }

  gotoAdd(): void {
    this.router.navigate(["/addFinancialCard"]); 
  }

  gotoEdit(financialCard : FinancialCard) : void {
    this.router.navigate(['/editFinancialCard', financialCard.id]);
  }

  deleteFinancialCard(financialCardId : number) : void {
    this.financialCardService.deleteFinancialCard(financialCardId).subscribe(
      () => this.getFinancialCards()
    );
  }

}
