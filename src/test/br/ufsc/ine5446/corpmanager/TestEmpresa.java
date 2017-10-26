package test.br.ufsc.ine5446.corpmanager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine5446.corpmanager.Empresa;
import br.ufsc.ine5446.corpmanager.Funcionario;
import br.ufsc.ine5446.corpmanager.Projeto;

public class TestEmpresa {
	Empresa aEmpresa;
	
	@Before
	public void configuracao() {
		aEmpresa = new Empresa();
	}
	
	@Test
	public void adicionaFuncionario() throws Exception {
		aEmpresa.adicionaFuncionario(new Funcionario());
		assertEquals(1, aEmpresa.numeroFuncionarios());
	}
	
	@Test
	public void adicionaProjeto() throws Exception {
		aEmpresa.adicionaProjeto(new Projeto());
		assertEquals(1, aEmpresa.numeroProjetos());
	}
}
