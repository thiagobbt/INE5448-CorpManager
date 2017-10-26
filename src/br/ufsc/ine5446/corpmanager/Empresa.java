package br.ufsc.ine5446.corpmanager;

import java.util.Collection;
import java.util.HashSet;

public class Empresa {
	private Collection<Funcionario> funcionarios;
	private Collection<Projeto> projetos;

	public Empresa() {
		funcionarios = new HashSet<>();
		projetos = new HashSet<>();
	}

	public void adicionaFuncionario(Funcionario umFuncionario) {
		funcionarios.add(umFuncionario);
	}

	public int numeroFuncionarios() {
		return funcionarios.size();
	}

	public void adicionaProjeto(Projeto umProjeto) {
		projetos.add(umProjeto);
	}

	public int numeroProjetos() {
		return projetos.size();
	}
}
