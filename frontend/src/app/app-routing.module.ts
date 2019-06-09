import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AesEcbComponent } from './aes-ecb/aes-ecb.component';
import { AesCbcComponent } from './aes-cbc/aes-cbc.component';
import { RsaComponent } from './rsa/rsa.component';

const routes: Routes = [
  {
    path: 'aes-ecb',
    component: AesEcbComponent
  },
  {
    path: 'aes-cbc',
    component: AesCbcComponent
  },
  {
    path: 'rsa',
    component: RsaComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
