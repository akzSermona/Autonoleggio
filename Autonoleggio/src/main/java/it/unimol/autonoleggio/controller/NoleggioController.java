package it.unimol.autonoleggio.controller;

import lombok.AllArgsConstructor;
import it.unimol.autonoleggio.entity.Noleggio;
import it.unimol.autonoleggio.service.NoleggioService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v2/noleggio")
@AllArgsConstructor

public class NoleggioController {
    private final NoleggioService noleggioService;

    @GetMapping("get-all")
    public List<Noleggio> getAllNoleggi() {
        return noleggioService.getAllNoleggi();
    }

    @GetMapping("get-by-id/{noleggioId}")
    public Noleggio getNoleggioById(@PathVariable String noleggioId){

        Noleggio noleggio = noleggioService.getNoleggioById(noleggioId);

        if(noleggio != null){
            return noleggio;
        }else return null;

    }

    @GetMapping("get-by-id-cliente/{idCliente}")
    public List<Noleggio> getAllNoleggioByIdCliente(@PathVariable String idCliente){

        List<Noleggio> noleggioList = noleggioService.getNoleggioByIdCliente(idCliente);
        if(!noleggioList.isEmpty()){
            return noleggioList;
        }else
            return null;
    }

    @GetMapping("get-by-id-auto/{idAuto}")
    public List<Noleggio> getAllNoleggioByIdAuto(@PathVariable String idAuto){

        List<Noleggio> noleggioList = noleggioService.getNoleggioByIdAuto(idAuto);
        if(!noleggioList.isEmpty()){
            return noleggioList;
        }else return null;

    }

    @GetMapping("get-by-data-inizio-noleggio/{year}/{month}/{day}")
    public List<Noleggio> getAllNoleggioByDataInizioNoleggio(@PathVariable int year, @PathVariable int month, @PathVariable int day){

        String dataInizioNoleggio = String.format("%04d/%02d/%02d", year, month, day);
        List<Noleggio> noleggioList = noleggioService.getNoleggioByDataInizioNoleggio(dataInizioNoleggio);
        if(!noleggioList.isEmpty()){
            return noleggioList;
        }else return null;

    }

    @GetMapping("get-by-data-fine-noleggio/{year}/{month}/{day}")
    public List<Noleggio> getAllNoleggioByDataFineNoleggio(@PathVariable int year, @PathVariable int month, @PathVariable int day){

        String dataFineNoleggio = String.format("%04d/%02d/%02d", year, month, day);
        List<Noleggio> noleggioList = noleggioService.getNoleggioByDataFineNoleggio(dataFineNoleggio);
        if(!noleggioList.isEmpty()){
            return noleggioList;
        }else return null;

    }

    @PostMapping("insert-noleggio")
    public Noleggio insertNoleggio(@RequestBody Noleggio noleggio) {
        return noleggioService.insertNoleggio(noleggio);
    }

    @DeleteMapping("delete/{id}")
    public String deleteNoleggio(@PathVariable String id) {
        return noleggioService.deleteNoleggioById(id);
    }

    @PutMapping("uptade")
    public Noleggio uptadeAuto(@RequestBody Noleggio noleggio) {
        return noleggioService.uptadeNoleggio(noleggio);
    }

}
