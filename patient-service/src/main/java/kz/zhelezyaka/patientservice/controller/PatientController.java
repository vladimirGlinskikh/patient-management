package kz.zhelezyaka.patientservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.zhelezyaka.patientservice.dto.PatientResponseDTO;
import kz.zhelezyaka.patientservice.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
@Tag(name = "Пациенты",
        description = "Эндпоинты для работы с пациентами")
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    @Operation(summary = "Возвращает пациентов", description = "Возвращает всех пациентов")
    public ResponseEntity<List<PatientResponseDTO>> getPatients() {
        List<PatientResponseDTO> patients = patientService.getPatients();
        return ResponseEntity.ok().body(patients);
    }
}
