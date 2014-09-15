package br.com.qileverage.relatoriodinamico.entidades;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public enum TFiltro implements  Serializable, IsSerializable
{
	/* Texto */
	COMECA_COM
	{
		@Override
		public String toString()
		{
			return "Começa com";
		}
	},
	TERMINA_COM
	{
		@Override
		public String toString()
		{

			return "Termina com";
		}
	},
	CONTEM
	{
		@Override
		public String toString()
		{
			return "Contém";
		}
	},

	/* Número */
	MAIOR_QUE
	{
		@Override
		public String toString()
		{
			return "Maior que";
		}
	},
	MENOR_QUE
	{
		@Override
		public String toString()
		{
			return "Menor que";
		}
	},
	IGUAL
	{
		@Override
		public String toString()
		{
			return "Igual";
		}
	},
	DIFERENTE
	{
		@Override
		public String toString()
		{
			return "Diferente";
		}
	}

}
