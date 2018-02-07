package br.com.beleza.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.beleza.model.Agendamento;
import br.com.beleza.model.Usuario;

public interface IUsuario extends CrudRepository<Usuario, Integer> {

	@Query(value = "SELECT * FROM usuario  WHERE usuario_email = :email AND usuario_senha = :senha", nativeQuery = true)
	public Usuario doLoginQuery(@Param("email") String email, @Param("senha") String senha);

	// @Query(value="select r.role from usuario u inner join user_role ur
	// on(u.usuario_id=ur.usuario_id) inner join role r on(ur.role_id=r.role_id)
	// where u.usuario_email= :email", nativeQuery=true)
	@Query(value = "select r.role from login l inner join login_role ur on(l.login_id=ur.login_id) inner join role r on(ur.role_id=r.role_id) where l.login_email= :email", nativeQuery = true)
	public String perfil(@Param("email") String email);

	@Query(value = "SELECT * FROM usuario  WHERE usuario_email = :email ", nativeQuery = true)
	public Usuario listPerfil(@Param("email") String email);

	@Query(value = "SELECT agendamento.usuario_usuario_id, s.servico, p.pro_endereco FROM agendamento inner join servico s on (agendamento.servico_servico_id = s.servico_id) inner join profissional p on (s.servico_id = p.pro_id) where agendamento.usuario_usuario_id = :id ", nativeQuery = true)
	public List<Agendamento> agendamento(@Param("id") Integer id);
}