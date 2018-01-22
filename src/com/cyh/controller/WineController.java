package com.cyh.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cyh.DAO.WineDAO;
import com.cyh.domain.Wine;

@Controller
@RequestMapping("jsp")
public class WineController {
	
	@RequestMapping("/showwines11.do")
	public String showWines(Model model){
		WineDAO wd=new WineDAO();
		List<Wine> list=wd.findAll();
		model.addAttribute("wineinfo",list);
		return "jsp/wines";
		
	}
	
}
