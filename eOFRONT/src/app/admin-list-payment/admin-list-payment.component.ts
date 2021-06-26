import { Component, OnInit } from '@angular/core';
import { PaymentService } from '../payment/payment.service';

@Component({
  selector: 'app-admin-list-payment',
  templateUrl: './admin-list-payment.component.html',
  styleUrls: ['./admin-list-payment.component.css']
})
export class AdminListPaymentComponent implements OnInit {

  payments: any; 
  currentPayment: null | any; 
  currentIndex = -1; 
  name = '';
  paymentAmount = 0;

  constructor(private paymentService: PaymentService) { }

  ngOnInit(): void {
    this.retrievePayments();
  }

  retrievePayments() : void {
    this.paymentService.getAll()
    .subscribe(
      data => {
        this.payments = data;
        console.log(data); 
      },
      error => {
        console.log(error);
      }
    );
  }

  refreshList(): void {
    this.retrievePayments();
    this.currentIndex = -1; 
    this.currentPayment= null;
  }

  setActivePayment(payment : null | any, index=-1) : void {
    this.currentPayment = payment;
    this.currentIndex = index;
  }
}
