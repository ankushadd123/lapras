package com.lapras.cv.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lapras.cv.model.cv.ResumeFormDTO;
import com.lapras.cv.service.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class LaprasController {

    @Autowired
    private CVService cvService;

    @PostMapping("/generate/cv")
    public ResponseEntity<byte[]> generateCV(@RequestBody ResumeFormDTO resumeFormDTOForm) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header("Content-Disposition", "attachment; filename=" + "CV.pdf")
                .body(this.cvService.generate(resumeFormDTOForm));
    }

    @GetMapping("/check")
    public String check() {
        return "Hello there I am working fine";
    }

    @GetMapping("/generate/sample")
    public ResponseEntity generateSampleCV() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header("Content-Disposition", "attachment; filename=" + "CV.pdf")
                .body(this.cvService.generateSampleCV());
    }
}
