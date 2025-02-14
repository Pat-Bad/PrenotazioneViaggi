package it.epicode.PrenotazioneViaggi.prenotazioni;

import it.epicode.PrenotazioneViaggi.dipendenti.Dipendente;
import it.epicode.PrenotazioneViaggi.dipendenti.dipendenteRequest;
import it.epicode.PrenotazioneViaggi.responses.CreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prenotazioni")
public class PrenotazioneController {
    private final prenotazioneService prenotazioneService;

    @GetMapping("prenotazioni")
    @ResponseStatus(HttpStatus.OK)
    public List<Prenotazione> findAll(){
        return prenotazioneService.findAll();
    }

    @GetMapping("prenotazioni/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Prenotazione findById(@PathVariable Long id){
        return prenotazioneService.findById(id);
    }

    @PostMapping("prenotazioni")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateResponse save(@RequestBody prenotazioneRequest request){
        return prenotazioneService.save(request);
    }

    @PutMapping("prenotazioni/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Prenotazione update(@PathVariable Long id, @RequestBody prenotazioneRequest request){
        return prenotazioneService.update(id, request);
    }
    @DeleteMapping("prenotazioni/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        prenotazioneService.delete(id);
    }
}

