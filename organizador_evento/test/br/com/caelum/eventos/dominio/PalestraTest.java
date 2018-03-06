package br.com.caelum.eventos.dominio;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalTime;

import org.junit.Test;

import br.com.caelum.eventos.dominio.Palestra;
import br.com.caelum.eventos.dominio.TempoDeDuracao;

public class PalestraTest {
	
	@Test
	public void igualdade(){
		String nomeDaPalestra = "nome da palestra";
		Palestra umaPalestra = new Palestra(nomeDaPalestra, new TempoDeDuracao(20));
		Palestra outraPalestra = new Palestra(nomeDaPalestra, new TempoDeDuracao(40));
		
		assertThat(umaPalestra, is(equalTo(outraPalestra)));
	}
	
	@Test
	public void toStringDePalestraAntesDoAlmoco(){
		Palestra palestraCedo = new Palestra("Uma palestra pra acordar", new TempoDeDuracao(10));
		palestraCedo.agendarPara(LocalTime.of(9, 30));
		
		String esperado = "09:30AM Uma palestra pra acordar 10min";
		String obtido = palestraCedo.toString();
		assertThat(obtido, is(equalTo(esperado)));
	}
	
	@Test
	public void toStringDePalestraAposOAlmoco(){
		Palestra palestraCedo = new Palestra("Uma palestra pra dormir", new TempoDeDuracao(10));
		palestraCedo.agendarPara(LocalTime.of(15, 30));
		
		String esperado = "03:30PM Uma palestra pra dormir 10min";
		String obtido = palestraCedo.toString();
		assertThat(obtido, is(equalTo(esperado)));
	}
}
