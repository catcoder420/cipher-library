package com.catcoder420;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Random;



public class CipherTests {
    CaesarCipher cc = new CaesarCipher(3);
    AtbashCipher ac = new AtbashCipher();
    VigenereCipher vc = new VigenereCipher("def");
    Random r = new Random();

    // ==========
    // Caesar
    // ==========

    @Test
    public void testCaesarEncrypt(){
        String result =
            cc.encrypt("abc");

        assertEquals("def", result);
    }

    @Test
    public void testCaesarDecrypt(){
        String result =
            cc.decrypt("def");

        assertEquals("abc", result);
    }

    @Test
    public void testCaesarWrapAround(){
        String result =
            cc.encrypt("xyz");
        
        assertEquals("abc", result);
    }

    @Test
    public void testCaesarEmptyString(){
        String result =
            cc.encrypt("");
        
        assertEquals("", result);
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
