import { Component, OnInit } from '@angular/core';
import { FinancialcardService } from '../financial-card/financialcard.service';
import { FinancialCard } from '../model/financial-card';

import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';

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
    totalCost : 0
  });

  form! : FormGroup; 
  submitted = false; 

  constructor(private financialCardService : FinancialcardService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      initialState: [
        '',
        [
          Validators.required, 
          Validators.minLength(3),
          Validators.maxLength(9)
        ] 
      ],
      totalPayment: [
        '',
       [
        Validators.required, 
        Validators.minLength(3),
        Validators.maxLength(9)
       ]
      ],
      totalPayout: [
        '',
        [
          Validators.required, 
          Validators.minLength(3),
          Validators.maxLength(9)
        ] 
      ],
      totalCost: [
        '',
        [
          Validators.required, 
          Validators.minLength(3),
          Validators.maxLength(9)
        ] 
      ],
    });
  }

  get f(): { [key: string]: AbstractControl} {
    return this.form.controls;
  }

  onSubmit() : void {
    this.submitted = true; 

    if(this.form.invalid) {
      return; 
    }

    console.log(JSON.stringify(this.form.value, null, 2));
  }

  onReset() : void {
    this.submitted = false; 
    this.form.reset();
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
      totalCost : 0
    };
  }

}
