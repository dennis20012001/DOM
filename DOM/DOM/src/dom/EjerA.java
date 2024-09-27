package dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EjerA {

	public static void main(String[] args) {
		File file = new File("./DOM/XML/cd_catalog.xml");
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			NodeList nList = doc.getElementsByTagName("CD");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				System.out.println(nNode.getNodeName() + ":" + temp);

				NodeList nodeList = nNode.getChildNodes();

				for (int i = 0; i < nodeList.getLength(); i++) {
					Node node = nodeList.item(i);

					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) node;
						System.out.print(eElement.getTagName() + ":");
						System.out.println(eElement.getTextContent());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
