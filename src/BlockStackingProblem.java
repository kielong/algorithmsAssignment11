import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Class whose main method reads in description of graph and trip requests, and
 * then returns shortest paths (according to distance or time) from one given
 * vertex to another. The input file is given by a command line argument.
 * 
 * @author Kiel Delan Ong and Abdul Ajeigbe
 * @date 03/22/20
 */

public class BlockStackingProblem {
	
	public int maxHeight(Block arr[], int n) {
		int maxHeight = 0;
		int count = 3*n;
		// We create a new array with each of the three different orientations of each block
		Block[] arrOfOrientations = new Block[count];
		
		// Add these orientations into the new array we created
		for(int i = 0; i < arr.length; i++) {
			
			Block currentBlock = arr[i];
			
			//first orientation
			arrOfOrientations[3*i] = new Block(Math.max(currentBlock.getWidth(), 
					currentBlock.getLength()), Math.min(currentBlock.getWidth(), currentBlock.getLength()), currentBlock.getHeight());			
			
			//second orientation
			arrOfOrientations[3*i+1] = new Block(Math.max(currentBlock.getLength(), 
					currentBlock.getHeight()), Math.min(currentBlock.getLength(), currentBlock.getHeight()), currentBlock.getWidth());
			
			//first orientation
			arrOfOrientations[3*i+2] = new Block(Math.max(currentBlock.getWidth(), 
					currentBlock.getHeight()), Math.min(currentBlock.getWidth(), currentBlock.getHeight()), currentBlock.getLength());
			
			
		}
		
		// get the baseArea of each Block
		for(int i = 0; i < count; i++) {
			
			arrOfOrientations[i].baseArea = arrOfOrientations[i].getLength()* arrOfOrientations[i].getWidth();
			
		}
		// Sort the array
		Arrays.sort(arrOfOrientations);

		int[] heights = new int[count];
		
		//add the heights of each orientation to the new array
		for(int i = 0; i < count; i++) {
			heights[i] = arrOfOrientations[i].getHeight();
			
		}
		
		// calculates the max height that is allowed based on the block that is on the bottom
		for(int i = 0; i < count; i++) {
			heights[i] = 0;
			Block curr = arrOfOrientations[i];
			int height = 0;
			
			for(int j = 0; j < i; j++) {
				Block prev = arrOfOrientations[j];
				if(curr.getWidth() < prev.getWidth() && curr.getLength() < prev.getLength()) {
					height = Math.max(height, heights[j]);
				}
			}
			heights[i] = height + curr.getHeight();
		}
		// get the max value from all the different start orientations
		for(int i = 0; i < count; i++) {
			maxHeight = Math.max(maxHeight, heights[i]);
		}
		
		
		return maxHeight;
		
	}
	
	public static void main(String[] args) {
		Block[] arr = new Block[4]; 
        arr[0] = new Block(4, 6, 7); 
        arr[1] = new Block(1, 2, 3); 
        arr[2] = new Block(4, 5, 6); 
        arr[3] = new Block(10, 12, 32); 
		BlockStackingProblem blockStackingProblem = new BlockStackingProblem();
		System.out.println(blockStackingProblem.maxHeight(arr, 4));
		
//		try {
//			BlockStackingProblem blockStackingProblem = new BlockStackingProblem();
//			File file = new File(args[0]); 
//			BufferedReader br = new BufferedReader(new FileReader(file));
//
//			int count = Integer.parseInt(br.readLine());
//			String st; 
//			Block[] arr = new Block[count];
//			int i = 0;
//			while ((st = br.readLine()) != null) {
//				String[] parts = st.split(" ");
//				Block block = new Block(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
//				arr[i] = block;
//				i++;
//			}
//			BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
//		    writer.write(blockStackingProblem.maxHeight(arr, count));
//		    writer.close();
//		    br.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} 
	}
	
}
