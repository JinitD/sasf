import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/core/service/auth/auth.service';
import jwt_decode from 'jwt-decode';
import { TokenService } from 'src/app/core/service/token/token.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(
    private authService: AuthService,
    private router: Router,
    private tokenService :TokenService
  ) {

  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    const token = this.tokenService.getToken();
    const rolesPath = route.data['roles'] as Array<string>; // Obtén los roles necesarios para la ruta desde los datos de la ruta

    if (token) {
      const tokenInfo = this.tokenService.getDecodeToken();
      const currentTime = Math.floor(Date.now() / 1000); // Obtiene la hora actual en segundos
      console.log(tokenInfo)
      if (tokenInfo.exp >= currentTime) {
        if (this.getPathByRole(rolesPath, tokenInfo.roles)) {
          console.log("es verdad")
          return true;
        }
      }
    }
    this.router.navigate(['sesion/signin']);
    return false;
  }


  getPathByRole(rolesPath: string[], decoderole: string[]): boolean {
    return rolesPath.some((role) => decoderole.includes(role));
  }



}

