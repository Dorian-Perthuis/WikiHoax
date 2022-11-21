import { AfterViewInit, Component, ElementRef, OnInit, Renderer2, TemplateRef, ViewChild } from '@angular/core';

@Component({
  selector: 'carrousel',
  templateUrl: './carrousel.component.html',
  styleUrls: ['./carrousel.component.css']
})
export class CarrouselComponent implements OnInit {

  constructor(private renderer: Renderer2) { }

  @ViewChild('images') images! : ElementRef;
  @ViewChild('btnG') btnG! : ElementRef;
  @ViewChild('btnR') btnR! : ElementRef;
  nbItems : number = 5;
  image_size : number = 200 ;

  ngOnInit(): void {
  }

  moveRight(){
    this.images.nativeElement.scrollBy(this.image_size,0);
  }

  moveLeft(){
    this.images.nativeElement.scrollBy(-this.image_size,0);
  }

  onScroll(event : Event){
    if((<Element>event!.target).scrollLeft <= 150){
      this.renderer.setStyle(this.btnG, 'inactive', true);
    }else{
      this.renderer.setStyle(this.btnG, 'inactive', false);
    }

    if((<Element>event.target).scrollLeft >= 270*this.nbItems-10){
      this.renderer.setStyle(this.btnR, 'inactive', true);
    }else{
      this.renderer.setStyle(this.btnR, 'inactive', false);
    }
  }
}
