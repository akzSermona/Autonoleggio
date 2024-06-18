package it.unimol.autonoleggio.repository;

import it.unimol.autonoleggio.entity.Noleggio;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface NoleggioRepository extends MongoRepository <Noleggio, String> {

    @Override
    Optional<Noleggio> findById(String noleggioId);
    Optional<List<Noleggio>> findNoleggioByIdCliente(String idCliente);
    Optional<List<Noleggio>> findNoleggioByIdAuto(String idAuto);
    Optional<List<Noleggio>> getNoleggioByDataInizioNoleggio(String dataInizioNoleggio);
    Optional<List<Noleggio>> getNoleggioByDataFineNoleggio(String dataFineNoleggio);






}
