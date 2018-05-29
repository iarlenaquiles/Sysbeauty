package com.beleza.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Service
public class UploadService {

	private final Path rootLocation;
	
	public UploadService(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") String root) {
		this.rootLocation = init(root);
	}
	
	public Path init(String root) {
		if (!Files.exists(Paths.get(root), LinkOption.NOFOLLOW_LINKS)) {
			try {
				Files.createDirectories(Paths.get(root));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return Paths.get(root);
	}
	
	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}
	
	public byte[] loadAsBytes(String filename) {
		File file = load(filename).toFile();

		try {
			InputStream stream = new FileInputStream(file);
			return FileCopyUtils.copyToByteArray(stream);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getPath(String filename) {
		File file = load(filename).toFile();
		return file.getAbsolutePath();
	}
}
