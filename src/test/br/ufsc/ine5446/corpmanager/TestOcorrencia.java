package test.br.ufsc.ine5446.corpmanager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine5446.corpmanager.Funcionario;
import br.ufsc.ine5446.corpmanager.Ocorrencia;

public class TestOcorrencia {
	Ocorrencia umaOcorrencia;
	Funcionario umFuncionario;
	
	@Before
	public void configuracao() throws Exception {
		umFuncionario = new Funcionario();
		umaOcorrencia = new Ocorrencia(umFuncionario);
	}
	
	@Test
	public void statusInicialEhAberto() throws Exception {
		assertEquals(Ocorrencia.Status.ABERTA, umaOcorrencia.status());
	}
	
	@Test
	public void checaResponsavel() throws Exception {
		assertEquals(umFuncionario, umaOcorrencia.responsavel());
	}
	
	@Test
	public void podeFecharOcorrencia() throws Exception {
		umaOcorrencia.fechar();
		assertEquals(Ocorrencia.Status.FECHADA, umaOcorrencia.status());
	}
	
	@Test
	public void fechaOcorrenciaSemResponsavel() throws Exception {
		Ocorrencia umaNovaOcorrencia = new Ocorrencia();
		umaNovaOcorrencia.fechar();
		assertEquals(Ocorrencia.Status.FECHADA, umaNovaOcorrencia.status());
	}
	
	@Test
	public void verificaStatusEnum() throws Exception {
		assertEquals(Ocorrencia.Status.ABERTA, Ocorrencia.Status.valueOf("ABERTA"));
		assertEquals(Ocorrencia.Status.FECHADA, Ocorrencia.Status.valueOf("FECHADA"));
	}
}
