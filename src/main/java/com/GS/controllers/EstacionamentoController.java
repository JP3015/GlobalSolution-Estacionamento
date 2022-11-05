package com.GS.controllers;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.GS.models.Carro;
import com.GS.models.Estacionamento;
import com.GS.repository.CarroRepository;
import com.GS.repository.EstacionamentoRepository;

@Controller
public class EstacionamentoController {

	@Autowired
	private EstacionamentoRepository er;
	
	@Autowired
	private CarroRepository cr;
	
	@RequestMapping(value="/cadastrarEstacionamento", method=RequestMethod.GET)
	public String form(){
		return "estacionamento/formEstacionamento";
	}
	
	@RequestMapping(value="/cadastrarEstacionamento", method=RequestMethod.POST)
	public String form(@Valid Estacionamento estacionamento, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarEstacionamento";
		}
		
		er.save(estacionamento);
		attributes.addFlashAttribute("mensagem", "Estacionamento cadastrado com sucesso!");
		return "redirect:/cadastrarEstacionamento";
	}
	
	@RequestMapping("/estacionamento")
	public ModelAndView listaEstacionamentos(){
		ModelAndView mv = new ModelAndView("listaEstacionamentos");
		Iterable<Estacionamento> estacionamento = er.findAll();
		mv.addObject("estacionamento", estacionamento);
		return mv;
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesEstacionamento(@PathVariable("codigo") long codigo){
		Estacionamento estacionamento = er.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("estacionamento/detalhesEstacionamento");
		mv.addObject("estacionamento", estacionamento);
		
		Iterable<Carro> carro = cr.findByEstacionamento(estacionamento);
		mv.addObject("carro", carro);
		
		return mv;
	}
	
	@RequestMapping("/deletarEstacionamento")
	public String deletarEstacionamento(long codigo){
		Estacionamento estacionamento = er.findByCodigo(codigo);
		er.delete(estacionamento);
		return "redirect:/estacionamento";
	}

	
	@RequestMapping(value="/{codigo}", method=RequestMethod.POST)
	public String detalhesEstacionamentoPost(@PathVariable("codigo") long codigo, @Valid Carro carro, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/{codigo}";
		}
		Estacionamento estacionamento = er.findByCodigo(codigo);
		carro.setEstacionamento(estacionamento);
		cr.save(carro);
		attributes.addFlashAttribute("mensagem", "Carro adicionado com sucesso!");
		return "redirect:/{codigo}";
	}
	
	@RequestMapping("/deletarCarro")
	public String deletarCarro(String placa){
		Carro carro = cr.findByPlaca(placa);
		cr.delete(carro);
		
		Estacionamento Estacionamento = carro.getEstacionamento();
		long codigoLong = Estacionamento.getCodigo();
		String codigo = "" + codigoLong;
		return "redirect:/" + codigo;
	}
}	
