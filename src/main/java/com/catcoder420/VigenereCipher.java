package com.catcoder420;

public class VigenereCipher implements Cipher{

    private final String key;

    public VigenereCipher(String key){
        this.key = key;
    }

    
    @Override
    public String encrypt(String input){
        return shift(input, encodeKey(key));
    }

    @Override
    public String decrypt(String input){
        return shift(input, negateValues(encodeKey(key)));
    }

    private int[] encodeKey(String k){
        int[] shift = new int[k.length()];
        
        for(int i = 0; i < k.length(); i++){
            if(Character.isLowerCase(k.charAt(i))){
                shift[i] = k.charAt(i) - 'a';
            }
            else if(Character.isUpperCase(k.charAt(i))){
                shift[i] = k.charAt(i) - 'A';
            }
            else{
                throw new IllegalArgumentException("Only letters are allowed for the key");
            }
        }

        return shift;
    }

    private String shift(String input, int[] shiftValue){
        char[] out = new char[input.length()];
        
        for(int i = 0; i < input.length(); i++){
            int shift = shiftValue[i % shiftValue.length];

            if(Character.isLowerCase(input.charAt(i))){
                int index = (((input.charAt(i) - 'a') + shift) + 26) % 26;
                out[i] = (char) ('a' + index);
            }
            else if(Character.isUpperCase(input.charAt(i))){
                int index = (((input.charAt(i) - 'a') + shift) + 26) % 26;
                out[i] = (char) ('a' + index);
            }
            else{
                out[i] = input.charAt(i);
            }
        }

        return new String(out);
    }

    private int[] negateValues(int[] shift){
        
        for(int i = 0; i < shift.length; i++){
            shift[i] = -shift[i];
        }

        return shift;
    }
}



  



