package it.unimol.autonoleggio.controller;

import lombok.AllArgsConstructor;
import it.unimol.autonoleggio.entity.Auto;
import it.unimol.autonoleggio.service.AutoService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v2/auto")
@AllArgsConstructor


public class AutoController {
    private final AutoService autoService;

    @GetMapping("get-all")
    public List<Auto> getAllAutos() {
        return autoService.getAllAutos();
    }

    @GetMapping("get-by-id/{autoId}")
    public Auto getAutoById(@PathVariable String autoId) {

        Auto auto = autoService.getAutoById(autoId);
        if(auto != null){
            return auto;
        }else return null;
    }

    @GetMapping("get-by-modello/{modello}")
    public List<Auto> getAllAutoByModello(@PathVariable String modello){

        List<Auto> autoList = autoService.getAutoByModello(modello);
        if(!autoList.isEmpty()){
            return autoList;
        }else
            return null;
    }

    @GetMapping("get-by-marchio/{marchio}")
    public List<Auto> getAllAutoByMarchio(@PathVariable String marchio){

        List<Auto> autoList = autoService.getAutoByMarchio(marchio);
        if(!autoList.isEmpty()){
            return autoList;
        }else return null;

    }

    @GetMapping("get-chilometri-by-targa/{targa}")
    public double getAllChilometriByTarga(@PathVariable String targa) {
        return autoService.getChilometriByTarga(targa);
    }

    @GetMapping("get-tagliando-by-targa/{targa}")
    public String getAllTagliandiByTarga(@PathVariable String targa){
        return autoService.getTagliandoByTarga(targa);
    }

    @PostMapping("insert-auto")
    public Auto insertAuto(@RequestBody Auto auto) {
        return autoService.insertAuto(auto);
    }

    @DeleteMapping("delete/{autoId}")
    public String deleteAutoById(@PathVariable String autoId) {

        return autoService.deleteAutoById(autoId);
    }

    @PutMapping("uptade")
    public Auto uptadeAuto(@RequestBody Auto auto) {
        return autoService.uptadeAuto(auto);
    }

}

