import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { PreexamObligation } from '../model/preexam-obligation';
import { PreexamObligationService } from '../preexam-obligation/preexam-obligation.service';

@Component({
  selector: 'app-preexam-obligation-details',
  templateUrl: './preexam-obligation-details.component.html',
  styleUrls: ['./preexam-obligation-details.component.css']
})
export class PreexamObligationDetailsComponent implements OnInit {

  preexamObligation: PreexamObligation = new PreexamObligation({
    points : 0, 
    location : '',
    dateOfObligation : new Date(),
    passed : false, 
    preexamObligationStatus : null, 
    preexamObligationType : null,
    exam : null
  });

  mode : string = 'ADD'; 

  constructor(private preexamObligationService : PreexamObligationService,private route: ActivatedRoute, private location: Location, private router : Router) { }

  ngOnInit(): void {
    if(this.route.snapshot.params['id']) {
      this.route.params.pipe(switchMap((params : Params) =>
      this.preexamObligationService.getPreexamObligation(+params['id'])))
      .subscribe(res => {
        this.preexamObligation = res.body;
      });
    }
  }

  save(): void {
    this.mode == 'ADD' ? this.add() : this.edit();
  }

  private add() : void {
    this.preexamObligationService.addPreexamObligation(this.preexamObligation)
    .subscribe(res => {
      this.preexamObligationService.announceChange(); 
      this.goBack();
    })
  } 

  private edit() : void {
    this.preexamObligationService.editPreexamObligation(this.preexamObligation)
    .subscribe(preexamObligation => {
      this.preexamObligationService.announceChange();
      this.goBack();
    });
  }

  goBack() : void {
    this.location.back();
  }


}
