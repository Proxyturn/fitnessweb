package br.com.cadastro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cadastro.dao.TreinoDAO;
import br.com.cadastro.model.Treino;

@Controller
public class TreinoController {
	
    @Autowired
    TreinoDAO daoTreino;
    
	@RequestMapping("listaTreinos")
    public String lista(Model modelTreino) throws ClassNotFoundException {
        modelTreino.addAttribute("treinos", daoTreino.lista());
        return "treino/lista";
    }

	@RequestMapping("novoTreino")
	public String form() {
		return "treino/formulario";
	}
	
	@RequestMapping("adicionaTreino")
	public String adiciona(@Valid Treino treino, BindingResult result) throws ClassNotFoundException {
		if(result.hasFieldErrors("identificacao")) {
			 return "treino/formulario";
	     }
		daoTreino.adiciona(treino);
		return "redirect:listaTreinos";
	}
	
	@RequestMapping("mostraTreino")
    public String mostra(Long id, Model modelTreino) throws ClassNotFoundException {
        modelTreino.addAttribute("treino", daoTreino.buscaPorId(id));
        return "treino/mostra";
    }
	
	@RequestMapping("alteraTreino")
	public String altera(@Valid Treino treino, BindingResult result) throws ClassNotFoundException {
		if(result.hasFieldErrors("identificacao")) {
			 return "treino/mostra";
	     }
		daoTreino.altera(treino);
        return "redirect:listaTreinos";
    }
	
    @RequestMapping("removeTreino")
    public String remove(Treino treino) throws ClassNotFoundException {
    	daoTreino.remove(treino);
        return "redirect:listaTreinos";
    }
    
}