package br.com.programacaoempar.demospringboot.controladores;

import br.com.programacaoempar.demospringboot.modelos.Cliente;
import br.com.programacaoempar.demospringboot.respositorios.ClienteRespositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteControlador {

    @Autowired
    public ClienteRespositorio clienteRespositorio;

    @GetMapping("/{id}")
    public Optional<Cliente> obtemCliente(@PathVariable("id") Long id) {
        return clienteRespositorio.findById(id);
    }

    @GetMapping
    public List<Cliente> listaClientes() {
        return clienteRespositorio.findAll();
    }


    @PostMapping
    public ResponseEntity<Cliente> criaCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteRespositorio.save(cliente), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Cliente> atualizaCliente(@RequestBody Cliente cliente) {
        Optional<Cliente> clienteExistente = clienteRespositorio.findById(cliente.getCodigo());
        if (clienteExistente.isPresent()) {
            Cliente _cliente = clienteExistente.get();
            _cliente.setNome(cliente.getNome());
            return new ResponseEntity<>(clienteRespositorio.save(cliente), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deletaCliente(@PathVariable("id") Long id) {
        clienteRespositorio.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
