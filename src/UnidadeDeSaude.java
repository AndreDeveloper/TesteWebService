import java.io.Serializable;

/**
 * Created by andre on 30/04/17.
 */

public class UnidadeDeSaude implements Serializable{
    private long codEstabelecimentoSaude;
    private long codUnidadeSaudeCNES;
    private String tipo;
    private String nomeFantasiaEstabelecimento;
    private String razaoSocial;
    private String cnpj;
    private String nomeLogradouro;
    private String numeroLogradouro;
    private String complementoLogradouro;
    private String cep;
    private String municipio;
    private String uf;
    private String nomeDoDiretorDaUnidade;
    private String descricaoDoTipoDaUnidadeSaude;
    private String ddd;
    private String telefone;
    private String email;
    private String longitude;
    private String latitude;

    public UnidadeDeSaude() {
    }

    public UnidadeDeSaude(long codEstabelecimentoSaude,
                          long codUnidadeSaudeCNES,
                          String tipo,
                          String nomeFantasiaEstabelecimento,
                          String razaoSocial,
                          String cnpj,
                          String nomeLogradouro,
                          String numeroLogradouro,
                          String complementoLogradouro,
                          String cep,
                          String municipio,
                          String uf,
                          String nomeDoDiretorDaUnidade,
                          String descricaoDoTipoDaUnidadeSaude,
                          String ddd,
                          String telefone,
                          String email,
                          String longitude,
                          String latitude) {
        this.codEstabelecimentoSaude = codEstabelecimentoSaude;
        this.codUnidadeSaudeCNES = codUnidadeSaudeCNES;
        this.tipo = tipo;
        this.nomeFantasiaEstabelecimento = nomeFantasiaEstabelecimento;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.nomeLogradouro = nomeLogradouro;
        this.numeroLogradouro = numeroLogradouro;
        this.complementoLogradouro = complementoLogradouro;
        this.cep = cep;
        this.municipio = municipio;
        this.uf = uf;
        this.nomeDoDiretorDaUnidade = nomeDoDiretorDaUnidade;
        this.descricaoDoTipoDaUnidadeSaude = descricaoDoTipoDaUnidadeSaude;
        this.ddd = ddd;
        this.telefone = telefone;
        this.email = email;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getCodEstabelecimentoSaude() {
        return codEstabelecimentoSaude;
    }

    public void setCodEstabelecimentoSaude(long codEstabelecimentoSaude) {
        this.codEstabelecimentoSaude = codEstabelecimentoSaude;
    }

    public long getCodUnidadeSaudeCNES() {
        return codUnidadeSaudeCNES;
    }

    public void setCodUnidadeSaudeCNES(long codUnidadeSaudeCNES) {
        this.codUnidadeSaudeCNES = codUnidadeSaudeCNES;
    }

    public String getNomeFantasiaEstabelecimento() {
        return nomeFantasiaEstabelecimento;
    }

    public void setNomeFantasiaEstabelecimento(String nomeFantasiaEstabelecimento) {
        this.nomeFantasiaEstabelecimento = nomeFantasiaEstabelecimento;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getNumeroLogradouro() {
        return numeroLogradouro;
    }

    public void setNumeroLogradouro(String numeroLogradouro) {
        this.numeroLogradouro = numeroLogradouro;
    }

    public String getComplementoLogradouro() {
        return complementoLogradouro;
    }

    public void setComplementoLogradouro(String complementoLogradouro) {
        this.complementoLogradouro = complementoLogradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNomeDoDiretorDaUnidade() {
        return nomeDoDiretorDaUnidade;
    }

    public void setNomeDoDiretorDaUnidade(String nomeDoDiretorDaUnidade) {
        this.nomeDoDiretorDaUnidade = nomeDoDiretorDaUnidade;
    }

    public String getDescricaoDoTipoDaUnidadeSaude() {
        return descricaoDoTipoDaUnidadeSaude;
    }

    public void setDescricaoDoTipoDaUnidadeSaude(String descricaoDoTipoDaUnidadeSaude) {
        this.descricaoDoTipoDaUnidadeSaude = descricaoDoTipoDaUnidadeSaude;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "UnidadeDeSaude{" +
                "codEstabelecimentoSaude=" + codEstabelecimentoSaude +
                ", codUnidadeSaudeCNES=" + codUnidadeSaudeCNES +
                ", nomeFantasiaEstabelecimento='" + nomeFantasiaEstabelecimento + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", nomeLogradouro='" + nomeLogradouro + '\'' +
                ", numeroLogradouro='" + numeroLogradouro + '\'' +
                ", complementoLogradouro='" + complementoLogradouro + '\'' +
                ", cep='" + cep + '\'' +
                ", municipio='" + municipio + '\'' +
                ", uf='" + uf + '\'' +
                ", nomeDoDiretorDaUnidade='" + nomeDoDiretorDaUnidade + '\'' +
                ", descricaoDoTipoDaUnidadeSaude='" + descricaoDoTipoDaUnidadeSaude + '\'' +
                ", ddd='" + ddd + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}