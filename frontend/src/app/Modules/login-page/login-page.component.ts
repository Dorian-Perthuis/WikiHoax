import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  loginBool : boolean = true;

  constructor() { }

  ngOnInit(): void {
  }

  toggleLoginBool(){
    this.loginBool = !this.loginBool;
  }

}
