import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UsersService } from '../users/users.service';

@Component({
  selector: 'app-admin-list-user',
  templateUrl: './admin-list-user.component.html',
  styleUrls: ['./admin-list-user.component.css']
})
export class AdminListUserComponent implements OnInit {

  users: User[] = [];
  currentUser: User; 
  currentIndex = -1; 
  username = ''; 

  page=  1; 
  count = 0; 
  pageSize = 3; 
  pageSizes = [3,6,9];

  constructor(private userService: UsersService) { }

  ngOnInit(): void {
    this.retrieveUsers();
  }

  getRequestParams(searchName: string, page: number, pageSize: number): any {
    let params: any = {};

    if (searchName) {
      params[`username`] = searchName;
    }

    if (page) {
      params[`page`] = page - 1;
    }

    if (pageSize) {
      params[`size`] = pageSize;
    }

    return params;
  }

  retrieveUsers(): void {
    const params = this.getRequestParams(this.username, this.page, this.pageSize);

    this.userService.getAll(params)
    .subscribe(
      response => {
        const { users, totalItems } = response;
        this.users = users;
        this.count = totalItems;
        console.log(response);
      },
      error => {
        console.log(error);
      });
  }

  handlePageChange(event: number): void {
    this.page = event;
    this.retrieveUsers();
  }

  handlePageSizeChange(event: any): void {
    this.pageSize = event.target.value;
    this.page = 1;
    this.retrieveUsers();
  }

  refreshList(): void {
    this.retrieveUsers();
    this.currentIndex = -1; 
    this.currentUser= null;
  }

  setActiveUser(user : null | any, index=-1) : void {
    this.currentUser = user;
    this.currentIndex = index;
  }

  searchUsername(): void {
    this.page = 1;
    this.retrieveUsers();
  }
  
}
