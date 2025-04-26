package com.enicarthage.Spectacles.spectacle.Model;

public class RepresentationDTO {
    private Long idSpec;
    private String titre;
    private String dates;
    private Double hDebut;
    private Integer durees;
    private String imagePath;
    private String imagePathVertical;
    private Long idLieu;
    private String nomLieu;
    private String adresse;
    private Integer capacite;
    private String url;
    private String ville;

    // Constructeur
    public RepresentationDTO(Long idSpec, String titre, String dates, Double hDebut, Integer durees,
                             String imagePath, String imagePathVertical,
                             Long idLieu, String nomLieu, String adresse, Integer capacite,
                             String url, String ville) {
        this.idSpec = idSpec;
        this.titre = titre;
        this.dates = dates;
        this.hDebut = hDebut;
        this.durees = durees;
        this.imagePath = imagePath;
        this.imagePathVertical = imagePathVertical;
        this.idLieu = idLieu;
        this.nomLieu = nomLieu;
        this.adresse = adresse;
        this.capacite = capacite;
        this.url = url;
        this.ville = ville;
    }

    public void setIdSpec(Long idSpec) {
        this.idSpec = idSpec;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Long getIdSpec() {
        return idSpec;
    }

    public String getTitre() {
        return titre;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setNomLieu(String nomLieu) {
        this.nomLieu = nomLieu;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDates() {
        return dates;
    }

    public Double gethDebut() {
        return hDebut;
    }

    public Integer getDurees() {
        return durees;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getImagePathVertical() {
        return imagePathVertical;
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

    public String getUrl() {
        return url;
    }

    public String getVille() {
        return ville;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public void sethDebut(Double hDebut) {
        this.hDebut = hDebut;
    }

    public void setDurees(Integer durees) {
        this.durees = durees;
    }

    public void setImagePathVertical(String imagePathVertical) {
        this.imagePathVertical = imagePathVertical;
    }

    public void setIdLieu(Long idLieu) {
        this.idLieu = idLieu;
    }

    // Getters et Setters
    // (génère automatiquement dans ton IDE)
}
