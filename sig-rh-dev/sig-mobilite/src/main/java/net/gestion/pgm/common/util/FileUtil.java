package net.gestion.pgm.common.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Component
public class FileUtil {

    public String getRootPathForAllFile(){
        Path path = Paths.get(System.getenv("APPDATA"), "ersto");
        return path.toString();
    }
    public Optional<String> getAbsoluteFilePath(String rootPath, String relativePath){
        if(relativePath !=null && rootPath!=null)
          return Optional.of(rootPath+"\\"+relativePath);
        return Optional.empty();
    }

    public byte[] readFileFromLocation(String pathFile) {
        try {
            return Files.readAllBytes(Paths.get(pathFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
