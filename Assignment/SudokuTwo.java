package prani;

public class SudokuTwo 
{

    private static final int SIZE = 9;

    
    private static int[][] matrix = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
        };

    private static void print()
    {
        for(int i=0;i<SIZE;i++)
        {
            for(int j=0;j<SIZE;j++)
            {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println("");
        }
    }

    //function to check if all cells are assigned or not
   
    private static int[] BlankNumbers(int row, int col)
    {
        int numunassign = 0;
        for(int i=0;i<SIZE;i++)
        {
            for(int j=0;j<SIZE;j++)
            {
                //cell is unassigned
                if(matrix[i][j] == 0)
                {
                   
                    row = i;
                    col = j;
                   
                    numunassign = 1;
                    int[] a = {numunassign, row, col};
                    return a;
                }
            }
        }
        int[] a = {numunassign, -1, -1};
        return a;
    }

    //function to check if it satisfies sudoku rules
    
    private static boolean isValid(int n, int r, int c)
    {
        //checking in row
        for(int i=0;i<SIZE;i++)
        {
            //there is a cell with same value
            if(matrix[r][i] == n)
                return false;
        }
        //checking column
        for(int i=0;i<SIZE;i++)
        {
            //there is a cell with the value equal to i
            if(matrix[i][c] == n)
                return false;
        }
        //checking sub matrix
        int row_start = (r/3)*3;
        int col_start = (c/3)*3;
        for(int i=row_start;i<row_start+3;i++)
        {
            for(int j=col_start;j<col_start+3;j++)
            {
                if(matrix[i][j]==n)
                    return false;
            }
        }
        return true;
    }

    //function to solve sudoku
    //using backtracking
    private static boolean solveSudoku()
    {
        int row=0;
        int col=0;
        int[] a = BlankNumbers(row, col);
      
        if(a[0] == 0)
            return true;
        //number between 1 to 9
        row = a[1];
        col = a[2];
        for(int i=1;i<=SIZE;i++)
        {
            
            if(isValid(i, row, col))
            {
                matrix[row][col] = i;
                //backtracking
                if(solveSudoku())
                    return true;
                
                //reassign the cell because cant proceed
                matrix[row][col]=0;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        if (solveSudoku())
            print();
        else
            System.out.println("No solution");
    }
}
