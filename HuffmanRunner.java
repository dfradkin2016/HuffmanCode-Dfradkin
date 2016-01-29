//testing the node
public class HuffmanRunner
{
	public static void main(String[] args)
	{
		HuffmanNode test = new HuffmanNode("df",3);
		test.setValue("DF");
		test.setFrequency(33);
		System.out.println(test.value());
		System.out.println(test.frequency());
		HuffmanNode t = new HuffmanNode("d",2);
		System.out.println(t.compareTo(test));
	}
}