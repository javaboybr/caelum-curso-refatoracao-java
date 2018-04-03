package br.com.caelum.livraria.dominio;

import static br.com.caelum.livraria.dominio.TelefoneTest.umTelefone;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ClienteTest {
	
	private static final String cep = "03297060";
	private static final String idCliente = "idCliente";
	public static final Cliente umCliente = new Cliente("idCliente", cep, umTelefone);
	public static final Cliente outroCliente = new Cliente("outroIdCliente", cep, umTelefone);
	
	@Test
	public void igualdade() {
		Cliente outroCliente = new Cliente(idCliente, cep, umTelefone);
		
		assertThat(umCliente, is(equalTo(outroCliente)));
		assertThat(umCliente.hashCode(), is(equalTo(outroCliente.hashCode())));
	}
	
	@Test
	public void lerTelefoneFormatado() {
		assertThat(umCliente.lerTelefone(), is(equalTo("(11) 55555555")));
	}
	
	@Test
	public void lerCepFormatado() {
		assertThat(umCliente.lerCepFormatado(), is(equalTo("03297-060")));
	}
}
