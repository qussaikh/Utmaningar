import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("** Välkommen till Namn lista ** ");
        ArrayList<String> namn = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("*---------------------------*");
            System.out.println("Listan innehåller " + namn.size() + " namn.   |");
            System.out.println("*---------------------------*");
            System.out.println(" Vad vill du göra?          |");
            System.out.println("1. Mata in ett namn         |");
            System.out.println("2. Radera ett namn          |");
            System.out.println("3. Ändra ett namn           |");
            System.out.println("4. Lista alla namn          |");
            System.out.println("5. Avsluta programmet       |");
            System.out.println("*---------------------------*");
            int val = input.nextInt();
            input.nextLine();
            String nyttNamn = null;

            switch (val){
                case 1:
                    System.out.println("Vilket namn vill du skapa: ");
                    nyttNamn = input.nextLine();
                    namn.add(nyttNamn);
                    System.out.println(nyttNamn + " har lagts till i listan.");
                    break;
                case 2:
                    if (namn.size() == 0 ){
                        System.out.println("Listan har ingen namn för att ta bort.");
                        break;
                    }
                    System.out.println(" Namnar som är i listan.");
                    System.out.println("==> " + namn);
                    System.out.println(" Vilken namn vill du ta bort? ");

                    String raderaNamn = input.next();
                    if (namn.contains(raderaNamn)) {
                        namn.remove(raderaNamn);
                        System.out.println(raderaNamn + " har raderats från listan.");
                    } else
                        System.out.println(raderaNamn + " finns inte i listan.");
                    break;
                case 3:
                    if (namn.size() == 0 ){
                        System.out.println("Listan har ingen namn för att Ändra.");
                        break;
                    }
                    System.out.println(" Namnar som är i listan.");
                    System.out.println("==> " + namn);
                    System.out.println(" Vilket namn vill du ändra? ");
                    String gammaltNamn = input.next();

                    if (namn.contains(gammaltNamn)) {
                        System.out.println("Ange nytt namn:");
                        String ändraNamn = input.next();
                        namn.set(namn.indexOf(gammaltNamn), ändraNamn);
                        System.out.println(gammaltNamn + " har uppdaterats till " + nyttNamn + ".");
                    } else {
                        System.out.println(gammaltNamn + " finns inte i listan.");
                    }
                    break;
                case 4:
                    if (namn.size() > 0 ) {
                        System.out.println("Namnar i listan.");
                        for (String name : namn) {
                            System.out.println(name);
                        }
                    }else System.out.println("Listan är tom.");

                    System.out.println("Antal namn: " + namn.size() + ".");
                    break;
                case 5:
                    System.out.println("Program avslutas.");
                    System.out.println("Tack för ditt tålamod.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ogiltigt val. Försök igen.");
                    break;
            }
        }
    }
}
