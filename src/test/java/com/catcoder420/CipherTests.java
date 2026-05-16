package com.catcoder420;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class CipherTests {
    AtbashCipher ac = new AtbashCipher();
    VigenereCipher vc = new VigenereCipher("def");

    // ==========
    // Caesar
    // ==========


    //general Test
    @Test 
    public void testCaesar(){
        int key = 8;
        String text = "Hello World!";
        CaesarCipher cc = new CaesarCipher(key);

        String encrypted = cc.encrypt(text);
        String decrypted = cc.decrypt(encrypted);

        assertEquals(text, decrypted);
    }

    //edge cases
    @Test
    public void testCaesarWrapAround(){
        int key = 3;
        String text = "xyz";
        CaesarCipher cc = new CaesarCipher(key);

        String encrypted = cc.encrypt(text);
        String decrypted = cc.decrypt(encrypted);
        
        assertEquals(text, decrypted);
    }

    @Test
    public void testCaesarEmptyString(){
        int key = 3;
        String text = "";
        CaesarCipher cc = new CaesarCipher(key);
        
        String encrypted = cc.encrypt(text);
        String decrypted = cc.decrypt(encrypted);
        
        assertEquals(text, decrypted);
    }

    @Test 
    public void testCaesarBigKey(){
        int key = 80;
        String text = "Hello World!";
        CaesarCipher cc = new CaesarCipher(key);
        
        String encrypted = cc.encrypt(text);
        String decrypted = cc.decrypt(encrypted);
        
        assertEquals(text, decrypted);
    }

    @Test 
    public void testCaesarNegativKey(){
        int key = -3;
        String text = "Hello World";
        CaesarCipher cc = new CaesarCipher(key);
        
        String encrypted = cc.encrypt(text);
        String decrypted = cc.decrypt(encrypted);

        assertEquals(text, decrypted);
    }


    // ==========
    // Atbash
    // ==========

    @Test
    public void testAtbashEncrypt(){
        String result =
            ac.encrypt("abc");

        assertEquals("zyx", result);
    }


    // ========== 
    // Vigenere
    // ==========

    @Test
    public void testVigenereEncrypt(){
        String result =
            vc.encrypt("abc");
        
        assertEquals("dfh", result);

    }

    public void testVigenereDecrypt(){
        String result =
            vc.decrypt("dfh");

        assertEquals("abc", result);
    }

    @Test
    public void testVigenere(){
        String text = "helloworld";
        String key = "test";
        
        VigenereCipher vc = new VigenereCipher(key);

        String encrypted = vc.encrypt(text);
        String decrypted = vc.decrypt(encrypted);

        assertEquals(text, decrypted);
    }

}
