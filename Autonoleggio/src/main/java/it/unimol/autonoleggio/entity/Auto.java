package it.unimol.autonoleggio.entity;

import com.mongodb.lang.Nullable;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Data
public class Auto {
    @Getter
    @Id
    private String id;
    @Indexed(unique = true)
    private String targa;
    private String marchio;
    private String modello;
    @Nullable
    private double chilometraggio;
    private String ultimoTagliando;
    private String annoImmatricolazione;

    public Auto(String targa, String marchio, String modello, double chilometraggio,
                String ultimoTagliando, String  annoImmatricolazione){
        this.targa = targa;
        this.marchio = marchio;
        this.modello = modello;
        this.chilometraggio = chilometraggio;
        this.ultimoTagliando = ultimoTagliando;
        this.annoImmatricolazione = annoImmatricolazione;

    }

}
