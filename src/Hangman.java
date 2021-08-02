import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.Initializable;
public class Hangman  {
    private static   ArrayList<String> dict;
    private static   ArrayList<String> hang;
    private static   ArrayList<String> store;
    public static String text = "";
    public static String teest = "/repeat.PNG";
    public static boolean end = false;
    private static String chosenWord;
    public static char[] ch;
    public static String image;
    private static boolean correct = false;
    private static int count = 1;
    private static int count2 = 0;

    public static void load() throws FileNotFoundException{

        Scanner s = new Scanner(new File("dictionary.txt"));
        Scanner s1 = new Scanner(new File("hang.txt"));
        dict = new ArrayList<String>();
        hang = new ArrayList<String>();
        store = new ArrayList<String>();

        while (s.hasNextLine()) {
            dict.add(s.nextLine());
        }

        while (s1.hasNextLine()) {
            hang.add(s1.nextLine());
        }


    }



    public static void initialize() throws FileNotFoundException {
        load();
        store.add("");
        image = hang.get(0);
        chosenWord = dict.get((int)(dict.size()*Math.random()));
        System.out.println(chosenWord);
        for(int i =0;i<(chosenWord.length());i++) {
            text = text + "- ";
        }
        ch = text.toCharArray();
        System.out.println(text);
    }



    public static void replace(char input) {
        String t="";

        for(int i = 0; i < chosenWord.length(); i++) {

            if(store.contains(Character.toString(input))==false) {
                if(input == chosenWord.charAt(i)) {
                    end = false;
                    correct = true;
                    ch[i*2]=input;
                    System.out.println(ch);
                    count2++;
                    if(count2 == chosenWord.length()) {
                        image = hang.get(7);

                    }
                }
            }else if(store.contains(Character.toString(input))==true) {
                end = true;
                break;
            }

        }
        if(store.contains(Character.toString(input))==false) {
            end = false;
            if(correct == false && count < hang.size()-1 ) {
                image = hang.get(count);
                count++;

            }
        }
        for(char x:ch) {
            t =t+x;
        }
        text = t;
        correct = false;
        store.add(Character.toString(input));
    }


}
