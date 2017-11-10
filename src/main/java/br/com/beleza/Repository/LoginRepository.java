package br.com.beleza.Repository;

import org.springframework.data.repository.CrudRepository;

import br.com.beleza.model.Login;

public interface LoginRepository  extends CrudRepository<Login, Integer> {

}
