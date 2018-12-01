package br.com.cadastro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cadastro.dao.CatalogoDAO;
import br.com.cadastro.dao.DiaDAO;
import br.com.cadastro.dao.ExercicioDAO;
import br.com.cadastro.model.Exercicio;

@Controller
public class ExercicioController {
	
    @Autowired
    ExercicioDAO daoExercicio;
    
    @Autowired
    DiaDAO daoDia;
    
    @Autowired
    CatalogoDAO daoCatalogo;
    
	@RequestMapping("listaExercicios")
    public String lista(Model modelExercicio,  Model modelCatalogo, Model modelDia, long id) throws ClassNotFoundException {
		modelDia.addAttribute("dia", daoDia.buscaPorId(id));
        modelExercicio.addAttribute("exercicios", daoExercicio.lista());
        modelCatalogo.addAttribute("catalogos", daoCatalogo.lista());
        modelDia.addAttribute("dia", daoDia.buscaPorId(id));
        return "exercicio/lista";
    }

	@RequestMapping("novoExercicio")
	public String form(long id, Model modelDia) {
		 modelDia.addAttribute("dia", daoDia.buscaPorId(id));
		return "exercicio/formulario";
	}
	
	@RequestMapping("adicionaExercicio")
	public String adiciona(@Valid Exercicio exercicio, BindingResult result, long id) throws ClassNotFoundException {
		if(result.hasFieldErrors("repeticoes")) {
			 return "exercicio/formulario";
	     }
		daoExercicio.adiciona(exercicio);
		return "redirect:listaExercicios?id="+id+"";
	}
	
	@RequestMapping("mostraExercicio")
    public String mostra(Long id, Model modelExercicio) throws ClassNotFoundException {
        modelExercicio.addAttribute("exercicio", daoExercicio.buscaPorId(id));
        return "exercicio/mostra";
    }
	
	@RequestMapping("alteraExercicio")
	public String altera(@Valid Exercicio exercicio, BindingResult result, long id) throws ClassNotFoundException {
		if(result.hasFieldErrors("repeticoes")) {
			 return "exercicio/mostra";
	     }
		daoExercicio.altera(exercicio);
		return "redirect:listaExercicios?id="+id+"";
    }
	
    @RequestMapping("removeExercicio")
    public String remove(Exercicio exercicio, long id) throws ClassNotFoundException {
    	daoExercicio.remove(exercicio);
        return "redirect:listaExercicios?id="+id+"";
    }
    
}