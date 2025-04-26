package com.enicarthage.Spectacles.spectacle.Model;

import java.util.List;

public class SpectacleGroupedByTitreDto {
    private String titre;
    private List<SpectacleDetailsDto> representations;

    public String getTitre() {
        return titre;
    }

    public List<SpectacleDetailsDto> getRepresentations() {
        return representations;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setRepresentations(List<SpectacleDetailsDto> representations) {
        this.representations = representations;
    }
}