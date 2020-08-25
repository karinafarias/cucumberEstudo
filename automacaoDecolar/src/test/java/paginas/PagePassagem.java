package paginas;

import elementos.ElePassagem;
import interacoes.InteracaoWeb;

public class PagePassagem extends ElePassagem implements InteracaoWeb {
	
	public void acessarBrowser() {
		abrirUrl("https://www.decolar.com/", "");
	}
}
