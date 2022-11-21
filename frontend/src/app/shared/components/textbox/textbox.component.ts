import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'textbox',
  templateUrl: './textbox.component.html',
  styleUrls: ['./textbox.component.css']
})
export class TextboxComponent implements OnInit {

  @Input() title: string = "Need Title !";


  constructor() { }

  ngOnInit(): void {
  }

}
