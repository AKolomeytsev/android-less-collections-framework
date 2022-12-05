package Sevices;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Reader<T> {
    public int getCountWord(T text,String searchWord) throws IOException {
        int count = 0;
        Class<? extends Object> s = text.getClass();
        if(s.getName().equalsIgnoreCase("java.io.BufferedReader")){
            return bufferRead((BufferedReader) text,searchWord);
        }

        if(s.getName().equalsIgnoreCase("java.util.Scanner")){
            return ScannerReader((Scanner) text,searchWord);
        }

        return count;
    }

    private int ScannerReader(Scanner text, String searchWord) {
        int count = 0;
        String currentLine;
        while(text.hasNext()){
            currentLine = text.nextLine();
            String[] words = currentLine.split(" ");
            count+=find(words,searchWord);
        }
        return count;
    }

    private int bufferRead(BufferedReader text,String searchWord) throws IOException {
        int count = 0;
        String currentLine;
        while((currentLine = text.readLine())!=null){
            String[] words = currentLine.split(" ");
            count+=find(words,searchWord);
        }
        return count;
    }

    private int find(String[] words,String searchWord){
        int count = 0;
        for(String word:words){
            if(isEqual(searchWord,word)){
                count++;
            }
        }
        return count;
    }
    private boolean isEqual(String word1, String word2){
        if(word1.length() < word2.length()) {
            return word1.equalsIgnoreCase(cut(word2, word1.length()));
        }else if(word1.length() > word2.length()){
            return false;
        }
        return word1.equalsIgnoreCase(word2);
    }

    private String cut(String word, int len){
        StringBuilder returnString = new StringBuilder();
        for(int i = 0;i<len;i++){
            returnString.append(word.charAt(i));
        }
        return returnString.toString();
    }
}
