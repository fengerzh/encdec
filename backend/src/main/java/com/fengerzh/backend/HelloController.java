package com.fengerzh.backend;

import org.springframework.web.bind.annotation.RestController;

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

}