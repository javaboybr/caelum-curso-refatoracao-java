package aula08.r17.introducelocalextension.depois;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Exemplo {
	
	public Exemplo() {
		DateTimeExtensions data = new DateTimeExtensions(LocalDateTime.now());
		LocalDate ultimoDiaDoMes = data.ultimoDiaDoMes();
		LocalDate primeiroDiaDoMes = data.primeiroDiaDoMes();
		boolean ehFimDeSemana = data.ehFimDeSemana();
	}	
}

class DateTimeExtensions {
	
	private LocalDateTime data;
	
	public DateTimeExtensions(LocalDateTime data) {
		this.data = data;
	}
	
	public LocalDate primeiroDiaDoMes() {
		return LocalDate.of(data.getYear(), data.getMonth(), 1);
	}
	
	public LocalDate ultimoDiaDoMes() {
		return LocalDate.of(data.getYear(), data.getMonth(), data.getMonth().maxLength());
	}
	
	public boolean ehFimDeSemana() {
		return data.getDayOfWeek().equals(DayOfWeek.SATURDAY) 
				|| data.getDayOfWeek().equals(DayOfWeek.SUNDAY); 
	}
}
