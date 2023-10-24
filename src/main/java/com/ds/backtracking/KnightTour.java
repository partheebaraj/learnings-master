package com.ds.backtracking;

public class KnightTour {

    static int N = 8;

    static boolean isSafe(int x,int y,int[][] sol) {
        return x>=0 && x<N
                && y>=0 && y<N
                &&  sol[x][y]==-1;
    }

    static void printSolution(int[][] sol){

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();

        }

    }


    static boolean solveKnightTour() {
        int[][] sol = new int[8][8];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++){
                sol[i][j] =-1;
            }
        }



        int xMove[] = {2, 1, -1, -2,  -2, -1,  1, 2};
        int yMove[] =   {1, 2, 2,  1,   -1, -2, -2, -1};



        sol[0][0]=0;
        if(!solveKnightTourUtil(0,0,1,sol,xMove,yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else {
            printSolution(sol);
        }

       return true;
    }

     static boolean solveKnightTourUtil(int x,int y,int moves,int[][] sol,
                                        int[] xMove,int[] yMove) {

            int next_X, next_y;
            if(moves == N*N) {
                return true;
            }

            for(int k=0;k<8;k++) {
                next_X = x+xMove[k];
                next_y = y+yMove[k];
                if(isSafe(next_X,next_y,sol)) {
                    sol[next_X][next_y]=moves;
                    if(solveKnightTourUtil(next_X,next_y,moves+1,sol,xMove,yMove)) {
                         return true;
                    } else {
                        sol[next_X][next_y]=-1;
                    }

                }
            }
       return false;
     }

    public static void main(String args[]) {
        solveKnightTour();
    }



}
