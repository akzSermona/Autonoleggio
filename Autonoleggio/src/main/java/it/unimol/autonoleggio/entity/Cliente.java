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
public class Cliente {
    @Getter
    @Id
    private String id;
    @Indexed(unique = true)
    private String ci;
    private String nome;
    private String cognome;
    private String dataNascita;

    public Cliente(String ci, String nome, String cognome, String dataNascita){
        this.ci = ci;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
    }

}
