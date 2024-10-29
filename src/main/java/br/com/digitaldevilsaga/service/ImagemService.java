package br.com.digitaldevilsaga.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

import org.springframework.stereotype.Service;

@Service
public class ImagemService {

    public ImagemService(){}

    public String imagemPadraoBase64(){
        try{
            Path path = Path.of("src/main/resources/static/images", "brinquedo padrao.png");
            byte[] imagemBytes = Files.readAllBytes(path);
            return Base64.getEncoder().encodeToString(imagemBytes);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
