package com.fengerzh.backend;

import org.springframework.web.bind.annotation.RestController;

import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class HelloController {

    /**
     * 用AES/ECB解密
     * 
     * @param payload 入参
     * @return
     */
    @RequestMapping(value = "/login-aes-ecb", method = RequestMethod.POST, produces = "application/json")
    public String loginAesEcb(@RequestBody Map<String, Object> payload) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec("0000000000000000".getBytes(), "AES"));
            String plaintext = new String(
                    cipher.doFinal(Base64.getDecoder().decode(payload.get("password").toString().getBytes())), "UTF-8");
            System.out.println(plaintext);
        } catch (Exception e) {
            System.out.println("解密出错：" + e.toString());
        }
        return "{\"success\":1}";
    }

    /**
     * 用AES/CBC解密
     * 
     * @param payload
     * @return
     */
    @RequestMapping(value = "/login-aes-cbc", method = RequestMethod.POST, produces = "application/json")
    public String loginAesCbc(@RequestBody Map<String, Object> payload) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec("0000000000000000".getBytes(), "AES"),
                    new IvParameterSpec("0000000000000000".getBytes()));
            String plaintext = new String(
                    cipher.doFinal(Base64.getDecoder().decode(payload.get("password").toString().getBytes())), "UTF-8");
            System.out.println(plaintext);
        } catch (Exception e) {
            System.out.println("解密出错：" + e.toString());
        }
        return "{\"success\":1}";
    }

    /**
     * 用RSA解密
     * 
     * @param payload
     * @return
     */
    @RequestMapping(value = "/login-rsa", method = RequestMethod.POST, produces = "application/json")
    public String loginRsa(@RequestBody Map<String, Object> payload) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(Cipher.DECRYPT_MODE,
                    KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(
                            "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDHXktDQP9Yckw8KLC4x8cqDowNwljGZLn5Nz5EZrfeeIESkNM2G8iQBMzcXQC/jbHyz8RQfAe/0XqQeIK/DyDOpXTCgqCPrGIaZ4WR3QCm6u08LAFz4QWGjW2Eub6++qSwtU8ph0CRcQsOuUzQEuU13asna3qf0G+Dgjhq2w0X08biP8WHtEXDhU6HDaZXULrUTqemzZuw7DYAj3C7leZ7sd8OQyi+n+NJEmUYa0xFHUErLesT8IJ99H0hrW8cnr33JF0aVFy0gcjW0TLY+aun+AP+j5fqDBvViqdb6n9siM7UfYKKACFWVuCKdH1YZlrtNIo/PGGwvdf2CS4mC5aXAgMBAAECggEAYn8Je+6OuKmvVEFeHcxFb1fEhb+wkEOPRbqvPqfoyzaJvhxi3OaZDd3xQCWKixh8A9P1zzWXtoLNpLaFEdNth+piZv6WSKUHyre+W7Pt8Ik8L3AmP5O6YSFaLCqAPGYkG1FYDNJPaguJRPrzIhFTwGsFdfI5oN8fWL9rFA+oxk3wb4g+B29Dr+7PCOarlaAfAN4EIlREj33+vmqnq0BudzIiU1eZRDh+fxMF+LOnKkuM3zQs2HlDEhoZdvUDDouUEY+/cMBP6rto5h0lGg6CtxE1EXzYxlsHZSMlaq1a7JqWtjIJZg9mp+CIxduYSmnCHqG32HQW3O+Vseu1fkCRsQKBgQD2cxexZmZdqXUMkSdtxdVi2wMlLFbpmrddI0I8miMNbfhsKw5xRQZ0X1B1EsJC1eT8krvWqJZKbSnPciylfvL3nnquljZGtM5YQ1ZbcD2uZ59cS6nX16vt1zl/wYWXA2oYgQ/9UkUAj+rl9vuD3bel1a2F0YForKOfwn3H1VrgAwKBgQDPGCGRKuyheHbkvnXlW1sEOCDqs1Mj+bDaOJyd6/eyZK0ud8mT0VEtUsbg/GWQHa5mMU25jTEbt7Db4iYlakHaY3Lpo0F0bVLK13Xh3jKpSVxGdToES9eqjYBWQOKkTbAar6T/DsS4kl8BwI2YAa3tpxS7QnM7zYsW1uJEKLK83QKBgFqQMq2zFnzmr6edk6KoJ2D7YG2BnLKdczJbqZSBg84EklyVeeov1k5fVD6hVRegaFRUS4h3TTsuYEXmC/gI7ZoG98g+VNWozYbrv8k8Nr5nP8131IMHsxtkkrGa2M+EprE4hDqvx8GMIWK+XvC3QixDmE9rjKV9g2dK3lPX2FwnAoGBAM78oHg2veI5xCOm1bFTGOpjq0rJxzx60S+bS7Zv5deQ1qNOKNSsboVtacfvnRdpAymy96uQmlfIxmVPaK8WwBEmOvGYMdDLf+eraHBDpMEcyLTHcCBhKYKXAYG0QpLT70MM8U3Ylfigm4Ll0N/wNcYFrCvqI8DPFMjUJ7zWLKelAoGBAOOlVr0Jf2Hsm4evhklgoAejdOQvkziRPf08Vg1RLIZFGim7K9SoffDaTu0MJns7hXk8zAOgK+F5XQNmmUKlbBlm6y5PtdWIkpO5Lvp776srq41IqHFrfWIuFPMl/CvvcgfmjKHgN0+2RAYCSpfEiVtl7JlJ4Iq4z4Ye3KA5baAd"))));
            String plaintext = new String(
                    cipher.doFinal(Base64.getDecoder().decode(payload.get("password").toString().getBytes())), "UTF-8");
            System.out.println(plaintext);
        } catch (Exception e) {
            System.out.println("解密出错：" + e.toString());
        }
        return "{\"success\":1}";
    }

}