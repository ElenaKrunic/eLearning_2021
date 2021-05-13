import { Component, Input, OnInit } from '@angular/core';
import { Payment } from '../model/payment';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  @Input() payments?: Payment[];

  constructor() { }

  ngOnInit(): void {
  }

}
