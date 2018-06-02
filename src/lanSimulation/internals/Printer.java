package lanSimulation.internals;

public class Printer extends Node{

	public Printer(byte type, String name, Node nextNode) {
		super(type, name, nextNode);
	}
	
	public void printXMLOnPrinter(StringBuffer buf) {
		buf.append("<printer>");
		buf.append(name_);
		buf.append("</printer>");
	}
	
	public void printOnPrinter(StringBuffer buf) {
		buf.append("Printer ");
		buf.append(name_);
		buf.append(" [Printer]");
	}


}
