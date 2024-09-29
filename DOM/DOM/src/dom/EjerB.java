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
import org.xml.sax.SAXException;

public class EjerB {

	public static void main(String[] args)
			throws TransformerException, SAXException, IOException, ParserConfigurationException {
		String nombreFichero = "C:\\\\Users\\\\Dennis\\\\DOM\\\\DOM\\\\DOM\\\\XML\\\\cd_catalog.xml";
		File inputFile = new File(nombreFichero);
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(inputFile);

		// Obtener el elemento raíz existente en lugar de crear uno nuevo
		Element eRaiz = doc.getDocumentElement();

		// Crear un nuevo nodo 'CD'
		Element eCoche = doc.createElement("CD");
		eRaiz.appendChild(eCoche);

		// Crear y agregar los elementos al nuevo nodo 'CD'
		Element eTitulo = doc.createElement("tilte");
		eTitulo.appendChild(doc.createTextNode("alohomora"));
		eCoche.appendChild(eTitulo);

		Element eArtista = doc.createElement("Artits");
		eArtista.appendChild(doc.createTextNode("harry"));
		eCoche.appendChild(eArtista);

		Element ePais = doc.createElement("country");
		ePais.appendChild(doc.createTextNode("england"));
		eCoche.appendChild(ePais);

		Element eCompania = doc.createElement("company");
		eCompania.appendChild(doc.createTextNode("Capcon"));
		eCoche.appendChild(eCompania);

		Element ePrecio = doc.createElement("price");
		ePrecio.appendChild(doc.createTextNode("1"));
		eCoche.appendChild(ePrecio);

		Element eAnio = doc.createElement("year");
		eAnio.appendChild(doc.createTextNode("1990"));
		eCoche.appendChild(eAnio);

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);

		StreamResult result = new StreamResult(new File(nombreFichero));
		transformer.transform(source, result);
	}

}
