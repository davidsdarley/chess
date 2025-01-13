public class test {
    public static void main(String[] args) {
        Piece pawn1 = new Piece("Knight", 'b');
        pawn1.move();
    }
}
class Piece{
    String type;
    char color;

    public Piece(String type, char color){
        this.type = type;
        this.color = color;
    }

    public void move(){
        if (this.type == "Pawn"){
            System.out.println("Move forward one space");
        } else if (this.type == "Knight") {
            System.out.println("Move two spaces one direction, one space a different direction");
        }

    }
}