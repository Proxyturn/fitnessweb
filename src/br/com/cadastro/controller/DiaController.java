package br.com.cadastro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cadastro.dao.DiaDAO;
import br.com.cadastro.dao.TreinoDAO;
import br.com.cadastro.dao.UsuarioDAO;
import br.com.cadastro.model.Dia;

@Controller
public class DiaController {
	
    @Autowired
    DiaDAO daoDia;
    
    @Autowired
    TreinoDAO daoTreino;
   
    
	@RequestMapping("listaDias")
    public String lista(Long id, Model modelDia, Model modelTreino) throws ClassNotFoundException {
		modelTreino.addAttribute("treino", daoTreino.buscaPorId(id));
        modelDia.addAttribute("dias", daoDia.lista());
        return "dia/lista";
    }

	@RequestMapping("novoDia")
	public String form(Long id, Model modelTreino) {
		modelTreino.addAttribute("treino", daoTreino.buscaPorId(id));
		return "dia/formulario";
	}
	
	@RequestMapping("adicionaDia")
	public String adiciona(@Valid Dia dia, BindingResult result, Long id) throws ClassNotFoundException {
		if(result.hasFieldErrors("identificacao") ) {
			 return "dia/formulario";
	     }
		daoDia.adiciona(dia);
		return "redirect:listaDias?id="+id+"";
	}
	
	@RequestMapping("mostraDia")
    public String mostra(Long id, Model modelDia) throws ClassNotFoundException {
        modelDia.addAttribute("dia", daoDia.buscaPorId(id));
        return "dia/mostra";
    }
	
	@RequestMapping("alteraDia")
	public String altera(@Valid Dia dia, BindingResult result, Long id) throws ClassNotFoundException {
		if(result.hasFieldErrors("identificacao") ) {
			 return "dia/mostra";
	     }
		daoDia.altera(dia);
		return "redirect:listaDias?id="+id+"";
    }
	
    @RequestMapping("removeDia")
    public String remove(Dia dia,Long idTreino) throws ClassNotFoundException {
    	daoDia.remove(dia);
    	return "redirect:listaDias?id="+idTreino+"";
    }
    
}