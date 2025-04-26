package com.enicarthage.Spectacles.spectacle.Model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class SpectacleDetailsDto {
    private Long idSpec;
    private LocalDate dates;
    private BigDecimal hDebut;
    private BigDecimal durees;
    private LieuDto lieu;
    private String imagePath;
    private String imagePathVertical;
    private String titre;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getImagePath() {
        return imagePath;
    }

    public String getImagePathVertical() {
        return imagePathVertical;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setImagePathVertical(String imagePathVertical) {
        this.imagePathVertical = imagePathVertical;
    }

    public Long getIdSpec() {
        return idSpec;
    }

    public LocalDate getDates() {
        return dates;
    }

    public BigDecimal gethDebut() {
        return hDebut;
    }

    public BigDecimal getDurees() {
        return durees;
    }

    public LieuDto getLieu() {
        return lieu;
    }

    public void setIdSpec(Long idSpec) {
        this.idSpec = idSpec;
    }

    public void setDates(LocalDate dates) {
        this.dates = dates;
    }

    public void sethDebut(BigDecimal hDebut) {
        this.hDebut = hDebut;
    }

    public void setDurees(BigDecimal durees) {
        this.durees = durees;
    }

    public void setLieu(LieuDto lieu) {
        this.lieu = lieu;
    }
}