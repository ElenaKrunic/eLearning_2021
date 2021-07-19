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
    lastName:'',
    user:{
      id:0,
      username:"",
      password:"",
      authorities: []
    }
  })

  constructor(private location:Location,private professorService: ProfessorService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.professorService.getMe().subscribe( (professor) => (this.professor = professor));
  }

  goBack(): void {
    this.location.back();
  }

}
