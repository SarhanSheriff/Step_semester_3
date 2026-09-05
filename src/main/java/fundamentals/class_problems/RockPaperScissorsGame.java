package fundamentals.class_problems;
import java.util.*;
public class RockPaperScissorsGame {
    static String playRound(String playerMove, String computerMove) {
        String p=playerMove.trim().toLowerCase(), c=computerMove.trim().toLowerCase();
        if(p.equals(c)) return "Draw";
        if((p.equals("rock")&&c.equals("scissors"))||(p.equals("paper")&&c.equals("rock"))||(p.equals("scissors")&&c.equals("paper"))) return "Player Wins";
        return "Computer Wins";
    }
    public static void main(String[] args) {
        String[] player= {
            "Rock","Paper","Scissors","Rock","Paper"
        }
        ;
        String[] computer= {
            "Scissors","Paper","Rock","Paper","Scissors"
        }
        ;
        int wins=0,losses=0,draws=0;
        System.out.println("Round | Player | Computer | Result");
        for(int i=0;i<player.length;i++) {
            String r=playRound(player[i],computer[i]);
            System.out.printf("%d | %s | %s | %s%n",i+1,player[i],computer[i],r);
            if(r.startsWith("Player"))wins++;
            else if(r.startsWith("Computer"))losses++;
            else draws++;
        }
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",wins,losses,draws,wins*100.0/player.length);
    }
}
