import java.util.Arrays;
import java.util.Random;
public class Sudoku {
    
    public static int[][] creategrid(){
        int[][] argrid = new int[9][9];

        for (int x = 0; x < 9; x++){
            for (int y = 0; y < 9; y++){
                argrid[x][y] = 0;
            }
        }
        return argrid;
    }   

    public static boolean checkboardinit(int[][] argrid,int col,int row,int num){

        if (argrid[row][col] == 0){ ///x= row y =col
            for (int x= 0; x < 9; x++){
                if (argrid[x][col] == num){
                    return false;}
            }
            for (int y= 0; y < 9; y++){
                if (argrid[row][y] == num){
                    return false;}
            }     
        }else{
            return false;
        }

        return true;
    }

    public static int[][] newboard(int[][] argrid){//will search a random position on the board to create a new game
        Random ran = new Random();

        int col = ran.nextInt(9);
        int row = ran.nextInt(9);
        int num = ran.nextInt(9);
        int clues = 17; //least number of clues to make unique solution moddable to make more difficult or easier puzzles
        int count = 0;

        while(count != clues){ //the least number of clues for sudoku "Brute force method creating many random numbers"
            if (checkboardinit(argrid, col, row, num)){
                argrid[row][col] = num;
                count+=1;
            }

            col = ran.nextInt(9);
            row = ran.nextInt(9);
            num = ran.nextInt(9);

        }

        return argrid;
    }

    public static void main(String[] args){
        int[][] grid = creategrid();
        
        String sline = "";
        int[][] nboard = newboard(grid);
        for (int x = 0; x < 9; x++){
            for (int y = 0; y < 9; y++){
                sline+= nboard[x][y] ;
            }
            System.out.println(sline);
            sline = "";
        }
    }
}
