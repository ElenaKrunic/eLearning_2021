import { Component, OnInit } from '@angular/core';
import { PreexamObligationService } from '../preexam-obligation/preexam-obligation.service';

@Component({
  selector: 'app-admin-list-preexam-obligation',
  templateUrl: './admin-list-preexam-obligation.component.html',
  styleUrls: ['./admin-list-preexam-obligation.component.css']
})
export class AdminListPreexamObligationComponent implements OnInit {

  preexamObligations: any; 
  currentPreexamObligation: null | any; 
  currentIndex = -1; 
  name = '';

  constructor(private preexamObligationService: PreexamObligationService) { }

  ngOnInit(): void {
    this.retrievePreexamObligations(); 
  }

  retrievePreexamObligations() : void {
    this.preexamObligationService.getAll()
    .subscribe(
      data => {
        this.preexamObligations = data;
        console.log(data); 
      },
      error => {
        console.log(error);
      }
    );
  }

  refreshList(): void {
    this.retrievePreexamObligations();
    this.currentIndex = -1; 
    this.currentPreexamObligation= null;
  }

  setActivePreexamObligation(preexamObligation : null | any, index=-1) : void {
    this.currentPreexamObligation = preexamObligation;
    this.currentIndex = index;
  }
}
