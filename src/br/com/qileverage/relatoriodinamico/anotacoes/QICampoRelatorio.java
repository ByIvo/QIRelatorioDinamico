package br.com.qileverage.relatoriodinamico.anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.qileverage.relatoriodinamico.entidades.TCampo;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface QICampoRelatorio
{

	String nomeColuna() default "";

	String nomeExibicao() default "";

	TCampo tipoCampo();
}
