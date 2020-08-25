package util;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class Utilitaria {

	public static String obterHoraMinutoSegundo() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm.ss");
		LocalDateTime agora = LocalDateTime.now(ZoneId.systemDefault());
		String agoraFormatado = agora.format(formatter);
		return agoraFormatado;
	}
	
	public String obterData() {
		LocalDate lcd = LocalDate.now(ZoneId.systemDefault());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String data = lcd.format(formatter);
		return data;
	}

	public String parsePdf(String pdf) throws IOException {
		PdfReader reader = new PdfReader(pdf);
		PdfReaderContentParser parser = new PdfReaderContentParser(reader);
		TextExtractionStrategy strategy = null;
		String texto = null;
		for (int i = 1; i <= reader.getNumberOfPages(); i++) {
			strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
			texto = texto + " " + strategy.getResultantText();
		}
		reader.close();
		return texto;
	}
	
	public static void renomearArquivo(String nomeAtual, String novoNome) {
		  new File(nomeAtual).renameTo(new File(novoNome));	
	}
}