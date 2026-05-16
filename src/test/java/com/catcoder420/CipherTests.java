package com.catcoder420;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Random;


public class CipherTests {
    AtbashCipher ac = new AtbashCipher();
    VigenereCipher vc = new VigenereCipher("def");
    Random r = new Random();

    // ==========
    // Helper Functions
    // ==========

    private String randomString(){
        char[] alphabet = 
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        char[] out = new char[r.nextInt(1, 100)];
        
        for(int i = 0; i < out.length; i++){
            out[i] = alphabet[r.nextInt(alphabet.length)];
        }

        return new String(out);
    }

    // ==========
    // Caesar
    // ==========


    // general test

    @Test 
    public void testCaesar(){
        int key = 8;
        String text = "Hello World!";
        CaesarCipher cc = new CaesarCipher(key);

        String encrypted = cc.encrypt(text);
        String decrypted = cc.decrypt(encrypted);

        assertEquals(text, decrypted);
    }

    // edge cases
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

    @Test
    public void testCaesarRandom(){

        int i;

        for(i = 0; i < 1000; i++){
            int key = r.nextInt(100);
            String text = randomString();
            CaesarCipher cc = new CaesarCipher(key);

            String encrypted = cc.encrypt(text);
            String decrypted = cc.decrypt(encrypted);

            if(!decrypted.equals(text)){
                break;
            } 
        }

        assertEquals(1000, i);
    }



    // ==========
    // Atbash
    // ==========

    // general test 

    @Test
    public void testAtbash(){
        String text = "Hello World!";
        AtbashCipher ac = new AtbashCipher();

        String encrypted = ac.encrypt(text);
        String decrypted = ac.decrypt(encrypted);

        assertEquals(text, decrypted);
    }

    // egde cases

    @Test
    public void testAtbashEmptyString(){
        String text = "";
        AtbashCipher ac = new AtbashCipher();

        String encrypted = ac.encrypt(text);
        String decrypted = ac.decrypt(encrypted);

        assertEquals(text, decrypted);  
    }

    // random test

    @Test
    public void testAtbashRandom(){

        int i;

        for(i = 0; i < 1000; i++){
            String text = randomString();
            AtbashCipher ac = new AtbashCipher();

            String encrypted = ac.encrypt(text);
            String decrypted = ac.decrypt(encrypted);

            if(!decrypted.equals(text)){
                break;
            } 
        }

        assertEquals(1000, i);
    }


    // ========== 
    // Vigenere
    // ==========

    // general test

    @Test
    public void testVigenere(){
        String text = "Hallo World!";
        String key = "test";
        VigenereCipher vc = new VigenereCipher(key);

        String encrypted = vc.encrypt(text);
        String decrypted = vc.decrypt(encrypted);

        assertEquals(text, decrypted);
    }

    // edge cases

    @Test(expected = IllegalArgumentException.class)
    public void testVigenereIllegalKey(){
        String text = "Hallo World!";
        String key = "abcd1";
        VigenereCipher vc = new VigenereCipher(key);

        vc.encrypt(text);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testVigenereEmptyKey(){
        String text = "Hello World!";
        String key = "";
        VigenereCipher vc = new VigenereCipher(key);

        vc.encrypt(text);

    }

    @Test
    public void testVigenereLongKey(){
        String text = "Hello World!";
        String key = "thisisaverylongkeymuchlongerthanthetext";
        VigenereCipher vc = new VigenereCipher(key);

        String encrypted = vc.encrypt(text);
        String decrypted = vc.decrypt(encrypted);

        assertEquals(text, decrypted);
    }

    @Test
    public void testVigenereLongKeyLongText(){
        String text = "Hello World!".repeat(1000);
        String key = "KeyKEY".repeat(100);
        VigenereCipher vc = new VigenereCipher(key);

        String encrypted = vc.encrypt(text);
        String decrypted = vc.decrypt(encrypted);

        assertEquals(text, decrypted);   
    }

    // random test

    @Test
    public void testVigenereRadnom(){      
         
        int i;

        for(i = 0; i < 1000; i++){
            String text = randomString();
            String key = randomString();
            VigenereCipher vc= new VigenereCipher(key);

            String encrypted = vc.encrypt(text);
            String decrypted = vc.decrypt(encrypted);

            if(!decrypted.equals(text)){
                break;
            } 
        }

        assertEquals(1000, i);
    }
}
