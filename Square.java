import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Square {

    String [] walls;
    int row,col;
    int[] next = new int[2];
    ArrayList bounds;
    ArrayList<String> moves = new ArrayList<>(Arrays.asList("l", "u", "r", "d"));//the available moves from this square; set to defult to all possmoves
    public boolean visited = false;
    //ArrayList<Pair> possableMoves = new ArrayList<>();

    public Square(String boundries,int row,int col){//creates the list of moves from the square
       //walls = boundries.split("(?!^)");
       this.row = row;
       this.col = col;
       bounds = new ArrayList<String>(Arrays.asList(boundries.split("(?!^)")));
       moves.removeAll(bounds);
       //Collections.sort(moves);
       //System.out.println(moves.toString());
    }

    public void visited(){//sets the bool to true;used to keep track of what squares have been visited 
        visited = true;
    }

    public int[] nextMoves(){//returns the next logocal move form the current sqr
        next[0]= row;next[1]=col;
        if (moves.contains("d")){
            next[0] = row+1;moves.remove("d");}
        else if (moves.contains("r")){
            next[1] = col+1;moves.remove("r");}
        else if (moves.contains("l")){
            next[1] = col-1;moves.remove("l");}
        
        else if (moves.contains("u")){
            next[0] = row-1;moves.remove("u");}
        
        
        else{

        }

        if(next[0]<0){
            next[0]=0;
        }
        if(next[1]<0){
            next[1]=0;
        }

        if(row == 0 && col == 0){//this is new 
            if (moves.isEmpty()){
                moves.add("r");
                moves.add("d");
            }
        }


       
        return next;
    }

    public void printSqr(){//for debugging; printing the sqr and the moves
        System.out.println("row: "+row+ " Col: "+col+ " moves: "+moves.toString());
        System.out.println();
    }

    public boolean hasMoves(){//returns true of there are still moves to be made from this square
        if(moves.isEmpty())
            return false;
        else
            return true;
    }


    
}
