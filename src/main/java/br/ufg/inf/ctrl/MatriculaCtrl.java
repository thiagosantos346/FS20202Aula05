package br.ufg.inf.ctrl;

import java.util.List;

import br.ufg.inf.ctrl.exception.MatriculaException;
import br.ufg.inf.ctrl.negocio.MatriculaNegocio;
import br.ufg.inf.model.entities.Matricula;

public class MatriculaCtrl {

	MatriculaNegocio negocio = new MatriculaNegocio();

	public Matricula inserir(Matricula matricula) {
		try {
			matricula = negocio.inserir(matricula);
			System.out.println("Matricula cadastrado com sucesso: " + matricula);
		} catch (MatriculaException e) {
			System.out.println("Erro ao tentar cadastrar matricula.");
			System.out.println(e.getMessage());
		}
		return matricula;
	}

	public List<Matricula> buscaTodos() {
		List<Matricula> matriculas = null;
		try {
			matriculas = negocio.buscaTodos();
		} catch (MatriculaException e) {
			System.out.println("Erro tentar buscar as matriculas cadastrados.");
			System.out.println(e.getMessage());
		}
		return matriculas;
	}

	public List<Matricula> buscaPorNome(String str) {
		List<Matricula> matriculas = null;

		matriculas = negocio.buscarPorNome(str);

		return matriculas;
	}

	public Matricula buscaPorId(Integer id) {
		Matricula matricula = null;
		try {
			matricula = negocio.buscaPorId(id);
		} catch (MatriculaException e) {
			System.out.println("Erro ao tentar buscar o matricula com ID: " + id + ".");
			System.out.println(e.getMessage());
		}
		return matricula;
	}

	public Matricula alterar(Matricula matricula) {
		try {
			matricula = negocio.alterar(matricula);
			System.out.println("Matricula alterado com sucesso: " + matricula);
		} catch (MatriculaException e) {
			System.out.println("Erro ao tentar alterar o matricula com ID: " + matricula.getIdMatricula() + ".");
			System.out.println(e.getMessage());
		}
		return matricula;
	}

	public void excluir(Integer id) {
		try {
			negocio.excluir(id);
			System.out.println("Matricula excluído com sucesso.");
		} catch (MatriculaException e) {
			System.out.println("Erro ao tentar excluir o matricula");
			System.out.println(e.getMessage());
		}
	}
}
