package kz.zhelezyaka.patientservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import kz.zhelezyaka.patientservice.dto.PatientRequestDTO;
import kz.zhelezyaka.patientservice.dto.PatientResponseDTO;
import kz.zhelezyaka.patientservice.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @Operation(summary = "Создание пациента", description = "Создает новых пациентов")
    public ResponseEntity<PatientResponseDTO> createPatient(
            @Valid @RequestBody PatientRequestDTO patientRequestDTO) {
        PatientResponseDTO patientResponseDTO = patientService.createPatient(patientRequestDTO);
        return ResponseEntity.ok().body(patientResponseDTO);
    }
}
