package br.uem.iss.anesthesia.model.repository;

import br.uem.iss.anesthesia.model.entity.DoctorModel;
import br.uem.iss.anesthesia.model.entity.PatientModel;
import br.uem.iss.anesthesia.model.entity.ProcessModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
@Repository
@Transactional
public interface ProcessRepository extends CrudRepository<ProcessModel, Long> {

    Iterable<ProcessModel> findByActiveTrue();

    Iterable<ProcessModel> findByDoctorAndActiveTrue(DoctorModel doctorModel);

    Iterable<ProcessModel> findByPatientAndActiveTrue(PatientModel patientModel);

    Iterable<ProcessModel> findByPatientAndDoctorAndActiveTrue(PatientModel patientModel, DoctorModel doctorModel);

    Iterable<ProcessModel> findByPatientEquals(PatientModel patientModel);

    Iterable<ProcessModel> findByInicialDateAfter(LocalDate calendar);

    Iterable<ProcessModel> findByInicialDateBefore(LocalDate calendar);

    Iterable<ProcessModel> findByInicialDateBeforeAndPatientEquals(LocalDate dtfinal, PatientModel patientModel);

    Iterable<ProcessModel> findByInicialDateAfterAndPatientEquals(LocalDate dtinicial, PatientModel patientModel);

    Iterable<ProcessModel> findByInicialDateAfterAndInicialDateBefore(LocalDate dtinicial, LocalDate dtfinal);

    Iterable<ProcessModel> findByInicialDateAfterAndInicialDateBeforeAndPatientEquals(LocalDate dtinicial, LocalDate dtfinal, PatientModel patientModel);

    Iterable<ProcessModel> findByInicialDateBeforeAndInicialDateAfter(String calendarBefore, String calendarAfter);


    long count();
}
