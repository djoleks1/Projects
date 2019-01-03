import { Injectable } from '@angular/core';

// import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { JwtUtilsService } from 'app/security/jwt-utils.service';


@Injectable()
export class AuthenticationService {

  private readonly loginPath = '/api/login';

  constructor(private http: HttpClient, private jwtUtilsService: JwtUtilsService) { }

  login(username: string, password: string): Observable<boolean> {
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post(this.loginPath, JSON.stringify({ username, password }), { headers })
      .map((res: any) => {
        let token = res && res['token'];
        if (token) {
          localStorage.setItem('currentUser', JSON.stringify({ 
                                    username: username, 
                                    roles:this.jwtUtilsService.getRoles(token), 
                                    token: token 
                                  }));
          return true;
        }
        else {
          return false;
        }
      })
      .catch((error: any) => {
        if (error.status === 400) {
          return Observable.throw('Ilegal login');
        }
        else {
          return Observable.throw(error.json().error || 'Server error');
        }
      });
  }

  getToken(): String {
    var currentUser = JSON.parse(localStorage.getItem('currentUser'));
    var token = currentUser && currentUser.token;
    return token ? token : "";
  }

  logout(): void {
    localStorage.removeItem('currentUser');
  }

  isLoggedIn(): boolean{
    if(this.getToken()!='') return true;
    else return false;
  }

  getCurrentUser(){
    if(localStorage.currentUser){
      return JSON.parse(localStorage.currentUser);
    }
    else{
      return undefined;
    }
  }

  hasRole(role: string): boolean {
    return this.getCurrentUser()['roles'].indexOf(role) !== -1;
  }
}
