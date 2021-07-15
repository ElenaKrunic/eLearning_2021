import { Component, OnInit } from '@angular/core';
import { Professor } from '../model/professor';
import { ProfessorService } from '../professor/professor.service';
@Component({
  selector: 'app-admin-list-professor',
  templateUrl: './admin-list-professor.component.html',
  styleUrls: ['./admin-list-professor.component.css']
})
export class AdminListProfessorComponent implements OnInit {
  professors : Professor[] = []; 
  currentProfessor: Professor; 
  currentIndex = -1; 
  firstName = '' ;

  page = 1;
  count = 0;
  pageSize = 3;
  pageSizes = [3, 6, 9];
  constructor(private pService: ProfessorService) { }

  ngOnInit(): void {
    this.retrieveProfessors();
  }

  getRequestParams(searchFirstName: string, page: number, pageSize: number): any {
    let params: any = {};

    if (searchFirstName) {
      params[`firstName`] = searchFirstName;
    }

    if (page) {
      params[`page`] = page - 1;
    }

    if (pageSize) {
      params[`size`] = pageSize;
    }

    return params;
  }

  retrieveProfessors() : void {
    const params = this.getRequestParams(this.firstName, this.page, this.pageSize);
    this.pService.getAll(params)
    .subscribe(
      response => {
        const { professors, totalItems } = response;
        this.professors = professors;
        this.count = totalItems;
        console.log(response);
      },
      error => {
        console.log(error);
      });
  }

  handlePageChange(event: number): void {
    this.page = event;
    this.retrieveProfessors();
  }

  handlePageSizeChange(event: any): void {
    this.pageSize = event.target.value;
    this.page = 1;
    this.retrieveProfessors();
  }

  refreshList(): void {
    this.retrieveProfessors();
    this.currentIndex = -1; 
    this.currentProfessor= null;
  }

  setActiveProfessor(professor : null | any, index=-1) : void {
    this.currentProfessor = professor;
    this.currentIndex = index;
  }

  searchFirstName(): void {
    this.page = 1;
    this.retrieveProfessors();
  }

}
