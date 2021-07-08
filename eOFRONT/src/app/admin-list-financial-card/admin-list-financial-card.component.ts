import { Component, OnInit } from '@angular/core';
import { FinancialcardService } from '../financial-card/financialcard.service';
import { FinancialCard } from '../model/financial-card';

@Component({
  selector: 'app-admin-list-financial-card',
  templateUrl: './admin-list-financial-card.component.html',
  styleUrls: ['./admin-list-financial-card.component.css']
})
export class AdminListFinancialCardComponent implements OnInit {

  financialCards: FinancialCard[] = []; 
  currentFinancialCard: FinancialCard; 
  currentIndex = -1; 
  totalCost = 0;

  page = 1;
  count = 0;
  pageSize = 3;
  pageSizes = [3, 6, 9];

  constructor(private financialCardService: FinancialcardService) { }

  ngOnInit(): void {
    this.retrieveFinancialCards();
  }

  getRequestParams(totalCost: number, page: number, pageSize: number): any {
    let params: any = {};

    if (totalCost) {
      params[`totalCost`] = totalCost;
    }

    if (page) {
      params[`page`] = page - 1;
    }

    if (pageSize) {
      params[`size`] = pageSize;
    }

    return params;
  }

  retrieveFinancialCards() : void {
    const params = this.getRequestParams(this.totalCost, this.page, this.pageSize);

    this.financialCardService.getAll(params)
    .subscribe(
      response => {
        const {financialCards, totalItems} = response;
        this.financialCards = financialCards;
        this.count = totalItems;
        console.log(response); 
      },
      error => {
        console.log(error);
      }
    );
  }

  handlePageChange(event: number): void {
    this.page = event;
    this.retrieveFinancialCards();
  }

  handlePageSizeChange(event: any): void {
    this.pageSize = event.target.value;
    this.page = 1;
    this.retrieveFinancialCards();
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

  searchTotalCost() : void {
    this.page = 1; 
    this.retrieveFinancialCards();
  }

}
