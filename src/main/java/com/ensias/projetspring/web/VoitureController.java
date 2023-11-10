package com.ensias.projetspring.web;


import com.ensias.projetspring.modele.Voiture;
import com.ensias.projetspring.modele.VoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class VoitureController {
    @Autowired
    private VoitureRepo voitureRepo;

    // Endpoint pour la suppression d'une voiture par ID
    @DeleteMapping("/voitures/{id}")
    public ResponseEntity<String> deleteVoiture(@PathVariable Long id) {
        try {
            // Vérifiez si la voiture avec l'ID spécifié existe
            if (voitureRepo.existsById(id)) {
                // Supprimez la voiture de la base de données
                voitureRepo.deleteById(id);
                return ResponseEntity.ok("Voiture supprimée avec succès");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la suppression de la voiture");
        }
    }

    // Endpoint pour la mise à jour d'une voiture par ID
    @PutMapping("/voitures/{id}")
    public ResponseEntity<String> updateVoiture(@PathVariable Long id, @RequestBody Voiture updatedVoiture) {
        try {
            // Vérifiez si la voiture avec l'ID spécifié existe
            if (voitureRepo.existsById(id)) {
                updatedVoiture.setId(id);
                voitureRepo.save(updatedVoiture); // Mettez à jour la voiture dans la base de données
                return ResponseEntity.ok("Voiture mise à jour avec succès");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la mise à jour de la voiture");
        }
    }

    @PostMapping("/voitures") // Endpoint pour l'ajout d'une nouvelle voiture
    public ResponseEntity<String> addVoiture(@RequestBody Voiture voiture) {
        try {
            Voiture savedVoiture = voitureRepo.save(voiture);
            return ResponseEntity.ok("Voiture ajoutée avec succès, ID : " + savedVoiture.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout de la voiture");
        }
    }

    @RequestMapping("/voitures")
    public Iterable<Voiture> getVoitures() {
        return voitureRepo.findAll();
    }
}

