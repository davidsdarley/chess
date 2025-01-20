package chess;
import chess.*;
import java.util.Collection;
import java.util.HashSet;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {
    ChessGame.TeamColor color;
    PieceType type;
    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.color = pieceColor;
        this.type = type;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return this.color;    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return this.type;
    }

    /**
     * Calculates **ALL** the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> moves = new HashSet<ChessMove>();
        /*Ok, how to do this. I need to find all possible legal moves.
        This is a bit of a project. I need to include

        */

        //Each move has 3 things: startPosition, endPosition, and potential piece promotion.
        //To find the start position, iterate through the board and find the position that contains the desired piece. Return that
                //actually we get the start position as an argument
            //make a function in ChessBoard to do this. We will be wanting to iterate through the board frequently
        //endPosition: depending on the piece type, we have different algorithms for how you can move
            //make a function that can calclutate that
        //promotion
            //if it's a pawn arriving at the other side (write function to see it that is the case) Queen. Otherwise null.
    return moves;
    }

    @Override
    public boolean equals(Object obj){
        if (obj.getClass() != this.getClass()){
            return false;
        }
        if((((ChessPiece) obj).getPieceType().equals(this.type))
            && (((ChessPiece)obj).getTeamColor().equals(this.color))){
                return true;
        }
        return false;
    }
    @Override
    public String toString(){
        String str = color.toString() + type.toString();
        return str;
    }
    @Override
    public int hashCode(){
        int total = 0;
        if (color == ChessGame.TeamColor.BLACK){
            total +=10;
        }
        switch(this.type){
            case PAWN:
                total +=1;
                break;
            case KNIGHT:
                total += 2;
                break;
            case BISHOP:
                total +=3;
                break;
            case ROOK:
                total +=4;
                break;
            case QUEEN:
                total +=5;
                break;
            case KING:
                total +=6;
                break;
        }
        return total;
    }
}
