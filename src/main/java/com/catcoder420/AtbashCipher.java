package com.catcoder420;

public class AtbashCipher implements Cipher{

    @Override
    public String encrypt(String input){
        return shift(input);
    }

    @Override
    public String decrypt(String input){
        return shift(input);
    }

    private String shift(String str){
        char[] in = str.toCharArray();
        char[] out = new char[in.length];

        for(int i = 0; i < in.length; i++){
            if(Character.isLowerCase(in[i])){
                out[i] = (char) ('z' - (in[i] - 'a'));
            }
            else if(Character.isUpperCase(in[i])){
                out[i] = (char) ('Z' - (in[i] - 'A'));
            }
            else{
                out[i] = in[i];
            }
        }

        return new String(out);
    }
}
