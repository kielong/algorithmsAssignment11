import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Class that solves the Block Stacking Problem.
 * 
 * @author Kiel Delan Ong and Abdul Ajeigbe
 * @date 03/22/20
 */

public class BlockStackingProblem {

	public StackDetails maxHeight(Block arr[], int n) {
		ArrayList<ArrayList<Block>> stack = new ArrayList<ArrayList<Block>>();
		int maxHeight = 0;
		int count = 3 * n;
		// We create a new array with each of the three different orientations of each
		// block
		Block[] arrOfOrientations = new Block[count];

		// Add these orientations into the new array we created
		for (int i = 0; i < arr.length; i++) {

			Block currentBlock = arr[i];

			// first orientation
			arrOfOrientations[3 * i] = new Block(Math.min(currentBlock.getWidth(), currentBlock.getLength()),
					Math.max(currentBlock.getWidth(), currentBlock.getLength()), currentBlock.getHeight());

			// second orientation
			arrOfOrientations[3 * i + 1] = new Block(Math.min(currentBlock.getLength(), currentBlock.getHeight()),
					Math.max(currentBlock.getLength(), currentBlock.getHeight()), currentBlock.getWidth());

			// first orientation
			arrOfOrientations[3 * i + 2] = new Block(Math.min(currentBlock.getWidth(), currentBlock.getHeight()),
					Math.max(currentBlock.getWidth(), currentBlock.getHeight()), currentBlock.getLength());

		}

		// get the baseArea of each Block
		for (int i = 0; i < count; i++) {

			arrOfOrientations[i].baseArea = arrOfOrientations[i].getLength() * arrOfOrientations[i].getWidth();

		}
		// Sort the array
		Arrays.sort(arrOfOrientations);

		int[] heights = new int[count];
		int[] numBlocks = new int[count];
		// add the heights of each orientation to the new array and initialize the number of blocks to 1
		for (int i = 0; i < count; i++) {
			heights[i] = arrOfOrientations[i].getHeight();
			numBlocks[i] = 1;

		}

		// calculates the max height that is allowed when the block in the respective indices is on top
		for (int i = 0; i < count; i++) {
			heights[i] = 0;
			Block curr = arrOfOrientations[i];
			int height = 0;
			ArrayList<Block> tempArray = new ArrayList<Block>();
			tempArray.add(curr);
			int tempIndex = -1;
			for (int j = 0; j < i; j++) {
				Block prev = arrOfOrientations[j];
				if ((curr.getWidth() < prev.getWidth()) && (curr.getLength() < prev.getLength())) {
					if(heights[j] > height) {
						height = heights[j];
						tempIndex = j;
					}
					
					
				}
				
				
			
			}
			if(tempIndex >= 0)
				numBlocks[i] += numBlocks[tempIndex];
			stack.add(tempArray);
			if(tempIndex >= 0)
				tempArray.addAll(stack.get(tempIndex));
			heights[i] = height + curr.getHeight();		
		}
		
		
		//System.out.println(Arrays.toString(numBlocks));
		maxHeight = heights[0];
		int totBlocks = numBlocks[0];
		int maxIndex = 0;
		// get the max value from all the different start orientations
		for (int i = 0; i < count; i++) {
			if(heights[i] > maxHeight) {
				maxHeight = heights[i];
				maxIndex = i;
				totBlocks = numBlocks[i];
			}
			
		}
		
		//stack details are all the details to get the output that is desired by the problem
		return new StackDetails(maxHeight, totBlocks, stack, maxIndex);

	}
	
	
	
	public static void main(String[] args) {
		
		try {
			BlockStackingProblem blockStackingProblem = new BlockStackingProblem();
			File file = new File(args[0]); 
			BufferedReader br = new BufferedReader(new FileReader(file));

			int count = Integer.parseInt(br.readLine());

			Block[] arr = new Block[count];
			int i = 0;
			String line;
			while ((line = br.readLine()) != null) {
				String[] st = line.split(" ");
				Block block = new Block(Integer.parseInt(st[0]), Integer.parseInt(st[1]), Integer.parseInt(st[2]));
				arr[i] = block;
				i++;
			}

			FileWriter writer = new FileWriter(args[1]);
			int maximum = blockStackingProblem.maxHeight(arr, count).getMaxHeight();
			int totBlocks = blockStackingProblem.maxHeight(arr, count).getTotBlocks();
			int maxIndex = blockStackingProblem.maxHeight(arr, count).getMaxIndex();
			writer.write(Integer.toString(totBlocks) + '\n');
			ArrayList<Block> maxStack = blockStackingProblem.maxHeight(arr, count).getStack().get(maxIndex);
			for(int j = maxStack.size()-1; j >= 0; j--) {
				if(j == 0)
					writer.write(maxStack.get(j).getLength() + " " + maxStack.get(j).getWidth() + " " + maxStack.get(j).getHeight());
				else
					writer.write(maxStack.get(j).getLength() + " " + maxStack.get(j).getWidth() + " " + maxStack.get(j).getHeight() + '\n');
			}
			System.out.println("The tallest tower has " + Integer.toString(totBlocks)+ " blocks and a height of " + Integer.toString(maximum) + ".");
			writer.close();
			br.close();
			} catch (IOException e) {
			e.printStackTrace();
			} 
	}
}


