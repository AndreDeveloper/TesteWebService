
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParserException;

public class ConsumirServico {
    public static final String URL = "https://servicos.saude.gov.br/cnes/EstabelecimentoSaudeService/v1r0";

    public static StringBuffer requisitar(String mensagemXML) throws IOException, XmlPullParserException {
//
        StringBuffer buffer = new StringBuffer();
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(URL);

        try {
            StringEntity se = new StringEntity( mensagemXML);
            se.setContentType("text/xml");
            httppost.setEntity(se);

            HttpResponse httpresponse = httpclient.execute(httppost);
            HttpEntity resEntity = httpresponse.getEntity();
            buffer.append(EntityUtils.toString(resEntity));
        } catch (ClientProtocolException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        }
        //


        return buffer;


    }

    
    public static void  teste(String longitude, String latitude){
    	XMLParser parser;
        StringBuffer resposta;
        String requisicao = XMLFactory.getXMLLocalizarEstabelecimentoSaude(
                longitude,
                latitude,
                Tipo.Hospital.CODIGO,
                Tipo.Hospital.DESCRICAO,
                1,
                10,
                50
        );
        try {
			resposta = ConsumirServico.requisitar(requisicao);
			parser = new XMLParser(resposta.toString());
			System.out.println(parser.getTesteByTag("res1:EstabelecimentoSaude"));
		} catch (IOException | XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    
    public static List<UnidadeDeSaude> getHospitais(String longitude, String latitude)
    throws IOException, XmlPullParserException, ParserConfigurationException, SAXException {

        List<UnidadeDeSaude> listaDeUnidades = new ArrayList<UnidadeDeSaude>();
        int numeroDaRequisicao = 1;
        XMLParser parser;
        StringBuffer resposta;
        boolean iterage = true;
        String tipo = Tipo.Hospital.DESCRICAO;
        String codigo = Tipo.Hospital.CODIGO;

        while (iterage && numeroDaRequisicao < 2) {
            String requisicao = XMLFactory.getXMLLocalizarEstabelecimentoSaude(
                    longitude,
                    latitude,
                    codigo,
                    tipo,
                    numeroDaRequisicao,
                    1,
                    50
            );
            resposta = ConsumirServico.requisitar(requisicao);
            parser = new XMLParser(resposta.toString());

            if (parser.getElementByTag("ns21:codigo") == null &&
                    parser.getElementByTag("S:Text") == null) {

               
            	//System.out.println("resultado_ns21:codigo = " + parser.getElementByTag("ns21:codigo"));
            	//System.out.println("resultado_S:Text = " + parser.getElementByTag("S:Text") );
            	//System.out.println("resultado_numeroDaRequisicao = " + numeroDaRequisicao);
            	//System.out.println("dad:perteceSistemaSUS = " + parser.getElementByTag("dad:perteceSistemaSUS"));
            	
                boolean isHospitalDoSUS = Boolean.parseBoolean(parser.getElementByTag("dad:perteceSistemaSUS"));


                UnidadeDeSaude unidadeDeSaude = new UnidadeDeSaude(
                        Long.parseLong(parser.getElementByTag("ns2:codigo")),
                        Long.parseLong(parser.getElementByTag("ns24:codigo")),
                        tipo,
                        parser.getElementByTag("ns7:Nome"),
                        parser.getElementByTag("ns7:Nome"),
                        null,
                        parser.getElementByTag("ns11:nomeLogradouro"),
                        parser.getElementByTag("ns11:numero"),
                        parser.getElementByTag("ns11:complemento"),
                        parser.getElementByTag("ns14:numeroCEP"),
                        parser.getElementByTag("ns15:nomeMunicipio"),
                        parser.getElementByTag("ns16:siglaUF"),
                        parser.getElementByTag("ns27:Nome"),
                        parser.getElementByTag("ns28:descricao"),
                        parser.getElementByTag("ns18:DDD"),
                        parser.getElementByTag("ns18:numeroTelefone"),
                        parser.getElementByTag("ns20:descricaoEmail"),
                        parser.getElementByTag("ns30:longitude"),
                        parser.getElementByTag("ns30:latitude")
                );
                
                System.out.println(unidadeDeSaude.toString());
                listaDeUnidades.add(unidadeDeSaude);
                numeroDaRequisicao++;
            } else {
                if (tipo == Tipo.Hospital.DESCRICAO){
                    tipo = Tipo.PostoSaude.DESCRICAO;
                    codigo = Tipo.PostoSaude.CODIGO;
                    numeroDaRequisicao = 1;
                }else{
                    iterage = false;
                }
            }

        }

        return listaDeUnidades;
    }

    public static final class Tipo{
        public final class Hospital{
            public static final String DESCRICAO = "HOSPITAL";
            public static final String CODIGO = "05";
        }
        public static final class PostoSaude{
            public static final String DESCRICAO = "POSTO SAUDE";
            public static final String CODIGO = "02";
        }
    }
}