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
	public void configuracao() {
		umProjeto = new Projeto();
		umFuncionario = new Funcionario();
	}
	
	@Test
	public void adicionaFuncionarioNoProjeto() throws Exception {
		umProjeto.adicionaFuncionario(umFuncionario);
		assertEquals(1, umProjeto.numeroFuncionarios());
	}
	
	@Test
	public void adicionaOcorrencia() throws Exception {
		umProjeto.adicionaFuncionario(umFuncionario);
		umProjeto.adicionaOcorrencia(new Ocorrencia(umFuncionario));
	}
	
	@Test(expected = Exception.class)
	public void adicionaOcorrenciaComFuncionarioNaoRelacionado() throws Exception {
		umProjeto.adicionaOcorrencia(new Ocorrencia(umFuncionario));
	}
}
