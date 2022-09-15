import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class io{
    public static void main(String[] args) {
        System.out.println(getSmallestEven("numbers1.txt"));
    }

    private static int getSmallestEven(String string) {
        Scanner fileInput = null;
        String[] list = null;
        try {
            fileInput = new Scanner(new File(string));
            while (fileInput.hasNextLine()) {
                list = fileInput.nextLine().split(",");
            }
        } catch (Exception e) {
            System.out.printf("ERROR: The file \'%s\' does not exist.", string);
            return 999;
        } finally {
            if (fileInput != null) {
                fileInput.close();
            }
        }
        int current = 0;
        int min = 999;
        for (int i = 0; i < list.length; i++) {
            current = Integer.parseInt(list[i]);
            if (current % 2 == 0) {
                min = Math.min(min, current);
            }
        }
        return min;
    }

    private static void encryptText(String string) {
        Scanner fileInput = null;
        try {
            fileInput = new Scanner(new File(string));
            while (fileInput.hasNext()){
                StringBuilder word = new StringBuilder(fileInput.next());
                for (int i = 0; i < word.length() ; i++) {
                    if (Character.isLowerCase(word.charAt(i))) {
                        word.setCharAt(i, Character.toLowerCase((char) (word.charAt(i) + 1)));
                    }
                }
                System.out.print(word + " ");
            }
        } catch (Exception e) {
            System.out.println("ERROR: The file 'error.txt' does not exist.");
        } finally {
            if (fileInput != null) {
                fileInput.close();
            }
        }
    }

    private static ArrayList<String> getWordsList(String string, int i) {
        ArrayList<String> out = new ArrayList<String>();
        Scanner input = null;
        try {
            input = new Scanner(new File(string));
            while (input.hasNext()) {
                String word = input.next().toLowerCase();
                if (word.length() == i){
                    if (out.contains(word) == false) {
                        out.add(word);
                    }
                    
                }
            }
        } catch (IOException e) {
            System.out.printf("ERROR: The file \'%s\' does not exist.\n", string);
            // TODO: handle exception
        } finally {
            if (input != null){
                input.close();
            }
        }
        out.sort(Comparator.naturalOrder());
        return out;
    }
    
}
