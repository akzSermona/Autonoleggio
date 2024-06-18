package it.unimol.autonoleggio.service;

import lombok.AllArgsConstructor;
import it.unimol.autonoleggio.entity.Noleggio;
import it.unimol.autonoleggio.repository.NoleggioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class NoleggioService {
    private final NoleggioRepository repository;

    //FUNZIONA
    public List<Noleggio> getAllNoleggi() {
        return repository.findAll();
    }

    //FUNZIONA
    public Noleggio getNoleggioById (String noleggioId){
        Optional<Noleggio> noleggio = repository.findById(noleggioId);
        return noleggio.orElse(null);
    }

    //FUNZIONA
    public List<Noleggio> getNoleggioByIdCliente ( String idCliente){
        Optional<List<Noleggio>> noleggioList = repository.findNoleggioByIdCliente(idCliente);
        return noleggioList.orElse(null);

    }

    public List<Noleggio> getNoleggioByIdAuto(String idAuto){
        Optional<List<Noleggio>> noleggioList = repository.findNoleggioByIdAuto(idAuto);
        return noleggioList.orElse(null);
    }

    public List<Noleggio> getNoleggioByDataInizioNoleggio(String dataInizioNoleggio){
        Optional<List<Noleggio>> noleggioList = repository.getNoleggioByDataInizioNoleggio(dataInizioNoleggio);
        return noleggioList.orElse(null);
    }

    public List<Noleggio> getNoleggioByDataFineNoleggio(String dataFineNoleggio){
        Optional<List<Noleggio>> noleggioList = repository.getNoleggioByDataFineNoleggio(dataFineNoleggio);
        return noleggioList.orElse(null);
    }

    public Noleggio insertNoleggio(Noleggio noleggio){
        System.out.println("Inserendo il noleggio" + noleggio);
        repository.insert(noleggio);
        return noleggio;
    }

    public String deleteNoleggioById(String idNoleggio){
        if(repository.existsById(idNoleggio)){
            repository.deleteById(idNoleggio);
            return "Noleggio con id \"" + idNoleggio + "\" eliminato.";
        }else{
            return "Noleggio con id \"" + idNoleggio + "\" non trovato.";

        }
    }

    public Noleggio uptadeNoleggio(Noleggio noleggio){
        Optional<Noleggio> noleggioEsistente = repository.findById(noleggio.getNoleggioId());

        if(noleggioEsistente.isPresent()){
            System.out.println("Noleggio con id \"" + noleggio.getNoleggioId() + "\" aggiornato.");
            return repository.save(noleggio);
        }else{
            return null;
        }
    }




}
