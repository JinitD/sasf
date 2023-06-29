import { Location } from '@angular/common';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/core/service/auth/auth.service';
import jwt_decode from 'jwt-decode';
import { TokenService } from 'src/app/core/service/token/token.service';
@Injectable({
  providedIn: 'root'
})
export class IsExpiredGuard implements CanActivate {
  constructor(
    private authService: AuthService,
    private router: Router
    , private location: Location,
    private tokenService :TokenService
  ) {

  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    const token = this.tokenService.getToken();

    if (token) {
      const tokenInfo = this.tokenService.getDecodeToken();

      const currentTime = Math.floor(Date.now() / 1000);
      if (tokenInfo.exp >= currentTime) {
        this.getPathByRole(tokenInfo.roles)
        return false;
      }
    }

    return true;
  }

  getPathByRole(roleTokens: string[]): void {
    let path: string;
    console.log(roleTokens);

    if (roleTokens.includes('ROLE_ADMIN')) {
      path = 'admin';
    } else if (roleTokens.includes('ROLE_USER')) {
      path = 'user';
    } else {
      // Manejo de caso cuando no coincide ningún rol válido
      console.error('Rol inválido');
      return;
    }

    this.router.navigate([path]);
  }


}
