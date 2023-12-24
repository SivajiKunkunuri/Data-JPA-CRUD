package in.laptop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.laptop.entity.Product;
import in.laptop.service.IProdService;

@Controller
public class ProdController {

	@Autowired
	private IProdService prodService;

	@GetMapping("/prods")
	public ModelAndView fetchAllProds() {
		ModelAndView mav = new ModelAndView();
		List<Product> allProds = prodService.getAllProds();
		mav.addObject("prods", allProds);
		mav.setViewName("product");
		return mav;
	}
	
	@GetMapping("/index")
	public ModelAndView getIndex() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("prods", new Product());
		mav.setViewName("save");
		return mav;
		int i = 100;
	}
	
	@PostMapping("/insert")
	public ModelAndView saveProd(@ModelAttribute("prods") Product product) {
		ModelAndView mav = new ModelAndView();
		boolean saveProd = prodService.saveProd(product);
		if(saveProd) {
			mav.addObject("success", "Record Saved...!");
		}
		mav.setViewName("save");
		return mav;
	}
	
	@GetMapping("/delete")
	public ModelAndView deleteProdById(@RequestParam("pid") Integer pid) {
		prodService.deleteProd(pid);
		
		ModelAndView mav = new ModelAndView();
		List<Product> allProds = prodService.getAllProds();
		mav.addObject("prods", allProds);
		mav.setViewName("product");
		return mav;
	}
	
	@GetMapping("/update")
	public ModelAndView updateProd(@RequestParam("pid") Integer pid) {
		Product updateProd = prodService.updateProd(pid);
		ModelAndView mav = new ModelAndView();
		mav.addObject("prods", updateProd);
		mav.setViewName("save");
		return mav;
	}

}
