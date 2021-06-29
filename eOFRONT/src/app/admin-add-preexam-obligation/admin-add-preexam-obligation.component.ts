import { Component, OnInit } from '@angular/core';
import { PreexamObligationService } from '../preexam-obligation/preexam-obligation.service';

@Component({
  selector: 'app-admin-add-preexam-obligation',
  templateUrl: './admin-add-preexam-obligation.component.html',
  styleUrls: ['./admin-add-preexam-obligation.component.css']
})
export class AdminAddPreexamObligationComponent implements OnInit {

  preexamObligation = {
    date: '',
    location: ''
    };
  submitted = false;

  constructor(private preexamObligationService: PreexamObligationService) { }

  ngOnInit(): void {
  }

  savePreexamObligation(): void {
    const data = {
      date: this.preexamObligation.date,
      location: this.preexamObligation.location
    };

    this.preexamObligationService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  newPreexamObligation(): void {
    this.submitted = false;
    this.preexamObligation = {
     date: '',
     location: ''
    };
  }

}
