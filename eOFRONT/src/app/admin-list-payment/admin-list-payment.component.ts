import { Component, OnInit } from '@angular/core';
import { Payment } from '../model/payment';
import { PaymentService } from '../payment/payment.service';

@Component({
  selector: 'app-admin-list-payment',
  templateUrl: './admin-list-payment.component.html',
  styleUrls: ['./admin-list-payment.component.css']
})
export class AdminListPaymentComponent implements OnInit {

  payments: Payment[] = []; 
  currentPayment: Payment; 
  currentIndex = -1; 
  name = '';
  paymentAmount = 0;

  page = 1;
  count = 0;
  pageSize = 3;
  pageSizes = [3, 6, 9];

  constructor(private paymentService: PaymentService) { }

  ngOnInit(): void {
    this.retrievePayments();
  }

  getRequestParams(paymentAmount: number, page: number, pageSize: number): any {
    let params: any = {};

    if (paymentAmount) {
      params[`paymentAmount`] = paymentAmount;
    }

    if (page) {
      params[`page`] = page - 1;
    }

    if (pageSize) {
      params[`size`] = pageSize;
    }

    return params;
  }

  retrievePayments() : void {
    const params = this.getRequestParams(this.paymentAmount, this.page, this.pageSize);

    this.paymentService.getAll(params)
    .subscribe(
      response => {
        const {payments, totalItems} = response;
        this.payments = payments;
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
    this.retrievePayments();
  }

  handlePageSizeChange(event: any): void {
    this.pageSize = event.target.value;
    this.page = 1;
    this.retrievePayments();
  }

  searchPaymentAmount() : void {
    this.page = 1; 
    this.retrievePayments();
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
