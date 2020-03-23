## Description of Algorithm
1) generate the 3 different 
orientations that are possible for each of the blocks that are given. This means
that there are 3 different combinations of a base area and a height because a block
has a length, width, and a height, but the block can also be oriented such that the 
length or width can also be the height.

2) Then, organize the base areas of each respective orientation in descending order. 

3) Block Stacking Problem(i)= {Maximum(Block Stacking Problem(j)) + height(i) such that j < i, width(j) > width(i), length(j) > length(i).
To summarize what this means, it is just the maximum height with box i at the top of the stack.

4) Finally, the overall maximum is the maximum of doing  Block Stacking Problem(i) from 0<i<n where n is the total orientations of all boxes.

## Interesting Design Decision

## Overview of code implementing algorithm

## How we tested our code and the results
