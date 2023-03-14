import java.util.ArrayList;
import java.util.Random;

public class WordList {
    private ArrayList<String> words;

    public WordList() {
        words = new ArrayList<>();
        words.add("programmering");
        words.add("dator");
        words.add("uppgift");
        words.add("java");
        words.add("program");
        words.add("katt");
        words.add("cykel");
        words.add("sol");
        words.add("bok");
        words.add("äpple");
        words.add("vatten");
        words.add("stol");
        words.add("hund");
        words.add("glass");
        words.add("park");
        words.add("grön");
        words.add("lampa");
        words.add("säng");
        words.add("mus");
    }

    public String slumpOrd() {
        Random rand = new Random();
        int index = rand.nextInt(words.size());
        return words.get(index);
    }
}

