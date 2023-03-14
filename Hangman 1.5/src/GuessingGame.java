    import java.util.Scanner;

    public class GuessingGame {
        private static Scanner sc = new Scanner(System.in);
        private static WordList wordList = new WordList();
        private static String currentWord;
        private static char[] currentWordArray;
        private static boolean[] guessedLetters;
        private static Player player;


        public static void play() {
            infoPlayer();
            currentWord = wordList.slumpOrd();
            currentWordArray = currentWord.toCharArray();
            guessedLetters = new boolean[currentWordArray.length];
            processWord();
            won();
        }

        private static void infoPlayer() {
            System.out.println("Välkommen till gissningsleken!");
            System.out.println("Vad heter du? ");
            String name = sc.nextLine();
            player = new Player(name);

        }

        private static void processWord() {
            int guessesLeft = 6;
            System.out.println("Du ska gissa på ett ord som består av " + currentWordArray.length + " bokstäver.");
            while (guessesLeft > 0 && !wordGuessed()) {
                System.out.println("Du har " + guessesLeft + " gissningar " + player.getName());
                System.out.println(player.getName() + " gissa en bokstav: ");
                String input = sc.nextLine();
                char guess = input.charAt(0);
                guessWholeWord(input);

                boolean correctGuess = gusessRightOrWrong(guess);
                guessesLeft = guessResults(guessesLeft, correctGuess);
                for (int i = 0; i < currentWordArray.length; i++) {
                    if (guessedLetters[i]) {
                        System.out.print(currentWordArray[i] + " ");
                    } else {
                        System.out.print("_ ");
                    }
                }
                System.out.println();
            }
        }
        private static void guessWholeWord(String input) {
            if (input.length() == currentWord.length()) {
                if (input.equals(currentWord)) {
                    System.out.println("GRATTIS Du gissade ordet.");
                    askToFinish();
                }
            }
        }

        private static boolean gusessRightOrWrong(char guess) {
            boolean correctGuess = false;
            for (int i = 0; i < currentWordArray.length; i++) {
                if (currentWordArray[i] == guess) {
                    guessedLetters[i] = true;
                    correctGuess = true;
                }
            }
            return correctGuess;
        }

        private static void won() {
            if (wordGuessed()) {
                System.out.println("Grattis, " + player.getName() + " du har gissat ordet!");
            } else {
                System.out.println("Tyvärr, " + player.getName() + " du förlorade. Ordet var " + currentWord + ".");
            }
            System.out.println(player.toString() + ".");
            //System.out.println(player.getGuesses() + " " + player.getScore());
            askToFinish();
        }

        private static int guessResults(int guessesLeft, boolean correctGuess) {

            if (correctGuess) {
                System.out.println("Rätt gissning!");
                player.increasePoints();
            } else {
                System.out.println("Fel gissning.");
                DrawHangMan.drawHangMan(guessesLeft);
                guessesLeft--;
                player.increaseGuesses();
            }
            return guessesLeft;
        }

        // Kolla om spelaren har gissat hela ordet
        private static boolean wordGuessed() {
            for (boolean b : guessedLetters) {
                if (!b) {
                    return false;
                }
            }
            return true;
        }

        private static void askToFinish() {
            System.out.println("Vill du spela igen? (j/n)");
            String svar = sc.next();
            if (svar.equals("j")) {
                play();
            } else {
                godbye();
                System.exit(0);
            }
        }

        private static void godbye() {
            System.out.println(" Hejdå ");
            System.out.println(" Tack för tiden. ");
            System.exit(0);
        }
    }

