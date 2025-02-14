package it.epicode.PrenotazioneViaggi.prenotazioni;

import it.epicode.PrenotazioneViaggi.dipendenti.Dipendente;
import it.epicode.PrenotazioneViaggi.viaggi.Viaggio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate data;
    private String note;
    @ManyToOne
    @JoinColumn(name="viaggio_id")
    private Viaggio viaggio;
    @ManyToOne
    @JoinColumn(name="dipendente_id")
    private Dipendente dipendente;

}
