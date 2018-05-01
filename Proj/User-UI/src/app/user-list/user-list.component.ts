import { Component, OnInit } from '@angular/core';
import { UserService } from '../Service/User.service';
import { User } from '../Model/User';
import { Router } from '@angular/router';
import { DataTableParam } from '../Model/DataTableParam';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  columns = [
    {field: 'firstName', header: 'FirstName'},
    {field: 'lastName', header: 'LastName'},
    {field: 'email', header: 'Email'},
    {field: 'contactNo', header: 'Contact#'}
  ];
  userList: User[] = [];
  first: Number = 0;
  datatableParam: DataTableParam;
  totalRecords: Number = 0;
  constructor(private userService: UserService, private route: Router) {
    this.datatableParam = new DataTableParam();
    this.datatableParam = {
      'first': 0,
      'rows': 20,
      'sortField': 'id',
      'sortOrder': 1,
      'searchValue': ''
    };
  }

  ngOnInit() {
    this.listUser();
  }

  onLazyLoad(event) {
    console.log(event)
    this.datatableParam = {
      'first': event.first ? event.first : 1,
      'rows': event.rows ? event.rows : 1 ,
      'sortField': event.sortField ? event.sortField : 'id',
      'sortOrder': event.sortOrder ? event.sortOrder : 1,
      'searchValue': event.globalFilter ?  event.globalFilter : ''
    };
    this.listUser();
  }

  edit(id) {
    this.route.navigate(['/user', {id: id}]);
  }
  addUser() {
    this.route.navigate(['/user']);
  }

  delete(id) {
    this.userService.deleteUser(id).subscribe(
      data => {
        console.log(data);
        if (data.statusCode === 'A200') {
          this.listUser();
        }
      },
      error => {
        console.log(error);
      }
    );
  }

  listUser() {
    this.userService.listUser(this.datatableParam).subscribe(
      data => {
        if (data.statusCode === 'A200') {
          this.userList = data.valueObject.data;
          this.first = data.valueObject.first;
          this.totalRecords = data.valueObject.totalRecords;
        }
      },
      error => {
        console.log(error);
      }
    );
  }


}
