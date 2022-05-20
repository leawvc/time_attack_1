import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

abstract class Player{
    private String name;
    private String initNumber;
    private List<String> fightList = new LinkedList<String>();
    private Boolean isEnd;
    public Player(String name, String initNumber) {
        this.name = name;
        this.initNumber = initNumber;
        this.isEnd = false;
    }
    public abstract void play(String number) throws Exception;
    public void addFightList(String number) { fightList.add(number); }
    public Boolean getIsEnd() { return isEnd; }
    public void setIsEnd(Boolean isEnd) { this.isEnd = isEnd; }
    public String getInitNumber() { return initNumber; }
    public String getName() { return name; }
    public void printFightList() {
        // TODO
    }
}
class PlayerATeam extends Player
{
    public PlayerATeam(String name, String number) {
        super(name, number);
    }

    @Override
    public void play(String number) throws Exception {
        int strike = 0;
        int ball = 0;
        int out = 0;

        String aTrade = "1234";

        Scanner scan = new Scanner(System.in);
        String sc = scan.nextLine();
        scan.close();

        for (int i = 0; i < 4; i++){
            char trade = sc.charAt(i);
            if (trade == aTrade.charAt(i)){
                strike =+ 1;
            } else if (aTrade.contains(String.valueOf(trade))) {
                ball =+ 1;
            } else {
                out =+ 1;
            }
        }

        if(strike == 4) {
            System.out.println("Congratulation!");
            super.setIsEnd(true);
        } else {
            System.out.println("Strike : "+strike+", Ball :"+ball+", Out: "+out);
        }
    }
}

class PlayerBTeam extends Player
{
    public PlayerBTeam(String name, String number) {
        super(name, number);
    }
    @Override
    public void play(String number) throws Exception {
        int strike = 0;
        int ball = 0;
        int out = 0;

        String aTrade = "5678";

        Scanner scan = new Scanner(System.in);
        String sc = scan.nextLine();
        int j = 0;
        for (int i = 0; i < 4; i++){
            if (sc.charAt(j) == sc.charAt(i)){
                if(str.indexOf(str.charAt(i)) == i) answer += str.charAt(i);
                j++;
            }
            return answer;
        }
        if (sc.length() == 4){

        }
        scan.close();

        for (int i = 0; i < 4; i++){
            char trade = sc.charAt(i);
            if (trade == aTrade.charAt(i)){
                strike =+ 1;
            } else if (aTrade.contains(String.valueOf(trade))) {
                ball =+ 1;
            } else {
                out =+ 1;
            }
        }
        if(ball == 4) {
            System.out.println("Congratulation!");
            super.setIsEnd(true);
        } else {
            System.out.println("Strike : "+strike+", Ball :"+ball+", Out: "+out);
        }
    }
}

public class Main {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Player playerArray[] = {new PlayerATeam("A Team","1234"), new PlayerBTeam("B Team","5678")};
        int checkPlayer = 0;

        while(true) {
            checkPlayer = 0;
            for(Player player : playerArray) {
                if (player.getIsEnd() == false) {
                    System.out.print("Please enter a 4 digit number (" + player.getName() + ") defence : ");
                    String number = scanner.nextLine();
                    try {
                        player.play(number);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    checkPlayer++;
                }
            }
            if(checkPlayer == playerArray.length) break;
        }

        for(Player player : playerArray) {
            player.printFightList();
        }
    }
}