import { Location } from '@angular/common';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/core/service/auth/auth.service';
import jwt_decode from 'jwt-decode';
import { Role } from 'src/app/core/model/Model';
@Injectable({
  providedIn: 'root'
})
export class IsExpiredGuard implements CanActivate {
  constructor(
    private authService: AuthService,
    private router: Router
    , private location: Location
  ) {

  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    const token = this.authService.getToken();

    if (token) {
      const tokenInfo = jwt_decode(token) as { exp: number, role: Role };

      const currentTime = Math.floor(Date.now() / 1000);
      if (tokenInfo.exp >= currentTime) {
        this.getPathByRole(tokenInfo.role.role)
        return false;
      }
    }

    return true;
  }

  getPathByRole(roleToken:string){
    let path ;
    if(roleToken =='admin'){
      path= 'admin'
    }
    else if(roleToken =='client'){
      path= 'page'
    }
    this.router.navigate([path]);
  }


}