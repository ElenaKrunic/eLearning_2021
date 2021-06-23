import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { Professor } from '../model/professor';
import { ProfessorService } from '../professor/professor.service';

@Component({
  selector: 'app-professor-profile',
  templateUrl: './professor-profile.component.html',
  styleUrls: ['./professor-profile.component.css']
})
export class ProfessorProfileComponent implements OnInit {
  professor= new Professor({
    firstName:'',
    lastName:''
  })

  constructor(private location:Location,private professorService: ProfessorService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.snapshot.params['id'];
    if (this.route.snapshot.params['id']) {
      // fetch professor if we edit the existing professor
      this.route.params.pipe(switchMap((params: Params) => 
          this.professorService.getProfessor(+params['id']))) // convert to number
        .subscribe(res => {
         // this.professor = res.body;
          
          }
        );
    } 
  }

  goBack(): void {
    this.location.back();
  }

}
