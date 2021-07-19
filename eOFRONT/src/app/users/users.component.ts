import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { Subscription } from 'rxjs';
import { UsersService } from './users.service';
import { AppComponent } from 'src/app/app.component';

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

  getRequestParams(firstName: string, page: number, pageSize: number): any {
    let params: any = {};

    if (firstName) {
      params[`firstName`] = firstName;
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
    /*
    this.userService.getUsers(params).subscribe(
      response => {
        // console.log(response)
        this.users = response.body == null? this.users:response.body;
      });
      */
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


  /*
  deleteUser(user: User): void {
    console.log("Brisem: "+JSON.stringify(user));
    this.userService.deleteUser(user.id==undefined ? 0:user.id).subscribe(
      () => this.getUsers()
    );
  }
  */

  setActiveUser(user : null | any, index=-1) : void {
    this.currentUser = user;
    this.currentIndex = index;
  }

  goToViewUser(user: User): void {
    this.router.navigate(['/view-user', user.id]);
  }

  searchUsername(): void {
    this.page = 1;
    this.retrieveUsers();
  }


  // isActive(num:number):boolean{
  //   if(this.numberPage===num){
  //     return true;
  //   }
  //   return false;
  // }

}
