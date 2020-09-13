package com.thewalking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thewalking.jpa.ProductService;
import com.thewalking.model.Product;
import com.thewalking.model.Category;
import com.thewalking.jpa.CategoryService;

@Controller
@RequestMapping(value="/products")
public class productController {
	@Autowired
	ProductService pService;
	@Autowired
	CategoryService cService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String list_products(Model model,
    		@Param("q") String q,
    		@Param("cid") Optional<Integer> cid) { //
        List<Product> listProducts=null;
        if (cid.isPresent()) {
        	listProducts = pService.findByCategoryId(cid.get());
        }else {
        	 listProducts = pService.findAll(q);
        }
        model.addAttribute("products", listProducts);
        List<Category> listCategories = cService.all();
    	model.addAttribute("categories", listCategories);
        model.addAttribute("q", q);
        
        return "products";
    }
	
//	@RequestMapping(value="/category",method = RequestMethod.GET)
//    public String list_products_by_category(Model model,
//    		@Param("category_id") Integer catId) { //Optional<Integer> opCatId
//        List<Product> listProducts=null;
//        System.out.println("##########"+catId);
//        String q="";
//        if (catId!=null) {
////        	Integer catId = opCatId.get();
//        	System.out.println("###" +catId);
//        	listProducts = pService.findByCategoryId(catId);
//        }else {
//        	 listProducts = pService.findAll(q);
//        }
//        model.addAttribute("products", listProducts);
//        List<Category> listCategories = cService.all();
//    	model.addAttribute("categories", listCategories);
//        model.addAttribute("q", q);
//        return "products";
//    }
	
	@RequestMapping(value = "/prod_details", method = RequestMethod.GET)
	public String product_details(
	  @Param("id") int id, Model model) {
		model.addAttribute("product", pService.find(id));
	    return "product_details";
	}

}
