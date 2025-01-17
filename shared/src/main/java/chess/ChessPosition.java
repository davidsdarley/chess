package chess;
import chess.*;

import static chess.ChessPiece.PieceType.*;

/**
 * Represents a single square position on a chess board
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPosition {
    int row;
    int col;
    ChessPiece piece;


    public ChessPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * @return which row this position is in
     * 1 codes for the bottom row
     */
    public int getRow() {return this.row;}
    /**
     * @return which column this position is in
     * 1 codes for the left row
     */
    public int getColumn() {return this.col;}

    @Override
    public String toString(){
        if(this.piece == null){
            return "| |";
        }
        else if(piece.type == KING){
            return String.format("|K|");
        }
        else if(piece.type == QUEEN) {
            return String.format("|Q|");
        }
        else if(piece.type == BISHOP) {
            return String.format("|B|");
        }
        else if(piece.type == KNIGHT){
                return String.format("|k|");}
        else if(piece.type == ROOK){
            return String.format("|R|");}
        else{
            return String.format("|P|");
        }
        //return String.format("Square (%d, %d)",this.row, this.col);
    }

    @Override
    public int hashCode(){  //for the moment, this just returns a two digit int, first number being the row second being the column. Not the best, as all the 8s and 9s are not used, but it will suffice for the moment
        return this.row*10+this.col;
    }
    @Override
    public boolean equals(Object obj){
        if (obj.getClass() != this.getClass()){
            return false;
        }
        if((((ChessPosition) obj).getColumn() == this.col) && (((ChessPosition)obj).getRow() == this.row)){
            return true;
        }
        return false;
    }
}
