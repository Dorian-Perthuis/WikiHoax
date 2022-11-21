import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  section : string = "main";

  constructor() { }

  ngOnInit(): void {
  }


  activateClassement(){
    this.section = 'classement';
  }

  activatePartie(){
    this.section = 'partie';
  }

  activateMain(){
    this.section = 'main';
  }

  activateUser(){
    this.section = 'user';
  }

}
