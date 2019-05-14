package fr.imie.contact;

import javax.persistence.*;
import java.time.*;
import java.sql.*;

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {
	
    @Override
    public Date convertToDatabaseColumn(LocalDate date) {
    	return date == null ? null : Date.valueOf(date);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
    	return date == null ? null : date.toLocalDate();
    }

}
