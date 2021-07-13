import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { Payment } from '../model/payment';
import { PaymentService } from '../payment/payment.service';

@Component({
  selector: 'app-payment-details',
  templateUrl: './payment-details.component.html',
  styleUrls: ['./payment-details.component.css']
})
export class PaymentDetailsComponent implements OnInit {

  payment: Payment = new Payment({
    dateOfPayment : '', 
    paymentAmount : 0, 
    paymentDescription : '',
    // financialCard : null
  });

  mode : string = 'ADD'; 

  constructor(private paymentService : PaymentService, private route: ActivatedRoute, private location: Location, private router : Router) { }

  ngOnInit(): void {
    if(this.route.snapshot.params['id']) {
      this.route.params.pipe(switchMap((params: Params) => 
      this.paymentService.getPayment(+params['id'])))
      .subscribe(res => {
        this.payment = res.body;
      })
    }
  }

  private edit() : void {
    this.paymentService.editPayment(this.payment)
    .subscribe(payment => {
      this.paymentService.announceChange();
      this.goBack();
    });
  }

  goBack() : void {
    this.location.back();
  }

  private add() : void {
    this.paymentService.addPayment(this.payment)
    .subscribe(res => {
      this.paymentService.announceChange();
      this.goBack();
    });
  }

  save() : void {
    this.mode == 'ADD' ? this.add() : this.edit();
  } 

}
