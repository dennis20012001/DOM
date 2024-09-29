package dom;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EjerC {

	public static void main(String[] args)
			throws TransformerException, SAXException, IOException, ParserConfigurationException {
		String nombreFichero = "C:\\\\Users\\\\Dennis\\\\DOM\\\\DOM\\\\DOM\\\\XML\\\\cd_catalog.xml";
		File inputFile = new File(nombreFichero);
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(inputFile);

		NodeList listaCDs = doc.getElementsByTagName("CD");

		for (int i = 0; i < listaCDs.getLength(); i++) {
			Element cd = (Element) listaCDs.item(i);

			if (!cd.hasAttribute("ID")) {
				cd.setAttribute("ID", String.valueOf(i + 1));
			}
		}

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);

		StreamResult result = new StreamResult(new File(nombreFichero));
		transformer.transform(source, result);

	}

}
