import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Professor} from '../model/professor';
import { ProfessorService } from '../professor/professor.service';
@Component({
  selector: 'app-admin-details-professor',
  templateUrl: './admin-details-professor.component.html',
  styleUrls: ['./admin-details-professor.component.css']
})
export class AdminDetailsProfessorComponent implements OnInit {
  currentProfessor: Professor = {} as Professor;
  message = ''; 
  form!: FormGroup; 
  submitted=false; 

  constructor(private pService: ProfessorService, private route: ActivatedRoute, private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.message = '';
    this.getProfessor(this.route.snapshot.paramMap.get('id'));
    this.form = this.formBuilder.group({
      firstName: [
        '',
        [
          Validators.required, 
          Validators.minLength(3),
          Validators.maxLength(20)
        ] 
      ],
      lastName: [
        '',
        [
          Validators.required, 
          Validators.minLength(3),
          Validators.maxLength(20)
        ] 
      ]});
    }
      getProfessor(id: any) : void {
        this.pService.get(id)
        .subscribe(
          data => {
            this.currentProfessor = data; 
            console.log(data); 
          }, 
          error => {
            console.log(error);
          }
        );
      }
      
      updateProfessor(): void {
        this.pService.update(this.currentProfessor.id, this.currentProfessor)
        .subscribe(
          response => {
            this.message= 'profesor updated! ';
            console.log(response); 
          },
          error => {
            console.log(error);
          }
        );
      }
    
      deleteProfessor() : void {
        this.pService.delete(this.currentProfessor.id)
        .subscribe(
          response => {
            console.log(response); 
            this.router.navigate(['/professors']);
          }, 
          error => {
            console.log(error); 
          }
        );
      }
    
      get f(): { [key: string]: AbstractControl } {
        return this.form.controls;
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
