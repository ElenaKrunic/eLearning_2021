import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FinancialcardService } from '../financial-card/financialcard.service';

@Component({
  selector: 'app-admin-details-financial-card',
  templateUrl: './admin-details-financial-card.component.html',
  styleUrls: ['./admin-details-financial-card.component.css']
})
export class AdminDetailsFinancialCardComponent implements OnInit {

  currentFinancialCard: any | null; 
  message = '';

  constructor(private financialCardService: FinancialcardService, private route : ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getFinancialCard(this.route.snapshot.paramMap.get('id'));
  }

  getFinancialCard(id: any) : void {
    this.financialCardService.get(id)
    .subscribe(
      data => {
        this.currentFinancialCard = data; 
        console.log(data); 
      }, 
      error => {
        console.log(error);
      }
    );
  }
  
  updateFinancialCard(): void {
    this.financialCardService.update(this.currentFinancialCard.id, this.currentFinancialCard)
    .subscribe(
      response => {
        console.log(response); 
        this.message =  "You successfully updated financial card!";
      },
      error => {
        console.log(error);
      }
    );
  }

  deleteFinancialCard() : void {
    this.financialCardService.delete(this.currentFinancialCard.id)
    .subscribe(
      response => {
        console.log(response); 
        this.router.navigate(['/financialCards']);
      }, 
      error => {
        console.log(error); 
      }
    );
  }

}
