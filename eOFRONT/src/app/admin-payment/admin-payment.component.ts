import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Payment } from '../model/payment';

@Component({
  selector: 'app-admin-payment',
  templateUrl: './admin-payment.component.html',
  styleUrls: ['./admin-payment.component.css']
})
export class AdminPaymentComponent implements OnInit {

  payments : Payment[];
  subscription : Subscription; 

  constructor() { }

  ngOnInit(): void {
  }

}
