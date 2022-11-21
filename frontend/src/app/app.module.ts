import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { LoginPageComponent } from './Modules/login-page/login-page.component';

import { AppComponent } from './Modules/root/app.component';
import { LogoWikiHoaxComponent } from './shared/components/logo-wiki-hoax/logo-wiki-hoax.component';
import { TextboxComponent } from './shared/components/textbox/textbox.component';
import { MainPageComponent } from './Modules/main-page/main-page.component';
import { HeaderButtonComponent } from './Modules/main-page/header-button/header-button.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    LogoWikiHoaxComponent,
    TextboxComponent,
    MainPageComponent,
    HeaderButtonComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
