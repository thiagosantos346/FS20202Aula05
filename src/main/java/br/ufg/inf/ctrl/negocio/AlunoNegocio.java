package br.ufg.inf.ctrl.negocio;

import java.util.List;

import br.ufg.inf.ctrl.exception.AlunoException;
import br.ufg.inf.model.dao.DaoAluno ;
import br.ufg.inf.model.entities.Aluno;

public class AlunoNegocio {

  DaoAluno dao = new DaoAluno();

  public Aluno inserir(Aluno aluno) throws AlunoException {
    this.validarAluno(aluno);
    dao.inserir(aluno);
    return aluno;
  }
  
  // READ
  public List<Aluno> buscaTodos() throws AlunoException{
    return dao.buscaTodos();	
  }
  
  public Aluno buscaPorId(Integer id) throws AlunoException {
    return dao.buscaPorId(id);
  }
  
  // UPDATE
  public Aluno alterar(Aluno aluno) throws AlunoException {		
    this.validarAluno(aluno);
    return dao.alterar(aluno);
  }
  
  // DELETE
  public void excluir(Integer id) throws AlunoException {
    dao.excluir(id);
  }
  
  public List<Aluno> buscarPorNome(String str){
    return dao.buscarPorNome(str);
  }
  
  private void validarAluno(Aluno aluno) throws AlunoException {
    if (aluno.getPessoa().getNmPessoa() == null || aluno.getPessoa().getNmPessoa().length() == 0) {
      throw new AlunoException("Nome da aluno é obrigatório.");
    }
  }


}
