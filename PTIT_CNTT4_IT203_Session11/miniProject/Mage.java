package PTIT_CNTT4_IT203_Session11.miniProject;

public class Mage extends GameCharacter implements ISkill {
    private int mana;

    public Mage(String name, int hp, int attackPower, int mana) {
        super(name, hp, attackPower);
        this.mana = mana;
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println("[Phap su] " + this.name + " tan cong " + target.getName() + "!");

        if (this.mana >= 5) {
            System.out.println("   -> Tan cong phep. Gay " + this.attackPower + " sat thuong.");
            target.takeDamage(this.attackPower);
            this.mana -= 5;
            System.out.println("   -> " + this.name + " ton 5 mana. Mana con: " + this.mana);
        } else {
            int reducedDamage = this.attackPower / 2;
            System.out.println("   -> Mana het! Tan cong yeu. Gay " + reducedDamage + " sat thuong.");
            target.takeDamage(reducedDamage);
        }
    }

    @Override
    public void useUltimate(GameCharacter target) {
        if (this.mana < 50) {
            System.out.println("[Chieu cuoi] " + this.name + " khong du mana de dung 'Hoa cau'! (Can 50 mana, hien co: "
                    + this.mana + ")");
            return;
        }

        int ultimateDamage = this.attackPower * 3;

        System.out.println("[Chieu cuoi] " + this.name + " dung 'Hoa cau' len " + target.getName() + "!");
        System.out.println("   -> " + this.name + " ton 50 mana.");
        System.out.println("   -> Gay " + ultimateDamage + " sat thuong khung khiep!");

        this.mana -= 50;
        target.takeDamage(ultimateDamage);
        System.out.println("   -> Mana con: " + this.mana);
    }

    @Override
    public void displayInfo() {
        System.out.println("Ten: " + name + " | HP: " + hp + " | Mana: " + mana);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
