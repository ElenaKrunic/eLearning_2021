import { Component, Input, OnInit } from '@angular/core';
import { FinancialCard } from '../model/financial-card';

@Component({
  selector: 'app-financialcard-student',
  templateUrl: './financialcard-student.component.html',
  styleUrls: ['./financialcard-student.component.css']
})
export class FinancialcardStudentComponent implements OnInit {

  @Input() financialcard?: FinancialCard[];

	constructor() {}

	ngOnInit() {}

}
