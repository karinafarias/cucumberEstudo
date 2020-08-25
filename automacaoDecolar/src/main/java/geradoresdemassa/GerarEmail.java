package geradoresdemassa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.geradoresdemassa.ModelGeradoresDeMassa;

public class GerarEmail {

	private ModelGeradoresDeMassa pessoa = new ModelGeradoresDeMassa();
	private String recebeNome;
	private String geradorDeEmail;
	private int emailAleatorio;
	private String expression;
	private Pattern pattern;
	private Matcher matcher;
	private String email[] = { "@hotmail.com", "@gmail.com", "@yahoo.com.br", "@bol.com.br", "@outlook.com" };
	private List<String> emails = new ArrayList<String>();

	boolean emailValidar = false;

	List<String> nomeGerado = new ArrayList<>();

	protected List<String> gerarEmail(int quantidade) {
		Random random = new Random();
		GerarNome gerarNome = new GerarNome();
		if (pessoa.getNome() == null) {
			nomeGerado.addAll(gerarNome.gerarNome(quantidade));
		} else {
			nomeGerado = null;
		}
		for (int i = 0; i < quantidade; i++) {
			emailAleatorio = 0 + random.nextInt(email.length);
			if (nomeGerado == null) {
				recebeNome = pessoa.getNome().replace(" ", "").toLowerCase();
				geradorDeEmail = recebeNome + email[emailAleatorio];
			} else {
				recebeNome = nomeGerado.get(i).replace(" ", "").toLowerCase();
				geradorDeEmail = recebeNome + email[emailAleatorio];
			}
			if (geradorDeEmail != null && validarEmail(geradorDeEmail) == true) {
				emails.add(geradorDeEmail);
			}
		}
		return emails;
	}

	private boolean validarEmail(String emailUsuario) {
		if (emailUsuario != null && emailUsuario.length() > 0) {
			expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			matcher = pattern.matcher(emailUsuario);
			if (matcher.matches()) {
				emailValidar = true;
			}
		}
		return emailValidar;
	}
}