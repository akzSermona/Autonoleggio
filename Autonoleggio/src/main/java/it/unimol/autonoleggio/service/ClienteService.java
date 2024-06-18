package it.unimol.autonoleggio.service;

import lombok.AllArgsConstructor;
import it.unimol.autonoleggio.entity.Cliente;
import it.unimol.autonoleggio.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {
    private final ClienteRepository repository;

    public List<Cliente> getAllClienti() {
        return repository.findAll();
    }

    public Cliente getClienteById(String clienteId){
        Optional<Cliente> cliente = repository.findById(clienteId);
        return cliente.orElse(null);
    }

    public List<Cliente> getClienteByNome(String nome){
        Optional<List<Cliente>> clienteList = repository.findClienteByNome(nome);
        return clienteList.orElse(null);
    }

    public List<Cliente> getClienteByCognome(String cognome){
        Optional<List<Cliente>> clienteList = repository.findClienteByCognome(cognome);
        return clienteList.orElse(null);
    }

    public Cliente insertCliente(Cliente cliente){

        if(isMaggiorenne(cliente.getDataNascita())){
           repository.findClienteByCi(cliente.getCi()).ifPresentOrElse(s -> {
              System.out.println("Il cliente con documento numero " + cliente.getCi() + "già esiste");
           }, () -> {
              System.out.println("Inserendo il cliente" + cliente);
              repository.insert(cliente);
           });
            return cliente;
        }else{
            System.out.println("il cliente non è maggiorenne, non può essere inserito.");
        }

        return cliente;


    }

    // Metodo per verificare se una data di nascita è maggiore di 18 anni
    private boolean isMaggiorenne(String dataDiNascitaStr) {
        LocalDate dataDiNascita = LocalDate.parse(dataDiNascitaStr, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        LocalDate oggi = LocalDate.now();
        Period periodo = Period.between(dataDiNascita, oggi);

        if(periodo.getYears() >= 18){
         return true;
        }

        return false;
    }

    public String deleteClienteById(String id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return "Cliente con id \"" + id + "\" eliminato.";
        }else{
            return "Cliente con id \"" + id + "\" non trovato.";

        }
    }

    public Cliente uptadeCliente(Cliente cliente){
        Optional<Cliente> clienteEsistente = repository.findById(cliente.getId());

        if(clienteEsistente.isPresent()){
            System.out.println("Cliente con id\"" + cliente.getId() + "\" aggiornato.");
            return repository.save(cliente);
        }else{
            return null;
        }
    }


}
