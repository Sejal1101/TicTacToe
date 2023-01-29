package TicTac.company;

public class Board {
    private char board[][];
    private int boardSize = 3;
    private char p1Symbol,p2Symbol;
    private int count;
    private final static char EMPTY = ' ';
    public final static int PLAYER1WINS = 1;
    public final static int PLAYER2WINS = 2;
    public final static int DRAW = 3;
    public final static int INCOMPLETE = 4;
    public final static int INVALIDMOVE = 5;


    public Board(char p1Symbol , char p2Symbol){
        board = new char[boardSize][boardSize];
        for (int i=0; i<boardSize; i++){
            for (int j=0; j<boardSize; j++){
                board[i][j] = EMPTY;
            }
        }
        this.p1Symbol = p1Symbol;
        this.p2Symbol = p2Symbol;
    }

    public int move(char symbol , int x , int y){
        if(x<0 || y<0 || x>=boardSize || y>=boardSize || board[x][y] != EMPTY){
            return INVALIDMOVE;
        }
        board[x][y] = symbol;
        count++;

        // Row
        if(board[x][0] == board[x][1] && board[x][0] == board[x][2]){
            return symbol == p1Symbol ? PLAYER1WINS : PLAYER2WINS;
        }
        // Column
        if(board[0][y] == board[1][y] && board[0][y] == board[2][y]){
            return symbol == p1Symbol ? PLAYER1WINS : PLAYER2WINS;
        }
        // Diagonals
        if(board[0][0] != EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]){
            return symbol == p1Symbol ? PLAYER1WINS : PLAYER2WINS;
        }
        if(board[0][2] != EMPTY && board[0][2] == board[1][1] && board[0][2] == board[2][0]){
            return symbol == p1Symbol ? PLAYER1WINS : PLAYER2WINS;
        }
        if (count == boardSize*boardSize){
            return DRAW;
        }
        return INCOMPLETE;

    }

    public void print(){
        System.out.println("_______________");
        for (int i=0; i<boardSize; i++){
            for (int j=0; j<boardSize; j++){
                System.out.print("| "+ board[i][j] + " |");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("________________");
    }
}
