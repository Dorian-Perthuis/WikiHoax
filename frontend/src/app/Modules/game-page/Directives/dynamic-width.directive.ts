import { Directive, ElementRef, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appDynamicWidth]'
})
export class DynamicWidthDirective {

  constructor(private elementRef: ElementRef, private renderer: Renderer2) {
    this.renderer.setStyle(this.elementRef.nativeElement, 'width', `50px`);
}
}
