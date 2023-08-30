# cryptanalyzer

Technical task

1.The final program must be compiled in jar format. Place the jar file itself in releases on github.

2.The program can be run from the console by passing arguments.
-You can enter arguments in Run configuration > program arguments
The program is launched with the following arguments:
command filePath key - exactly in this order.
  --Running the application from the console itself will look like java -jar myApp.jar command filePath key
    command - three available options: [ENCRYPT, DECRYPT, BRUTE_FORCE]
    filepath - absolute (full) path to the file to be encoded.
    key - an integer, the key for shifting the alphabet.
-If there are spaces or special characters in the path to the jar file or to the text file. symbols
(* / \ $ % & # @ ! ( ) { } [ ] , ; ' ” < > | ^ ~.)`, then enclose such a path in double quotes.
java -jar "c:/My Project/target/my App.jar" ENCRYPT "folder name/textFile1.txt" 20
-In case of transfer ENCRYPT/DECRYPT key is mandatory.

3.As a result of the program, a file with the same name as the input file, but marked [ENCRYPTED] / [DECRYPTED] should appear in the folder with the initial file, depending on the operation performed.

4.The contents of the file must be encoded/decoded using the Caesar cipher.
-The shift in the alphabet must be cyclic.
-If the key is more than the number of letters in the alphabet, then go to the end of the alphabet and start over.

5.Only letters of the English alphabet (uppercase and lowercase) are encoded.
-You can also encode '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '. Other characters remain unchanged.
-Keep in mind that when encoding symbols, the cipher becomes "more reliable", but it will already be a modified Caesar cipher.

6.After decryption, the text should preserve the original formatting as much as possible (spaces, indents, carriage to the next line, signs, upper and lower case letters). Ideally, the text should not differ at all.

7.The program must use the same key to correctly encode and decode the file.

8.The program must have a brute-force mode for automatically selecting the key for the encrypted text and decrypting it.
