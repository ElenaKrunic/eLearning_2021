import { Component, OnInit } from '@angular/core';
import { FinancialcardService } from '../financial-card/financialcard.service';
import { FinancialCard } from '../model/financial-card';

@Component({
  selector: 'app-admin-add-financial-card',
  templateUrl: './admin-add-financial-card.component.html',
  styleUrls: ['./admin-add-financial-card.component.css']
})
export class AdminAddFinancialCardComponent implements OnInit {

  financialCard: FinancialCard = new FinancialCard({
    initialState: 0, 
    totalPayment : 0, 
    totalPayout : 0, 
    totalCost : 0,
    student : null
  });

  submitted = false; 

  constructor(private financialCardService : FinancialcardService) { }

  ngOnInit(): void {
  }

  saveFinancialCard() {
    const data = {
      initialState: this.financialCard.initialState, 
      totalPayment : this.financialCard.totalPayment, 
      totalPayout : this.financialCard.totalPayout, 
      totalCost : this.financialCard.totalCost
    }; 

    this.financialCardService.create(data)
    .subscribe(
      response => {
        console.log(response); 
        this.submitted = true; 
      },
      error => {
        console.log(error);
      }
    );
  }

  newFinancialCard(){
    this.submitted = false; 
    this.financialCard = {
      initialState: 0, 
      totalPayment : 0, 
      totalPayout : 0, 
      totalCost : 0,
      student : null
    };
  }

}
