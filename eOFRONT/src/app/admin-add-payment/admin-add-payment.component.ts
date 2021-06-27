import { Component, OnInit } from '@angular/core';
import { Payment } from '../model/payment';
import { PaymentService } from '../payment/payment.service';

@Component({
  selector: 'app-admin-add-payment',
  templateUrl: './admin-add-payment.component.html',
  styleUrls: ['./admin-add-payment.component.css']
})
export class AdminAddPaymentComponent implements OnInit {

  payment: Payment = new Payment({
    dateOfPayment: '',
    paymentDescription : '', 
    paymentAmount: 0,
    financialCard : null
  });

  submitted = false;

  constructor(private paymentService: PaymentService) { }

  ngOnInit(): void {
  }

  savePayment() {
    const data = {
      dateOfPayment: this.payment.dateOfPayment,
      paymentDescription : this.payment.paymentDescription, 
      paymentAmount: this.payment.paymentAmount,
    }; 

    this.paymentService.create(data)
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

  newPayment(){
    this.submitted = false; 
    this.payment = {
      dateOfPayment: '',
      paymentDescription : '', 
      paymentAmount: 0,
      financialCard : null
    };
  }

}
