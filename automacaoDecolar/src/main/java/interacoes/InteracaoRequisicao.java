package interacoes;

import interfaces.api.IDefinicoesExtras;
import interfaces.api.IDelete;
import interfaces.api.IGet;
import interfaces.api.IPost;
import interfaces.api.IPut;
import interfaces.api.IUtils;
import interfaces.log.ILog;

public interface InteracaoRequisicao extends IGet, IPost, IDelete, IPut, IDefinicoesExtras, IUtils, ILog{}