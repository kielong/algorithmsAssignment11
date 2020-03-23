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
<br />
This is correct because the solution to this problem exhibits optimal substructure. The algorithm breaks this down into smaller sub problems by starting with the orientation with the largest base area. Then, in descending order, finding the heights of the blocks that are allowed to be stacked below it and adding up those heights for that respective block orientation. Finally we are finding the top block orientation that allowed for the maximum height.
<br />
The time complexity of this algorithm is O(n^2) because for each block orientation, we check the maximum height they can achieve based on all the maximum heights of the block orientations that have a greater base area than it, and add the maximum if it satisfies the conditions that the length and width are larger than it. We know this is O(n^2), where n is the total numer of block orientations, because in our code implementation, this part was done in a nested for loop where we iterated through each block orientation and then found the max heights of the blocks that came before it (which have a smaller base area). 

## Interesting Design Decision
Our interesting design decision was that we chose to optimize the maximum in a bottom up manner, instead of a top down manner. We chose to do it in a bottom up manner so that we can add the maximum height that is acheived from block orientations that have a larger base area and add it to the block that the iteration is on. We decided against a top down manner to avoid having to recalculate duplicate work.



## Overview of code implementing algorithm
Our code implements the first part of our algorithm with the method maximumHeight in the BlockStackingProblem class. In that class, we get the blocks different orientations and then store them in an array. In that same method, we sort the array using the sort method to get the blocks in order based on their base. Then finally, we calculate the max height that can be obtained for every block orientation at the top, and any blocks with a smaller base area goes below it.

## How we tested our code and the results
We tested our code by making a sample input file with the following numbers 

10 <br />
383 886 777 <br />
915 793 335 <br />
386 492 649 <br />
421 362 27 <br />
690 59 763 <br />
926 540 426 <br />
172 736 211 <br />
368 567 429 <br />
782 530 862 <br />
123 67 135 <br />

We ran the program with this input file and wrote to an output file, seeing if we got the expected output. If we got this number in our output file, we knew our algorithm succesfully worked. Otherwise, we edited our algorithm.
