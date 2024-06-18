package it.unimol.autonoleggio.repository;

import it.unimol.autonoleggio.entity.Auto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AutoRepository extends MongoRepository <Auto, String>{

    @Override
    Optional<Auto> findById(String autoId);
    Optional <List<Auto>> findAutoByModello(String modello);

    Optional <List<Auto>> findAutoByMarchio(String marchio);

    Optional<Auto> findByTarga(String targa);

}
