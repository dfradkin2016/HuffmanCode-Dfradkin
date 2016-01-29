/*

@author	Daria Fradkin
@version	January 29, 2016
*/

//need to comment
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanNode implements Comparable
{
	protected String value;
	protected int frequency;
	protected HuffmanNode left;
	protected HuffmanNode right;

	public HuffmanNode(String v, int f)
	{
		frequency = f;
		value = v;
		left = null;
		right = null;
	}
	
	public HuffmanNode(HuffmanNode l, HuffmanNode r)
	{
		left = l;
		right = r;
		value = l.value() + r.value();
		frequency = l.frequency() + r.frequency();
	}
	
	public String value()
	{
		return value;
	}
	
	public void setValue(String v)
	{
		value = v;
	}
	
	public int frequency()
	{
		return frequency;
	}
	
	public void setFrequency(int f)
	{
		frequency = f;
	}

	public HuffmanNode left()
	{
		return left;
	}
	
	public void setLeft(HuffmanNode l)
	{
		left = l;
	}

	public HuffmanNode right()
	{
		return right;
	}
	
	public void setRight(HuffmanNode r)
	{
		right = r;
	}
	
	public int compareTo(Object o)
	{
		return frequency - ((HuffmanNode)o).frequency();
	}
}
