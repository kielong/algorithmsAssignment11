# algorithmsAssignment11

## Each File
There are two files that I am submitting: Block.java and BlockStackingProblem.java. The Block class represents a block object, which is used to instantiate the length, width, height, and baseArea of a block. The BlockStackingProblem is the main class that calculates the maxHeight that can be produced with the given block dimensions. 
## How to compile and run code
To compile this code, you first clone the repository onto your desktop. BlockStackingProblem.java and Block.java should be in your src folder. You should put your input file in this folder as well. If not you can use the "mv" command to move it to the same folder that has the java files. Once this is done, you open up your terminal and "cd" into the folder containing the java files--perhaps the src folder. Compile the java code with the following command:

javac Block.java
//
javac BlockStackingProblem.java

You should now have a Block.class file and BlockStackingProblem.class file in the folder. You can check by writing "ls" in the command line. Finally you run the java program with the file you're reading and the file you're outputting by typing the following command:

java BlockStackingProblem "inputfilename.txt" "outputfilename.txt"

You should see your output file in the folder.
