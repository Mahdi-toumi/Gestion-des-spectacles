package com.enicarthage.Spectacles.spectacle.Model;

import java.util.List;

public class SpectacleGroupDTO {
    private String titre;
    private String lieu;
    private List<Spectacle> spectacles;

    public SpectacleGroupDTO(String titre, String lieu, List<Spectacle> spectacles) {
        this.titre = titre;
        this.lieu = lieu;
        this.spectacles = spectacles;
    }

    public String getTitre() {
        return titre;
    }

    public String getLieu() {
        return lieu;
    }

    public List<Spectacle> getSpectacles() {
        return spectacles;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setSpectacles(List<Spectacle> spectacles) {
        this.spectacles = spectacles;
    }
}
