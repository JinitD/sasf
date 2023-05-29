import { Component } from '@angular/core';
import {  FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  form!: FormGroup;
  
  constructor(private formBuilder: FormBuilder,
    private router: Router) {
      this.buildForm();
  }

  private buildForm() {
    this.form = this.formBuilder.group({
      correo: ['', [Validators.required]],
      password: ['', [Validators.required]],
    })
  }
  login(event: Event) {
    console.log('asd')
    event.preventDefault();
    this.router.navigate(['/menu/furniture']);
  
  }
}
