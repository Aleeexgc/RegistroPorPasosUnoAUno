package org.agomez.RegistroPorPasos.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.agomez.RegistroPorPasos.model.Colecciones;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("registro")
public class RegistroController {


	/**
	 * @param sol
	 * @return
	 */
	@GetMapping("/datosPersonales")
	public ModelAndView datosPersonales(HttpServletRequest sol) {
		ModelAndView mAV = new ModelAndView();

		String nombre = "";
		String apellido = "";
		String nacimiento = "";
		String genero = "";
		String estado = "";
		String hijos = "";

		List<String> nacionalidades = null;

		if (sol.getSession().getAttribute("nombre") != null) {
			nombre = (String)sol.getSession().getAttribute("nombre");
		}
		if (sol.getSession().getAttribute("apellido") != null) {
			apellido = (String)sol.getSession().getAttribute("apellido");
		}
		if (sol.getSession().getAttribute("nacimiento") != null) {
			nacimiento = (String)sol.getSession().getAttribute("nacimiento");
		}
		if (sol.getSession().getAttribute("genero") != null) {
			genero = (String)sol.getSession().getAttribute("genero");
		}
		if (sol.getSession().getAttribute("estado") != null) {
			estado = (String)sol.getSession().getAttribute("estado");
		}
		if (sol.getSession().getAttribute("hijos") != null) {
			hijos = (String)sol.getSession().getAttribute("hijos");

		}

		if (sol.getSession().getAttribute("nacionalidades") != null) {
			nacionalidades = (List<String>)sol.getSession().getAttribute("nacionalidades");

		}

		mAV.addObject("nombre",nombre);
		mAV.addObject("apellido",apellido);
		mAV.addObject("nacimiento",nacimiento);
		mAV.addObject("genero",genero);
		mAV.addObject("estado",estado);
		mAV.addObject("hijos",hijos);
		mAV.addObject("nacionalidades",nacionalidades);

		mAV.addObject("datosNavegacion",Colecciones.datosNavegacion);
		mAV.addObject("listaGenerosOrdenada", Colecciones.listaGenerosOrdenada);
		mAV.addObject("nacionalidadesLista",Colecciones.nacionalidades);
		mAV.setViewName("DatosPersonales");

		return mAV;
	}

	/**
	 * @param sol
	 * @param nombre
	 * @param apellido
	 * @param nacimiento
	 * @param genero
	 * @param estado
	 * @param hijos
	 * @param nacionalidades
	 * @return
	 */
	@PostMapping("/datosPersonales")
	public ModelAndView guardaDatosPersonales(HttpServletRequest sol, 
			@RequestParam(required= false) String nombre,
			@RequestParam(required= false) String apellido,
			@RequestParam(required= false) String nacimiento,
			@RequestParam(required= false) String genero,
			@RequestParam(required= false) String estado,
			@RequestParam(required= false) String hijos,
			@RequestParam(required= false) List<String> nacionalidades) {

		ModelAndView mAV = new ModelAndView();

		sol.getSession().setAttribute("nombre", nombre);
		sol.getSession().setAttribute("apellido", apellido);
		sol.getSession().setAttribute("nacimiento", nacimiento);
		sol.getSession().setAttribute("genero", genero);
		sol.getSession().setAttribute("estado", estado);
		sol.getSession().setAttribute("hijos", hijos);
		sol.getSession().setAttribute("nacionalidades", nacionalidades);

		mAV.setViewName("redirect:datosProfesionales");
		return mAV;
	}

	/**
	 * @param sol
	 * @return
	 */
	@GetMapping("/datosProfesionales")
	public ModelAndView datosProfesionales(HttpServletRequest sol) {
		ModelAndView mAV = new ModelAndView();

		String departamento = "";
		String salario = "";
		String comentarios = "";


		if (sol.getSession().getAttribute("departamento") != null) {
			departamento = (String)sol.getSession().getAttribute("departamento");
		}
		if (sol.getSession().getAttribute("salario") != null) {
			salario = (String)sol.getSession().getAttribute("salario");
		}
		if (sol.getSession().getAttribute("comentarios") != null) {
			comentarios = (String)sol.getSession().getAttribute("comentarios");
		}

		mAV.addObject("departamento",departamento);
		mAV.addObject("salario",salario);
		mAV.addObject("comentarios",comentarios);

		mAV.addObject("datosNavegacion",Colecciones.datosNavegacion);
		mAV.addObject("departamentos",Colecciones.departamentos);
		mAV.setViewName("DatosProfesionales");
		return mAV;
	}

	/**
	 * @param sol
	 * @param departamento
	 * @param salario
	 * @param comentarios
	 * @return
	 */
	@PostMapping("/datosProfesionales")
	public ModelAndView guardaDatosProfesionales(HttpServletRequest sol,
			@RequestParam(required= false) String departamento,
			@RequestParam(required= false) String salario,
			@RequestParam(required= false) String comentarios) {
		ModelAndView mAV = new ModelAndView();

		sol.getSession().setAttribute("departamento", departamento);
		sol.getSession().setAttribute("salario", salario);
		sol.getSession().setAttribute("comentarios", comentarios);

		mAV.setViewName("redirect:datosBancarios");
		return mAV;
	}

	/**
	 * @param sol
	 * @return
	 */
	@GetMapping("/datosBancarios")
	public ModelAndView datosBancarios(HttpServletRequest sol) {
		ModelAndView mAV = new ModelAndView();

		String cuenta = "";
		if (sol.getSession().getAttribute("cuenta") != null) {
			cuenta = (String)sol.getSession().getAttribute("cuenta");
		}
		mAV.addObject("cuenta",cuenta);
		mAV.addObject("datosNavegacion",Colecciones.datosNavegacion);
		mAV.setViewName("DatosBancarios");
		return mAV;
	}

	/**
	 * @param sol
	 * @param cuenta
	 * @return
	 */
	@PostMapping("/datosBancarios")
	public ModelAndView guardaDatosBancarios (HttpServletRequest sol, @RequestParam(required= false) String cuenta) {
		ModelAndView mAV = new ModelAndView();

		sol.getSession().setAttribute("cuenta", cuenta);
		
		mAV.setViewName("redirect:resumen");
		return mAV;
	}

	/**
	 * @param sol
	 * @return
	 */
	@GetMapping("/resumen")
	public ModelAndView resumen(HttpServletRequest sol) {
		ModelAndView mAV = new ModelAndView();

		String nombre = "";
		String apellido = "";
		String nacimiento = "";
		String genero = "";
		String estado = "";
		String hijos = "";
		List<String> nacionalidades = null;
		String departamento = "";
		String salario = "";
		String comentarios = "";
		String cuenta = "";

		if (sol.getSession().getAttribute("nombre") != null) {
			nombre = (String)sol.getSession().getAttribute("nombre");
		}
		if (sol.getSession().getAttribute("apellido") != null) {
			apellido = (String)sol.getSession().getAttribute("apellido");
		}
		if (sol.getSession().getAttribute("nacimiento") != null) {
			nacimiento = (String)sol.getSession().getAttribute("nacimiento");
		}
		if (sol.getSession().getAttribute("genero") != null) {
			genero = (String)sol.getSession().getAttribute("genero");
		}
		
		if (sol.getSession().getAttribute("nacionalidades") != null) {
			nacionalidades = (List<String>)sol.getSession().getAttribute("nacionalidades");

		}
		
		if (sol.getSession().getAttribute("departamento") != null) {
			departamento = (String)sol.getSession().getAttribute("departamento");
		}
		if (sol.getSession().getAttribute("salario") != null) {
			salario = (String)sol.getSession().getAttribute("salario");
		}
		if (sol.getSession().getAttribute("comentarios") != null) {
			comentarios = (String)sol.getSession().getAttribute("comentarios");
		}
		if (sol.getSession().getAttribute("cuenta") != null) {
			cuenta = (String)sol.getSession().getAttribute("cuenta");
		}
	
		mAV.addObject("nombre",nombre);
		mAV.addObject("apellido",apellido);
		mAV.addObject("nacimiento",nacimiento);
		mAV.addObject("genero",genero);
		mAV.addObject("nacionalidades",nacionalidades);
		mAV.addObject("departamento",departamento);
		mAV.addObject("salario",salario);
		mAV.addObject("comentarios",comentarios);
		mAV.addObject("cuenta",cuenta);

		mAV.addObject("datosNavegacion",Colecciones.datosNavegacion);
		mAV.setViewName("Resumen");
		return mAV;
	}

	@PostMapping("/resumen")
	public ModelAndView cierraSesion(HttpServletRequest sol) {
		
		ModelAndView mAV = new ModelAndView();

		sol.getSession().invalidate();
		mAV.setViewName("redirect:datosPersonales");
		return mAV;
	}

}
