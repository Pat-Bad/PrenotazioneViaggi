package it.epicode.PrenotazioneViaggi.prenotazioni;

import it.epicode.PrenotazioneViaggi.dipendenti.Dipendente;
import it.epicode.PrenotazioneViaggi.dipendenti.DipendenteRepository;
import it.epicode.PrenotazioneViaggi.responses.CreateResponse;
import it.epicode.PrenotazioneViaggi.viaggi.Viaggio;
import it.epicode.PrenotazioneViaggi.viaggi.ViaggioRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrenotazioneService {
    private final PrenotazioneRepository prenotazioneRepository;
    private final ViaggioRepository viaggioRepository;
    private final DipendenteRepository dipendenteRepository;

    //POST
    public CreateResponse save(@Valid PrenotazioneRequest request) {
        if(prenotazioneRepository.existsByData(request.getData())) {
            throw new EntityExistsException("In questa data esiste già una prenotazione");
        }
        Prenotazione prenotazione = new Prenotazione();
        Viaggio viaggio = viaggioRepository.findById(request.getViaggioId())
                .orElseThrow(() -> new EntityNotFoundException("Viaggio non trovato"));
        Dipendente dipendente = dipendenteRepository.findById(request.getDipendenteId())
                .orElseThrow(() -> new EntityNotFoundException("Dipendente non trovato"));

        prenotazione.setViaggio(viaggio);
        prenotazione.setDipendente(dipendente);


        BeanUtils.copyProperties(request,prenotazione);;
        prenotazioneRepository.save(prenotazione);

        CreateResponse response = new CreateResponse();
        response.setId(prenotazione.getId());
        return response;
    }

    //PUT
    public Prenotazione update(Long id, @Valid PrenotazioneRequest request) {
        if(!prenotazioneRepository.existsById(id)) {
            throw new EntityNotFoundException("Prenotazione non trovata");
        }
        Prenotazione prenotazione = prenotazioneRepository.findById(id).get();
        BeanUtils.copyProperties(request,prenotazione);
        prenotazioneRepository.save(prenotazione);
        return prenotazione;
    }

    //DELETE
    public void delete(Long id) {
        if(!prenotazioneRepository.existsById(id)) {
            throw new EntityNotFoundException("Prenotazione non trovata");
        }
        Prenotazione prenotazione = prenotazioneRepository.findById(id).get();
        prenotazioneRepository.delete(prenotazione);
    }

    public List<Prenotazione> findAll() {
        return prenotazioneRepository.findAll();
    }

    public Prenotazione findById(Long id) {
        return prenotazioneRepository.findById(id).get();
    }
}
