package br.com.lrsantos.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.lrsantos.model.beans.Beneficiario;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Integer>{
	
	@Query("select b from Beneficiario b where b.matricula=:matricula and b.cpf=:cpf")
	public Beneficiario valida (@Param ("matricula") String matricula, @Param("cpf")String cpf);
	
	@Query("select b from Beneficiario b where b.id in :ids order by b.id")
	public List<Beneficiario> listByIds(@Param("ids") List<Integer> id);

}
