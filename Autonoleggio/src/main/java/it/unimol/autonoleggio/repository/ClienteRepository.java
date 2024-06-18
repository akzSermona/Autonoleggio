package it.unimol.autonoleggio.repository;

import it.unimol.autonoleggio.entity.Auto;
import it.unimol.autonoleggio.entity.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
    Optional<List<Cliente>> findClienteByNome(String nome);
   @Override
    Optional<Cliente> findById(String clienteId);
    Optional<List<Cliente>> findClienteByCognome(String cognome);
    Optional<Cliente> findClienteByCi(String ci);

}

