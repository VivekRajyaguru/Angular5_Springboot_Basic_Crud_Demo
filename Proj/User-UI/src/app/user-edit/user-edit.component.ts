import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { User } from '../Model/User';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../Service/User.service';

@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css']
})
export class UserEditComponent implements OnInit {
  userForm: FormGroup;
  user: User;
  userId;
  constructor(private formBuilder: FormBuilder, private route: ActivatedRoute, private router: Router,
  private userService: UserService) {
    this.userForm = formBuilder.group({
      'id': '',
      'firstName': '',
      'lastName': '',
      'email': '',
      'contactNo': '',
      'isActive': '1'

    });

    this.route.params.subscribe( params =>
      this.userId = params['id']
    );
  }

  ngOnInit() {
    if (this.userId) {
      this.loadUserDetails(this.userId);
    }
  }

  submit() {
    console.log(this.userForm.value);
    this.userService.saveUser(this.userForm.value).subscribe(
      data => {
        console.log(data);
        if (data.statusCode === 'A200') {
          this.router.navigate(['/']);
        }
      },
      error => {
        console.log(error);
      }
    );
  }

  loadUserDetails(userId) {
    this.userService.loadUserById(userId).subscribe(
        data => {
          if (data.statusCode === 'A200') {
            const object = data.valueObject;
            this.userForm.controls['id'].setValue(object.id);
            this.userForm.controls['firstName'].setValue(object.firstName);
            this.userForm.controls['lastName'].setValue(object.lastName);
            this.userForm.controls['email'].setValue(object.email);
            this.userForm.controls['contactNo'].setValue(object.contactNo);
            this.userForm.controls['isActive'].setValue(object.isActive);
          }
        },
        error => {
          console.log(error);
        }
    );
  }

}
