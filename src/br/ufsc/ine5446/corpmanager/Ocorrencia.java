package br.ufsc.ine5446.corpmanager;

public class Ocorrencia {
	private Funcionario responsavel;
	private Status status;
	private Prioridade prioridade;
	
	public enum Status {
		ABERTA,
		FECHADA
	};
	
	public enum Prioridade {
		ALTA,
		MEDIA,
		BAIXA
	}
	
	public Ocorrencia() {
		status = Status.ABERTA;
		prioridade = Prioridade.MEDIA;
	}

	public Ocorrencia(Funcionario umFuncionario) throws Exception {
		this();
		responsavel = umFuncionario;
		umFuncionario.definirResponsabilidade(this);
	}

	public Status status() {
		return status;
	}
	
	public Prioridade prioridade() {
		return prioridade;
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

	public void definePrioridade(Prioridade novaPrioridade) throws Exception {
		if (status == Status.ABERTA) {
			prioridade = novaPrioridade;
		} else {
			throw new Exception("Não é possível mudar a prioridade de uma ocorrencia fechada");
		}
	}

	public void mudaResponsavel(Funcionario novoFuncionario) throws Exception {
		if (responsavel != null) {
			responsavel.removeOcorrencia(this);
		}
		responsavel = novoFuncionario;
		novoFuncionario.definirResponsabilidade(this);
	}

}
