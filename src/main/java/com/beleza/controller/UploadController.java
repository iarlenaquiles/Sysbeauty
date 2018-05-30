package com.beleza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.beleza.service.UploadService;

@RestController
public class UploadController {

	@Autowired
	private UploadService uploadService;

	@GetMapping(value = "/upload/image/{filename:.+}", produces = { MediaType.IMAGE_JPEG_VALUE,
			MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_GIF_VALUE })
	public ResponseEntity<?> downloadJpeg(@PathVariable String filename) {
		byte[] content = uploadService.loadAsBytes(filename);
		return new ResponseEntity<>(content, HttpStatus.OK);
	}
}
