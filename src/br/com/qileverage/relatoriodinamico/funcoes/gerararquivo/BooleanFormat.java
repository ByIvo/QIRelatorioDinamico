package br.com.qileverage.relatoriodinamico.funcoes.gerararquivo;

import java.text.ParseException;

public class BooleanFormat
{

	public String trueValueFormat;
	public String falseValueFormat;

	public BooleanFormat(String trueValueFormat, String falseValueFormat)
	{
		super();
		this.trueValueFormat = trueValueFormat;
		this.falseValueFormat = falseValueFormat;
	}

	public Boolean parse(String value) throws ParseException
	{
		try
		{
			if (value.equalsIgnoreCase("true"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (Exception e)
		{
			throw new ParseException(value, 0);
		}
	}

	public String format(Object value)
	{
		if (value instanceof Boolean)
		{
			return format((Boolean) value);
		}else
		{
			throw new RuntimeException();
		}
	}

	public String format(Boolean value)
	{
		try
		{
			if (value)
			{
				return getTrueValueFormat();
			}
			else
			{
				return getFalseValueFormat();
			}
		}
		catch (NullPointerException e)
		{
			throw new RuntimeException("Valores sem instância não podem ser formatados.");
		}
	}

	public String getTrueValueFormat()
	{
		return trueValueFormat;
	}

	public void setTrueValueFormat(String trueValueFormat)
	{
		this.trueValueFormat = trueValueFormat;
	}

	public String getFalseValueFormat()
	{
		return falseValueFormat;
	}

	public void setFalseValueFormat(String falseValueFormat)
	{
		this.falseValueFormat = falseValueFormat;
	}

}
