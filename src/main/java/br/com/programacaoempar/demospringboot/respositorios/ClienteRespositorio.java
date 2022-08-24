package br.com.programacaoempar.demospringboot.respositorios;

import br.com.programacaoempar.demospringboot.modelos.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRespositorio extends JpaRepository<Cliente, Long> {
}
