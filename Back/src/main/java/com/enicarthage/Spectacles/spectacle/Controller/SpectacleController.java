package com.enicarthage.Spectacles.spectacle.Controller;

import com.enicarthage.Spectacles.spectacle.Model.Spectacle;
import com.enicarthage.Spectacles.spectacle.Model.SpectacleGroupDTO;
import com.enicarthage.Spectacles.spectacle.Model.SpectacleGroupedByTitreDto;
import com.enicarthage.Spectacles.spectacle.Service.SpectacleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/spectacles")
public class SpectacleController {

    @Autowired
    private SpectacleService spectacleService;

    @GetMapping
    public List<Spectacle> getAll() {
        return spectacleService.getAllSpectacles();
    }

    @GetMapping("/{id}")
    public Spectacle getById(@PathVariable Long id) {
        return spectacleService.getSpectacleById(id);
    }

    @GetMapping("/search")
    public List<Spectacle> search(@RequestParam String titre) {
        return spectacleService.searchByTitre(titre);
    }

    @PostMapping
    public Spectacle save(@RequestBody Spectacle s) {
        return spectacleService.saveSpectacle(s);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        spectacleService.deleteSpectacle(id);
    }

    @GetMapping("/byTitreAndLieu")
    public List<Spectacle> getSpectaclesByTitreAndLieu(
            @RequestParam String titre,
            @RequestParam Long idLieu
    ) {
        return spectacleService.getSpectaclesByTitreAndIdLieu(titre, idLieu);
    }

    @GetMapping("/grouped")
    public List<SpectacleGroupDTO> getGroupedSpectacles() {
        return spectacleService.getGroupedSpectacles();
    }

    @GetMapping("/grouped-by-titre")
    public ResponseEntity<List<SpectacleGroupedByTitreDto>> getSpectaclesGroupedByTitre() {
        List<SpectacleGroupedByTitreDto> result = spectacleService.getSpectaclesGroupedByTitre();
        return ResponseEntity.ok(result);
    }



}

