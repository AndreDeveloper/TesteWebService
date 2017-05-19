import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Principal {
	public static void main(String[] args) {
		try {
		String xml = Service.getXMLLocalizarEstabelecimento();		
				
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document;
		document = builder.parse(new InputSource(new StringReader(xml)));
		Element rootElement = document.getDocumentElement();
		
		System.out.println("cod:CodigoCNES = " + getString("ns2:codigo", rootElement));
		System.out.println("cod:CodigoUnidade = " + getString("ns24:codigo", rootElement));
		System.out.println("dad:nomeFantasia = " + getString("ns7:Nome", rootElement));
		System.out.println("dad:nomeEmpresarial = " + getString("ns7:Nome", rootElement));
		System.out.println("ns18:numeroTelefone " + getString("ns18:numeroTelefone", rootElement));
		System.out.println("pag:posicaoRegistroInicio = " + getString("pag:posicaoRegistroInicio", rootElement));
		System.out.println("pag:quantidadeRegistrosPorPagina = " + getString("pag:quantidadeRegistrosPorPagina", rootElement));
		System.out.println("pag:quantidadeRegistros = " + getString("pag:quantidadeRegistros", rootElement));
		System.out.println("ns30:longitude = " + getString("ns30:longitude", rootElement));
		System.out.println("ns30:latitude = " + getString("ns30:latitude", rootElement));
		System.out.println("ns30:geoJson = " + getString("ns30:geoJson", rootElement));
		
		
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	private static String getString(String tagName, Element element) {
        NodeList list = element.getElementsByTagName(tagName);
        if (list != null && list.getLength() > 0) {
            NodeList subList = list.item(0).getChildNodes();

            if (subList != null && subList.getLength() > 0) {
                return subList.item(0).getNodeValue();
            }
        }

        return null;
    }
}
