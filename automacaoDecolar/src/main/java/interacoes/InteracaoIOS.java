package interacoes;

import interfaces.mobile.ios.IAcoesAPP;
import interfaces.mobile.ios.IAcoesDevice;
import interfaces.mobile.ios.IArrastar;
import interfaces.mobile.ios.IClique;
import interfaces.mobile.ios.ICombo;
import interfaces.mobile.ios.IEscrever;
import interfaces.mobile.ios.ILimpar;
import interfaces.mobile.ios.IMover;
import interfaces.mobile.ios.IObter;
import interfaces.mobile.ios.IUtils;

public interface InteracaoIOS extends IAcoesAPP, IAcoesDevice, IArrastar, IClique, ICombo, IEscrever, ILimpar, IMover, IObter, IUtils {
	String nomePlataformaDeExecucao = null;
}