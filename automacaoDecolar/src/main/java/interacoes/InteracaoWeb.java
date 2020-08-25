package interacoes;

import interfaces.web.IAcoesBrowser;
import interfaces.web.IAlert;
import interfaces.web.IArrastar;
import interfaces.web.IClique;
import interfaces.web.ICliqueJS;
import interfaces.web.ICombo;
import interfaces.web.IEscrever;
import interfaces.web.IEscreverJS;
import interfaces.web.IEspera;
import interfaces.web.IFrame;
import interfaces.web.ILimpar;
import interfaces.web.IMover;
import interfaces.web.IMoverJS;
import interfaces.web.IObterJS;
import interfaces.web.IProcurar;
import interfaces.web.IRolarJS;
import interfaces.web.IUtils;
import interfaces.web.IValidacoesWeb;

public interface InteracaoWeb extends IAlert, IAcoesBrowser, IArrastar, IClique, ICliqueJS, ICombo, IEscrever, IEscreverJS, IEspera, IFrame, ILimpar, IMover, IMoverJS, IObterJS, IProcurar, IRolarJS, IValidacoesWeb, IUtils {
}