package Lab5_slot7;

import java.util.*;

public class LyricSet {
    public static final String [] lyric = {"you", "say", "it", "best",
            "when", "you", "say", "nothing", "at", "all"};

    public static void main(String[] args) {

        Set words = new HashSet();

        for (String w : lyric)
            words.add(w);

        for (Object o : words)
            System.out.print(o + " ");
        System.out.println("\n------------------");
        System.out.println("Contains [you]?:" + words.contains("you"));
        System.out.println("Contains [me]?:" + words.contains("me"));

    }


}
