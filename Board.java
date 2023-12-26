public class Board{
    private int[][] board;
    private boolean isTaken;
    private boolean full;
    private int wonBy;
    public Board(){
        board = new int[3][3];
    }
    public boolean isWon(){
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
        return(isTaken);
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
           if(board[a][i]==1) System.out.print("X");
                else if (board[a][i]==2) System.out.print("O");
                else System.out.print("-"); 
        }
        if(b){
            System.out.print(" <   ");
        }
        else{
            System.out.print("     ");
        }
    }
    /*public boolean getTaken(int a, int b){//checks if spot is taken
        if(this.board[b][a]!=0) return false;
        else return true;
    } */
    public int[][] getSmallArray(){
        return board;
    }
    public int getWinner(){
        return wonBy;
    }
    public boolean getFull(){
        return full;
    }  
}
