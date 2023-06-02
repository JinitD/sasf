import { Component } from '@angular/core';
import { RoleDTO, User } from 'src/app/core/model/Model';
import { RoleService } from 'src/app/core/service/role/role.service';
import { UserService } from 'src/app/core/service/user/user.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent {
  usersDto !: RoleDTO[];
  constructor(
    private roleService: RoleService
  ) {
    this.fetch();
  }

  fetch() {
    this.roleService.getAllRole().subscribe(item => {
      this.usersDto = item;
      console.log(this.usersDto)
    });
  }
}
