package com.beleza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beleza.model.Banner;
import com.beleza.repository.BannerRepository;

@Service
public class BannerService {
	
	@Autowired
	private BannerRepository bannerRepository;
	
	public List<Banner> listaBanners() {
		return bannerRepository.findAll();
	}
	
	public Banner salvarBanner(Banner banner) {
		return bannerRepository.save(banner);
	}
	
	public void deleteBanner(Integer id) {
		bannerRepository.delete(id);
	}
	
	public Banner getById(Integer id) {
		return bannerRepository.findOne(id);
	}

}
