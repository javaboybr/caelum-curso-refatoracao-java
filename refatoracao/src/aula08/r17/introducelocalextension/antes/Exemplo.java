package aula08.r17.introducelocalextension.antes;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Exemplo {
	
	public Exemplo() {
		LocalDateTime data = LocalDateTime.now();
		LocalDate ultimoDiaDoMes = ultimoDiaDoMes(data);
		LocalDate primeiroDiaDoMes = primeiroDiaDoMes(data);
		boolean ehFimDeSemana = ehFimDeSemana(data);
	}

	private boolean ehFimDeSemana(LocalDateTime data) {
		return data.getDayOfWeek().equals(DayOfWeek.SATURDAY) 
				|| data.getDayOfWeek().equals(DayOfWeek.SUNDAY);
	}

	private LocalDate primeiroDiaDoMes(LocalDateTime data) {
		return LocalDate.of(data.getYear(), data.getMonth(), 1);
	}

	private LocalDate ultimoDiaDoMes(LocalDateTime data) {
		return LocalDate.of(data.getYear(), data.getMonth(), data.getMonth().maxLength());
	}
}
