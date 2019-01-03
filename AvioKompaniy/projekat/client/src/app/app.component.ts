import { Component } from '@angular/core';
import { AuthenticationService } from './security/authentication.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  constructor(private authenticationService: AuthenticationService) {

  }

  logOut() {
    localStorage.removeItem('currentUser');
    // this.authenticationService.logout();
  }

  isLoggedIn() {
    return this.authenticationService.isLoggedIn();
  }
}
