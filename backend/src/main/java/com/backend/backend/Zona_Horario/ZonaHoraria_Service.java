package com.backend.backend.Zona_Horario;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ZonaHoraria_Service {

    public String obtenerDiaSemanaEnEspañol() {
        // Mapeo de nombres de días en inglés a español
        Map<String, String> dayTranslations = new HashMap<>();
        dayTranslations.put("MONDAY", "Lunes");
        dayTranslations.put("TUESDAY", "Martes");
        dayTranslations.put("WEDNESDAY", "Miercoles");
        dayTranslations.put("THURSDAY", "Jueves");
        dayTranslations.put("FRIDAY", "Viernes");
        dayTranslations.put("SATURDAY", "Sabado");
        dayTranslations.put("SUNDAY", "Domingo");

        // Obtener la zona horaria UTC-04:00
        ZoneId zoneId = ZoneId.of("UTC-04:00");
        // Obtener la fecha actual en la zona horaria especificada
        LocalDate currentDate = LocalDate.now(zoneId);
        // Obtener el día de la semana actual
        DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();
        // Convertir el día de la semana a texto en inglés
        String dayOfWeekEnglish = currentDayOfWeek.toString();
        // Obtener el nombre del día en español a partir del mapeo
        return dayTranslations.get(dayOfWeekEnglish);
    }

    public LocalTime obtenerHoraEnZonaHoraria() {
        // Obtener la hora actual en la zona horaria UTC-04:00
        return LocalTime.now(ZoneId.of("UTC-04:00"));
    }

    public Date obtenerFecha() {
        // Obtener la zona horaria UTC-04:00
        ZoneId zoneId = ZoneId.of("UTC-04:00");
        // Obtener la fecha actual en la zona horaria especificada
        LocalDate currentDate = LocalDate.now(zoneId);
        // Convertir LocalDate a ZonedDateTime
        ZonedDateTime zonedDateTime = currentDate.atStartOfDay(zoneId);
        // Convertir ZonedDateTime a Date
        return Date.from(zonedDateTime.toInstant());
    }
}
