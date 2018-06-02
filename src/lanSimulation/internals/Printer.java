package lanSimulation.internals;

public class Printer extends Node{

	public Printer(byte type, String name, Node nextNode) {
		super(type, name, nextNode);
	}
	
	public static void printXMLOnPrinter(StringBuffer buf) {
		buf.append("<printer>");
		buf.append(name_);
		buf.append("</printer>");
	}

	

	public static void printXMLOnNode(StringBuffer buf) {
		buf.append("<node>");
		buf.append(name_);
		buf.append("</node>");
	}
	
	
	public static void printOnPrinter(StringBuffer buf) {
		buf.append("Printer ");
		buf.append(name_);
		buf.append(" [Printer]");
	}

	

	public static void printOnNode(StringBuffer buf) {
		buf.append("Node ");
		buf.append(name_);
		buf.append(" [Node]");
	}

}
