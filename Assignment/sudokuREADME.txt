Defining a method solveSudoku() First, with row=0,col=0 initially

From this method giving a call to a method BlankNumbers(row, col)
This method has logic written to return a array, a[]={numberunassinged, itsrow, itscol}

lets take Eg of first row--
{5,3,0,0,7,0,0,0,0}, here first unassinged number is at {0,2} location.
And the temporary numberassinged will be "1".
hence,it will return a[]

Now, Coming to solveSudoku()...now we apply a forLoop that loops 9 times and
will assing a no between 1-9 at the blankNumber location and will also check if it satisfies sudoku rules or not

So now checking for number-1,row-0,col-2, 

here i have defined isValid(n,r,c) method.
In this i am checking for three Conditions:--------

1---Any row contains the same passed number(n) more than once.

2---Any column contains the same passed number(n) more than once.

3---3x3 sub-matrix has the same passed number(n) more than once.

Now, if this method returns true. we assign this passed no to the passed col,row.
and again solveSudoku() is called till loop ends...and this process is repeated till all unassigned numbers are filled.

but, if this method returns False. Still the process keeps continuing using further no till loop ends and all blank numbers are filled.
eg.(if it returns false for assigned no "1", then it assignes next digit thats "2" and checks for that)

If a number is not satisfying any no from 1-9 at a specific location...here we start backtracing
In this we first assign "0" value for that location and start backtracing through our loop
eg(we will come back to our previous coloum and try changing it value) and checking if it satisfies isValid() method for all 1-9 no again.
if id does then we will continue for further col like previously,
if doesnt satisfy we will come backwards to one more col and try changing its value again.
this process continues till it entirely comes out of the main loop....all coloum values for row[0] satisfies isValid() completely without backtracing anymore..

Once this is Completed, We go for row[1] and process Continues.
Backtracing and can process backward through rows also...till it entirely comes out of the main loop...with all conditions satisfied.

And last calling the print() to print sodoku row and coloum wise.










