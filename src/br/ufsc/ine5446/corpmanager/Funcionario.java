package br.ufsc.ine5446.corpmanager;

import java.util.Collection;
import java.util.HashSet;

public class Funcionario {
	private Collection<Ocorrencia> ocorrenciasAbertasResponsavel;
	private Collection<Ocorrencia> ocorrenciasFechadasResponsavel;

	public Funcionario() {
		ocorrenciasAbertasResponsavel = new HashSet<>();
		ocorrenciasFechadasResponsavel = new HashSet<>();
	}

	public void definirResponsabilidade(Ocorrencia umaOcorrencia) throws Exception {
		if (ocorrenciasAbertasResponsavel.size() <= 10) {
			ocorrenciasAbertasResponsavel.add(umaOcorrencia);
		} else {
			throw new Exception("Número máximo de ocorrências abertas atingido.");
		}
	}
	
	public void fechaOcorrencia(Ocorrencia umaOcorrencia) throws Exception {
		if (ocorrenciasAbertasResponsavel.contains(umaOcorrencia)) {
			ocorrenciasAbertasResponsavel.remove(umaOcorrencia);
			ocorrenciasFechadasResponsavel.add(umaOcorrencia);
		} else {
			throw new Exception("Ocorrência não existe na lista de responsabilidades");
		}
	}

	public Object numeroOcorrenciasAbertasResponsavel() {
		return ocorrenciasAbertasResponsavel.size();
	}

	public Collection<Ocorrencia> getResponsabilidades() {
		return ocorrenciasAbertasResponsavel;
	}
}
