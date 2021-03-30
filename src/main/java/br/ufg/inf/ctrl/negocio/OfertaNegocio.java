package br.ufg.inf.ctrl.negocio;

import java.util.ArrayList;
import java.util.List;

import br.ufg.inf.ctrl.exception.DisciplinaExection;
import br.ufg.inf.ctrl.exception.OfertaExection;
import br.ufg.inf.ctrl.exception.ProfessorExection;
import br.ufg.inf.model.dao.OfertaDAO;
import br.ufg.inf.model.entities.Oferta;

public class OfertaNegocio {


		OfertaDAO dao = new OfertaDAO();
		ProfessorNegocio professorNegocio = new ProfessorNegocio();
		DisciplinaNegocio disciplinaNegocio = new DisciplinaNegocio();
	
		public Oferta inserir(Oferta oferta) throws OfertaExection {
			this.validarOferta(oferta);
			//dao.inserir(oferta);
			return oferta;
		}
		
		// READ
		public List<Oferta> buscaTodos() throws OfertaExection, ProfessorExection, DisciplinaExection{
			List<Oferta> ofertas =  new ArrayList<Oferta>();
			/*for(Oferta o : dao.buscaTodos()) {
				o.setProfessor(professorNegocio.buscaPorId(o.getProfessor().getIdProfessor()));
				o.setDisciplina(disciplinaNegocio.buscaPorId(o.getDisciplina().getIdDisciplina()));
			}*/
			return ofertas;	
		}
		
		public Oferta buscaPorId(Integer id) throws OfertaExection, ProfessorExection, DisciplinaExection {
			Oferta oferta = new Oferta();
			//oferta.setProfessor(professorNegocio.buscaPorId(oferta.getProfessor().getIdProfessor()));
			//oferta.setDisciplina(disciplinaNegocio.buscaPorId(oferta.getDisciplina().getIdDisciplina()));
			return oferta;
		}
		
		
		// UPDATE
		
		public Oferta alterar(Oferta oferta) throws OfertaExection {		
			this.validarOferta(oferta);
			return null; //dao.alterar(oferta);
		}
		
		// DELETE
		
		public void excluir(Integer id) throws OfertaExection {
			//dao.excluir(id);
		}
		
		private void validarOferta(Oferta oferta) throws OfertaExection {
			

		}
}
