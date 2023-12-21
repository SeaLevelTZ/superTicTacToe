import java.util.Scanner;

public class Main{
    private static int playerState = 1;
    private static int coord1 = 1;
    private static int coord2 = 1;
    public static void main(String[]args){
Scanner scan = new Scanner(System.in);
BigBoard board = new BigBoard();
System.out.println("Welcome to SUPER Tic-Tac-Toe! To make a move, enter the coordinates of a corresponding square.");
while(board.returnFinished()==false){
    move(scan, board);
    BigBoard.printBoard(board);
    board.isWon();
    board.isDraw();
    changeTurn();

}
if(board.getDraw()) System.out.println("Its a draw :(");
else System.out.println("Player " + board.getWinner() + " wins!!!");


    }
    
    
    public static void move(Scanner s,BigBoard bo){//need to add a way to play if small game is a draw
        while(bo.getBoard(coord1, coord2).getFull()==true){
    coord1 = (int)Math.random()*3;
    coord2 = (int)Math.random()*3;
   }
   System.out.println();
   System.out.println("Playing in board "+ (coord1+1)+" "+(coord2+1));
        System.out.print("Player "+ playerState +", pick a spot: ");
   
   int a = s.nextInt()-1; 
   int b = s.nextInt()-1;
   
   int [][] tempArray = bo.getBoard(coord1, coord2).getSmallArray();
   while(a<0||a>2||b>2||b<0||tempArray[b][a]!=0){
    if(a>2||a<0||b>2||b<0){
        System.out.print("ArrayIndexOut...Just kidding\nEnter 2 valid coordinates between 1 and 3: ");
        a = s.nextInt()-1;
        b = s.nextInt()-1;
    }
    else if(tempArray[b][a]!=0){
        System.out.print("Spot already taken \nPick another spot: ");
        a = s.nextInt()-1;
        b = s.nextInt()-1;
    }
    }
    tempArray[b][a] = playerState;
    bo.getBoard(coord1,coord2).isWon();
    bo.getBoard(coord1, coord2).isFull();
    coord1 = b;
    coord2 = a;
    }
    public static void changeTurn(){
        if(playerState == 1) playerState = 2;
        else if(playerState ==2) playerState = 1;
    }
}