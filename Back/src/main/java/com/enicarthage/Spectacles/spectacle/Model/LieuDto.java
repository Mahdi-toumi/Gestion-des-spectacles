package com.enicarthage.Spectacles.spectacle.Model;

public class LieuDto {
    private Long idLieu;
    private String nomLieu;
    private String adresse;
    private Integer capacite;
    private String ville;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setIdLieu(Long idLieu) {
        this.idLieu = idLieu;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNomLieu(String nomLieu) {
        this.nomLieu = nomLieu;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public Long getIdLieu() {
        return idLieu;
    }

    public String getNomLieu() {
        return nomLieu;
    }

    public String getAdresse() {
        return adresse;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public String getVille() {
        return ville;
    }
}