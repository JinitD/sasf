import { Component } from '@angular/core';
import { UserService } from 'src/app/core/service/user/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent {
  constructor(
    private userService: UserService
  ) {
    this.fetch()
  }
  fetch(){
    this.userService.getOneUserByEmail();
  }
}
