package br.com.qileverage.relatoriodinamico.entidades;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public interface ICampo extends  Serializable, IsSerializable
{
	
	TFiltro[] getFiltros();
}
