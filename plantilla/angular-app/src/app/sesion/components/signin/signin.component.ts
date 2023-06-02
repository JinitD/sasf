import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Credencitals } from 'src/app/core/model/Model';
import { AuthService } from 'src/app/core/service/auth/auth.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss']
})
export class SigninComponent {
  form!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private authService: AuthService
  ) {
    this.buildForm();
  }

  private buildForm() {
    this.form = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(4)]],
    })
  }

  sigin(event: Event) {
    event.preventDefault();
    if (this.form.valid) {
      const creds: Credencitals = this.form.value;
      console.log(creds)
      this.authService.signinAuth(creds)
        .subscribe(arg => {
          this.router.navigate([''])
        });

    }

  }

}
