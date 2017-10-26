package br.ufsc.ine5446.corpmanager;

public class Ocorrencia {
	private Funcionario responsavel;
	private Status status;
	private Prioridade prioridade;
	private Tipo tipo;
	
	public enum Status {
		ABERTA,
		FECHADA
	};
	
	public enum Prioridade {
		ALTA,
		MEDIA,
		BAIXA
	}
	
	public enum Tipo {
		TAREFA,
		BUG,
		MELHORIA
	}
	
	public Ocorrencia() {
		this.status = Status.ABERTA;
		this.prioridade = Prioridade.MEDIA;
		this.tipo = Tipo.MELHORIA;
	}
	
	public Ocorrencia(Tipo tipo) {
		this();
		this.tipo = tipo;
	}

	public Ocorrencia(Funcionario umFuncionario) throws Exception {
		this();
		this.responsavel = umFuncionario;
		umFuncionario.definirResponsabilidade(this);
	}
	
	public Ocorrencia(Funcionario umFuncionario, Tipo tipo) throws Exception {
		this(tipo);
		this.responsavel = umFuncionario;
		umFuncionario.definirResponsabilidade(this);
	}

	public Status status() {
		return status;
	}
	
	public Prioridade prioridade() {
		return prioridade;
	}
	
	public Tipo tipo() {
		return tipo;
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
