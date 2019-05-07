package br.com.lrsantos.model.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lrsantos.model.BeneficiarioService;
import br.com.lrsantos.model.beans.Beneficiario;
import br.com.lrsantos.model.repository.BeneficiarioRepository;

@RestController
@RequestMapping("/api/beneficiario")
@CrossOrigin
public class BeneficarioResource {
	
	@Autowired
	private BeneficiarioRepository repository;
	
	@Autowired
	private BeneficiarioService service;
	
	@PostMapping("/validacao")
	public ResponseEntity valida(@Valid @RequestBody ConsultaVO consulta) {
		System.out.println("Recebido " + consulta);
		Beneficiario beneficiario = this.repository.valida(consulta.getMatricula(), consulta.getCpf());
		if (beneficiario!=null) {
			return new ResponseEntity(beneficiario, HttpStatus.OK);
		}
		
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/pdf")
	public ResponseEntity<String> gravaPdf() {
		String resultado="";
		HttpStatus status = null;
		try {
			this.service.gravaPdf();
			resultado = "Arquivo gravados com sucesso";
			status = HttpStatus.OK;
		} catch (Exception e ) {
			e.printStackTrace();
			resultado = "Erro ao gravar arquivos PDF:  " + e.getMessage();
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity(resultado, status);
	}

}
