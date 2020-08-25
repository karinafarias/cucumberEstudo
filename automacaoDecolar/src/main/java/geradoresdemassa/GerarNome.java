package geradoresdemassa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GerarNome {

	private Random random = new Random();
	private List<String> nomes = new ArrayList<String>();
	private int resultSorteio;
	private int aleatorioMasculino1;
	private int aleatorioMasculino2;
	private int aleatorioSobrenome;
	private int aleatorioFeminino1;
	private int aleatorioFeminino2;
	private String nome = null;

	protected List<String> gerarNome(int quantidade) {
		String masculino[] = { "Amadeu", "Abel", "Abelardo", "Abigael", "Alceu", "Alfino", "Amaralio", "Alacio",
				"Ananias", "Asmael", "William", "Bernado", "Jhonnatan", "Gabriel", "Guimaraes", "Enzo", "Joao", "Jose",
				"Vitor", "Emanuel", "Wellington", "Edmar", "Caio", "Rui", "Isaque", "Edvan", "Derek", "Pietro",
				"Maxwel", "Carlos", "Jorge", "George", "Paulo", "Jonathan", "David", "Ernani", "Fagundes", "Kaue",
				"Giovani", "Hernani", "Josue", "Ivanildo", "Jonas", "Kleber", "Leandro", "Mario", "Nivaldo", "Osvaldo",
				"Sandoval", "Marcelo", "Jairo", "Josivaldo", "Josivan", "Jheferson", "Kleber", "Luis", "Luiz", "Kaua" };
		String sobrenome[] = { "Villas Lobos", "Villas", "Silverio", "Solas", "Cruz", "dos Santos", "Goncalves",
				"Lopes", "Santos", "Rosa", "Louise", "Verissimo", "Silva", "Barbosa", "Amado", "Macedo", "Machado",
				"Pessoa", "Bandeira", "Meireles", "Andrade", "Cunha", "Moraes", "de Castro", "Castro", "de Assis",
				"Nobrega", "Correia", "Alves", "Azevedo", "Ramos", "Lobo", "Souto", "Rodrigues", "Oliveira", "Souza" };
		String feminino[] = { "Patricia", "Clara", "Maria", "Roberta", "Monique", "Leticia", "Cecilia", "Julia",
				"Gabriele", "Gabriela", "Flavia", "Juliene", "Juliana", "Cristina", "Clarice", "Agatha", "Rachel",
				"Iraci", "Fatima", "Cleuza", "Nauva", "Neuza", "Jeiza", "Beatriz", "Carla", "Dauva", "Ernesta",
				"Giovana", "Hernania", "Izilda", "Janaina", "Kelly", "Lana", "Maraisa", "Noranei", "Abigail", "Judite",
				"Mariete", "Maiara", "Maraisa", "Josefa", "Pamela" };
		String sorteio[] = { "feminino", "masculino" };

		resultSorteio = 0 + random.nextInt(sorteio.length);
		for (int i = 0; i < quantidade; i++) {
			if (sorteio[resultSorteio] == "masculino") {
				aleatorioMasculino1 = 0 + random.nextInt(masculino.length);
				aleatorioMasculino2 = 0 + random.nextInt(masculino.length);
				aleatorioSobrenome = 0 + random.nextInt(sobrenome.length);

				nome = masculino[aleatorioMasculino1] + " " + masculino[aleatorioMasculino2] + " "
						+ sobrenome[aleatorioSobrenome];
			} else {
				aleatorioFeminino1 = 0 + random.nextInt(feminino.length);
				aleatorioFeminino2 = 0 + random.nextInt(feminino.length);
				aleatorioSobrenome = 0 + random.nextInt(sobrenome.length);

				nome = feminino[aleatorioFeminino1] + " " + feminino[aleatorioFeminino2] + " "
						+ sobrenome[aleatorioSobrenome];
			}
			nomes.add(nome);
		}
		return nomes;
	}
}