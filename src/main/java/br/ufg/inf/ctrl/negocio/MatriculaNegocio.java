package br.ufg.inf.ctrl.negocio;

import java.util.List;

import br.ufg.inf.ctrl.exception.MatriculaException;
import br.ufg.inf.model.dao.DaoMatricula ;
import br.ufg.inf.model.entities.Matricula;

public class MatriculaNegocio {


  DaoMatricula dao = new DaoMatricula();

  public Matricula inserir(Matricula matricula) throws MatriculaException {
    this.validarMatricula(matricula);
    dao.inserir(matricula);
    return matricula;
  }
  
  // READ
  public List<Matricula> buscaTodos() throws MatriculaException{
    return dao.buscaTodos();	
  }
  
  public Matricula buscaPorId(Integer id) throws MatriculaException {
    
    return dao.buscaPorId(id);
  }
  
  
  // UPDATE
  
  public Matricula alterar(Matricula matricula) throws MatriculaException {		
    this.validarMatricula(matricula);
    return dao.alterar(matricula);
  }
  
  // DELETE
  
  public void excluir(Integer id) throws MatriculaException {
    dao.excluir(id);
  }
  
  public List<Matricula> buscarPorNome(String str){
    return dao.buscarPorNome(str);
  }
  
  private void validarMatricula(Matricula matricula) throws MatriculaException {
    
    if (matricula.getAluno() == null){
      throw new MatriculaException("O matricula é obrigatório.");
    }

    if ( matricula.getIdMatricula() == null){
      throw new MatriculaException("A matricula é obrigatório.");
    }
    
    if ( matricula.getOferta() == null ){
      throw new MatriculaException("A oferta é obrigatório.");
    }

  }
}
