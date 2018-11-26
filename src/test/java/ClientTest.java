import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.beleza.model.Cliente;
import com.beleza.model.Perfil;
import com.beleza.model.Usuario;
import com.beleza.service.ClienteService;

class ClientTest {

	@Test
	void test() {
		ClienteService clienteService = new ClienteService();
		//List<Cliente> clientes = clienteService.listaClientes();
		Perfil p = new Perfil("ROLE_ADMIN");
		List<Perfil> meuPerfil = new ArrayList<>();
		meuPerfil.add(p);

		Usuario user1 = new Usuario("iarlen@gmail.com", "123", meuPerfil);

		Cliente cli1 = new Cliente();
		cli1.setUsuario(user1);

		assertEquals(user1.getEmail(), "iarlen@gmail.com");
		assertEquals("ROLE_ADMIN", user1.getPerfil().get(0).getNome());
		assert (cli1 != null);
	}

}
