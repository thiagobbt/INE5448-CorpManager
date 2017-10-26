package br.ufsc.ine5446.corpmanager;

import java.util.Collection;
import java.util.HashSet;

public class Funcionario {
	private Collection<Ocorrencia> ocorrenciasResponsavel;

	public Funcionario() {
		ocorrenciasResponsavel = new HashSet<>();
	}

	public void definirResponsabilidade(Ocorrencia umaOcorrencia) throws Exception {
		if (ocorrenciasResponsavel.size() < 10) {
			ocorrenciasResponsavel.add(umaOcorrencia);
		} else {
			throw new Exception("Número máximo de ocorrências atingido.");
		}
	}

	public Object numeroOcorrenciasResponsavel() {
		return ocorrenciasResponsavel.size();
	}
}
