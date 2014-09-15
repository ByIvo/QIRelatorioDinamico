package br.com.qileverage.relatoriodinamico.funcoes.leranotacoes;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

import br.com.qileverage.relatoriodinamico.anotacoes.QICampoRelatorio;
import br.com.qileverage.relatoriodinamico.anotacoes.QITabelaRelatorio;
import br.com.qileverage.relatoriodinamico.entidades.QIRelatorioDinamico;
import br.com.qileverage.relatoriodinamico.entidades.TCampo;

public class QIFuncoesLerAnotacoes
{

	public static List<QIRelatorioDinamico> prepararRelatorios(String... packages)
	{
		List<QIRelatorioDinamico> listaRelatorio = new ArrayList<QIRelatorioDinamico>();

		for (String packageReport : packages)
		{
			try
			{
				Reflections reflections = new Reflections(packageReport);

				Set<Class<? extends Object>> allClasses = reflections.getTypesAnnotatedWith(QITabelaRelatorio.class);

				for (Class<?> classe : allClasses)
				{
					QIRelatorioDinamico relatorio = prepararRelatorio(classe);

					if (relatorio != null)
					{
						listaRelatorio.add(relatorio);
					}
				}
			}
			catch (Exception e)
			{
			}
		}

		return listaRelatorio;
	}

	private static QIRelatorioDinamico prepararRelatorio(Class<?> classeAnotada)
	{
		QIRelatorioDinamico relatorio = new QIRelatorioDinamico();

		lerInfoRelatorio(classeAnotada, relatorio);
		lerFieldsRelatorio(classeAnotada, relatorio);

		return relatorio;
	}

	private static void lerInfoRelatorio(Class<?> classeAnotada, QIRelatorioDinamico relatorio)
	{
		QITabelaRelatorio anTabelaRetorio = classeAnotada.getAnnotation(QITabelaRelatorio.class);

		if (anTabelaRetorio != null)
		{
			String nomeRelatorio;

			try
			{
				nomeRelatorio = anTabelaRetorio.nomeRelatorio();
			}
			catch (Exception e)
			{
				nomeRelatorio = "##ERRO##";
			}

			relatorio.setNome(nomeRelatorio);
			relatorio.setClassRelatorio(classeAnotada.getName());
		}
	}

	private static void lerFieldsRelatorio(Class<?> classeAnotada, QIRelatorioDinamico relatorio)
	{

		Field[] camposClasseAnotada = classeAnotada.getDeclaredFields();

		for (Field campoClasse : camposClasseAnotada)
		{
			QICampoRelatorio anCampoRelatorio = campoClasse.getAnnotation(QICampoRelatorio.class);

			if (anCampoRelatorio != null)
			{
				try
				{
					String nomeColuna = anCampoRelatorio.nomeColuna();
					String nomeExibicao = anCampoRelatorio.nomeExibicao();
					TCampo tipoCampo = anCampoRelatorio.tipoCampo();

					br.com.qileverage.relatoriodinamico.entidades.QICampoRelatorio novoCampo = criarNovoCampo(nomeColuna, nomeExibicao, tipoCampo);

					relatorio.adicionarNovoCampo(novoCampo);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	private static br.com.qileverage.relatoriodinamico.entidades.QICampoRelatorio criarNovoCampo(String nomeColuna, String nomeExibicao, TCampo tipoCampo)
	{
		br.com.qileverage.relatoriodinamico.entidades.QICampoRelatorio campoRelatorio = new br.com.qileverage.relatoriodinamico.entidades.QICampoRelatorio();

		campoRelatorio.setNomeCampo(nomeExibicao);
		campoRelatorio.setNomeColunaBanco(nomeColuna);
		campoRelatorio.setTipoCampo(tipoCampo);

		return campoRelatorio;

	}

}
