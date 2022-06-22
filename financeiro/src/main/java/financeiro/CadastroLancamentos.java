package financeiro;

import java.util.Date;

import javax.inject.Inject;

import anotation.Transactional;
import financeiro.Repository.Lancamentos;

public class CadastroLancamentos {
	
	@Inject
	private Lancamentos lancamentos;

	public CadastroLancamentos(Lancamentos lancamentos) {
		this.lancamentos = lancamentos;
	}
	@Transactional
	public void salvar(Lancamento lancamento) throws NegocioException {
		if (lancamento.getDataPagamento() != null && 
				lancamento.getDataPagamento().after(new Date())) {
			throw new NegocioException("Data de pagamento não pode ser uma data futura.");
		}
		
		this.lancamentos.adicionar(lancamento);
		
	}
	
}
