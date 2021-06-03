import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { AuthenticationService } from '../login/authentication.service';
import { Location } from '@angular/common';
import { StudentService } from '../students/student.service';
import { switchMap } from 'rxjs/operators';
import { Document } from '../model/document';

@Component({
  selector: 'app-student-documents',
  templateUrl: './student-documents.component.html',
  styleUrls: ['./student-documents.component.css']
})
export class StudentDocumentsComponent implements OnInit {
  documents:Document[];
 
  constructor(private studentService: StudentService, private router: Router,private authService:AuthenticationService,private route:ActivatedRoute,private location:Location) { 
  
  }
  ngOnInit(): void {
    if(this.route.snapshot.params['id']) {
      this.route.params.pipe(switchMap((params : Params) =>
      this.studentService.getStudentDocument(+params['id'])))
      .subscribe(res => {
        this.documents = res;
        
      });
    }
      
  }
  
  goBack(): void {
    this.location.back();
  }

  }

