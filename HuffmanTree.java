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
	private HashMap<Character, Integer> m;
	private PriorityQueue<HuffmanNode>  q;
	
	/*
	Constructor.
	Takes in the sentence and then creates tree.
	
	@param	s	sentence
	*/
	public HuffmanTree(String s)
	{
		sentence = s;
		m = new HashMap<Character, Integer>();
		q = new PriorityQueue<HuffmanNode>();
		init();
	}
	
	/*
	Organizes by calling other functions.
	*/
	private void init()
	{
		createMap();
		makeQueue();
		makeTree();
	}
	
	/*
	method that initializes to a map
	if chr exists in map, add 1 to frequency
	if it does not use put to add chr to map with a frequency of 1
	*/
	private void createMap()
	{
		for (char c : sentence.toCharArray())
		{
			if (m.containsKey(c))
			{
				m.put(c,m.get(c)+1);
			}
			else
				m.put(c,1);
		}
	}
	
	/*
	Takes everything from the map and put it into a priority queue
	*/
	private void makeQueue()
	{
		System.out.println(m);
		for ( char c : m.keySet())
		{
			System.out.println(c);
			q.add(new HuffmanNode("" + c, m.get(c)));
		}
	}
	
	/*
	Takes the priority queue and change everything in it into linked huffman nodes
	*/
	private void makeTree()
	{
		while (q.size() > 1)
		{
			HuffmanNode hn = new HuffmanNode(q.poll(),q.poll());
			q.add(hn);
			System.out.println(hn);
		}
		root = q.poll();
	}
	
	/*
	Changes sentence to ones and zeros using root
	precondition: letters are all in the tree
	
	@param	s	new sentence
	*/
	public String encode(String s)
	{
		String output = "";
		for (char c : s.toCharArray())
		{
			HuffmanNode hn = root;
			while (!(hn.isLeaf()))
			{
				if (inLeft(hn,c))
				{
					output += "0";
					hn = hn.left();
				}
				//goes to right, has to be in one or the other
				else
				{
					output += "1";
					hn = hn.right();
				}
			}
		}
		return output;
	}
	
	/*
	Checks to see if character is in left branch.
	
	@param	n	checks left of n
	@param	c	character
	*/
	private boolean inLeft(HuffmanNode n, char c)
	{
		n = n.left();
		for (char l : n.value().toCharArray())
		{
			if (c == l)
				return true;
		}
		return false;
	}
	
	/*
	Decodes the string.
	Takes in ones and zeroes and changes to characters.
	
	@param	s	1's and 0's
	*/
	//0's and 1's
	public String decode(String s)
	{
		String output = "";
		HuffmanNode hn = root;
		for (char c : s.toCharArray())
		{
			if (hn.isLeaf())
			{
				output+=hn.value();
				hn = root;
			}
			if (c == '0')
			{
				hn = hn.left();
			}
			else
			{
				hn = hn.right();
			}
		}
		output+=hn.value();
		return output;
	}
	
	/*
	toString method.
	Prints the tree
	*/
	public String toString()
	{
		return root.toString();
	}
}