import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Professor } from '../model/professor';
import {  ProfessorService } from '../professor/professor.service';
@Component({
  selector: 'app-admin-add-professor',
  templateUrl: './admin-add-professor.component.html',
  styleUrls: ['./admin-add-professor.component.css']
})
export class AdminAddProfessorComponent implements OnInit {

  professor : Professor = new Professor({
    user: null,

    firstName: '', 
    lastName: ''

  });

  form!: FormGroup;
  submitted = false; 

  constructor(private pService: ProfessorService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      firstName: [
        '',
        [
          Validators.required, 
          Validators.minLength(3),
          Validators.maxLength(13)
        ] 
      ],
      lastName: [
        '',
        [
          Validators.required, 
          Validators.minLength(3),
          Validators.maxLength(13)
        ] 
      ]  });

    }get f(): { [key: string]: AbstractControl} { return this.form.controls;}

    saveProfessor() {
      const data = {
      
       firstName: this.professor.firstName, 
       lastName: this.professor.lastName, 
       
      }; 
  
      this.pService.create(data)
      .subscribe(
        response => {
          console.log(response); 
          this.submitted = true; 
        },
        error => {
          console.log(error);
        }
      );
    }
  
    newProfessor(){
      this.submitted = false; 
      this.professor = {
        user: null,
       
        firstName: '', 
        lastName: '' 
      };
    }
  
    onSubmit(): void {
      this.submitted = true;
  
      if (this.form.invalid) {
        return;
      }
  
      console.log(JSON.stringify(this.form.value, null, 2));
    }
  
    onReset(): void {
      this.submitted = false;
      this.form.reset();
    }
  

}
