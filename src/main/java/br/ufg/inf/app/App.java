package br.ufg.inf.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.ufg.inf.ctrl.DisciplinaCtrl;
import br.ufg.inf.ctrl.OfertaCtrl;
import br.ufg.inf.ctrl.PessoaCtrl;
import br.ufg.inf.ctrl.ProfessorCtrl;
import br.ufg.inf.model.entities.Disciplina;
import br.ufg.inf.model.entities.Oferta;
import br.ufg.inf.model.entities.Pessoa;
import br.ufg.inf.model.entities.Professor;
import br.ufg.inf.model.enums.Dia;
import br.ufg.inf.model.enums.Escolaridade;

public class App {

  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Executando!!!");
		testeOferta();
		System.out.println("Concluindo");
	}
	
	
	public static void testeOferta() {
		
		OfertaCtrl ctrl = new OfertaCtrl();
		ProfessorCtrl professorCtrl = new ProfessorCtrl();
		DisciplinaCtrl disciplinaCtrl = new DisciplinaCtrl();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		
			Oferta oferta = ctrl.buscaPorId(1);
			oferta.setDtInicio(simpleDateFormat.parse("22/02/2021"));
			
			ctrl.alterar(oferta);
			
			for(Oferta o : ctrl.buscaTodos()) {
				System.out.println(o);
			}
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void testeProfessor() {
		
		ProfessorCtrl ctrl = new ProfessorCtrl();
		PessoaCtrl pessoaCtrl = new PessoaCtrl();
		Professor prof1 = ctrl.buscaPorId(1);
		
		prof1.setEscolaridade(Escolaridade.GRADUACAO);
		ctrl.alterar(prof1);
	
	}
	
	
	public static void testePessoa() {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

		
		PessoaCtrl ctrl = new PessoaCtrl();
		try {
			Pessoa pes1 = ctrl.buscaPorId(2);
			pes1.setDtNascimento(simpleDateFormat.parse("01-01-1990"));
			ctrl.alterar(pes1);
			Pessoa pes2 = ctrl.buscaPorId(2);
			pes2.setDtNascimento(simpleDateFormat.parse("01-04-2000"));
			ctrl.alterar(pes2);

			Pessoa pes3 = ctrl.buscaPorId(3);
			pes3.setDtNascimento(simpleDateFormat.parse("15-06-2005"));
			ctrl.alterar(pes3);
			
			Pessoa pes4 = ctrl.buscaPorId(4);
			pes4.setDtNascimento(simpleDateFormat.parse("30-09-2015"));
			ctrl.alterar(pes4);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void testeCtrl() {
		
		DisciplinaCtrl ctrl = new DisciplinaCtrl();
		Disciplina disciplina = new Disciplina(null, "Banco de Dados", 64);
		disciplina.setNmDisciplina(disciplina.getNmDisciplina()+" - Alterada");
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
		Disciplina disc2 = new Disciplina(null, "Matem�tica", 88);
		Disciplina disc3 = new Disciplina(null, "Java", 30);
		Disciplina disc4 = new Disciplina(null, "TypeScript", 90);
	
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
		
	}
  
}
