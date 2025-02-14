package it.epicode.PrenotazioneViaggi.dipendenti;

import it.epicode.PrenotazioneViaggi.responses.CreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/dipendenti")
public class DipendenteController {
    private final DipendenteService dipendenteService;
    private final DipendenteRepository dipendenteRepository;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Dipendente> findAll(){
        return dipendenteRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dipendente findById(@PathVariable Long id){
        return dipendenteService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateResponse save(@RequestBody DipendenteRequest request){
        return dipendenteService.save(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dipendente update(@PathVariable Long id, @RequestBody DipendenteRequest request){
        return dipendenteService.update(id, request);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        dipendenteService.delete(id);
    }
}
