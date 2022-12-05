package Sevices;

import java.io.*;
import java.util.Scanner;

public class MyServices {
    private String[] words;

    public FileReader createFileReader(String file) throws FileNotFoundException {
        File f = new File(file);
        FileReader fr = new FileReader(f);
        return fr;
    }
    public int getNumberOfOccurrencesInTheTextBufferedReader(FileReader fr, String searchWord) throws IOException {
        BufferedReader br = new BufferedReader(fr);
        Reader<BufferedReader> reader = new Reader<>();
        return reader.getCountWord(br,searchWord);
    }
    public int getNumberOfOccurrencesInTheTextScaner(FileReader fr, String searchWord) throws IOException {
        Scanner br = new Scanner(fr);
        Reader<Scanner> reader = new Reader<>();
        return reader.getCountWord(br,searchWord);
    }


    public String multiplicationTable(){
        StringBuilder returnString = new StringBuilder();
        for(int i = 1;i<=10;i++){
            for(int j = 1;j<=10;j++){
                returnString.append(i*j);
                returnString.append(" ");
            }
            returnString.append("\n");
        }
        return returnString.toString();
    }


}
