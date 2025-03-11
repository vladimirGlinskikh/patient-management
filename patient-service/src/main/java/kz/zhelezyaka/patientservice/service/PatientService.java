package kz.zhelezyaka.patientservice.service;

import kz.zhelezyaka.patientservice.dto.PatientRequestDTO;
import kz.zhelezyaka.patientservice.dto.PatientResponseDTO;
import kz.zhelezyaka.patientservice.mapper.PatientMapper;
import kz.zhelezyaka.patientservice.model.Patient;
import kz.zhelezyaka.patientservice.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientMapper::toDTO)
                .toList();
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        Patient newPatient = patientRepository.save(
                PatientMapper.toModel(patientRequestDTO));
        return PatientMapper.toDTO(newPatient);
    }
}
