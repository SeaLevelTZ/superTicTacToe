import java.util.Scanner;

public class Main{
    private static int playerState = 1;
    private static int coord1 = 1;
    private static int coord2 = 1;
    public static void main(String[]args){
Scanner scan = new Scanner(System.in);
BigBoard board = new BigBoard();
System.out.println("Welcome to SUPER Tic-Tac-Toe! To make a move, enter the coordinates of a corresponding square with a space in between.");
BigBoard.printBoard(board);
while(board.returnFinished()==false){
    move(scan, board);
    BigBoard.printBoard(board);
    board.isWon();
    board.isDraw();
    changeTurn();

}
if(board.getDraw()) System.out.println("Its a draw :(");
else System.out.println("Player " + board.getWinner() + " wins!!!");
System.out.println("Come back later for improvements to the game!");

    }
    
    
    public static void move(Scanner s,BigBoard bo){//very rarely just randomly put in wrong number???
        while(bo.getBoard(coord1, coord2).getFull()){
    coord1 = (int)Math.random()*3;
    coord2 = (int)Math.random()*3;
   }
   System.out.println();
   System.out.println("Playing in board "+ (coord2+1)+", "+(coord1+1));
        System.out.print("Player "+ playerState +", pick a spot: ");
   int[] play = takeNum(s);
   int a = play[0];
   int b = play[1];
   
   int [][] tempArray = bo.getBoard(coord1, coord2).getSmallArray();
   while(a<0||a>2||b>2||b<0||tempArray[b][a]!=0){
    if(a>2||a<0||b>2||b<0){
        System.out.print("ArrayIndexOut...Just kidding\nEnter 2 valid coordinates between 1 and 3: ");
        play = takeNum(s);
        a = play[0];
        b = play[1];
    }
    else if(tempArray[b][a]!=0){
        System.out.print("Spot already taken \nPick another spot: ");// issue where sometimes it gets stuck saying saying this, can't figure out why
        play = takeNum(s);
        a = play[0];
        b = play[1];
    }
    }
    tempArray[b][a] = playerState;
    bo.getBoard(coord1,coord2).isWon();
    bo.getBoard(coord1, coord2).isFull();
    //System.out.println(bo.getBoard(coord1, coord2).isWon());
    //System.out.println(bo.getBoard(coord1, coord2).getWinner());

    coord1 = b;
    coord2 = a;
    }

    
    public static void changeTurn(){
        if(playerState == 1) playerState = 2;
        else if(playerState ==2) playerState = 1;
    }
    public static int[] takeNum(Scanner s){
        String i = enterString(s);
        String a1 = i.substring(0,1);
        String b1 = i.substring(2,3);
        int a = 0;
        int b=0;
        while(isNumeric(a1)==false||isNumeric(b1)==false){
            System.out.print("Invalid character. \nEnter 2 integers between 1 and 3: ");
            i = enterString(s);
            a1 = i.substring(0,1);
            b1 = i.substring(2,3);
        }
        a = Integer.parseInt(i.substring(0,1));
        b = Integer.parseInt(i.substring(2,3));
        return new int[] {a-1,b-1};
    }
    private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }
    public static String enterString(Scanner s){//necessary to prevent error after entering 3 digit string followed by 1 digit string
        String i = s.nextLine();
        while(i.length()<3){
            System.out.print("Invalid character. \nEnter 2 integers between 1 and 3: ");
             i = s.nextLine();
        }
        return i;
    }
}