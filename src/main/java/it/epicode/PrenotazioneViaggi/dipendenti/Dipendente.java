package it.epicode.PrenotazioneViaggi.dipendenti;

import it.epicode.PrenotazioneViaggi.viaggi.Viaggio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    @OneToOne
    @JoinColumn(name = "viaggio_id")
    private Viaggio viaggioId;


}
