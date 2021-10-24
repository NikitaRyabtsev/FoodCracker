package by.htp.example;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeAdapter extends XmlAdapter<String, LocalTime> {
    @Override
    public LocalTime unmarshal(String time) throws Exception {
        return LocalTime.parse(time, DateTimeFormatter.ISO_TIME);
    }

    @Override
    public String marshal(LocalTime time) throws Exception {
        return DateTimeFormatter.ISO_TIME.format(time);
    }
}
