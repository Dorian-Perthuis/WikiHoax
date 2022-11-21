import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'header-button',
  templateUrl: './header-button.component.html',
  styleUrls: ['./header-button.component.css']
})
export class HeaderButtonComponent implements OnInit {

  @Input() title: string = "Need Title !";
  @Input() url: string = "";

  constructor() { }

  ngOnInit(): void {
  }

}
