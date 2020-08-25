package geradoresdemassa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GerarDataNascimento {
	private Random random = new Random();
	private List<String> datas = new ArrayList<>();
	private int aleatorioDia;
	private int aleatorioMes;
	private int aleatorioAno;
	private String dataNascimento;
	private String dtMes;
	private String dtDia;
	private String dataTotal;

	protected List<String> gerarData(int quantidade, boolean comBarra) {
		String dia[] = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		String mes[] = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		String ano[] = { "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931",
				"1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944",
				"1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1954", "1955", "1956",
				"1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969",
				"1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982",
				"1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995",
				"1996", "1997", "1998", "1999", "2000" };

		for (int i = 0; i < quantidade; i++) {
			aleatorioDia = 0 + random.nextInt(dia.length);
			aleatorioMes = 0 + random.nextInt(mes.length);
			aleatorioAno = 0 + random.nextInt(ano.length);
			dataNascimento = dia[aleatorioDia] + mes[aleatorioMes] + ano[aleatorioAno];
			dataNascimento = validaData(dataNascimento);
			if (dataNascimento.length() == 8) {
				if(comBarra) {
					dataNascimento = acrescentarBarras(dataNascimento);
				}		
				datas.add(dataNascimento);
			}
		}
		
		return datas;
	}

	private String acrescentarBarras(String data) {
		return data.substring(0, 2) + "/" + data.substring(2, 4) + "/" + data.substring(4, 8);
	}

	private String validaData(String dataNascimento) {
		dtMes = dataNascimento.substring(2, 4);
		dtDia = dataNascimento.substring(0, 2);

		if (dtMes.equals(dtMes) == dtMes.equals("02")) {
			if (dtDia.equals(dtDia) == dtDia.equals("29") || dtDia.equals(dtDia) == dtDia.equals("30")
					|| dtDia.equals(dtDia) == dtDia.equals("31")) {

				dataNascimento = dataNascimento.substring(0, 2).replace(dtDia, "28") + dataNascimento.substring(2, 4)
						+ dataNascimento.substring(4, 8);
			}
		}

		dataTotal = dataNascimento;
		if (dtMes.equals("04") || dtMes.equals("06") || dtMes.equals("09") || dtMes.equals("11")) {
			if (dtDia.equals("31")) {
				String dats = dataTotal.replace(dtDia, "30");
				dataNascimento = dats.substring(0, 2) + dats.substring(2, 4) + dats.substring(4, 8);
			}
		}
		return dataNascimento;
	}
}