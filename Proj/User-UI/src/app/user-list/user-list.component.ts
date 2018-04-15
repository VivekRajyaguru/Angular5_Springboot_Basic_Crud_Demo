import { Component, OnInit } from '@angular/core';
import { UserService } from '../Service/User.service';
import { User } from '../Model/User';
import { Router } from '@angular/router';

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
  constructor(private userService: UserService, private route: Router) { }

  ngOnInit() {
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
    this.userService.listUser().subscribe(
      data => {
        if (data.statusCode === 'A200') {
          this.userList = data.data;
        }
      },
      error => {
        console.log(error);
      }
    );
  }


}
