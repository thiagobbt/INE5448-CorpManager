package test.br.ufsc.ine5446.corpmanager;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine5446.corpmanager.Funcionario;
import br.ufsc.ine5446.corpmanager.Ocorrencia;

public class TestFuncionario {
	Funcionario umFuncionario;
	
	@Before
	public void configuracao() {
		umFuncionario = new Funcionario();
	}
	
	@Test
	public void defineResponsabilidade() throws Exception {
		umFuncionario.definirResponsabilidade(new Ocorrencia());
		assertEquals(1, umFuncionario.numeroOcorrenciasAbertasResponsavel());
	}
	
	@Test
	public void verificaResponsabilidades() throws Exception {
		Ocorrencia anOcurrence = new Ocorrencia(umFuncionario);
		umFuncionario.definirResponsabilidade(anOcurrence);
		
		Collection<Ocorrencia> responsabilidades = umFuncionario.getResponsabilidades();
		
		assertEquals(1, responsabilidades.size());
		assertTrue(responsabilidades.contains(anOcurrence));
	}
	
	@Test(expected = Exception.class)
	public void removeOcorrenciaNaoRelacionada() throws Exception {
		umFuncionario.removeOcorrencia(new Ocorrencia());
	}
	
	@Test(expected = Exception.class)
	public void adicionaMaisResponsabilidadesQueOPermitido() throws Exception {
		umFuncionario.definirResponsabilidade(new Ocorrencia(umFuncionario));
		umFuncionario.definirResponsabilidade(new Ocorrencia(umFuncionario));
		umFuncionario.definirResponsabilidade(new Ocorrencia(umFuncionario));
		umFuncionario.definirResponsabilidade(new Ocorrencia(umFuncionario));
		umFuncionario.definirResponsabilidade(new Ocorrencia(umFuncionario));
		umFuncionario.definirResponsabilidade(new Ocorrencia(umFuncionario));
		umFuncionario.definirResponsabilidade(new Ocorrencia(umFuncionario));
		umFuncionario.definirResponsabilidade(new Ocorrencia(umFuncionario));
		umFuncionario.definirResponsabilidade(new Ocorrencia(umFuncionario));
		umFuncionario.definirResponsabilidade(new Ocorrencia(umFuncionario));
		umFuncionario.definirResponsabilidade(new Ocorrencia(umFuncionario));
	}
	
	@Test
	public void adicionaResponsabilidadeDepoisDefechar() throws Exception {
		umFuncionario.definirResponsabilidade(new Ocorrencia(umFuncionario));
		umFuncionario.definirResponsabilidade(new Ocorrencia(umFuncionario));
		umFuncionario.definirResponsabilidade(new Ocorrencia(umFuncionario));
		umFuncionario.definirResponsabilidade(new Ocorrencia(umFuncionario));
		umFuncionario.definirResponsabilidade(new Ocorrencia(umFuncionario));
		umFuncionario.definirResponsabilidade(new Ocorrencia(umFuncionario));
		umFuncionario.definirResponsabilidade(new Ocorrencia(umFuncionario));
		umFuncionario.definirResponsabilidade(new Ocorrencia(umFuncionario));
		umFuncionario.definirResponsabilidade(new Ocorrencia(umFuncionario));
		umFuncionario.definirResponsabilidade(new Ocorrencia(umFuncionario));
		
		Ocorrencia responsabilidades[] = umFuncionario.getResponsabilidades().toArray(new Ocorrencia[0]);
		responsabilidades[0].fechar();
		
		umFuncionario.definirResponsabilidade(new Ocorrencia(umFuncionario));
		assertEquals(10, umFuncionario.numeroOcorrenciasAbertasResponsavel());
	}
	
	@Test(expected = Exception.class)
	public void fechaOcorrenciaNaoRelacionada() throws Exception {
		umFuncionario.fechaOcorrencia(new Ocorrencia());
	}
}
