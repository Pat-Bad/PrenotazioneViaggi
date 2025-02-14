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
    private final dipendenteService dipendenteService;

    @GetMapping("dipendenti")
    @ResponseStatus(HttpStatus.OK)
    public List<Dipendente> findAll(){
        return dipendenteService.findAll();
    }

    @GetMapping("dipendenti/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dipendente findById(@PathVariable Long id){
        return dipendenteService.findById(id);
    }

    @PostMapping("dipendenti")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateResponse save(@RequestBody dipendenteRequest request){
        return dipendenteService.save(request);
    }

    @PutMapping("dipendenti/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dipendente update(@PathVariable Long id, @RequestBody dipendenteRequest request){
        return dipendenteService.update(id, request);
    }
    @DeleteMapping("dipendenti/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        dipendenteService.delete(id);
    }
}
