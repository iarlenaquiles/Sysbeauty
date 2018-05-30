package com.beleza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beleza.model.Profissional;
import com.beleza.model.StatusProfissional;
import com.beleza.model.Usuario;
import com.beleza.repository.ProfissionalRepository;

@Service
public class ProfissionalService {

	@Autowired
	private ProfissionalRepository profissionalRepository;

	public List<Profissional> listaProfissionais() {
		return profissionalRepository.findAll();
	}

	public Profissional salvarProfissional(Profissional pro) {
		return profissionalRepository.save(pro);
	}

	public void deleteProfissional(Integer id) {
		profissionalRepository.delete(id);
	}

	public Profissional getById(Integer id) {
		return profissionalRepository.findOne(id);
	}

	public Profissional getByUsuario(Usuario usuario) {
		return profissionalRepository.getByUsuario(usuario);
	}

	public long getQuantidadeCadastros() {
		return profissionalRepository.count();
	}

	public List<Profissional> getByUsuarioStatusFalse() {
		return profissionalRepository.getByUsuarioStatusFalse();
	}

	public List<Profissional> getByNomeLike(String nome) {
		return profissionalRepository.getByNome(nome);
	}

	public List<Profissional> getByEditado(StatusProfissional status) {
		return profissionalRepository.getByStatus(status);
	}
}
