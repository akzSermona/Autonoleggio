package it.unimol.autonoleggio.service;

import lombok.AllArgsConstructor;
import it.unimol.autonoleggio.entity.Auto;
import it.unimol.autonoleggio.repository.AutoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AutoService {
    private final AutoRepository repository;

    public List<Auto> getAllAutos(){
        return repository.findAll();
    }

    public Auto getAutoById(String autoId){

        Optional<Auto> auto = repository.findById(autoId);
        return auto.orElse(null);
    }

    public List<Auto> getAutoByModello(String modello){
        Optional <List<Auto>> autoList = repository.findAutoByModello(modello);
        return autoList.orElse(null);
    }

    public List<Auto> getAutoByMarchio(String marchio){
        Optional <List<Auto>> autoList = repository.findAutoByMarchio(marchio);
        return autoList.orElse(null);
    }

    public double getChilometriByTarga(String targa){
        Optional<Auto> auto = repository.findByTarga(targa);
        return auto.get().getChilometraggio();
    }

   public String getTagliandoByTarga(String targa){
       Optional<Auto> auto = repository.findByTarga(targa);
       return auto.get().getUltimoTagliando();
   }

   public Auto insertAuto(Auto auto){
       repository.findById(auto.getTarga()).ifPresentOrElse(s -> {
           System.out.println("L'auto con targa " + auto.getTarga() + "già esiste");
       }, () -> {
           System.out.println("Inserendo l'auto" + auto);
           repository.insert(auto);
       });
       return auto;
   }

    public String deleteAutoById(String autoId) {
        if (repository.existsById(autoId)) {
            repository.deleteById(autoId);
            return "Auto " + autoId + " deleted";
        } else return "Auto non è presente nel database";
    }

   public Auto uptadeAuto(Auto auto){
       Optional<Auto> autoEsistente = repository.findById(auto.getId());

       if(autoEsistente.isPresent()){
           System.out.println("Auto con targa \"" + auto.getTarga()+ "\" aggiornata.");
           return repository.save(auto);
       }else{
           return null;
       }
   }
}

