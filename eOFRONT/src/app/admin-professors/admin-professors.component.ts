import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Professor } from '../model/professor';
import { ProfessorService } from '../professor/professor.service';

@Component({
  selector: 'app-admin-professors',
  templateUrl: './admin-professors.component.html',
  styleUrls: ['./admin-professors.component.css']
})
export class AdminProfessorsComponent implements OnInit {

  professors: Professor[];
  subscription: Subscription;
  constructor(private professorService: ProfessorService, private router: Router) { 
    this.getProfessors();  }

  ngOnInit(): void {
    this.getProfessors
  }
  getProfessors(){
    this.professorService.getProfessors().subscribe(res => 
      this.professors = res.body);
  }
  gotoAdd() : void {
    this.router.navigate(["/addProfessor"]);
  }

  gotoEdit(professor : Professor) : void {
    this.router.navigate(['/editProfessor', professor.id]);
  } 

  deleteProfessor(professorId : number) : void {
    this.professorService.deleteProfessor(professorId).subscribe(
      () => this.getProfessors()
    );
  }

}
