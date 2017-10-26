package test.br.ufsc.ine5446.corpmanager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine5446.corpmanager.Funcionario;
import br.ufsc.ine5446.corpmanager.Ocorrencia;

public class TestFuncionario {
	Funcionario umFuncionario;
	
	@Before
	public void configuration() {
		umFuncionario = new Funcionario();
	}
	
	@Test
	public void addOccurrenceResponsability() throws Exception {
		umFuncionario.definirResponsabilidade(new Ocorrencia());
		assertEquals(1, umFuncionario.numeroOcorrenciasResponsavel());
	}
	
	@Test(expected = Exception.class)
	public void addMoreResponsabilitiesThanPermitted() throws Exception {
		umFuncionario.definirResponsabilidade(new Ocorrencia());
		umFuncionario.definirResponsabilidade(new Ocorrencia());
		umFuncionario.definirResponsabilidade(new Ocorrencia());
		umFuncionario.definirResponsabilidade(new Ocorrencia());
		umFuncionario.definirResponsabilidade(new Ocorrencia());
		umFuncionario.definirResponsabilidade(new Ocorrencia());
		umFuncionario.definirResponsabilidade(new Ocorrencia());
		umFuncionario.definirResponsabilidade(new Ocorrencia());
		umFuncionario.definirResponsabilidade(new Ocorrencia());
		umFuncionario.definirResponsabilidade(new Ocorrencia());
		umFuncionario.definirResponsabilidade(new Ocorrencia());
	}
}
