import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {
  constructor(private http: HttpClient) {}

  postLoginAesEcb(params) {
    return this.http.post('http://localhost:8080/login-aes-ecb', params);
  }

  postLoginAesCbc(params) {
    return this.http.post('http://localhost:8080/login-aes-cbc', params);
  }
}
