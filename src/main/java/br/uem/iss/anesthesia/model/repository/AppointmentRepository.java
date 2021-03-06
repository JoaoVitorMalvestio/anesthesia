package br.uem.iss.anesthesia.model.repository;

import br.uem.iss.anesthesia.model.entity.AppointmentModel;
import br.uem.iss.anesthesia.model.entity.DoctorModel;
import br.uem.iss.anesthesia.model.entity.ProcessModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<AppointmentModel, Long> {


    List<AppointmentModel> findByDateBetween(LocalDateTime initial, LocalDateTime end);

    List<AppointmentModel> findByActiveTrue();

    List<AppointmentModel> findByDateBetweenAndProcessIn(LocalDateTime initial, LocalDateTime end, Iterable<ProcessModel> byDoctor);

    List<AppointmentModel> findByDateBetweenAndDoctor(LocalDateTime initial, LocalDateTime end, DoctorModel doctor);

    long count();
}
