import java.util.Scanner;

public class Game  {





    public void StartGame() {

        System.out.println("Enter your player name: ");
        Scanner scHeroName = new Scanner(System.in);

        Player hero = new Hero(10, 10, 10, 10);
        hero.setName(scHeroName.nextLine());




        System.out.println("Greetings our new hero " + hero.getName() + "\n Where do you want to go " + hero.getName() + "?" +
                "\n 1. Go to Dealer " +
                "\n 2. Go to kick some monsters ass" +
                "\n 3. Exit");


        Scanner scanner = new Scanner(System.in);
        int heroSelect = scanner.nextInt();

       War war = new War();
        switch (heroSelect) {
            case 1:
                System.out.println("Not ready yet");
                break;
            case 2: war.WarBegins();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            case 3:
                break;

        }

    }
}





