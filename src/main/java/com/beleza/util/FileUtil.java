package com.beleza.util;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class FileUtil {

	public static void saveFile(String path, String base64, String basePath) {
		try {
			byte[] data = Base64.getDecoder().decode(base64.getBytes(StandardCharsets.UTF_8));

			if (!Files.exists(Paths.get(basePath), LinkOption.NOFOLLOW_LINKS))
				Files.createDirectories(Paths.get(basePath));

			Path destinationFile = Paths.get(basePath, path);

			Files.write(destinationFile, data);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
