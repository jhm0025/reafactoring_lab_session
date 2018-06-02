package lanSimulation.internals;

public class Workstation extends Node{

	public Workstation(byte type,String name,Node nextNode) {
		super(type,name ,nextNode);
	}
	
	public void printXMLOnWorkstation(StringBuffer buf) {
		buf.append("<workstation>");
		buf.append(name_);
		buf.append("</workstation>");
	}
	
	public void printOnWorkstation(StringBuffer buf) {
		buf.append("Workstation ");
		buf.append(name_);
		buf.append(" [Workstation]");
	}

}
