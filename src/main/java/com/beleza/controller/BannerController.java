package com.beleza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beleza.model.Banner;
import com.beleza.service.BannerService;
import com.beleza.util.Constants;
import com.beleza.util.FileUtil;

@RestController
public class BannerController {

	@Autowired
	BannerService bannerService;

	@GetMapping("/banners")
	public List<Banner> listar() {
		return this.bannerService.listaBanners();
	}

	@GetMapping("/banners/{id}")
	public Banner getById(@PathVariable Integer id) {
		return this.bannerService.getById(id);
	}

	@PostMapping("/banners")
	public Banner salvar(@RequestBody Banner banner) {
		if (banner.getImagemData() != null) {
			String base64 = banner.getImagemData();
			FileUtil.saveFile(banner.getImagem(), base64, Constants.BASE_UPLOAD);
			banner.setImagem(Constants.BASE + banner.getImagem());
		}
		return this.bannerService.salvarBanner(banner);
	}

	@PutMapping("/banners")
	public Banner editar(@RequestBody Banner banner) {
		if (banner.getImagemData() != null) {
			String base64 = banner.getImagemData();
			FileUtil.saveFile(banner.getImagem(), base64, Constants.BASE_UPLOAD);
			banner.setImagem(Constants.BASE + banner.getImagem());
		}
		return this.bannerService.salvarBanner(banner);
	}

	@DeleteMapping("/banners/{id}")
	public void deletar(@PathVariable Integer id) {
		this.bannerService.deleteBanner(id);
	}
}
