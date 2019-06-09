import { Component, OnInit } from '@angular/core';
import { ConfigService } from '../config.service';
import * as forge from 'node-forge';

@Component({
  selector: 'app-rsa',
  templateUrl: './rsa.component.html',
  styleUrls: ['./rsa.component.css']
})
export class RsaComponent implements OnInit {
  username = '';
  password = '';

  constructor(private configService: ConfigService) {}

  ngOnInit() {}

  login() {
    const pki = forge.pki;
    const publicKey = pki.publicKeyFromPem(`-----BEGIN RSA PUBLIC KEY-----
MIIBCgKCAQEA+I21NPWzvEV+PFPhqVMSXptzfaNSm7yyBk8/1O5ikqPAG0ByeV16
D4DHZQH4tmfgUaPlqlLVgh5c9nbJg6ABW54LgfLCXd5WZcSJuUmziTlmNIsOLXTQ
EB8cMwvBi2+noKsTohKmNu4zRDD9GHrcM/qKUfY9rmOEkCedOh7RcAJnUGrzEBv1
3Pv4Uje9QpdeYnjbjqwbIaVoOezbx+708VvydDfnEzkQIhF5vUwYALxOZODO1rj8
8r70eKmIhSVzRQJ+nk9ImlXAQchupickUlj3SvwFIaU4TQ4XIKQ/WKRR3OoXnQMI
4s4aiB7+iJ/T+wyFIbgIo8VqkTMf7g4bLwIDAQAB
-----END RSA PUBLIC KEY-----`);
    const encrypted = publicKey.encrypt('123456', 'RSA-OAEP', {
      md: forge.md.sha256.create(),
      mgf1: {
        md: forge.md.sha1.create()
      }
    });
    console.log(forge.util.encode64(encrypted));

    // const cipher = forge.cipher.createCipher('AES-ECB', '0000000000000000');
    // cipher.start();
    // cipher.update(forge.util.createBuffer(this.password));
    // cipher.finish();
    // const encrypted = forge.util.encode64(cipher.output.getBytes());
    // console.log(encrypted);

    // this.configService.getConfig().subscribe((data: any) => {
    //   console.log(data);
    // });
  }
}
