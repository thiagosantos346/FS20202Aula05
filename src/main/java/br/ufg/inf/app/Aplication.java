package br.ufg.inf.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.ufg.inf.ctrl.DisciplinaCtrl;
import br.ufg.inf.model.entities.Disciplina;

public class Aplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Executando!!!");
		testeCtrl();
		System.out.println("Concluindo");
	}
	
	
	public static void testeCtrl() {
		
		DisciplinaCtrl ctrl = new DisciplinaCtrl();
		
		Disciplina disciplina = new Disciplina(null, "Banco de Dados", 64);
		
		//ctrl.inserir(disciplina);
		
		
		disciplina.setNmDisciplina(disciplina.getNmDisciplina()+" - Alterada");
		
		//ctrl.alterar(disciplina);
		
		System.out.println(ctrl.buscaPorId(3));
		
		for(Disciplina d : ctrl.buscaTodos()) {
			System.out.println(d);
		}
		System.out.println("-----------------------------------");
		for(Disciplina d : ctrl.buscaPorNome("Banco")) {
			System.out.println(d);
		}
	}
	
	
	public void testeJPA() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");
		EntityManager em = emf.createEntityManager();
		
		Disciplina disc1 = new Disciplina(null, "FullStack", 64);
		Disciplina disc2 = new Disciplina(null, "Matemática", 88);
		Disciplina disc3 = new Disciplina(null, "Java", 30);
		Disciplina disc4 = new Disciplina(null, "TypeScript", 90);
		//System.out.println("-------------------------");
		//System.out.println(disc1);
		//System.out.println(disc2);
		//System.out.println(disc3);
		//System.out.println(disc4);
		//System.out.println("-------------------------");	
		//em.getTransaction().begin();
		//em.persist(disc1);
		//em.persist(disc2);
		//em.persist(disc3);
		//em.persist(disc4);
		//em.getTransaction().commit();
		
		//System.out.println("-------------------------");
		//System.out.println(disc1);
		//System.out.println(disc2);
		//System.out.println(disc3);
		//System.out.println(disc4);
		//System.out.println("-------------------------");
		//System.out.println("Acabou!");
		
		
		TypedQuery<Disciplina> query =  em.createQuery("from Disciplina", Disciplina.class);
		List<Disciplina> disciplinas = query.getResultList();
		
		System.out.println("----------------------------");
		System.out.println("---Disciplinas Cadatradas---");
		for(Disciplina d : disciplinas) {
			System.out.println(d);
		}
		System.out.println("----------------------------");
		
		
		Disciplina disciplina = em.find(Disciplina.class, 2);
		System.out.println("----------------------------");
		System.out.println("---Disciplina id 2---");
		System.out.println(disciplina);
		System.out.println("----------------------------");
		

		disciplina.setNmDisciplina(disciplina.getNmDisciplina()+" ALTERADO");
		
		em.getTransaction().begin();
		em.persist(disciplina);
		em.getTransaction().commit();
		
		System.out.println("----------------------------");
		System.out.println("---Disciplina id 2 Alterado---");
		System.out.println(disciplina);
		System.out.println("----------------------------");
		
	
		String str = "ll";
		
		String sql = "from Disciplina d where d.nmDisciplina like :str";
		query = em.createQuery(sql, Disciplina.class);
		query.setParameter("str", "%"+str+"%");
		disciplinas = query.getResultList();
		
		System.out.println("----------------------------");
		System.out.println("---Disciplinas com "+str+"---");
		for(Disciplina d : disciplinas) {
			System.out.println(d);
		}
		System.out.println("----------------------------");
		
		Disciplina excluir = em.find(Disciplina.class, 1);
		System.out.println(excluir);
	//	em.getTransaction().begin();
	//	em.remove(excluir);
	//	em.getTransaction().commit();
		
		
		
	}
	

}
