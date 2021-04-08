import java.util.Scanner;
import java.util.Stack;
public class solve{
    public static void main(String[]srgs){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Stack<Square> path = new Stack<Square>();//stack to store the path
        String maze_sqrs[] = input.split("\\s+");
        Square [][] maze = new Square[10][10];
        int z =0;//used to count the square walls input
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                maze[i][j] = new Square(maze_sqrs[z],i,j);
                z++;
            }
        }

        findPath(maze,path);
        printPath(path);

    }

    public static void findPath(Square[][] maze, Stack<Square> path){
        int row = 0; int col=0;
        int[] nextRC;
        path.push(maze[row][col]);
        path.peek().visited();;

        while(path.peek()!= maze[9][9]){
            nextRC = path.peek().nextMoves();
            if(hasValidMove(maze, nextRC)){
                path.push(maze[nextRC[0]][nextRC[1]]);
                path.peek().visited();
                row = nextRC[0];col = nextRC[1];
            }
            if(path.peek().moves.isEmpty()){
                path.pop();
            }
            //path.peek().printSqr();
    }
}
    

    public static boolean hasValidMove(Square[][] maze,int[]next){
        if(maze[next[0]][next[1]].visited == true){
            return false;
        }
        else{
            return true;
        }
    }

    public static void printPath(Stack<Square> path){
        int z = path.size();
        for(int i =0;i< z;i++){
            System.out.println("("+path.peek().row +" " + path.peek().col+")");
            path.pop();
        }

    }
}