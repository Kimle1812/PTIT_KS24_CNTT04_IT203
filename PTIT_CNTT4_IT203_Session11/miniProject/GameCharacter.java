package PTIT_CNTT4_IT203_Session11.miniProject;

public abstract class GameCharacter {
    protected String name;
    protected int hp;
    protected int attackPower;

    public static int count = 0;

    public GameCharacter(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        count++;
    }

    public abstract void attack(GameCharacter target);

    public void takeDamage(int amount) {
        this.hp -= amount;
        if (this.hp <= 0) {
            System.out.println(this.name + " da bi ha guc!");
        }
    }

    public void displayInfo() {
        System.out.println("Ten: " + name + " | HP: " + hp + " | Suc tan cong: " + attackPower);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
}
