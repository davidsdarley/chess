package chess;
import chess.*;
/**
 * Represents moving a chess piece on a chessboard
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessMove {
    ChessPosition start;  //records the start position object
    ChessPosition end;      //records end position object
    ChessPiece.PieceType piece;
    public ChessMove(ChessPosition startPosition, ChessPosition endPosition,
                     ChessPiece.PieceType promotionPiece) {
        start = startPosition;
        end = endPosition;
        piece = promotionPiece;
    }

    /**
     * @return ChessPosition of starting location
     */
    public ChessPosition getStartPosition() {
        return this.start;
    }

    /**
     * @return ChessPosition of ending location
     */
    public ChessPosition getEndPosition() {
        return this.end;
    }

    /**
     * Gets the type of piece to promote a pawn to if pawn promotion is part of this
     * chess move
     *
     * @return Type of piece to promote a pawn to, or null if no promotion
     */
    public ChessPiece.PieceType getPromotionPiece() {
        return piece;
    }

    @Override
    public boolean equals(Object check){
        //check for same class
        if (check.getClass() != this.getClass()){
            System.out.println("DEBUG Not ChessMove");
            return false;
        }
        ChessMove obj = (ChessMove)check;

        //Check positions
        System.out.println(obj.getEndPosition().hashCode());
        System.out.println(this.getEndPosition().hashCode());
        if(!(
                obj.getStartPosition().equals(this.start) && obj.getEndPosition().equals(this.end)
        )){
                return false;
        }
        System.out.println("DEBUG Positions verified");

        //check pieces
        if(this.getPromotionPiece() == null || obj.getPromotionPiece() == null) //if either are null
        {
            System.out.println("DEBUG Null case");
            if(this.getPromotionPiece() == null && obj.getPromotionPiece() == null){
                System.out.println("DEBUG Both null");
                return true;}
            System.out.println("DEBUG Not same");
            return false;
        }
        if(! obj.getPromotionPiece().equals(this.piece)){
            System.out.println("DEBUG piece failed");
            return false;
        }
        System.out.println("DEBUG Piece verified");
        return true;
    }

    @Override
    public int hashCode(){  //adds the hashCodes of start and end positions, then multiplies by promotion piece if applicable
        int total = getStartPosition().hashCode() + getEndPosition().hashCode();
        if(getPromotionPiece() != null){
            total*=getPromotionPiece().hashCode();
        }
        return total;
    }

}
