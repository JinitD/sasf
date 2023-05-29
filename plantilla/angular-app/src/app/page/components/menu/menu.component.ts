import { Component } from '@angular/core';
import { User } from 'src/app/core/model/Model';
import { UserService } from 'src/app/core/service/user/user.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent {
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
