import java.util.Random;
import java.util.Scanner;

public class War {


    private static Boolean kick(Player defender, Player attacker, War.FightCallback fightCallback) {

        int hit = attacker.attack();
        int defenderHealth = defender.getHealth() - hit;

        if (hit != 0) {
            System.out.println(attacker.getName() + "Hit with power of" + hit);
            System.out.println(defender.getName() + "Health is " + defenderHealth);

        } else {
            System.out.println(attacker.getName() + "Miss a hit");
        }
        if (defenderHealth <= 0 && defender instanceof Hero) {
            System.out.println("Sorry" + defender.getName() + "you're dead! :(");
            fightCallback.fightLost();
            return true;

        } else if (defenderHealth <= 0) {
            System.out.println("Our Hero win!" + defender.getName() + "You're getting" + defender.getSkills() + defender.getGold());
            attacker.setSkills(attacker.getSkills() + defender.getSkills());
            attacker.setGold(attacker.getGold() + defender.getGold());
            fightCallback.fightWin();
            return true;

        } else {
            defender.setHealth(defenderHealth);
            return false;
        }


    }

    public static void fight(Player hero, Player monster, War.FightCallback fightCallback) {

        Runnable runnable = () -> {

            int turn = 1;
            boolean isFightEnded = false;

            while (!isFightEnded) {
                System.out.println("-----Turn" + turn + "------");
                if (turn++ % 2 != 0) {
                    isFightEnded = kick(monster, hero, fightCallback);

                } else {
                    isFightEnded = kick(hero, monster, fightCallback);
                }

            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

    private static Player MonsterSelection() {

        Random rand = new Random();
        int randomRange = 2;
        int monsterSelect = rand.nextInt(randomRange);


        if (monsterSelect == 1) {
            return new Goblin(100, 10, 10, 100);

        } else {
            return new Skelet(100, 10, 10, 100);

        }

    }

    interface FightCallback {
        void fightWin();

        void fightLost();
    }



         public void WarBegins() {
            Player hero = new Hero(10,10,20,30);

             War.fight( hero, MonsterSelection(), new FightCallback() {





            @Override
            public void fightWin() {
                System.out.println(String.format("%s победил! Теперь у вас %d опыта и %d золота, а также осталось %d едениц здоровья." + hero.getName(), hero.getSkills(), hero.getGold(), hero.getHealth()));

            }

            @Override
            public void fightLost() {

            }
        });
    }

}



