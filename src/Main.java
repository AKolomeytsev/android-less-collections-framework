import Sevices.MyServices;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MyServices ms = new MyServices();
        String sb = "Страдание";
        String sw = sb.substring(0, sb.length() - 4);
        int count = ms.getNumberOfOccurrencesInTheTextBufferedReader(ms.createFileReader(
                "C:\\Users\\akolomeytsev\\IdeaProjects\\android-less-collections-framework\\file.txt"), sw);
        System.out.println("BufferedReader - "+ count);
        count = ms.getNumberOfOccurrencesInTheTextScaner(ms.createFileReader(
                "C:\\Users\\akolomeytsev\\IdeaProjects\\android-less-collections-framework\\file.txt"), sw);
        System.out.println("Scaner - "+ count);

        System.out.println();
        System.out.println(ms.multiplicationTable());
    }
}
