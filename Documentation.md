## Description of Algorithm
1) Our algorithm generates the 3 different 
orientations that are possible for each of the blocks that are given. This means
that there are 3 different combinations of a base area and a height because a block
has a length, width, and a height, but the block can also be oriented such that the 
length or width can also be the height.

2) Then, organize the base areas of each respective orientation in descending order. 

3) Block Stacking Problem(i)= {Maximum(Block Stacking Problem(j)) + height(i) such that j < i, width(j) > width(i), length(j) > length(i).
To summarize what this means, it is just the maximum height with box i at the top of the stack.

4) Finally, the overall maximum is the maximum of doing  Block Stacking Problem(i) from 0<i<n where n is the total orientations of all boxes.

## Interesting Design Decision
Our interesting design decision 



## Overview of code implementing algorithm
Our code implements the first part of our algorithm with the method maximumHeight in the BlockStackingProblem class. In that class, we get the blocks different orientations and then store them in an array. In that same method, we sort the array using the sort method to get the blocks in order based on their base. Then finally, we calculate the max in the same method as well by calling the max function 

## How we tested our code and the results
We tested our code by making a sample input file with the following numbers 

10
383 886 777
915 793 335
386 492 649
421 362 27
690 59 763
926 540 426
172 736 211
368 567 429
782 530 862
123 67 135

We ran the program with this input file and wrote to an output file, seeing if we got the expected output. If we got this number in our output file, we knew our algorithm succesfully worked. Otherwise, we edited our algorithm.
