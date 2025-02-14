package it.epicode.PrenotazioneViaggi.prenotazioni;

import it.epicode.PrenotazioneViaggi.responses.CreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prenotazioni")
public class PrenotazioneController {
    private final PrenotazioneService prenotazioneService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Prenotazione> findAll(){
        return prenotazioneService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Prenotazione findById(@PathVariable Long id){
        return prenotazioneService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateResponse save(@RequestBody PrenotazioneRequest request){
        return prenotazioneService.save(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Prenotazione update(@PathVariable Long id, @RequestBody PrenotazioneRequest request){
        return prenotazioneService.update(id, request);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        prenotazioneService.delete(id);
    }
}

