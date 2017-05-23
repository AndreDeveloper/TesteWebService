

/**
 * Created by andre on 30/04/17.
 */


public final class XMLFactory {

    public static String getXMLLocalizarEstabelecimentoSaude(
            String longitude,
            String latitude,
            String codUnidade,
            String descricaoUnidade,
            int posicaoInicioDoRegistro,
            int qtdadeRegistrosPorPagina,
            int qtdadeTotalRegistros){
        return " <soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" "
                + "xmlns:est=\"http://servicos.saude.gov.br/cnes/v1r0/estabelecimentosaudeservice\" "
                + "xmlns:fil=\"http://servicos.saude.gov.br/wsdl/mensageria/v1r0/filtrolocalizacaoestabelecimentosaude\""
                + " xmlns:loc=\"http://servicos.saude.gov.br/schema/cnes/v1r0/localizacao\" "
                + "xmlns:tip=\"http://servicos.saude.gov.br/schema/cnes/v1r0/tipounidade\" "
                + "xmlns:pag=\"http://servicos.saude.gov.br/wsdl/mensageria/v1r0/paginacao\">"
                + "   <soap:Header>"
                + "<wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">"
                + "<wsse:UsernameToken wsu:Id=\"Id-0001334008436683-000000002c4a1908-1\" "
                + "xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">"
                + "<wsse:Username>CNES.PUBLICO</wsse:Username>"
                + "<wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">cnes#2015public</wsse:Password>"
                + "</wsse:UsernameToken>"
                + "</wsse:Security></soap:Header>"
                + "   <soap:Body>"
                + "      <est:requestLocalizarEstabelecimentoSaude>"
                + "         <fil:FiltroLocalizacaoEstabelecimentoSaude>"
                + "            <loc:Localizacao>"
                + "               <loc:longitude>" + longitude + "</loc:longitude>"
                + "               <loc:latitude>" + latitude + "</loc:latitude>"
                + "            </loc:Localizacao>"
                + "            <tip:tipoUnidade>"
                + "               <tip:codigo>" + codUnidade + "</tip:codigo>"
                + "               <tip:descricao>" + descricaoUnidade + "</tip:descricao>"
                + "            </tip:tipoUnidade>"
                + "            <!--Optional:-->"
                + "            <pag:Paginacao>"
                + "               <pag:posicaoRegistroInicio>" + posicaoInicioDoRegistro + "</pag:posicaoRegistroInicio>"
                + "               <pag:quantidadeRegistrosPorPagina>" + qtdadeRegistrosPorPagina + "</pag:quantidadeRegistrosPorPagina>"
                + "               <!--Optional:-->"
                + "               <pag:quantidadeRegistros>" + qtdadeTotalRegistros + "</pag:quantidadeRegistros>"
                + "            </pag:Paginacao>"
                + "         </fil:FiltroLocalizacaoEstabelecimentoSaude>"
                + "      </est:requestLocalizarEstabelecimentoSaude>"
                + "   </soap:Body>"
                + "</soap:Envelope>";

    }
}