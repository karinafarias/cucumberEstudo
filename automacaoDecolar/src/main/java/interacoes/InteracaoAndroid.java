package interacoes;

import interfaces.mobile.android.IAcoesAPP;
import interfaces.mobile.android.IAcoesDevice;
import interfaces.mobile.android.IArrastar;
import interfaces.mobile.android.IClique;
import interfaces.mobile.android.ICombo;
import interfaces.mobile.android.IEscrever;
import interfaces.mobile.android.ILimpar;
import interfaces.mobile.android.IMover;
import interfaces.mobile.android.IObter;
import interfaces.mobile.android.ISwipe;
import interfaces.mobile.android.IUtils;

public interface InteracaoAndroid extends IAcoesAPP, IAcoesDevice, IArrastar, IClique, ICombo, IEscrever, ILimpar, ISwipe, IMover, IObter, IUtils {
	String nomePlataformaDeExecucao = null;
}