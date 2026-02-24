package PTIT_CNTT4_IT203_Session11.miniProject;

public class main {
    public static void main(String[] args) {
        System.out.println("=== ARENA OF HEROES ===\n");

        Warrior warrior = new Warrior("Yasuo", 500, 50, 20);
        Mage mage = new Mage("Veigar", 400, 35, 200);

        GameCharacter goblin = new GameCharacter("Goblin", 100, 10) {
            @Override
            public void attack(GameCharacter target) {
                System.out.println("[Quai vat] " + this.name + " can trom " + target.getName() + "...");
                System.out.println("   -> Gay 10 sat thuong co dinh.");
                target.takeDamage(10);
            }

            @Override
            public void displayInfo() {
                System.out.println("Ten: " + name + " | HP: " + hp);
            }
        };

        System.out.println("Da khoi tao " + GameCharacter.count + " nhan vat tham gia dau truong.\n");

        GameCharacter[] characters = new GameCharacter[3];
        characters[0] = warrior;
        characters[1] = mage;
        characters[2] = goblin;

        System.out.println("=== BAT DAU TRAN DAU ===\n");

        System.out.println("--- Luot 1 ---");
        warrior.attack(goblin);
        System.out.println();

        System.out.println("--- Luot 2 ---");
        ((ISkill) mage).useUltimate(warrior);
        System.out.println();

        System.out.println("--- Luot 3 ---");
        goblin.attack(mage);
        System.out.println();

        System.out.println("--- Luot 4 ---");
        ((ISkill) warrior).useUltimate(goblin);
        System.out.println();

        System.out.println("=== THONG SO SAU LUOT DAU ===");
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != null) {
                characters[i].displayInfo();
            }
        }

        System.out.println("\nTong so nhan vat da tao: " + GameCharacter.count);
    }
}
