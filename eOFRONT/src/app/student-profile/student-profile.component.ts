import { Component, Input, OnInit } from '@angular/core';
import { Student } from '../model/student';

@Component({
  selector: 'app-student-profile',
  templateUrl: './student-profile.component.html',
  styleUrls: ['./student-profile.component.css']
})
export class StudentProfileComponent implements OnInit {
  @Input() students?:Student[];
  constructor() { }

  ngOnInit(): void {
  }

}
