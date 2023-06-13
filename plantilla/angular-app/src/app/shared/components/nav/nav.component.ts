import { Component } from '@angular/core';
import { TokenService } from 'src/app/core/service/token/token.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent {
  role: string = "";

  constructor(
    private tokenService: TokenService
  ) {
    this.role= this.roleValidator();
  }

  roleValidator(){
    return window.location.pathname.split('/')[1];
  }

}
