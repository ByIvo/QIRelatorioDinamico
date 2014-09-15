package br.com.qileverage.relatoriodinamico.funcoes.gerararquivo;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import br.com.qileverage.relatoriodinamico.entidades.TCampo;

public class QIFormatterCamposRelatorioDinamico implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String formatoData;
	private String formatoDataHora;
	private String formatoNumero;
	private String formatoDinheiro;

	private String formatoTrue;
	private String formatoFalse;

	private SimpleDateFormat dateFormatter;
	private SimpleDateFormat dateTimeFormatter;
	private NumberFormat numberFormat;
	private NumberFormat moneyFormat;
	private BooleanFormat booleanFormat;

	public QIFormatterCamposRelatorioDinamico()
	{
		formatoData = "dd/MM/yyyy";
		formatoDataHora = "dd/MM/yyyy HH:mm:ss";
		formatoNumero = "0.##";
		formatoDinheiro = "R$ ###,###,##0.00";
		formatoTrue = "Sim";
		formatoFalse = "Não";

		dateFormatter = new SimpleDateFormat(formatoData);
		dateTimeFormatter = new SimpleDateFormat(formatoDataHora);
		numberFormat = new DecimalFormat(formatoNumero);
		moneyFormat = new DecimalFormat(formatoDinheiro);
		booleanFormat = new BooleanFormat(formatoTrue, formatoFalse);
	}

	public String formatar(TCampo tipoCampo, Object value)
	{
		try
		{
			return formatarByCampo(tipoCampo, value);
		}
		catch (Exception e)
		{
			return "##ERRO DE FORMATAÇÃO##";
		}
	}

	private String formatarByCampo(TCampo tipoCampo, Object value)
	{
		switch (tipoCampo)
		{
			case TEXTO:
				return value.toString();

			case NUMERO:

				if (value == null)
				{
					return "0";
				}

				return numberFormat.format(value);

			case VALOR_MONETARIO:

				if (value == null)
				{
					return "0";
				}

				return moneyFormat.format(value);

			case DATA:
				if (value == null)
				{
					return "";
				}
				return dateFormatter.format(value);

			case DATA_HORA:
				if (value == null)
				{
					return "";
				}
				return dateTimeFormatter.format(value);

			case BOOLEANO:
				return booleanFormat.format(value);

			default:
				return "##FORMATO DESCONHECIDO##";
		}
	}

	public String getFormatoData()
	{
		return formatoData;
	}

	public void setFormatoData(String formatoData)
	{
		this.formatoData = formatoData;
		dateFormatter = new SimpleDateFormat(formatoData);
	}

	public String getFormatoDataHora()
	{
		return formatoDataHora;
	}

	public void setFormatoDataHora(String formatoDataHora)
	{
		this.formatoDataHora = formatoDataHora;
		dateTimeFormatter = new SimpleDateFormat(formatoDataHora);
	}

	public String getFormatoNumero()
	{
		return formatoNumero;
	}

	public void setFormatoNumero(String formatoNumero)
	{
		this.formatoNumero = formatoNumero;
		numberFormat = new DecimalFormat(formatoNumero);
	}

	public String getFormatoTrue()
	{
		return formatoTrue;
	}

	public void setFormatoTrue(String formatoTrue)
	{
		this.formatoTrue = formatoTrue;
		booleanFormat.setTrueValueFormat(formatoTrue);
	}

	public String getFormatoFalse()
	{
		return formatoFalse;
	}

	public void setFormatoFalse(String formatoFalse)
	{
		this.formatoFalse = formatoFalse;
		booleanFormat.setFalseValueFormat(formatoFalse);
	}

	public void setMoneyFormat(NumberFormat moneyFormat)
	{
		this.moneyFormat = moneyFormat;
		moneyFormat = new DecimalFormat(formatoDinheiro);
	}

	public SimpleDateFormat getDateFormatter()
	{
		return dateFormatter;
	}

	public SimpleDateFormat getDateTimeFormatter()
	{
		return dateTimeFormatter;
	}

	public NumberFormat getNumberFormat()
	{
		return numberFormat;
	}

	public BooleanFormat getBooleanFormat()
	{
		return booleanFormat;
	}

	public NumberFormat getMoneyFormat()
	{
		return moneyFormat;
	}

}
