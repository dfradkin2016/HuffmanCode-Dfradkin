//testing the node

import java.util.PriorityQueue;

public class HuffmanRunner
{
	public static void main(String[] args)
	{
		//HuffmanNode test = new HuffmanNode("df",3);
		//test.setValue("DF");
		//test.setFrequency(33);
		//System.out.println(test.value());
		//System.out.println(test.frequency());
		//HuffmanNode t = new HuffmanNode("d",2);
		//System.out.println(t.compareTo(test));
		PriorityQueue<HuffmanNode>  q = new PriorityQueue<HuffmanNode>();
		q.add(new HuffmanNode("a", 1));
		q.add(new HuffmanNode("b", 1));
		q.add(new HuffmanNode("c", 3));
		q.add(new HuffmanNode("d", 1));
		System.out.println(q.poll().value());
		System.out.println(q.poll().value());
		System.out.println(q.poll().value());
		HuffmanTree tree = new HuffmanTree("The Bluebook blamed blue Brian");
		System.out.println(tree);
		System.out.println(tree.encode("The"));
		System.out.println(tree.decode("11100"));
		System.out.println(tree.decode(tree.encode("hi im lame mall")));
		HuffmanTree ex = new HuffmanTree("aaaaabbrrcd");
		System.out.println(ex);
	}
}