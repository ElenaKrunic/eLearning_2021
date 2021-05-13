import { Component, Input, OnInit } from '@angular/core';
import { Payout } from '../model/payout';

@Component({
  selector: 'app-payout',
  templateUrl: './payout.component.html',
  styleUrls: ['./payout.component.css']
})
export class PayoutComponent implements OnInit {
  @Input() payouts?:Payout[];
  constructor() { }

  ngOnInit(): void {
  }

}
