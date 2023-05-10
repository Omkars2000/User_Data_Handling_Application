package org.jspider.Vertical_ask.controller;

import com.itextpdf.text.DocumentException;
import org.jspider.Vertical_ask.module.User;
import org.jspider.Vertical_ask.repository.UserRepository;
import org.jspider.Vertical_ask.service.ExcelUtil;
import org.jspider.Vertical_ask.service.PdfUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/o1")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/save")
    public void addUser(@RequestBody User user) {
        User savedUser=userRepository.save(user);

    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable int id, @RequestBody User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUserName(user.getUserName());
            existingUser.setUserEmail(user.getUserEmail());
            existingUser.setUserPhone(user.getUserPhone());
            userRepository.save(existingUser);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @PostMapping("/upload")
    public void uploadExcel(@RequestParam("file") MultipartFile file) throws IOException {
        List<User> users = ExcelUtil.readUsersFromExcel(file.getInputStream());
        userRepository.saveAll(users);
    }
    @GetMapping(value = "/report",produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> generateReport() throws IOException, DocumentException {
        List<User> users = userRepository.findAll();
        ByteArrayInputStream bis = PdfUtil.generatePdf(users);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=user_report.pdf");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}


