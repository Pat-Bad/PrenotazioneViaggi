package it.epicode.PrenotazioneViaggi.prenotazioni;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface prenotazioneRepository extends JpaRepository <Prenotazione, Long> {

    boolean existsByData(LocalDate data);
}
