package financeiro;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class Pessoas {

	private EntityManager manager;
	
	@Inject
	public Pessoas(EntityManager manager) {
		this.manager = manager;
	}
	public List<Pessoa> todas() {
		TypedQuery<Pessoa> query = manager.createQuery("from Pessoa", Pessoa.class);
		return query.getResultList();
	}
	public Pessoa porId(Long id) {
		return manager.find(Pessoa.class, id);
	}
	public void adicionar(Pessoa pessoa) {
		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		this.manager.persist(pessoa);
		trx.commit();
		}


}
