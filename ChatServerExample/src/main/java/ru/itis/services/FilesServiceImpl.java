//package ru.ivmiit.services;
//
//import lombok.SneakyThrows;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//import ru.itis.models.File;
//import ru.itis.repositories.FilesRepository;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.FileInputStream;
//import java.io.InputStream;
//
//@Service
//public class FilesServiceImpl implements FilesService {
//
//    @Value("${storage.path}")
//    private String storagePath;
//
//    @Autowired
//    private FilesRepository filesRepository;
//
//    @Override
//    public String saveFile(Authentication authentication, MultipartFile file) {
//        return null;
//    }
//
//    @Override
//    @SneakyThrows
//    public void writeFileToResponse(String fileName, HttpServletResponse response) {
//
//        File file = filesRepository.findFirstByStorageName(fileName);
//        response.setContentType(file.getType());
//        InputStream inputStream = new FileInputStream(new java.io.File(file.getUrl()));
//        org.apache.commons.io.IOUtils.copy(inputStream, response.getOutputStream());
//        response.flushBuffer();
//    }
//}
