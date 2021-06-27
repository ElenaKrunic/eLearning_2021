import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PaymentService } from '../payment/payment.service';

@Component({
  selector: 'app-admin-details-payment',
  templateUrl: './admin-details-payment.component.html',
  styleUrls: ['./admin-details-payment.component.css']
})
export class AdminDetailsPaymentComponent implements OnInit {

  currentPayment: any | null; 
  message = '';

  constructor(private paymentService: PaymentService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.message = ''; 
    this.getPayment(this.route.snapshot.paramMap.get('id'));
  }

  getPayment(id: any) : void {
    this.paymentService.get(id)
    .subscribe(
      data => {
        this.currentPayment = data; 
        console.log(data); 
      }, 
      error => {
        console.log(error);
      }
    );
  }
  
  updatePayment(): void {
    this.paymentService.update(this.currentPayment.id, this.currentPayment)
    .subscribe(
      response => {
        console.log(response); 
        this.message =  "You successfully updated payment!";
      },
      error => {
        console.log(error);
      }
    );
  }

  deletePayment() : void {
    this.paymentService.delete(this.currentPayment.id)
    .subscribe(
      response => {
        console.log(response); 
        this.router.navigate(['/payments']);
      }, 
      error => {
        console.log(error); 
      }
    );
  }

}
