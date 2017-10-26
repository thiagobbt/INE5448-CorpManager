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
	public void criaOcorrencia() throws Exception {
		new Ocorrencia(umFuncionario);
	}
	
	@Test
	public void criaOcorrenciaComTipo() throws Exception {
		Ocorrencia novaOcorrencia = new Ocorrencia(umFuncionario, Ocorrencia.Tipo.TAREFA);
		assertEquals(Ocorrencia.Tipo.TAREFA, novaOcorrencia.tipo());
		assertEquals(umFuncionario, novaOcorrencia.responsavel());
		assertTrue(umFuncionario.getResponsabilidades().contains(novaOcorrencia));
	}
	
	@Test
	public void statusInicialEhAberto() throws Exception {
		assertEquals(Ocorrencia.Status.ABERTA, umaOcorrencia.status());
	}
	
	@Test
	public void verificaResponsavel() throws Exception {
		assertEquals(umFuncionario, umaOcorrencia.responsavel());
	}
	
	@Test
	public void verificaPrioridadeInicial() throws Exception {
		assertEquals(Ocorrencia.Prioridade.MEDIA, umaOcorrencia.prioridade());
	}
	
	@Test
	public void verificaTipoPadrao() throws Exception {
		assertEquals(Ocorrencia.Tipo.MELHORIA, umaOcorrencia.tipo());
	}
	
	@Test
	public void mudaPrioridade() throws Exception {
		umaOcorrencia.definePrioridade(Ocorrencia.Prioridade.ALTA);
		assertEquals(Ocorrencia.Prioridade.ALTA, umaOcorrencia.prioridade());
	}
	
	@Test(expected = Exception.class)
	public void mudaPrioridadeOcorrenciaFechada() throws Exception {
		umaOcorrencia.fechar();
		umaOcorrencia.definePrioridade(Ocorrencia.Prioridade.ALTA);
	}
	
	@Test
	public void mudaResponsavel() throws Exception {
		Funcionario novoFuncionario = new Funcionario();
		umaOcorrencia.mudaResponsavel(novoFuncionario);
		
		assertFalse(umFuncionario.getResponsabilidades().contains(umaOcorrencia));
		assertEquals(novoFuncionario, umaOcorrencia.responsavel());
		assertTrue(novoFuncionario.getResponsabilidades().contains(umaOcorrencia));
	}
	
	@Test
	public void mudaResponsavelDeOcorrenciaSemResponsavel() throws Exception {
		Ocorrencia novaOcorrencia = new Ocorrencia();
		Funcionario novoFuncionario = new Funcionario();
		novaOcorrencia.mudaResponsavel(novoFuncionario);
		
		assertEquals(novoFuncionario, novaOcorrencia.responsavel());
	}
	
	@Test(expected = Exception.class)
	public void mudaResponsavelDeOcorrenciaFechada() throws Exception {
		umaOcorrencia.fechar();
		umaOcorrencia.mudaResponsavel(new Funcionario());
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
	
	@Test
	public void verificaPrioridadeEnum() throws Exception {
		assertEquals(Ocorrencia.Prioridade.ALTA, Ocorrencia.Prioridade.valueOf("ALTA"));
		assertEquals(Ocorrencia.Prioridade.MEDIA, Ocorrencia.Prioridade.valueOf("MEDIA"));
		assertEquals(Ocorrencia.Prioridade.BAIXA, Ocorrencia.Prioridade.valueOf("BAIXA"));
	}
	
	@Test
	public void verificaTipoEnum() throws Exception {
		assertEquals(Ocorrencia.Tipo.TAREFA, Ocorrencia.Tipo.valueOf("TAREFA"));
		assertEquals(Ocorrencia.Tipo.BUG, Ocorrencia.Tipo.valueOf("BUG"));
		assertEquals(Ocorrencia.Tipo.MELHORIA, Ocorrencia.Tipo.valueOf("MELHORIA"));
	}
}
