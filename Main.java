import java.util.Scanner;
public class Main{
    private static int playerState = 1;
    private static int coord1 = 1;
    private static int coord2 = 1;
    public static String playerName1;
    public static String playerName2;
    private static String symbolPlayer1;
    private static String symbolPlayer2;
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        BigBoard board = new BigBoard();
        System.out.println("Welcome to SUPER Tic-Tac-Toe! To make a move, enter the coordinates of a corresponding square with a space in between.");
        System.out.println("The current small game you are in is indicated by arrows");
        System.out.println("The move you make in the small game indicates which small game the next player must play in.\n");
        System.out.println("The following example board shows the cooresponding coordinates to each square: \n");

        for(int i = 1; i<4; i++){
            for(int x = 1; x<4;x++){
                System.out.print("("+x+","+i+")"+" ");
            }
            System.out.println("\n");
        }
        System.out.println("Have fun!\n");
        setNames(scan);
        BigBoard.printBoard(board);
        while(board.returnFinished()==false){
            move(scan, board);
            board.isWon();
            board.isDraw();
            changeTurn();

        }
        if(board.getDraw()) System.out.println("Its a draw :(");
        else System.out.println(winnerToName(board) + " wins!!!");
        System.out.println("Come back later for improvements to the game!");
            }
    private static void move(Scanner s,BigBoard bo){
       
        System.out.println();
        System.out.println("Playing in board "+ (coord2+1)+", "+(coord1+1));
        if(playerState==1) System.out.print(playerName1 +", pick a spot: ");
        else System.out.print(playerName2 +", pick a spot: ");
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
                System.out.print("Spot already taken \nPick another spot: ");
                play = takeNum(s);
                a = play[0];
                b = play[1];
            }
        }
        tempArray[b][a] = playerState;
        if(bo.getBoard(coord1,coord2).isWon()==false){
            bo.getBoard(coord1,coord2).isWon();
        }
        bo.getBoard(coord1, coord2).isFull();
        coord1 = b;
        coord2 = a;
        while(bo.getBoard(coord1, coord2).getFull()){//maybe make it so player can choose
            coord1 = (int)(Math.random()*3);
            coord2 = (int)(Math.random()*3);
            System.out.println("Board full, randomizing board");
        }
        BigBoard.printBoard(bo);
    }
    private static void changeTurn(){
        if(playerState == 1) playerState = 2;
        else if(playerState ==2) playerState = 1;
    }
    private static int[] takeNum(Scanner s){
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
    private static String enterString(Scanner s){//necessary to prevent error after entering 3 digit string followed by 1 digit string
        String i = s.nextLine();
        while(i.length()<3){
            System.out.print("Invalid character. \nEnter 2 integers between 1 and 3: ");
             i = s.nextLine();
        }
        return i;
    }
    public static int[] getCurrentBoard(){
        return new int[] {coord1,coord2};
    }
    private static void setNames(Scanner s){
        System.out.print("Player 1, enter your name: ");
        playerName1 = s.nextLine();
        System.out.print("Player 1, enter the symbol for use on the board (eg. X or O): ");
        symbolPlayer1 = s.nextLine();
        while(symbolPlayer1.length()!=1){
            System.out.print("The symbol must be 1 character long\nEnter another symbol: ");
            symbolPlayer1 = s.nextLine();
        }
        System.out.print("Player 2, enter your name: ");
        
        playerName2 = s.nextLine();
        while(playerName2.equals(playerName1)){
            System.out.println("Name must be different than Player 1's name. ");
        System.out.print("Player 2, enter your name: ");
        playerName2 = s.nextLine();
            
        }
         System.out.print("Player 2, enter the symbol for use on the board (eg. X or O): ");
        symbolPlayer2 = s.nextLine();
        while(symbolPlayer2.length()!=1||symbolPlayer2.equals(symbolPlayer1)){
            if(symbolPlayer2.length()!=1)System.out.print("The symbol must be 1 character long\nEnter another symbol: ");
            else System.out.print("Symbol must be different than "+playerName1+"'s symbol\nEnter another symbol: ");
            symbolPlayer2 = s.nextLine();
        }
    }
    public static String[] getSymbol(){
        return new String[] {symbolPlayer1, symbolPlayer2};
    }
    private static String winnerToName(BigBoard b){
        if(b.getWinner()==1) return playerName1;
        else return playerName2;
    }
  
}