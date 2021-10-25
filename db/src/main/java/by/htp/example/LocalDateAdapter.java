package by.htp.example;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter <String, LocalDate>{

    @Override
    public LocalDate unmarshal(String date) throws Exception {
        return LocalDate.parse(date , DateTimeFormatter.ISO_DATE);
    }

    @Override
    public String marshal(LocalDate date) throws Exception {
        return DateTimeFormatter.ISO_DATE.format(date);
    }
}
