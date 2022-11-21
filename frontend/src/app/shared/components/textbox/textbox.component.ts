import { AfterViewInit, Component, ElementRef, Input, OnInit, Renderer2, ViewChild } from '@angular/core';

@Component({
  selector: 'textbox',
  templateUrl: './textbox.component.html',
  styleUrls: ['./textbox.component.css']
})
export class TextboxComponent implements OnInit, AfterViewInit {

  @Input() title: string = "Need Title !";
  @Input() color: string = "";
  @ViewChild('contentContainer') container!: ElementRef;

  constructor(
    private renderer : Renderer2
  ) { }

  ngOnInit(): void {

  }

  ngAfterViewInit(): void {
    if(this.color =='light'){
      this.renderer.setStyle(this.container,"light",true)
    }
  }

}
