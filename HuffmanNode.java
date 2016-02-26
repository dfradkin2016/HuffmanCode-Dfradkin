/*
Huffman node contains the String and frequency pairs that form the tree for encode and decode.

@author	Daria Fradkin
@version	January 29, 2016
*/

import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanNode implements Comparable
{
	protected String value;
	protected int frequency;
	protected HuffmanNode left;
	protected HuffmanNode right;

	/*
	Constructor.
	Creates a new node that doesn't point to anything.
	
	@param	f	frequency
	@param	v	String piece of sentence
	*/
	public HuffmanNode(String v, int f)
	{
		frequency = f;
		value = v;
		left = null;
		right = null;
	}
	
	/*
	Constructor.
	Takes to other nodes and adds them together.
	Adds frequency and combines Strings.
	
	@param	l	left node
	@param	r	right node
	*/
	public HuffmanNode(HuffmanNode l, HuffmanNode r)
	{
		left = l;
		right = r;
		value = l.value() + r.value();
		frequency = l.frequency() + r.frequency();
	}
	
	/*
	String accessor
	
	@return	value
	*/
	public String value()
	{
		return value;
	}
	
	/*
	String modifier
	
	@param	v	value
	*/
	public void setValue(String v)
	{
		value = v;
	}
	
	/*
	Frequency accessor
	
	@return	frequency
	*/
	public int frequency()
	{
		return frequency;
	}
	
	/*
	Frequency modifier
	
	@param	f	frequency
	*/
	public void setFrequency(int f)
	{
		frequency = f;
	}
	
	/*
	Left accessor
	
	@return	left node
	*/
	public HuffmanNode left()
	{
		return left;
	}
	
	/*
	Left modifier
	
	@param	l	left node
	*/
	public void setLeft(HuffmanNode l)
	{
		left = l;
	}

	/*
	Right accessor
	
	@return	right node
	*/
	public HuffmanNode right()
	{
		return right;
	}
	
	/*
	Right modifier
	
	@param	r	right node
	*/
	public void setRight(HuffmanNode r)
	{
		right = r;
	}
	
	/*
	Compare to method.
	Priority queue uses this to compare nodes.
	Compares nodes based on frequency
	
	@param	o	second node
	@return	positive if greater, negative if lower
	*/
	public int compareTo(Object o)
	{
		return frequency - ((HuffmanNode)o).frequency();
	}
	
	/*
	Checks if node points to anything
	
	@return	true if does not point to anything
	*/
	public boolean isLeaf()
	{
		//if left is null right must also be null, and vice versa
		//only have to check one case
		if (null == left)
			return true;
		return false;
	}
	
	/*
	toString method.
	Uses the same algorithm as binary tree
	
	@return	String representation of tree
	*/
	public String toString()
	{
		String output;
		if (value == null)
			output = "Null";
		else
			output = value.toString() + frequency;
		if (isLeaf())
			return output;
		//don't need to check cases if only right or left is null
		//don't need to print out frequency
		else
			return output + "(" + left.toString() + "," + right.toString() + ")";
	}
}
