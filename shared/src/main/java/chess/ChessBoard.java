package chess;
import chess.*;
/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {
    ChessPosition[][] board = new ChessPosition[8][8];

    public ChessBoard() {
        //assign a ChessPosition to each of the available spaces in the board
        for(int row = 0; row < 8; row+=1){
            for(int column = 0; column <8; column +=1){
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
        for(int row = 0; row < 8; row+=1){
            for(int column = 0; column <8; column +=1){
                board[row][column].piece = null;}
        }

        //set up black in rows 0 and 1
        //pawns first
        for (int counter = 0; counter < 8; counter += 1) {
            ChessPiece pawn = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN);
            board[1][counter].piece = pawn;
        }

        // all the others, in order KING, QUEEN, BISHOPs, KNIGHTs, ROOKs
        board[0][4].piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KING);
        board[0][3].piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.QUEEN);
        board[0][2].piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP);
        board[0][5].piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP);
        board[0][1].piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT);
        board[0][6].piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT);
        board[0][0].piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK);
        board[0][7].piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK);

        //set up white in rows 6 and 7
        //pawns first
        for (int counter = 0; counter < 8; counter += 1) {
            ChessPiece pawn = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN);
            board[6][counter].piece = pawn;
        }

        // all the others, in order KING, QUEEN, BISHOPs, KNIGHTs, ROOKs
        board[7][4].piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KING);
        board[7][3].piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.QUEEN);
        board[7][2].piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.BISHOP);
        board[7][5].piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.BISHOP);
        board[7][1].piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KNIGHT);
        board[7][6].piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KNIGHT);
        board[7][0].piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK);
        board[7][7].piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK);
    }

    @Override
    public String toString(){
        String str = "";
        for(ChessPosition[] row:this.board){
            for(ChessPosition place: row){
                str += place;
            }
            str += "\n";
        }
        return str;
    }
    @Override
    public int hashCode(){//DEBUG I have no idea what this one is supposed to be doing so for now it returns 1
        return 1;
    }


        //DEBUG main method for testing purposes
    public static void main(String[] args){

        ChessBoard tester = new ChessBoard();
        System.out.println(tester);

    }

}
