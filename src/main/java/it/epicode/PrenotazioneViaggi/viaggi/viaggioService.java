package it.epicode.PrenotazioneViaggi.viaggi;

import it.epicode.PrenotazioneViaggi.responses.CreateResponse;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class viaggioService {
    private final ViaggioRepository viaggioRepository;

    //POST
    public CreateResponse save(@Valid viaggioRequest request) {
        LocalDate dataViaggio = request.getData();
        if (viaggioRepository.existsByData(dataViaggio)) {
            throw new EntityExistsException("Il viaggio con data " + request.getData() + " esiste già");
        }
        Viaggio viaggio = new Viaggio();
        BeanUtils.copyProperties(request,viaggio);;
        viaggioRepository.save(viaggio);

        CreateResponse response = new CreateResponse();
        response.setId(viaggio.getId());
        return response;
    }

    //PUT
    public Viaggio update(Long id, @Valid viaggioRequest request) {
        if(!viaggioRepository.existsById(id)) {
            throw new EntityNotFoundException("Il viaggio con id" + id + "non è stato trovato");
        }
        Viaggio viaggio = viaggioRepository.findById(id).get();
        BeanUtils.copyProperties(request,viaggio);
        viaggioRepository.save(viaggio);
        return viaggio;
    }

    //DELETE
    public void delete(Long id) {
        if(!viaggioRepository.existsById(id)) {
            throw new EntityNotFoundException("Il viaggio con id" + id + "non è stato trovato");
        }
        Viaggio viaggio = viaggioRepository.findById(id).get();
        viaggioRepository.delete(viaggio);
    }


    public Viaggio findById(Long id) {
            return viaggioRepository.findById(id).get();
    }

    /*public Viaggio modificaStato (Long id, ViaggioRequestPatch request) {
        if(!viaggioRepository.existsById(id)) {
            throw new EntityNotFoundException("Il viaggio con id " + id + " non è stato trovato");
        }

        Viaggio viaggio =  viaggioRepository.findById(id).get();

            if (request.getStatoViaggio() != null) {
                viaggio.setStatoViaggio(request.getStatoViaggio());
            }
            return viaggioRepository.save(viaggio);
    }*/

}

