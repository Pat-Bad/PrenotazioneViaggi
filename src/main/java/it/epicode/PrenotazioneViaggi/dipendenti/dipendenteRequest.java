package it.epicode.PrenotazioneViaggi.dipendenti;

import it.epicode.PrenotazioneViaggi.viaggi.Viaggio;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class dipendenteRequest {
    @NotBlank(message="il campo username non può rimanere vuoto")
    private String username;
    @NotBlank(message = "il campo nome non deve essere vuoto")
    private String nome;
    @NotBlank(message = "il campo cognome non deve essere vuoto")
    private String cognome;
    @Email(message = "inserire un indirizzo email valido")
    @NotBlank(message = "il campo email non deve essere vuoto")
    private String email;
    @Min(message = "il valore del capo deve essere minimo 1", value = 1)
    private Long viaggioId;
}
