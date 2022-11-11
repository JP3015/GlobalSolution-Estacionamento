package com.GS.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.GS.models.Carro;
import com.GS.models.Estacionamento;
import com.GS.repository.CarroRepository;
import com.GS.repository.EstacionamentoRepository;

@Controller
public class CarroController {

	@Autowired
	private EstacionamentoRepository er;
	
	@Autowired
	private CarroRepository cr;
	

	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesEstacionamento(@PathVariable("codigo") long codigo){
		Estacionamento estacionamento = er.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("estacionamento/detalhesEstacionamento");
		mv.addObject("estacionamento", estacionamento);
		
		Iterable<Carro> carro = cr.findByEstacionamento(codigo);
		mv.addObject("carro", carro);
		
		return mv;
	}

	@RequestMapping("/estacionamento")
	public ModelAndView listaEstacionamentos(){
		ModelAndView mv = new ModelAndView("listaEstacionamentos");
		Iterable<Estacionamento> estacionamento = er.findAll();
		mv.addObject("estacionamento", estacionamento);
		return mv;
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.POST)
	public String detalhesEstacionamentoPost(@PathVariable("codigo") long codigo, @Validated Carro carro, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/{codigo}";
		}
		carro.setEstacionamento(codigo);
		cr.save(carro);
		attributes.addFlashAttribute("mensagem", "Carro adicionado com sucesso!");
		return "redirect:/{codigo}";
	}
	
	@RequestMapping("/deletarCarro")
	public String deletarCarro(String placa){
		Carro carro = cr.findByPlaca(placa);
		cr.delete(carro);
		
		long codigoLong = carro.getEstacionamento();
		String codigo = "" + codigoLong;
		return "redirect:/" + codigo;
	}

	@RequestMapping(value="/editar", method=RequestMethod.POST)
	public String detalhesEstacionamentoPUT(@Validated Carro carro, RedirectAttributes attributes){
		cr.save(carro);
		attributes.addFlashAttribute("mensagem", "Carro editado com sucesso!");
		long codigoLong = carro.getEstacionamento();
		String codigo = "" + codigoLong;
		return "redirect:/" + codigo;
	}


    @GetMapping("editar/{id}")
    public String CarroPUT(@PathVariable (value = "id") Long id, Model model) {
        model.addAttribute("carro", cr.findById(id).get());
        return "estacionamento/editCarro";
    } 

}	
