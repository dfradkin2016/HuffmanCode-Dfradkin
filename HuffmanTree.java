/*
First, HuffmanTree creates a map that contains each character in the sentence wit its frequency.
Then it adds each of these characters to a priority queue whose priority is its frequency.
Then it goes through the priority queue and turns the values and frequencies into huffmanNodes.
To do this, it takes the first two objects out of the queue and combines them into one huffmanNode.
Then the String with its combined frequency goes back into the priority queue.
It does this until the priority queue only has one object left.

The encode turns a String into zeros and ones.

I used HashMap because it is more efficient that treeMap when order does not matter, such
as the case here. TreeMap may be sorted but that is unnecessary. Based on the character,
there is no efficient way of sorting to make the search faster each time.

@author	Daria Fradkin
@version	January 29, 2016
*/



import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanTree
{
	private HuffmanNode root; //null at first, and then parent when tree done
	private String sentence;
	
	public HuffmanTree(String s)
	{
		sentence = s;
		init();
	}
	
	private void init()
	{
		createMap();
		makeQueue();
		makeTree();
	}
	
	private void createMap()
	//method that initializes to a map
	//if chr exists in map, add 1 to frequency
	//if it does not use put to add chr to map with a frequency of 1
	
	private void makeQueue()
	//take everything from the map and put it into a priority queue
	
	private void makeTree()
	//take the priority queue and change everything in it into linked huffman nodes
	
	
	public String encode(String s)
	//changes it to ones and zeros using root
	
	public String decode(String s)
	//changes ones and zeros to characters
	
	public void toString()
	//print the tree
}