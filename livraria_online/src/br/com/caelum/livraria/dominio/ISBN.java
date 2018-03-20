package br.com.caelum.livraria.dominio;

public class ISBN {

	private final String isbn;

	public ISBN(String isbn) {
		if(!validar(isbn)) 
			throw new IllegalArgumentException(String.format("ISBN inválido: %s", isbn));
		this.isbn = isbn;
	}

	private boolean validar(String isbn) {
		if (isbn == null) return false;
		
		// 7 - remover atribuições a parâmetros: é possível de usar esse código para exemplificar?
		isbn = isbn.replaceAll("-", "");
		if(isbn.replaceAll( "-", "" ).length() != 13) return false;
		
		try{
			int tot = 0;
			for (int i = 0; i < 12; i++ ){
				int digito = Integer.parseInt(isbn.substring(i, i + 1));
				tot += (i % 2 == 0) ? digito * 1 : digito * 3;
			}

			int checksum = 10 - (tot % 10);
			if ( checksum == 10 ) checksum = 0;
			

			return checksum == Integer.parseInt(isbn.substring(12));
		}
		catch (NumberFormatException nfe){
			return false;
		}
	}
}
