import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PreexamObligationService } from '../preexam-obligation/preexam-obligation.service';

@Component({
  selector: 'app-admin-details-preexam-obligation',
  templateUrl: './admin-details-preexam-obligation.component.html',
  styleUrls: ['./admin-details-preexam-obligation.component.css']
})
export class AdminDetailsPreexamObligationComponent implements OnInit {

  currentPreexamobligation : any | null; 
  message = '';

  constructor(private preexamObligationService: PreexamObligationService, private route : ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getPreexamObligation(this.route.snapshot.paramMap.get('id'));
  }

  getPreexamObligation(id: any) : void {
    this.preexamObligationService.get(id)
    .subscribe(
      data => {
        this.currentPreexamobligation = data; 
        console.log(data); 
      }, 
      error => {
        console.log(error);
      }
    );
  }
  
  updatePreexamObligation(): void {
    this.preexamObligationService.update(this.currentPreexamobligation.id, this.currentPreexamobligation)
    .subscribe(
      response => {
        console.log(response); 
        this.message =  "You successfully updated preexam obligation!";
      },
      error => {
        console.log(error);
      }
    );
  }

  deletePreexamObligation() : void {
    this.preexamObligationService.delete(this.currentPreexamobligation.id)
    .subscribe(
      response => {
        console.log(response); 
        this.router.navigate(['/preexamObligations']);
      }, 
      error => {
        console.log(error); 
      }
    );
  }

}
