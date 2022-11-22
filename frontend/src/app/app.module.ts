import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { LoginPageComponent } from './Modules/login-page/login-page.component';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './Modules/root/app.component';
import { LogoWikiHoaxComponent } from './shared/components/logo-wiki-hoax/logo-wiki-hoax.component';
import { TextboxComponent } from './shared/components/textbox/textbox.component';
import { MainPageComponent } from './Modules/main-page/main-page.component';
import { HeaderButtonComponent } from './Modules/main-page/header-button/header-button.component';
import { UserButtonComponent } from './Modules/main-page/user-button/user-button.component';
import { GamePageComponent } from './Modules/game-page/game-page.component';
import { CarrouselComponent } from './shared/components/carrousel/carrousel.component';
import { TutoPageComponent } from './Modules/tuto-page/tuto-page.component';
import { RankPageComponent } from './Modules/rank-page/rank-page.component';
import { UserPageComponent } from './Modules/user-page/user-page.component';
import { RankTableComponent } from './Modules/rank-page/rank-table/rank-table.component';
import { DynamicWidthDirective } from './Modules/game-page/Directives/dynamic-width.directive';

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    LogoWikiHoaxComponent,
    TextboxComponent,
    MainPageComponent,
    HeaderButtonComponent,
    UserButtonComponent,
    GamePageComponent,
    CarrouselComponent,
    TutoPageComponent,
    RankPageComponent,
    UserPageComponent,
    RankTableComponent,
    DynamicWidthDirective
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
