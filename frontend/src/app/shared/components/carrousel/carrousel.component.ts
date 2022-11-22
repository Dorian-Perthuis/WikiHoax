import { AfterViewInit, Component, ElementRef, Input, OnInit, Renderer2, TemplateRef, ViewChild } from '@angular/core';
import { image } from 'src/app/Services/game.service';

@Component({
  selector: 'carrousel',
  templateUrl: './carrousel.component.html',
  styleUrls: ['./carrousel.component.css']
})
export class CarrouselComponent implements OnInit {

  @ViewChild('images') images! : ElementRef;
  @ViewChild('btnG') btnG! : ElementRef;
  @ViewChild('btnR') btnR! : ElementRef;

  @Input() imageList : image[] = [];

  nbItems : number = 5;
  image_size : number = 200 ;

  constructor(private renderer: Renderer2) { }

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