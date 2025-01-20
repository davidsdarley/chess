package chess;
import chess.*;
/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {
    ChessPosition[][] board = new ChessPosition[9][9];

    public ChessBoard() {
        //assign a ChessPosition to each of the available spaces in the board
        for(int row = 0; row < 9; row+=1){
            for(int column = 0; column <9; column +=1){
                ChessPosition pos =new ChessPosition(row, column);
                board[row][column] = pos;}
            }
        resetBoard();
    }

    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece) {
        position.piece = piece;

    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        return position.piece;
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {
        //remove all current pieces from board
        for(int row = 1; row < 9; row+=1){
            for(int column = 1; column <9; column +=1){
                board[row][column].piece = null;}
        }

        //set up black in rows 0 and 1
        //pawns first
        for (int counter = 1; counter < 9; counter += 1) {
            ChessPiece pawn = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN);
            board[2][counter].piece = pawn;
        }

        // all the others, in order KING, QUEEN, BISHOPs, KNIGHTs, ROOKs
        board[1][5].piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KING);
        board[1][4].piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.QUEEN);
        board[1][3].piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP);
        board[1][6].piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP);
        board[1][2].piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT);
        board[1][7].piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT);
        board[1][1].piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK);
        board[1][8].piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK);

        //set up white in rows 6 and 7
        //pawns first
        for (int counter = 1; counter < 9; counter += 1) {
            ChessPiece pawn = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN);
            board[7][counter].piece = pawn;
        }

        // all the others, in order KING, QUEEN, BISHOPs, KNIGHTs, ROOKs
        board[8][5].piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KING);
        board[8][4].piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.QUEEN);
        board[8][3].piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.BISHOP);
        board[8][6].piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.BISHOP);
        board[8][2].piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KNIGHT);
        board[8][7].piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KNIGHT);
        board[8][1].piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK);
        board[8][8].piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK);
    }

    public ChessPosition find(ChessPiece piece){//Takes a SPECIFIC PIECE OBJECT and returns what position it is in
        ChessPosition position = null;
        for(int row = 1; row < 9; row+=1){
            for(int column = 1; column <9; column +=1){
                position = board[row][column];}
                if(position.piece.equals(piece)){
                    return position;
                }
        }
        System.out.println("WELL THAT'S A PROBLEM. PIECE DOESN'T SEEM TO EXIST!");
        return null;
    }

    @Override
    public String toString(){
        String str = "";

        for(int row = 1; row <9; row+=1){
            str += "|";
            for(int col = 1; col <9; col +=1){
                str+= this.board[row][col];
            }
            str += "\n";
        }
//        for(ChessPosition[] row:this.board){
//            for(ChessPosition place: row){
//                str += place;
//            }
//            str += "\n";
//        }
        return str;
    }
    @Override
    public int hashCode(){//DEBUG I have no idea what this one is supposed to be doing so for now it returns 1
        return 1;
    }


    @Override
    public boolean equals(Object obj){
        if(obj.getClass() != this.getClass()){
            return false;
        }
        else{
            for(int row = 0; row < 8; row+=1){
                for(int column = 0; column <8; column +=1){
                    if(!this.board[row][column].equals(((ChessBoard)obj).board[row][column])){
                        return false;
                    }
                }
            }
        }
        return true;
    }

        //DEBUG main method for testing purposes
    public static void main(String[] args){

        ChessBoard tester = new ChessBoard();
        System.out.println(tester);
        ChessPiece pawn1 = tester.board[2][2].piece;
        pawn1.pieceMoves();

    }

}
