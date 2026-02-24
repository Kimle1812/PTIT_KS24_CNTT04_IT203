package PTIT_CNTT4_IT203_Session11.miniProject;

public class Warrior extends GameCharacter implements ISkill {
    private int armor;

    public Warrior(String name, int hp, int attackPower, int armor) {
        super(name, hp, attackPower);
        this.armor = armor;
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println("[Chien binh] " + this.name + " tan cong " + target.getName() + "!");
        System.out.println("   -> Gay " + this.attackPower + " sat thuong.");
        target.takeDamage(this.attackPower);
    }

    @Override
    public void takeDamage(int amount) {
        int realDamage = amount - this.armor;
        if (realDamage < 0) {
            realDamage = 0;
        }
        System.out.println("   -> " + this.name + " mat " + realDamage + " mau. HP con: " + (this.hp - realDamage));
        this.hp -= realDamage;
        if (this.hp <= 0) {
            System.out.println(this.name + " da bi ha guc!");
        }
    }

    @Override
    public void useUltimate(GameCharacter target) {
        int ultimateDamage = this.attackPower * 2;
        int hpLoss = this.hp / 10;

        System.out.println("[Chieu cuoi] " + this.name + " dung 'Dam ngan can' len " + target.getName() + "!");
        System.out.println("   -> Gay " + ultimateDamage + " sat thuong khung khiep!");
        System.out.println("   -> " + this.name + " mat " + hpLoss + " mau do grang suc.");

        target.takeDamage(ultimateDamage);
        this.hp -= hpLoss;

        if (this.hp <= 0) {
            System.out.println(this.name + " da bi ha guc!");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Ten: " + name + " | HP: " + hp + " | Giap: " + armor);
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
