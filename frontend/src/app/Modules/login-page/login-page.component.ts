import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {
  @Output() connectionEvent: EventEmitter<boolean> = new EventEmitter();
  @Output() createAccountEvent: EventEmitter<boolean> = new EventEmitter();

  loginBool : boolean = true;

  constructor() { }

  ngOnInit(): void {
  }

  toggleLoginBool(){
    this.loginBool = !this.loginBool;
  }

  connection() : void{
    this.connectionEvent.emit(true);
  }

  createAccount(){
    this.createAccountEvent.emit(true);
  }
}
