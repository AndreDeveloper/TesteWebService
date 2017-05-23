
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Principal {
	public static void main(String[] args) {

			/*try {
				List<UnidadeDeSaude> list = ConsumirServico.getHospitais("-45.99400", "-3.56500");
			} catch (IOException | XmlPullParserException | ParserConfigurationException | SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			ConsumirServico.teste("-46.25416", "-3.56500");

		

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
