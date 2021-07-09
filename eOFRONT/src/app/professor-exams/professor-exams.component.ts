import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { ExamService } from '../exam/exam.service';
import { Exam } from '../model/exam';

@Component({
  selector: 'app-professor-exams',
  templateUrl: './professor-exams.component.html',
  styleUrls: ['./professor-exams.component.css']
})
export class ProfessorExamsComponent implements OnInit {
  exams : Exam[];
  subscription : Subscription;
  constructor(private examService: ExamService, private router: Router) {
    
  }
  
  ngOnInit(): void {
  }

}
