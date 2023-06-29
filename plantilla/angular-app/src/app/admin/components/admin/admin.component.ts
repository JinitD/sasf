import { Component } from '@angular/core';
import { User } from 'src/app/core/model/Model';
import { UserService } from 'src/app/core/service/user/user.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent {
  users !: User[];
  constructor(
    private userService: UserService
  ) {
    this.fetch();
  }

  fetch() {
    this.userService.getAllUsers().subscribe(item => {
      this.users = item;
    });
  }
}
