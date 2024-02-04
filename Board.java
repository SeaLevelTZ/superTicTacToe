public class Board{
    private int[][] board;
    private boolean isTaken;
    private boolean full;
    private int wonBy;
    private String wonByString;
    public Board(){
        board = new int[3][3];
    }
    public void isWon(){
        for(int i= 0;i<board.length;i++){//now works I think but breaks for board stealing
            if(board[i][0]!=0&&board[i][0]==board[i][1]&&board[i][1]==board[i][2]){
                isTaken = true;
                wonBy = board[i][0];
            }
        }
        for(int i = 0;i<board.length;i++){
            if(board[0][i]!=0&&board[1][i]!=0&& board[0][i]==board[1][i]&&board[1][i]==board[2][i]){
                isTaken = true;
                wonBy = board[0][i];
            }
        }
        if(board[0][0]!=0&&board[0][0]==board[1][1]&&board[1][1]==board[2][2]){
            isTaken = true;
            wonBy = board[0][0];
        }
        if(board[0][2]!=0&&board[0][2]==board[1][1]&&board[1][1]==board[2][0]){
                isTaken = true;
                wonBy = board[0][2];
        }
        if(wonBy==1) wonByString = Main.getSymbol()[0];
        else if(wonBy==2) wonByString = Main.getSymbol()[1];
    }
    
    public boolean isFull(){
        int count = 0;
        for(int c = 0; c < board[0].length; c++) {
            for(int r = 0; r < board.length; r++) {
                if(board[r][c]!=0){
                    count++;
                } 
            }
        }
        if(count==9){
            isTaken = true;
            full = true;
    
        }
        return (full);
    }
    public void printLine(int a, boolean b){
        int i=0;
        for( i = 0; i<3;i++){
           if(board[a][i]==1) System.out.print(Main.getSymbol()[0]);
                else if (board[a][i]==2) System.out.print(Main.getSymbol()[1]);
                else System.out.print("-"); 
        }
        if(b){
            System.out.print(" <   ");
        }
        else{
            System.out.print("     ");
        }
    }
    public int[][] getSmallArray(){
        return board;
    }
    public int getWinner(){
        return wonBy;
    }
    public boolean getFull(){
        return full;
    }  
    public String getWonString(){
        return wonByString;
    }
    public boolean getIsWon(){
        return isTaken;
    }
    
}
