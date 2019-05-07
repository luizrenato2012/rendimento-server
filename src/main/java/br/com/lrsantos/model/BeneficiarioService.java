package br.com.lrsantos.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lrsantos.model.beans.Beneficiario;
import br.com.lrsantos.model.repository.BeneficiarioRepository;

@Service
public class BeneficiarioService {
	
	@Autowired
	private BeneficiarioRepository repository;

	public void gravaPdf() throws IOException {
		String PATH="C:\\Users\\luiz\\temp\\";
		List<Beneficiario> beneficiarios = this.repository.listByIds(Arrays.asList(1,2,3));
		if (beneficiarios==null || beneficiarios.size()==0) {
			throw new RuntimeException("Não encontrados beneficiarios");
		}
		
		if (beneficiarios.size()!=3) {
			throw new RuntimeException("No de beneficiarios encontrados invalidos "+ beneficiarios.size());
		}
		
		Path pathArquivo=null;
		for (Beneficiario beneficiario : beneficiarios ){
			pathArquivo = Paths.get(PATH+ "arquivo" + beneficiario.getId() + ".pdf");
			byte[] arquivo = Files.readAllBytes(pathArquivo);
			if (arquivo==null) {
				throw new RuntimeException("Arquivo invalido "+ pathArquivo.getFileName() );
			}
			beneficiario.setComprovante(arquivo);
		};
		
		this.repository.save(beneficiarios);
		
	}
}
