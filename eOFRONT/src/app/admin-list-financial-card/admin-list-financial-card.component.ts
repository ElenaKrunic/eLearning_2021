import { Component, OnInit } from '@angular/core';
import { FinancialcardService } from '../financial-card/financialcard.service';

@Component({
  selector: 'app-admin-list-financial-card',
  templateUrl: './admin-list-financial-card.component.html',
  styleUrls: ['./admin-list-financial-card.component.css']
})
export class AdminListFinancialCardComponent implements OnInit {

  financialCards: any; 
  currentFinancialCard: null | any; 
  currentIndex = -1; 
  totalCost = 0;

  constructor(private financialCardService: FinancialcardService) { }

  ngOnInit(): void {
    this.retrieveFinancialCards();
  }

  retrieveFinancialCards() : void {
    this.financialCardService.getAll()
    .subscribe(
      data => {
        this.financialCards = data;
        console.log(data); 
      },
      error => {
        console.log(error);
      }
    );
  }

  refreshList(): void {
    this.retrieveFinancialCards();
    this.currentIndex = -1; 
    this.currentFinancialCard= null;
  }

  setActiveFinancialCard(financialCard : null | any, index=-1) : void {
    this.currentFinancialCard = financialCard;
    this.currentIndex = index;
  }


}
