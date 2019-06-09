import { Component, OnInit } from '@angular/core';
import { ConfigService } from '../config.service';
import * as forge from 'node-forge';

@Component({
  selector: 'app-aes-ecb',
  templateUrl: './aes-ecb.component.html',
  styleUrls: ['./aes-ecb.component.css']
})
export class AesEcbComponent implements OnInit {
  username = '';
  password = '';

  constructor(private configService: ConfigService) {}

  ngOnInit() {}

  login() {
    const cipher = forge.cipher.createCipher('AES-ECB', '0000000000000000');
    cipher.start();
    cipher.update(forge.util.createBuffer(this.password));
    cipher.finish();
    this.configService
      .postLoginAesEcb({
        username: this.username,
        password: forge.util.encode64(cipher.output.getBytes())
      })
      .subscribe((data: any) => {
        console.log(data);
      });
  }
}
