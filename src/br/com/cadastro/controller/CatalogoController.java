package br.com.cadastro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cadastro.dao.CatalogoDAO;
import br.com.cadastro.model.Catalogo;

@Controller
public class CatalogoController {
	
    @Autowired
    CatalogoDAO daoCatalogo;
    
	@RequestMapping("listaCatalogos")
    public String lista(Model modelCatalogo) throws ClassNotFoundException {
        modelCatalogo.addAttribute("catalogos", daoCatalogo.lista());
        return "catalogo/lista";
    }

	@RequestMapping("novoCatalogo")
	public String form(Model modelCatalogo) {
		modelCatalogo.addAttribute("catalogos", daoCatalogo.lista());
		return "catalogo/formulario";
	}
	
	@RequestMapping("adicionaCatalogo")
	public String adiciona(@Valid Catalogo catalogo, BindingResult result) throws ClassNotFoundException {
		if(result.hasFieldErrors("identificacao") || result.hasFieldErrors("descricao")) {
			 return "catalogo/formulario";
	     }
		daoCatalogo.adiciona(catalogo);
		return "redirect:listaCatalogos";
	}
	
	@RequestMapping("mostraCatalogo")
    public String mostra(Long id, Model modelCatalogo) throws ClassNotFoundException {
        modelCatalogo.addAttribute("catalogo", daoCatalogo.buscaPorId(id));
        return "catalogo/mostra";
    }
	
	@RequestMapping("alteraCatalogo")
	public String altera(@Valid Catalogo catalogo, BindingResult result) throws ClassNotFoundException {
		if(result.hasFieldErrors("identificacao") || result.hasFieldErrors("descricao")) {
			 return "catalogo/mostra";
	     }
		daoCatalogo.altera(catalogo);
        return "redirect:listaCatalogos";
    }
	
    @RequestMapping("removeCatalogo")
    public String remove(Catalogo catalogo) throws ClassNotFoundException {
    	daoCatalogo.remove(catalogo);
        return "redirect:listaCatalogos";
    }
    
}