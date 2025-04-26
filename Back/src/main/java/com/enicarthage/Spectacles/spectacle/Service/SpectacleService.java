package com.enicarthage.Spectacles.spectacle.Service;

import com.enicarthage.Spectacles.spectacle.Model.*;
import com.enicarthage.Spectacles.spectacle.Repository.SpectacleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SpectacleService {

    @Autowired
    private SpectacleRepository spectacleRepository;

    public List<Spectacle> getAllSpectacles() {
        return spectacleRepository.findAll();
    }

    public Spectacle getSpectacleById(Long id) {
        return spectacleRepository.findById(id).orElse(null);
    }

    public List<Spectacle> searchByTitre(String titre) {
        return spectacleRepository.findByTitreContainingIgnoreCase(titre);
    }

    public Spectacle saveSpectacle(Spectacle s) {
        return spectacleRepository.save(s);
    }

    public void deleteSpectacle(Long id) {
        spectacleRepository.deleteById(id);
    }
    public List<Spectacle> getSpectaclesByTitreAndIdLieu(String titre, Long idLieu) {
        return spectacleRepository.findByTitreAndIdLieu(titre, idLieu);
    }
  /*  @Autowired
    private SpectacleRepository spectacleRepository;*/

    public List<SpectacleGroupedByTitreDto> getSpectaclesGroupedByTitre() {
        List<Map<String, Object>> rawData = spectacleRepository.findAllGroupableRepresentations();

        Map<String, List<SpectacleDetailsDto>> groupedByTitre = new LinkedHashMap<>();

        for (Map<String, Object> row : rawData) {
            String titre = (String) row.get("titre");

            SpectacleDetailsDto details = new SpectacleDetailsDto();
            details.setIdSpec((Long) row.get("idSpec"));
            details.setDates((LocalDate) row.get("dates"));
            details.sethDebut((BigDecimal) row.get("hDebut"));
            details.setDurees((BigDecimal) row.get("durees"));
            details.setImagePath((String) row.get("imagePath"));
            details.setImagePathVertical((String) row.get("imagePathVertical"));
            details.setTitre((String) row.get("titre"));
            LieuDto lieu = new LieuDto();
            lieu.setIdLieu((Long) row.get("idLieu"));
            lieu.setNomLieu((String) row.get("nomLieu"));
            lieu.setAdresse((String) row.get("adresse"));
            lieu.setCapacite((Integer) row.get("capacite"));
            lieu.setVille((String) row.get("ville"));
            lieu.setUrl((String) row.get("url"));
            details.setLieu(lieu);

            groupedByTitre.computeIfAbsent(titre, k -> new ArrayList<>()).add(details);
        }

        return groupedByTitre.entrySet().stream()
                .map(entry -> {
                    SpectacleGroupedByTitreDto dto = new SpectacleGroupedByTitreDto();
                    dto.setTitre(entry.getKey());
                    dto.setRepresentations(entry.getValue());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public List<SpectacleGroupDTO> getGroupedSpectacles() {
        List<Spectacle> allSpectacles = spectacleRepository.findAll();

        return allSpectacles.stream()
                .collect(Collectors.groupingBy(s ->
                        s.getTitre() + "|" + s.getLieu().getNom() // clé de groupement
                ))
                .entrySet()
                .stream()
                .map(entry -> {
                    String[] keyParts = entry.getKey().split("\\|");
                    return new SpectacleGroupDTO(
                            keyParts[0],
                            keyParts[1],
                            entry.getValue()
                    );
                })
                .collect(Collectors.toList());
    }




}

