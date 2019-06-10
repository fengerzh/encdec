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
    this.configService
      .postLoginRsa({
        username: this.username,
        password: forge.util.encode64(
          forge.pki
            .publicKeyFromPem(
              `-----BEGIN RSA PUBLIC KEY-----
MIIBCgKCAQEAx15LQ0D/WHJMPCiwuMfHKg6MDcJYxmS5+Tc+RGa33niBEpDTNhvI
kATM3F0Av42x8s/EUHwHv9F6kHiCvw8gzqV0woKgj6xiGmeFkd0ApurtPCwBc+EF
ho1thLm+vvqksLVPKYdAkXELDrlM0BLlNd2rJ2t6n9Bvg4I4atsNF9PG4j/Fh7RF
w4VOhw2mV1C61E6nps2bsOw2AI9wu5Xme7HfDkMovp/jSRJlGGtMRR1BKy3rE/CC
ffR9Ia1vHJ699yRdGlRctIHI1tEy2Pmrp/gD/o+X6gwb1YqnW+p/bIjO1H2CigAh
VlbginR9WGZa7TSKPzxhsL3X9gkuJguWlwIDAQAB
-----END RSA PUBLIC KEY-----`
            )
            .encrypt(this.password, 'RSA-OAEP', {
              md: forge.md.sha256.create(),
              mgf1: {
                md: forge.md.sha1.create()
              }
            })
        )
      })
      .subscribe((data: any) => {
        console.log(data);
      });
  }
}
