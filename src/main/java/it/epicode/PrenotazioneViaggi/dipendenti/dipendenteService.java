package it.epicode.PrenotazioneViaggi.dipendenti;

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
public class dipendenteService {
    private final dipendenteRepository dipendenteRepository;
    private final ViaggioRepository viaggioRepository;
    //qua devo mettere i metodi per le CRUD
    //Ho creato la CREATERESPONSE di modo da ricevere indietro l'id di quello che vado a salvare
    //La REQUEST, cioè il DTO per il payload (nella mia testa ha senso)

    //POST
    public CreateResponse save(@Valid dipendenteRequest request) {
        if(dipendenteRepository.existsByUsername(request.getUsername())) {
            throw new EntityExistsException("L'utente con username " + request.getUsername() + " esiste già");
        }

        Dipendente dipendente = new Dipendente();
        BeanUtils.copyProperties(request, dipendente);
        Viaggio viaggio = viaggioRepository.findById(request.getViaggioId()).orElseThrow(() -> new EntityNotFoundException("Viaggio non trovato"));
        dipendente.setViaggioId(viaggio);

        dipendenteRepository.save(dipendente);

        CreateResponse response = new CreateResponse();
        response.setId(dipendente.getId());
        return response;
    }

    //PUT
    public Dipendente update(Long id, @Valid dipendenteRequest request) {
        if(!dipendenteRepository.existsById(id)) {
            throw new EntityNotFoundException("L'utente con id " + id + " non esiste");}
        Dipendente dipendente = dipendenteRepository.findById(id).get();
        BeanUtils.copyProperties(request, dipendente);
        dipendenteRepository.save(dipendente);
        return dipendente;
    }

    //DELETE
    public void delete(Long id){
        Dipendente dipendente = dipendenteRepository.findById(id).get();
        dipendenteRepository.delete(dipendente);
    }

    public List<Dipendente> findAll() {
        return dipendenteRepository.findAll();
    }

    public Dipendente findById(Long id) {
        return dipendenteRepository.findById(id).get();
    }
}
