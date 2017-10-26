package br.ufsc.ine5446.corpmanager;

public class Ocorrencia {
	private Funcionario responsavel;
	private Status status;
	
	public enum Status {
		ABERTA,
		FECHADA
	};
	
	public Ocorrencia() {
		status = Status.ABERTA;
	}

	public Ocorrencia(Funcionario umFuncionario) throws Exception {
		responsavel = umFuncionario;
		umFuncionario.definirResponsabilidade(this);
		status = Status.ABERTA;
	}

	public Status status() {
		return status;
	}

	public Funcionario responsavel() {
		return responsavel;
	}

	public void fechar() throws Exception {
		status = Status.FECHADA;
		if (responsavel != null) {
			responsavel.fechaOcorrencia(this);
		}
	}

}
