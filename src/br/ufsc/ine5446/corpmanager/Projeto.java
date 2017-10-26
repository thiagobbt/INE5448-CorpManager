package br.ufsc.ine5446.corpmanager;

import java.util.Collection;
import java.util.HashSet;

public class Projeto {
	private Collection<Ocorrencia> ocorrencias;
	private Collection<Funcionario> funcionarios;
	
	public Projeto() {
		ocorrencias = new HashSet<>();
		funcionarios = new HashSet<>();
	}

	public void adicionaFuncionario(Funcionario umFuncionario) {
		funcionarios.add(umFuncionario);		
	}

	public int numeroFuncionarios() {
		return funcionarios.size();
	}

	public void adicionaOcorrencia(Ocorrencia umaOcorrencia) throws Exception {
		Funcionario funcionarioResponsavel = umaOcorrencia.responsavel();
		if (funcionarios.contains(funcionarioResponsavel)) {
			ocorrencias.add(umaOcorrencia);
		} else {
			throw new Exception("Funcionario não trabalha nesse projeto.");
		}
	}

}
