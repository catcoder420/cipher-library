# CIPHER-LIBARY IN JAVA

A collection of different ciphers written in Java inclouding: CaesarCipher, AtbashCipher, VigenereCipher

Supports encryption and decryption of lower and uppercase alphabetic text


## Feautures

-Encrypt text
-Decrypt text
-Custom keys
-Unit tests


## Example

```java

Cipher cipher = new Cipher("def"); //cipher can be one of the mentioned ciphers 

String encrypted = cipher.encrypt("abc"); //encrypting text "abc" with key "def"

String decrypted = cipher.decrypt(encrypted); //decrypting encrypted text abc¨


## Build

```bash
mvn package
```


## Run Tests

```bash
mvn test
```


## Project Structure

src/main/java - source code
src/test/java - tests


## How the algorythems work 

Caesar: https://en.wikipedia.org/wiki/Caesar_cipher

Atbash: https://en.wikipedia.org/wiki/Atbash

Vigenere: https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher
