package com.enicarthage.Spectacles.spectacle.Repository;

import com.enicarthage.Spectacles.spectacle.Model.Spectacle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface SpectacleRepository extends JpaRepository<Spectacle, Long> {
    List<Spectacle> findByTitreContainingIgnoreCase(String titre);

    @Query("SELECT s FROM Spectacle s WHERE LOWER(TRIM(s.titre)) = LOWER(TRIM(:titre)) AND s.lieu.id = :idLieu")
    List<Spectacle> findByTitreAndIdLieu(@Param("titre") String titre, @Param("idLieu") Long idLieu);

    @Query("SELECT s.titre as titre, s.id as idSpec, s.date as dates, " +
            "s.heureDebut as hDebut, s.duree as durees, " +
            "s.imagePath as imagePath, s.imagePathVertical as imagePathVertical, " +
            "l.id as idLieu, l.nom as nomLieu, l.adresse as adresse, " +
            "l.capacite as capacite,l.url as url, l.ville as ville " +
            "FROM Spectacle s JOIN s.lieu l " +
            "ORDER BY s.titre, s.date")
    List<Map<String, Object>> findAllGroupableRepresentations();

}

