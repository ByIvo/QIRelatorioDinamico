package br.com.qileverage.relatoriodinamico.entidades;

public enum TCampo implements ICampo
{
	NUMERO
	{
		@Override
		public TFiltro[] getFiltros()
		{
			return new TFiltro[]
			{ TFiltro.MAIOR_QUE, TFiltro.MENOR_QUE, TFiltro.IGUAL, TFiltro.DIFERENTE };
		}
	},
	TEXTO
	{
		@Override
		public TFiltro[] getFiltros()
		{
			return new TFiltro[]
			{ TFiltro.COMECA_COM, TFiltro.TERMINA_COM, TFiltro.CONTEM };
		}
	},
	DATA
	{
		@Override
		public TFiltro[] getFiltros()
		{
			return new TFiltro[]
			{ TFiltro.MAIOR_QUE, TFiltro.MENOR_QUE, TFiltro.IGUAL };
		}
	},
	DATA_HORA
	{
		@Override
		public TFiltro[] getFiltros()
		{
			return new TFiltro[]
			{ TFiltro.MAIOR_QUE, TFiltro.MENOR_QUE, TFiltro.IGUAL };
		}
	},
	BOOLEANO
	{
		@Override
		public TFiltro[] getFiltros()
		{
			return new TFiltro[]
			{ TFiltro.IGUAL, TFiltro.DIFERENTE };
		}
	},
	VALOR_MONETARIO
	{
		@Override
		public TFiltro[] getFiltros()
		{
			return new TFiltro[]
			{ TFiltro.MAIOR_QUE, TFiltro.MENOR_QUE, TFiltro.IGUAL, TFiltro.DIFERENTE };
		}
	}

}
