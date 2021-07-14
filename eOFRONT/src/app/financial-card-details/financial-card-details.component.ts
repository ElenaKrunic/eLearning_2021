import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { FinancialcardService } from '../financial-card/financialcard.service';
import { FinancialCard } from '../model/financial-card';

@Component({
  selector: 'app-financial-card-details',
  templateUrl: './financial-card-details.component.html',
  styleUrls: ['./financial-card-details.component.css']
})
export class FinancialCardDetailsComponent implements OnInit {

  financialCard: FinancialCard = new FinancialCard({
    initialState : 0,
    totalPayment : 0,
    totalPayout: 0, 
    totalCost : 0  });

  mode: string = 'ADD'; 

  constructor(private financialCardService : FinancialcardService, private route: ActivatedRoute, private location: Location, private router : Router) { }

  ngOnInit(): void {
    if(this.route.snapshot.params['id']) {
      this.route.params.pipe(switchMap((params : Params) =>
      this.financialCardService.getFinancialCard(+params['id'])))
      .subscribe(res => {
        this.financialCard = res.body;
      });
    }
  }

  save(): void {
    this.mode == 'ADD' ? this.add() : this.edit();
  }

  private add() : void {
    this.financialCardService.addFinancialCard(this.financialCard)
    .subscribe(res => {
      this.financialCardService.announceChange(); 
      this.goBack();
    })
  } 

  private edit() : void {
    this.financialCardService.editFinancialCard(this.financialCard)
    .subscribe(financialCard => {
      this.financialCardService.announceChange();
      this.goBack();
    });
  }

  goBack() : void {
    this.location.back();
  }

}
