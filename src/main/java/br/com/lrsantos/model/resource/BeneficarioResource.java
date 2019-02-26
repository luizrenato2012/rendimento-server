package br.com.lrsantos.model.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lrsantos.model.beans.Beneficiario;
import br.com.lrsantos.model.repository.BeneficiarioRepository;

@RestController
@RequestMapping("/api/beneficario")
public class BeneficarioResource {
	
	@Autowired
	private BeneficiarioRepository repository;
	
	@PostMapping("/validacao")
	public ResponseEntity valida(@RequestBody ConsultaVO consulta) {
		Beneficiario beneficiario = this.repository.valida(consulta.getMatricula(), consulta.getCpf());
		if (beneficiario!=null) {
			return new ResponseEntity(beneficiario, HttpStatus.OK);
		}
		
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

}
