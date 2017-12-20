//package ru.ivmiit.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import ru.itis.services.FilesService;
//
//import javax.servlet.http.HttpServletResponse;
//
//public class StorageController {
//
//    @Autowired
//    private FilesService service;
//
//    @GetMapping("files/{file-name:.+}")
//    public void getFile(@PathVariable("file-name") String filename, HttpServletResponse response){
//        service.writeFileToResponse(filename, response);
//    }
//}
