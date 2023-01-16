import java.util.Random;

public class Player implements Attack {

    private String name;
    private int health;
    private int hitPower;
    private int skills;
    private int gold;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHitPower() {
        return hitPower;
    }

    public void setHitPower(int hitPower) {
        this.hitPower = hitPower;
    }

    public int getSkills() {
        return skills;
    }

    public void setSkills(int skills) {
        this.skills = skills;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Player( int health, int hitPower, int skills, int gold) {
     //   this.name = name;
        this.health = health;
        this.hitPower = hitPower;
        this.skills = skills;
        this.gold = gold;
    }

    public int getRandomHitPower() {
        Random rand = new Random();
        int MaxHitPower = 100;
        int RandomHitPower = rand.nextInt(MaxHitPower);
        return RandomHitPower;
    }
   @Override
    public int attack() {
        if (skills * 3 > getRandomHitPower())
            return hitPower;
    else return 0;
    }
}
