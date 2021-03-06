/*   This file is part of lanSimulation.
 *
 *   lanSimulation is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; either version 2 of the License, or
 *   (at your option) any later version.
 *
 *   lanSimulation is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with lanSimulation; if not, write to the Free Software
 *   Foundation, Inc. 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
 *   Copyright original Java version: 2004 Bart Du Bois, Serge Demeyer
 *   Copyright C++ version: 2006 Matthias Rieger, Bart Van Rompaey
 */
package lanSimulation.internals;

import java.io.IOException;
import java.io.Writer;

import lanSimulation.Network;

/**
 * A <em>Node</em> represents a single Node in a Local Area Network (LAN).
 * Several types of Nodes exist.
 */
public class Node {
	// enumeration constants specifying all legal node types
	/**
	 * A node with type NODE has only basic functionality.
	 */
	public static final byte NODE = 0;
	/**
	 * A node with type WORKSTATION may initiate requests on the LAN.
	 */
	public static final byte WORKSTATION = 1;
	/**
	 * A node with type PRINTER may accept packages to be printed.
	 */
	public static final byte PRINTER = 2;

	/**
	 * Holds the type of the Node.
	 */
	public byte type_;
	/**
	 * Holds the name of the Node.
	 */
	public String name_;
	/**
	 * Holds the next Node in the token ring architecture.
	 * 
	 * @see lanSimulation.internals.Node
	 */
	public Node nextNode_;

	/**
	 * Construct a <em>Node</em> with given #type and #name.
	 * <p>
	 * <strong>Precondition:</strong> (type >= NODE) & (type <= PRINTER);
	 * </p>
	 */
	public Node(byte type, String name) {
		assert (type >= NODE) & (type <= PRINTER);
		setType(type);
		setName(name);
		setNextNode_();
	}

	/**
	 * 
	 */
	public void setNextNode_() {
		nextNode_ = null;
	}

	/**
	 * Construct a <em>Node</em> with given #type and #name, and which is linked
	 * to #nextNode.
	 * <p>
	 * <strong>Precondition:</strong> (type >= NODE) & (type <= PRINTER);
	 * </p>
	 */
	public Node(byte type, String name, Node nextNode) {
		assert (type >= NODE) & (type <= PRINTER);
		setType(type);
		setName(name);
		nextNode_ = nextNode;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		name_ = name;
	}

	private void setType(byte type) {
		type_ = type;
	}

	public void logging(Writer report, Network network) throws IOException {
		report.write("\tNode '");
		report.write(name_);
		report.write("' passes packet on.\n");
		report.flush();
	}

	/**
	 * @param network TODO
	 * @return
	 */
	public Node atDestination(Network network) {
		Node currentNode;
		currentNode = nextNode_;
		return currentNode;
	}

	/**
	 * @param buf
	 * @param network TODO
	 */
	public void printOn(StringBuffer buf, Network network) {
		switch (getType()) {
		case Node.NODE:
			printOnNode(buf);
			break;
		case Node.WORKSTATION:
			printOnWorkstation(buf);
			break;
		case Node.PRINTER:
			printOnPrinter(buf);
			break;
		default:
			buf.append("(Unexpected)");
			;
			break;
		}
	}

	private byte getType() {
		return type_;
	}

	public void printOnPrinter(StringBuffer buf) {
		buf.append("Printer ");
		buf.append(name_);
		buf.append(" [Printer]");
	}

	public void printOnWorkstation(StringBuffer buf) {
		buf.append("Workstation ");
		buf.append(name_);
		buf.append(" [Workstation]");
	}

	public void printOnNode(StringBuffer buf) {
		buf.append("Node ");
		buf.append(name_);
		buf.append(" [Node]");
	}

	/**
	 * @param buf
	 * @param network TODO
	 */
	public void printXMLOn(StringBuffer buf, Network network) {
		switch (getType()) {
		case Node.NODE:
			printXMLOnNode(buf);
			break;
		case Node.WORKSTATION:
			printXMLOnWorkstation(buf);
			break;
		case Node.PRINTER:
			printXMLOnPrinter(buf);
			break;
		default:
			buf.append("<unknown></unknown>");
			;
			break;
		}
		;
	}

	public void printXMLOnPrinter(StringBuffer buf) {
		buf.append("<printer>");
		buf.append(name_);
		buf.append("</printer>");
	}

	public void printXMLOnWorkstation(StringBuffer buf) {
		buf.append("<workstation>");
		buf.append(name_);
		buf.append("</workstation>");
	}

	public void printXMLOnNode(StringBuffer buf) {
		buf.append("<node>");
		buf.append(name_);
		buf.append("</node>");
	}

}