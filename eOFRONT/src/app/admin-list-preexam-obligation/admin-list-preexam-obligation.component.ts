import { Component, OnInit } from '@angular/core';
import { PreexamObligation } from '../model/preexam-obligation';
import { PreexamObligationService } from '../preexam-obligation/preexam-obligation.service';

@Component({
  selector: 'app-admin-list-preexam-obligation',
  templateUrl: './admin-list-preexam-obligation.component.html',
  styleUrls: ['./admin-list-preexam-obligation.component.css']
})
export class AdminListPreexamObligationComponent implements OnInit {

  preexamObligations: PreexamObligation[] = []; 
  currentPreexamObligation: PreexamObligation; 
  currentIndex = -1; 
  location = '';

  page = 1;
  count = 0;
  pageSize = 3;
  pageSizes = [3, 6, 9];

  constructor(private preexamObligationService: PreexamObligationService) { }

  ngOnInit(): void {
    this.retrievePreexamObligations(); 
  }

  getRequestParams(searchLocation: string, page: number, pageSize: number): any {
    let params: any = {};

    if (searchLocation) {
      params[`location`] = searchLocation;
    }

    if (page) {
      params[`page`] = page - 1;
    }

    if (pageSize) {
      params[`size`] = pageSize;
    }

    return params;
  }

  retrievePreexamObligations() : void {
    const params = this.getRequestParams(this.location, this.page, this.pageSize);
    this.preexamObligationService.getAll(params)
    .subscribe(
      response => {
        const { preexamObligations, totalItems } = response;
        this.preexamObligationService = preexamObligations;
        this.count = totalItems;
        console.log(response);
      },
      error => {
        console.log(error);
      }
    );
  }

  handlePageChange(event: number): void {
    this.page = event;
    this.retrievePreexamObligations();
  }

  handlePageSizeChange(event: any): void {
    this.pageSize = event.target.value;
    this.page = 1;
    this.retrievePreexamObligations();
  }

  refreshList(): void {
    this.retrievePreexamObligations();
    this.currentIndex = -1; 
    this.currentPreexamObligation= null;
  }

  setActivePreexamObligation(preexamObligation : null | any, index=-1) : void {
    this.currentPreexamObligation = preexamObligation;
    this.currentIndex = index;
  }

  searchLocation(): void {
    this.page = 1;
    this.retrievePreexamObligations();
  }
}
