
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Created by andre on 20/05/17.
 */

public class XMLParser {
	public String xml;
	public Element rootElement;
	Document document;

	public XMLParser(String xml) throws ParserConfigurationException, IOException, SAXException {
		this.xml = xml.replace(" ", "");

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		document = builder.parse(new InputSource(new StringReader(xml)));
		this.rootElement = document.getDocumentElement();
	}

	public String getElementByTag(String tagName) {
		NodeList list = this.rootElement.getElementsByTagName(tagName);
		if (list != null && list.getLength() > 0) {
			NodeList subList = list.item(0).getChildNodes();

			if (subList != null && subList.getLength() > 0) {
				return subList.item(0).getNodeValue();
			}
		}
		return null;
	}

	public String getTesteByTag(String tagName) {
		NodeList list = this.rootElement.getElementsByTagName(tagName);
		if (list != null && list.getLength() > 0) {
			// NodeList subList = list.item(0).getChildNodes();
			// System.out.println("resultado = " + getNodeValueList(list));
			// if (subList != null && subList.getLength() > 0) {
			int x = 1;
			System.out.println("tamanho da lista" + list.getLength());
			System.out.println("nome: " + list.item(0).getNodeName());
			for (String s : getNodeValueList(list)) {
				System.out.println(s);
				x++;
			}
			// }
		}
		return null;
	}

	public List<String> getNodeValueList(NodeList list) {
		List<String> resultado = new ArrayList<String>();
		for (int x = 0; x < list.getLength(); x++) {
			if (list.item(x).getNodeValue() != null) {
				resultado.add(list.item(x).getNodeValue());

			} else {
				if (list.item(x).getChildNodes().item(0).getChildNodes().item(0).getNodeValue() != null){
					resultado.add(list.item(x).getNodeName());
				}
				List<String> listaTemp = getNodeValueList(list.item(x).getChildNodes());				
				if (listaTemp != null) {
					resultado.addAll(getNodeValueList(list.item(x).getChildNodes()));
				}
			}
		}
		return resultado;
	}


}