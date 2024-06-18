package it.unimol.autonoleggio.entity;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Document
@Data
public class Noleggio {
    @Getter
    @Id
    private String noleggioId;
    @Indexed(unique = true)
    private String idAuto;
    private String idCliente;
    private String dataInizioNoleggio;
    private String dataFineNoleggio;

    public Noleggio(String idAuto, String idCliente,String dataInizioNoleggio, String dataFineNoleggio){
        this.idAuto = idAuto;
        this.idCliente = idCliente;
        this.dataInizioNoleggio = dataInizioNoleggio;
        this.dataFineNoleggio = dataFineNoleggio;
    }
}
