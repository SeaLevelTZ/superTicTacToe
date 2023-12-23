public class BigBoard {
    private Board[][] largeBoard;
    private boolean finished;
    private int winner; //0 by default when initialized 
    private boolean draw = false;
    public BigBoard(){
        largeBoard = new Board[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                largeBoard[i][j] = new Board();
            }
        }
        finished = false;
    
    }
    
    public void isWon(){//issue hopefully fixed needs testing
        for(int i= 0;i<largeBoard.length;i++){
            if(largeBoard[i][0].isWon()==true&&largeBoard[i][1].isWon()==true&&largeBoard[i][2].isWon()==true&&largeBoard[i][0].getWinner()==largeBoard[i][1].getWinner()&&largeBoard[i][1].getWinner()==largeBoard[i][2].getWinner()){
                finished = true;
                winner = largeBoard[i][0].getWinner();
            }
        }
        for(int i = 0;i<largeBoard.length;i++){
            if(largeBoard[0][i].isWon()==true&&largeBoard[1][i].isWon()==true&&largeBoard[2][i].isWon()==true&&largeBoard[0][i].getWinner()==largeBoard[1][i].getWinner()&&largeBoard[1][i].getWinner()==largeBoard[2][i].getWinner()){
                finished = true;
                winner = largeBoard[0][i].getWinner();
            }
        }
        if(largeBoard[0][0].isWon()==true&&largeBoard[1][1].isWon()==true&&largeBoard[2][2].isWon()==true&&largeBoard[0][0].getWinner()==largeBoard[1][1].getWinner()&&largeBoard[1][1].getWinner()==largeBoard[2][2].getWinner()){
            finished = true;
            winner = largeBoard[0][0].getWinner();
        }
        if(largeBoard[0][2].isWon()==true&&largeBoard[1][1].isWon()==true&&largeBoard[2][0].isWon()==true&&largeBoard[0][2].getWinner()==largeBoard[1][1].getWinner()&&largeBoard[1][1].getWinner()==largeBoard[2][0].getWinner()){
                finished = true;
                winner = largeBoard[0][2].getWinner();
        }
            }
    public void isDraw(){
        //do this later :)
         int count= 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(largeBoard[i][j].getFull()==true) count++;
            }
        }
        if(count==9){ draw = true; finished = true;}
    }
    public static void printBoard(BigBoard b){//need to make this print one line at a time
        for(int c = 0; c < b.largeBoard.length; c++) {
            for(int i = 0; i<3;i++){
                System.out.println();
                for(int x = 0; x<3;x++){
                    b.largeBoard[c][x].printLine(i);
                }
            }
            System.out.println();//prints winners in horizontal direction if they are vertical...
            for(int e = 0;e<3;e++){
                if(b.getBoard(c,e).getWinner()!=0)
                System.out.print("W: "+b.getBoard(c,e).getWinner()+"      ");
                else
                System.out.print("       ");
            }
        }
        System.out.println();
        //prints the whole board when called
    }
    public Board getBoard(int one, int two){
        return largeBoard[one][two];
    }
    public boolean returnFinished(){
        return finished;
    }
    public boolean getDraw(){
        return draw;
    }
    public int getWinner(){
        return winner;
    }
   

}
