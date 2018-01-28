package aula06.r12.extractclass.antes;

public class Empresa {
	
    public String razaoSocial;
    public String cnpj;

    public String endEntregaLogradouro;
    public String endEntregaNumero;
    public String endEntregaComplemento;
    public String endEntregaBairro;
    public String endEntregaCEP;
    public String endEntregaMunicipio;
    public String endEntregaUF;

    public String endComercialLogradouro;
    public String endComercialNumero;
    public String endComercialComplemento;
    public String endComercialBairro;
    public String endComercialCEP;
    public String endComercialMunicipio;
    public String endComercialUF;
	
    public Empresa(String razaoSocial, String cnpj, String endEntregaLogradouro, String endEntregaNumero, 
    		String endEntregaComplemento, String endEntregaBairro, String endEntregaCEP, 
    		String endEntregaMunicipio, String endEntregaUF, String endComercialLogradouro, 
    		String endComercialNumero, String endComercialComplemento, String endComercialBairro, 
    		String endComercialCEP, String endComercialMunicipio, String endComercialUF)
    {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endEntregaLogradouro = endEntregaLogradouro;
        this.endEntregaNumero = endEntregaNumero;
        this.endEntregaComplemento = endEntregaComplemento;
        this.endEntregaBairro = endEntregaBairro;
        this.endEntregaCEP = endEntregaCEP;
        this.endEntregaMunicipio = endEntregaMunicipio;
        this.endEntregaUF = endEntregaUF;
        this.endComercialLogradouro = endComercialLogradouro;
        this.endComercialNumero = endComercialNumero;
        this.endComercialComplemento = endComercialComplemento;
        this.endComercialBairro = endComercialBairro;
        this.endComercialCEP = endComercialCEP;
        this.endComercialMunicipio = endComercialMunicipio;
        this.endComercialUF = endComercialUF;
    }

    public String GetTextoEnderecoComercial()
    {
        return String.format("Endereço: %s %s %s - %s - CEP %s - %s - %s", 
        		endComercialLogradouro, endComercialNumero, endComercialComplemento, endComercialBairro, endComercialCEP, endComercialMunicipio, endComercialUF);
    }

    public String GetTextoEnderecoEntrega()
    {
        return String.format("Endereço: %s %s %s - %s - CEP %s - %s - %s",
        		endEntregaLogradouro, endEntregaNumero, endEntregaComplemento, endEntregaBairro, endEntregaCEP, endEntregaMunicipio, endEntregaUF);
    }

    public void UpdateEnderecoEntrega(String endEntregaLogradouro, String endEntregaNumero, String endEntregaComplemento, String endEntregaBairro, String endEntregaCEP, String endEntregaMunicipio, String endEntregaUF)
    {
    		this.endEntregaLogradouro = endEntregaLogradouro;
    		this.endEntregaNumero = endEntregaNumero;
    		this.endEntregaComplemento = endEntregaComplemento;
    		this.endEntregaBairro = endEntregaBairro;
    		this.endEntregaCEP = endEntregaCEP;
    		this.endEntregaMunicipio = endEntregaMunicipio;
    		this.endEntregaUF = endEntregaUF;
    }

    public void UpdateEnderecoComercial(String endComercialLogradouro, String endComercialNumero, String endComercialComplemento, String endComercialBairro, String endComercialCEP, String endComercialMunicipio, String endComercialUF)
    {
    		this.endComercialLogradouro = endComercialLogradouro;
    		this.endComercialNumero = endComercialNumero;
    		this.endComercialComplemento = endComercialComplemento;
    		this.endComercialBairro = endComercialBairro;
    		this.endComercialCEP = endComercialCEP;
    		this.endComercialMunicipio = endComercialMunicipio;
    		this.endComercialUF = endComercialUF;
    }
}
