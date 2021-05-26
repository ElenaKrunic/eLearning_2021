import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../login/authentication.service';
import { Document } from '../model/document';
import { StudentService } from '../students/student.service';

@Component({
  selector: 'app-student-documents',
  templateUrl: './student-documents.component.html',
  styleUrls: ['./student-documents.component.css']
})
export class StudentDocumentsComponent implements OnInit {
  document?: Document[];
  
  //  subscription: Subscription;

  constructor(private studentService: StudentService, private router: Router,private authService:AuthenticationService) {
    //  this.subscription = studentService.RegenerateData$.subscribe(() =>
    //   //  this.getDocuments(studentId?:number)

    //  );
   }
  // ngOnInit(): void {
  //   this.getDocuments(studentId?:number);

  // }

  getDocuments(studentId:number){

    this.studentService.getStudentDocument(studentId);
  }

}
