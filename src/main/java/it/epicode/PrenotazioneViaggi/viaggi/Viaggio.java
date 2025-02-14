package it.epicode.PrenotazioneViaggi.viaggi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.epicode.PrenotazioneViaggi.prenotazioni.Prenotazione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String destinazione;
    private LocalDate data;
    private StatoViaggio statoViaggio;

    @OneToMany(mappedBy = "viaggio")
    @JsonIgnoreProperties("viaggio")
    private List<Prenotazione> prenotazioni;

}
