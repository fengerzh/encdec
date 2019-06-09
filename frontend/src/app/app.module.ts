import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {
  MatFormFieldModule,
  MatInputModule,
  MatButtonModule
} from '@angular/material';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AesEcbComponent } from './aes-ecb/aes-ecb.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AesCbcComponent } from './aes-cbc/aes-cbc.component';
import { RsaComponent } from './rsa/rsa.component';

@NgModule({
  declarations: [AppComponent, AesEcbComponent, AesCbcComponent, RsaComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
