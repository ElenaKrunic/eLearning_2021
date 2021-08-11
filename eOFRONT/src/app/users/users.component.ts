import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { Subscription } from 'rxjs';
import { UsersService } from './users.service';
import { AppComponent } from 'src/app/app.component';

//asdadas
@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users: User[] = [];
  currentUser: User;
  currentIndex = -1; 
  username = '';

  page = 1; 
  count = 0; 
  pageSize = 1;
  pageSizes = [3,6,9]; 

  subscription: Subscription;

  constructor(private userService: UsersService, private router: Router) {}

  ngOnInit(): void {
    this.retrieveUsers();
  }

  getRequestParams(username: string, page: number, pageSize: number): any {
    let params: any = {};

    if (username) {
      params[`username`] = username;
    }

    if (page) {
      params[`page`] = page - 1;
    }

    if (pageSize) {
      params[`size`] = pageSize;
    }

    return params;
  }

  retrieveUsers(){
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
