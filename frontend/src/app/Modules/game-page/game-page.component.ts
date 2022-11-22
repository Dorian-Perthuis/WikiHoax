import { AfterViewInit, Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';
import { gamePage, GameService, image } from 'src/app/Services/game.service';

@Component({
  selector: 'game-page',
  templateUrl: './game-page.component.html',
  styleUrls: ['./game-page.component.css']
})
export class GamePageComponent implements OnInit, AfterViewInit {

  @ViewChild('titleId') titleElement! : ElementRef;
  @ViewChild('textId') textElement! : ElementRef;

  titleSplit : string[] = [];
  textSplit : string[] = [];

  titleText : string = "Comment écrire une histoire d'amour.";
  mainText : string = "La partie la plus excitante dans le fait de tomber amoureux est souvent le début d'une romance, la rencontre fortuite et parfois amusante avec l'être aimé, l'insouciance et la joie qu'accompagnent la réalisation que cette attirance est mutuelle, le confort et la sécurité de pouvoir se reposer sur une autre personne et construire une vie à deux, etc. Gardez tous ces aspects en tête lorsque vous commencerez à écrire votre histoire d'amour. Car le plus important, au-delà de vos personnages, intrigues et style d'écriture, sera de captiver votre lecteur et de le rendre aussi impatient que vos héros à l'idée de cet amour naissant."
  titleItems: item[] = [];
  mainItems: item[] = [];

  images: image[] = [];

  mot : string = "";

  testedWords : string[] = [];

  constructor(
    private renderer : Renderer2,
    private gameService : GameService
  ) { }


  ngOnInit(): void {
    this.splitText(this.titleText,this.titleItems);
    this.splitText(this.mainText, this.mainItems);
    this.gameService.getGamePage().subscribe((json:gamePage) => {
      this.titleText = json.title;
      this.mainText = json.description;
      this.images = json.images;
    });
  }

  ngAfterViewInit(): void {
    this.updateStyle(this.titleElement, this.titleItems);
    this.updateStyle(this.textElement, this.mainItems);
  }

  splitText(text : string, array:item[]){
    for(var i = 0; i<text.length; i++){
      if(text[i] === "." || text[i] === ","){
        text = [text.slice(0,i), ' ', text.slice(i)].join('');
        i +=1;
      }else if(text[i] === "'"){
        text = [text.slice(0,i), ' ', text.slice(i,i+1), ' ', text.slice(i+1)].join('');
        i+=2;
      }
    }

    text.split(" ").forEach((e:string, index) => {
      array.push({
        id:index,
        text:e,
        lenght:e.length,
        find: false
      });
    });
  }

  updateStyle(htmlElement : ElementRef, items:item[]){
    htmlElement.nativeElement.childNodes.forEach((htmlElement: ElementRef, index:number) => {
      if(typeof items[index] != "undefined"){
        this.renderer.setStyle(htmlElement,'width',`${10*items[index].lenght+5}px`);
        if (items[index].text === '.' ||items[index].text === ',' || items[index].text ==="'"){

          items[index].find = true;
          this.renderer.setProperty(htmlElement, 'textContent', items[index].text);
          this.renderer.setStyle(htmlElement, 'width', 'initial');
          this.renderer.addClass(htmlElement, 'show');
          this.renderer.removeClass(htmlElement, "hide");
        }
      }
    });
  }

  updateInput(mot : string){
    this.mot = mot.trim();
  }

  testMot(){
    this.findMot(this.mot, this.mainItems, this.textElement.nativeElement.childNodes);
    this.findMot(this.mot, this.titleItems, this.titleElement.nativeElement.childNodes, true);
    this.testWin();
    if(!this.testedWords.includes(this.mot)){
      this.testedWords.push(this.mot);
    }
  }

  findMot(mot : string, array:item[], htmlElements:ElementRef[], hasNbFind:boolean = false){
    array.forEach((e, index)=>{
      if((!e.find) && (e.text.toLocaleLowerCase() == mot.toLocaleLowerCase())){
        e.find = true;
        this.renderer.setProperty(htmlElements[index], 'textContent', e.text);
        this.renderer.setStyle(htmlElements[index], 'width', 'initial');
        this.renderer.addClass(htmlElements[index], 'show');
        this.renderer.removeClass(htmlElements[index], "hide");
      }
    });
  }

  testWin(){
    if(this.titleItems.every((e)=>e.find===true)){
      this.mainItems.forEach((e, index) => {
        this.renderer.setProperty(this.textElement.nativeElement.childNodes[index], 'textContent', e.text);
        this.renderer.setStyle(this.textElement.nativeElement.childNodes[index], 'width', 'initial');
        this.renderer.addClass(this.textElement.nativeElement.childNodes[index], 'show');
        this.renderer.removeClass(this.textElement.nativeElement.childNodes[index], "hide");
      });
    }
  }
}

export interface item{
  id: number;
  text: string;
  lenght: number;
  find: boolean;
}
