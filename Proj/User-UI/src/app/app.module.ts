import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import {TableModule} from 'primeng/table';
import { UserService } from './Service/User.service';
import { CustomHttpService } from './Service/CustomHttp.service';
import { NotificationService } from './Service/Notification.service';
import { HttpClientModule } from '@angular/common/http';
import { Routes, RouterModule } from '@angular/router';
import {GrowlModule} from 'primeng/growl';
import { NotificationComponent } from './common/error.component';
import { AppRoutingModule } from './app.routes';
import { UserEditComponent } from './user-edit/user-edit.component';
import { UserListComponent } from './user-list/user-list.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    NotificationComponent,
    UserEditComponent,
    UserListComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    TableModule,
    GrowlModule,
    HttpClientModule,
    RouterModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [UserService, CustomHttpService, NotificationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
