import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Payment } from '../model/payment';
import { PaymentService } from '../payment/payment.service';

@Component({
  selector: 'app-admin-payment',
  templateUrl: './admin-payment.component.html',
  styleUrls: ['./admin-payment.component.css']
})
export class AdminPaymentComponent implements OnInit {

  payments : Payment[];
  subscription : Subscription; 

  constructor(private paymentService: PaymentService, private router : Router) { 
    this.getPayments();
  }

  ngOnInit(): void {
    this.getPayments();
  }

  getPayments() { 
    this.paymentService.getPayments().subscribe(res =>
      this.payments = res.body);
  }

  gotoAdd() : void {
    this.router.navigate(['/addPayment']);
  }

  gotoEdit(payment : Payment) : void {
    this.router.navigate(['/editPayment', payment.id]);
  }

  deletePayment(paymentId: number) : void {
    this.paymentService.deletePayment(paymentId).subscribe(
      () => this.getPayments()
    );
  }

}
