package aula08.r16.introduceforeignmethod.antes;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Exemplo {
	
	public Exemplo() {
		LocalDateTime data = LocalDateTime.now();
		LocalDate ultimoDiaDoMes = LocalDate.of(data.getYear(), data.getMonth(), data.getMonth().maxLength());
	}
}
