package it.epicode.PrenotazioneViaggi.dipendenti;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
    boolean existsByUsername(@NotBlank(message="il campo username non può rimanere vuoto") String username);
}
