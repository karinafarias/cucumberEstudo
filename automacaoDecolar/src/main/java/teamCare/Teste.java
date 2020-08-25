package teamCare;

import java.io.IOException;

import org.junit.Test;

public class Teste {
	
	@Test
	public void testar() throws IOException {
		PercorrerFeature percorrerFeature = new PercorrerFeature();
		System.out.println(percorrerFeature.percorrer("C:\\Users\\paulolobo\\Documents\\workspace-gitlab-brq\\Frameworks\\Framework Oficial\\frameworkqaa\\src\\test\\resources\\features"));

		VerificarQuantidadeDeRegressivos verQuantReg  = new VerificarQuantidadeDeRegressivos();
		verQuantReg.verificarQuantidadesDeRegressivos("C:\\Users\\paulolobo\\Documents\\workspace-gitlab-brq\\Frameworks\\Framework Oficial\\frameworkqaa\\src\\test\\resources\\relatorios\\cucumber-report\\Resultado.json");
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		
		ErrosPorRegressivo erroPorReg = new ErrosPorRegressivo();
		erroPorReg.errosPorRegressivo("C:\\Users\\paulolobo\\Documents\\workspace-gitlab-brq\\Frameworks\\Framework Oficial\\frameworkqaa\\src\\test\\resources\\relatorios\\cucumber-report\\Resultado.json");
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		
		
		ErroPorSprint erroPorSpr = new ErroPorSprint();
		erroPorSpr.verificarErrosNasSprints("C:\\Users\\paulolobo\\Documents\\workspace-gitlab-brq\\Frameworks\\Framework Oficial\\frameworkqaa\\src\\test\\resources\\relatorios\\cucumber-report\\Resultado.json");
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		
		StatusPorSprint statusPorSpr = new StatusPorSprint();
		statusPorSpr.verificarErrosNasSprints("C:\\Users\\paulolobo\\Documents\\workspace-gitlab-brq\\Frameworks\\Framework Oficial\\frameworkqaa\\src\\test\\resources\\relatorios\\cucumber-report\\Resultado.json");
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		
		StatusPorFeature statusPorFea = new StatusPorFeature();
		statusPorFea.obterStatusFeatures("C:\\Users\\paulolobo\\Documents\\workspace-gitlab-brq\\Frameworks\\Framework Oficial\\frameworkqaa\\src\\test\\resources\\relatorios\\cucumber-report\\Resultado.json");
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		
		ErroPorFeature erroPorFea = new ErroPorFeature();
		erroPorFea.obterErroFeatures("C:\\Users\\paulolobo\\Documents\\workspace-gitlab-brq\\Frameworks\\Framework Oficial\\frameworkqaa\\src\\test\\resources\\relatorios\\cucumber-report\\Resultado.json");
	}
}