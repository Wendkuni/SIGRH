package mr.sigrh.sigsanctionsrecompenses.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileStorageService {

    @Value("${file.storage.location}")
    private String storageLocation;

    @PostConstruct
    public void init() {
        try {
            Path storagePath = Paths.get(storageLocation).toAbsolutePath().normalize();
            Files.createDirectories(storagePath);
            System.out.println("Répertoire de stockage prêt}"+storagePath);
        } catch (IOException ex) {
            System.out.println("Impossible de créer le répertoire de stockage"+ex);
            throw new RuntimeException("Impossible de créer le répertoire de stockage", ex);
        }
    }

    public String storeFile(MultipartFile file) throws IOException {
        validateFile(file);

        String fileName = UUID.randomUUID().toString() + "_" + sanitizeFileName(Objects.requireNonNull(file.getOriginalFilename()));
        Path targetLocation = getFilePath(fileName);

        log.info("Enregistrement du fichier à l'emplacement : {}", targetLocation);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

        return fileName;
    }

    public Path loadFile(String fileName) {
        Path filePath = getFilePath(fileName);
        log.info("Chargement du fichier depuis l'emplacement : {}", filePath);
        return filePath;
    }

    public void deleteFile(String fileName) throws IOException {
        Path filePath = getFilePath(fileName);
        log.info("Suppression du fichier à l'emplacement : {}", filePath);
        Files.deleteIfExists(filePath);
    }

    private Path getFilePath(String fileName) {
        return Paths.get(storageLocation).resolve(fileName).normalize().toAbsolutePath();
    }

    private void validateFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("Impossible de sauvegarder un fichier vide.");
        }
    }

    private String sanitizeFileName(String fileName) {
        return fileName.replaceAll("[^a-zA-Z0-9\\._-]", "_");
    }
}
