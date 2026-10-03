package abstraction.assignment_problems.problem_4;

public class ArenaBattleSimulator {
    interface Attackable {
        String attack();
        String attack(String weaponName);
    }

    interface Defendable {
        String defend();
    }

    static abstract class GameCharacter {
        private static int nextId = 1001;
        private final String characterId = "CHAR-" + nextId++;

        public abstract String getSpecialMove();

        public String getCharacterId() {
            return characterId;
        }
    }

    static class Warrior extends GameCharacter
            implements Attackable, Defendable {

        private final String name;

        Warrior(String name) {
            this.name = name;
        }

        @Override
        public String attack() {
            return name + " strikes with a blade";
        }

        @Override
        public String attack(String weaponName) {
            return name + " strikes with an " + weaponName;
        }

        @Override
        public String defend() {
            return name + " raises a shield";
        }

        @Override
        public String getSpecialMove() {
            return name + " unleashes Whirlwind Slash";
        }
    }

    static class Trap implements Defendable {
        private final String trapType;

        Trap(String trapType) {
            this.trapType = trapType;
        }

        @Override
        public String defend() {
            return trapType + " triggers automatically";
        }
    }

    static void resolveDefense(Defendable[] combatants) {
        for (Defendable combatant : combatants) {
            System.out.println(combatant.defend());
        }
    }
}
