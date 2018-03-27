package br.com.caelum.livraria.dominio;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ClienteTest {
	
	private static final String cep = "03297060";
	public static final Cliente umCliente = new Cliente("idCliente", cep);
	public static final Cliente outroCliente = new Cliente("outroIdCliente", cep);
	
	@Test
	public void igualdade() {
		String id = "id do cliente";
		Cliente idCliente = new Cliente(id, cep);
		Cliente outroIdCliente = new Cliente(id, cep);
		
		assertThat(idCliente, is(equalTo(outroIdCliente)));
		assertThat(idCliente.hashCode(), is(equalTo(outroIdCliente.hashCode())));
	}
}
