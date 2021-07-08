import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FinancialcardService } from '../financial-card/financialcard.service';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-admin-details-financial-card',
  templateUrl: './admin-details-financial-card.component.html',
  styleUrls: ['./admin-details-financial-card.component.css']
})
export class AdminDetailsFinancialCardComponent implements OnInit {

  currentFinancialCard: any | null; 
  message = '';
  form!: FormGroup;
  submitted=false;

  constructor(private financialCardService: FinancialcardService, private route : ActivatedRoute, private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.message = '';
    this.getFinancialCard(this.route.snapshot.paramMap.get('id'));
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

  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

  onSubmit(): void {
    this.submitted = true;

    if (this.form.invalid) {
      return;
    }

    console.log(JSON.stringify(this.form.value, null, 2));
  }

  onReset(): void {
    this.submitted = false;
    this.form.reset();
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
        this.router.navigate(['/financialCards']);
        //this.message =  "You successfully updated financial card!";
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
