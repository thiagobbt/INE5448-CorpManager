package test.br.ufsc.ine5446.corpmanager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine5446.corpmanager.Funcionario;
import br.ufsc.ine5446.corpmanager.Ocorrencia;
import br.ufsc.ine5446.corpmanager.Projeto;

public class TestProjeto {
	private Projeto umProjeto;
	private Funcionario umFuncionario;
	
	@Before
	public void configuration() {
		umProjeto = new Projeto();
		umFuncionario = new Funcionario();
	}
	
	@Test
	public void addEmployeeToProject() throws Exception {
		umProjeto.adicionaFuncionario(umFuncionario);
		assertEquals(1, umProjeto.numeroFuncionarios());
	}
	
	@Test
	public void addOccurrence() throws Exception {
		umProjeto.adicionaFuncionario(umFuncionario);
		umProjeto.adicionaOcorrencia(new Ocorrencia(), umFuncionario);
	}
	
	@Test(expected = Exception.class)
	public void addTooManyOccurrences() throws Exception {
		umProjeto.adicionaFuncionario(umFuncionario);
		umProjeto.adicionaOcorrencia(new Ocorrencia(), umFuncionario);
		umProjeto.adicionaOcorrencia(new Ocorrencia(), umFuncionario);
		umProjeto.adicionaOcorrencia(new Ocorrencia(), umFuncionario);
		umProjeto.adicionaOcorrencia(new Ocorrencia(), umFuncionario);
		umProjeto.adicionaOcorrencia(new Ocorrencia(), umFuncionario);
		umProjeto.adicionaOcorrencia(new Ocorrencia(), umFuncionario);
		umProjeto.adicionaOcorrencia(new Ocorrencia(), umFuncionario);
		umProjeto.adicionaOcorrencia(new Ocorrencia(), umFuncionario);
		umProjeto.adicionaOcorrencia(new Ocorrencia(), umFuncionario);
		umProjeto.adicionaOcorrencia(new Ocorrencia(), umFuncionario);
		umProjeto.adicionaOcorrencia(new Ocorrencia(), umFuncionario);
	}
	
	@Test(expected = Exception.class)
	public void addOccurrenceWithUnrelatedEmployee() throws Exception {
		umProjeto.adicionaOcorrencia(new Ocorrencia(), umFuncionario);
	}
}
