package me.student2026.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.student2026.exception.FileAlreadyExistsException;
import me.student2026.exception.ResourceNotFoundException;
import me.student2026.model.FileUploadForm;
import me.student2026.model.Tiket;
import me.student2026.model.UploadedFile;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Dependent
public class TiketService {

    @Inject
    private EntityManager em;

    @Transactional
    public Tiket createTiket(Tiket tiket) throws ResourceNotFoundException {
        if (tiket == null) {
            throw new ResourceNotFoundException("Tiket nije proslijedjen");
        }
        if (tiket.getNaslov() == null || tiket.getNaslov().isEmpty()) {
            throw new ResourceNotFoundException("Naslov je prazan");
        }
        if (tiket.getOpis() == null || tiket.getOpis().isEmpty()) {
            throw new ResourceNotFoundException("Opis je prazan");
        }
        if (tiket.getRok() == null) {
            throw new ResourceNotFoundException("Rok nije proslijedjen");
        }
        return em.merge(tiket);
    }

    @Transactional
    public List<Tiket> getAllTiketi() throws ResourceNotFoundException {
        List<Tiket> tiketi = em.createQuery("from Tiket", Tiket.class).getResultList();
        if (tiketi.isEmpty()) {
            throw new ResourceNotFoundException("Nema tiketa.");
        }
        return tiketi;
    }

    public List<Tiket> getByNaslov(String naslov) {
        return em.createQuery("SELECT t FROM Tiket t WHERE t.naslov LIKE :naslov", Tiket.class)
                .setParameter("naslov", "%" + naslov + "%")
                .getResultList();
    }

    public Tiket getById(Long id) {
        Tiket tiket = em.find(Tiket.class, id);
        if (tiket == null) {
            throw new ResourceNotFoundException("Tiket sa id=" + id + " nije pronađen.");
        }
        return tiket;
    }

    @Transactional
    public Tiket uploadFileToTiket(Long tiketId, FileUploadForm form) {
        Tiket tiket = getById(tiketId);

        String uploadDir = System.getProperty("user.home") + "/uploads/";
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File destFile = new File(uploadDir + form.filename);
        if (destFile.exists()) {
            throw new FileAlreadyExistsException("Fajl '" + form.filename + "' vec postoji na putanji: " + destFile.getAbsolutePath());
        }

        try {
            Files.copy(form.file.uploadedFile(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Greška pri čuvanju fajla: " + e.getMessage());
        }

        UploadedFile uploadedFile = new UploadedFile();
        uploadedFile.setFilename(destFile.getAbsolutePath());

        tiket.getUploadedFiles().add(uploadedFile);
        return em.merge(tiket);
    }

    public Tiket getTiketWithFiles(Long id) {
        Tiket tiket = getById(id);
        for (UploadedFile uf : tiket.getUploadedFiles()) {
            uf.setFile(new File(uf.getFilename()));
        }
        return tiket;
    }
}
