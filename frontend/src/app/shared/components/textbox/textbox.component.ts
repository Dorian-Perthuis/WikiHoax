import { AfterViewChecked, AfterViewInit, Component, ElementRef, EventEmitter, Input, OnInit, Output, Renderer2, ViewChild } from '@angular/core';

@Component({
  selector: 'textbox',
  templateUrl: './textbox.component.html',
  styleUrls: ['./textbox.component.css']
})
export class TextboxComponent implements OnInit, AfterViewChecked {

  @Input() title: string = "Need Title !";
  @Input() color: string = "";
  @ViewChild('editable') input! : ElementRef;

  @Output() inputEvent = new EventEmitter<string>();
  @ViewChild('contentContainer') container!: ElementRef;

  constructor(
    private renderer: Renderer2
  ) { }

  ngOnInit(): void {

  }

  ngAfterViewChecked(): void {
    this.renderer.addClass(this.container.nativeElement, this.color);
  }

  inputValue(text : string) {
    this.inputEvent.emit(text);
  }

  deleteInput(){
    this.renderer.setProperty(this.input.nativeElement,'innerText', "");
  }

}
