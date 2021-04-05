package br.ufg.inf.ctrl.negocio;

import java.util.Calendar;
import java.util.List;

import br.ufg.inf.ctrl.exception.PessoaExection;
import br.ufg.inf.model.dao.PessoaDAO;
import br.ufg.inf.model.entities.Pessoa;

public class PessoaNegocio {

		PessoaDAO dao = new PessoaDAO();
	
		public Pessoa inserir(Pessoa pessoa) throws PessoaExection {
			this.validarPessoa(pessoa);
			return dao.inserir(pessoa);
		}
		
		public List<Pessoa> buscaTodos() throws PessoaExection{
			return dao.buscaTodos();	
		}
		
		public Pessoa buscaPorId(Integer id) throws PessoaExection {
			return dao.buscaPorId(id);
		}

		public Pessoa alterar(Pessoa pessoa) throws PessoaExection {		
			this.validarPessoa(pessoa);
			return dao.alterar(pessoa);
		}

		public void excluir(Integer id) throws PessoaExection {
			dao.excluir(id);
		}
		
		private void validarPessoa(Pessoa pessoa) throws PessoaExection {
			
			if (pessoa.getNmPessoa() == null || pessoa.getNmPessoa().length() == 0) {
				throw new PessoaExection("Nome da pessoa � obrigat�rio.");
			}

			if (pessoa.getCpf().toString().length() != 11) {
				throw new PessoaExection("CPF deve ter pelo menos 11 algarismos.");
			}
			
			Calendar calHoje = Calendar.getInstance();
			Calendar calNascimento = Calendar.getInstance();
			calNascimento.setTime(pessoa.getDtNascimento());
			
			if (calHoje.before(calNascimento)) {
				throw new PessoaExection("Data de Nascimento deve ser maior que hoje.");
			}

		}
}
