package it.epicode.PrenotazioneViaggi.viaggi;

import it.epicode.PrenotazioneViaggi.responses.CreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/viaggi")
@PreAuthorize("isAuthenticated()")
public class ViaggioController {
    private final ViaggioService viaggioService;
    private final ViaggioRepository viaggioRepository;

    @GetMapping("")
    @PreAuthorize("hasRole('USER')")
    @ResponseStatus(HttpStatus.OK)
    public List<Viaggio> findAll(){
        return viaggioRepository.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.OK)
    public Viaggio findById(@PathVariable Long id){
        return viaggioService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public CreateResponse save(@RequestBody ViaggioRequest request){
        return viaggioService.save(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public Viaggio update(@PathVariable Long id, @RequestBody ViaggioRequest request){
        return viaggioService.update(id, request);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        viaggioService.delete(id);
    }

    //teoricamente così modifica solo la proprietà stato, come scritto nel metodo che invoco
    /*@PatchMapping("viaggi/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Viaggio modificaStato (@PathVariable Long id, @RequestBody ViaggioRequestPatch request) {
        Viaggio viaggio;
        if (!viaggioRepository.existsById(id)) {
            throw new EntityNotFoundException("Il viaggio con id " + id + " non è stato trovato");
        } else {
            viaggio = viaggioRepository.findById(id).get();

            viaggio.setStatoViaggio((request.getStatoViaggio()));
        }

        return viaggioRepository.save(viaggio);
    }*/

    }

