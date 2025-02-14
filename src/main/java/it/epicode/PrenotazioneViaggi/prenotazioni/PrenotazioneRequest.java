package it.epicode.PrenotazioneViaggi.prenotazioni;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrenotazioneRequest {
    @Future(message = "la data deve essere futura")
    private LocalDate data;
    @NotBlank(message = "il campo note non deve essere vuoto")
    private String note;
    @Min(message = "il valore del capo deve essere minimo 1", value = 1)
    private Long viaggioId;
    @Min(message = "il valore del capo deve essere minimo 1", value = 1)
    private Long dipendenteId;

    }
