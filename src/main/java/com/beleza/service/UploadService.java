package com.beleza.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.beleza.model.Fotos;

@Service
public class UploadService {

	public static final String uploadingdirclientes = System.getProperty("user.dir") + "/fotos_clientes/";
	public static final String uploadingdirprofissionais = System.getProperty("user.dir") + "/fotos_profissionais/";
	public static final String uploadingdirportfolio = System.getProperty("user.dir") + "/portfolio";

	public String uploadCliente(MultipartFile[] fotos) throws IllegalStateException, IOException {
		File file = null;
		for (MultipartFile uploadedFile : fotos) {
			file = new File(uploadingdirclientes + uploadedFile.getOriginalFilename());
			uploadedFile.transferTo(file);
		}
		return file.toString();
	}

	public String uploadProfissional(MultipartFile[] fotos) throws IllegalStateException, IOException {
		File file = null;
		for (MultipartFile uploadedFile : fotos) {
			file = new File(uploadingdirprofissionais + uploadedFile.getOriginalFilename());
			uploadedFile.transferTo(file);
		}
		return file.toString();
	}

	public List<Fotos> uploadPortfolio(MultipartFile[] fotos) throws IllegalStateException, IOException {
		Fotos foto;
		List<Fotos> fotosProfissional = new ArrayList<>();
		
		for (MultipartFile uploadedFile : fotos) {
			foto = new Fotos();
			File file = new File(uploadingdirportfolio + uploadedFile.getOriginalFilename());
			uploadedFile.transferTo(file);
			foto.setNome(file.toString());
		}
		
		return fotosProfissional;
	}
}
