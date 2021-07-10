import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { AuthenticationService } from '../login/authentication.service';
import { Location } from '@angular/common';
import { StudentService } from '../students/student.service';
import { switchMap } from 'rxjs/operators';


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

  }
  
  getStudentDocuments(){
    this.studentService.getStudentDocument().subscribe(res=>this.documents=this.documents)
  }
  goBack(): void {
    this.location.back();
  }

  }

