package it.epicode.PrenotazioneViaggi.viaggi;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {

     boolean existsById(Long id);

     boolean existsByData(LocalDate data);
}
