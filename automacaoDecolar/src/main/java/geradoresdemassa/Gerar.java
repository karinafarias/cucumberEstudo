package geradoresdemassa;

import java.util.List;

import enums.Estado;

public class Gerar {

	public List<String> retornaEmail(int param) { GerarEmail geraEmail = new GerarEmail(); return geraEmail.gerarEmail(param); }

	public List<String> retornaTelefoneFixo(int param) {GerarTelefone geraTelefone = new GerarTelefone(); return geraTelefone.gerarTelefoneFixo(param); }

	public List<String> retornaTelefoneCelular(int param) { GerarTelefone geraTelefone = new GerarTelefone(); return geraTelefone.gerarTelefoneCelular(param); }

	public List<String> retornaRg(int param) { GerarRg geraRg = new GerarRg(); return geraRg.gerarRg(param); }

	public List<String> retornaCpf(int param) { GerarCpf geraCpf = new GerarCpf(); return geraCpf.gerarCpf(param); }

	public List<String> retornaCnpj(int param) { GerarCnpj geraCnpj = new GerarCnpj(); return geraCnpj.gerarCnpj(param); }

	public List<String> retornaCep(int param, Estado estado) { GerarCep geraCep = new GerarCep(); return geraCep.gerarCep(param, estado.toString()); }

	public List<String> retornaDataNasc(int param, boolean comBarra) { GerarDataNascimento geraDataNascimento = new GerarDataNascimento(); return geraDataNascimento.gerarData(param, comBarra); }

	public List<String> retornaNome(int param) { GerarNome geraNome = new GerarNome(); return geraNome.gerarNome(param); }

	public List<String> retornaEndereco(int param) { GerarEndereco geraEndereco = new GerarEndereco(); return geraEndereco.gerarEndereco(param); }
}