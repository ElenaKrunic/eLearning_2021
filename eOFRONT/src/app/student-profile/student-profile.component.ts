import { Component, Input, OnInit } from '@angular/core';
import { Student } from '../model/student';
import { Location } from '@angular/common';

@Component({
  selector: 'app-student-profile',
  templateUrl: './student-profile.component.html',
  styleUrls: ['./student-profile.component.css']
})
export class StudentProfileComponent implements OnInit {
  student?:Student;
  constructor(private location:Location) { }

  ngOnInit(): void {
  }

  goBack(): void {
    this.location.back();
  }

}
