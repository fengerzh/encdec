import { Component, OnInit } from '@angular/core';
import { ConfigService } from '../config.service';
import * as forge from 'node-forge';

@Component({
  selector: 'app-aes-cbc',
  templateUrl: './aes-cbc.component.html',
  styleUrls: ['./aes-cbc.component.css']
})
export class AesCbcComponent implements OnInit {
  username = '';
  password = '';

  constructor(private configService: ConfigService) {}

  ngOnInit() {}

  login() {
    const cipher = forge.cipher.createCipher('AES-CBC', '0000000000000000');
    cipher.start({ iv: '0000000000000000' });
    cipher.update(forge.util.createBuffer(this.password));
    cipher.finish();
    this.configService
      .postLoginAesCbc({
        username: this.username,
        password: forge.util.encode64(cipher.output.getBytes())
      })
      .subscribe((data: any) => {
        console.log(data);
      });
  }
}
