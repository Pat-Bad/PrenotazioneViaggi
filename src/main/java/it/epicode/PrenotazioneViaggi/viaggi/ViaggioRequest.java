package it.epicode.PrenotazioneViaggi.viaggi;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViaggioRequest {
    @NotBlank(message = "il campo destinazione non deve essere vuoto")
    private String destinazione;
    @Future(message = "la data deve essere futura")
    private LocalDate data;
    @NotNull(message = "il campo stato non deve essere vuoto")
    private StatoViaggio statoViaggio;
}
