package it.unimol.autonoleggio.controller;

import lombok.AllArgsConstructor;
import it.unimol.autonoleggio.entity.Cliente;
import it.unimol.autonoleggio.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/cliente")
@AllArgsConstructor

public class ClienteController {
    private final ClienteService clienteService;

    @GetMapping("get-all")
    public List<Cliente> getAllClienti() {
        return clienteService.getAllClienti();
    }

    @GetMapping("get-by-id/{clienteId}")
    public Cliente getClienteById(@PathVariable String clienteId) {

        Cliente cliente = clienteService.getClienteById(clienteId);
        if(cliente != null){
            return cliente;
        }else return null;
    }

    @GetMapping("get-by-nome/{nome}")
    public List<Cliente> getAllClienteByNome(@PathVariable String nome){

        List<Cliente> clienteList = clienteService.getClienteByNome(nome);
        if(!clienteList.isEmpty()){
            return clienteList;
        }else return null;

    }

    @GetMapping("get-by-cognome/{cognome}")
    public List<Cliente> getAllClienteByCognome(@PathVariable String cognome){

        List<Cliente> clienteList = clienteService.getClienteByCognome(cognome);
        if(!clienteList.isEmpty()){
            return clienteList;
        }else return null;

    }

    @PostMapping("insert-cliente")
    public Cliente insertCliente(@RequestBody Cliente cliente) {
        return clienteService.insertCliente(cliente);
    }

    @DeleteMapping("delete/{id}")
    public String deleteCliente(@PathVariable String id) {
        return clienteService.deleteClienteById(id);
    }

    @PutMapping("uptade")
    public Cliente uptadeCliente(@RequestBody Cliente cliente) {
        return clienteService.uptadeCliente(cliente);
    }

}
