package com.catcoder420;


public class CaesarCipher implements Cipher{

    private final int key;

    public CaesarCipher(int key){
        this.key = key;
    }

    @Override
    public String encrypt(String input){
        return shift(input, key);
    }

    @Override
    public String decrypt(String input){
        return shift(input, -key);
    }
     
    private String shift(String input, int k){
        char[] in = input.toCharArray();
        char[] out = new char[in.length];

        for(int i = 0; i < in.length; i++){
            if(Character.isLowerCase(in[i])){
                int shift = ((((in[i] - 'a') + k)% 26 + 26) % 26); 
                out[i] = (char) ('a' + shift);
                    
            }else if(Character.isUpperCase(in[i])){
                int shift = ((((in[i] - 'A') + k)% 26 + 26) % 26);
                out[i] = (char) ('A' + shift);
                    
            }else{
                out[i] = in[i];
            }
        }
            
        return new String(out);
    } 
        
}

