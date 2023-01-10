package converter;

import com.cactusli.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by cactusli on 2022/12/29 15:43
 */
public class StringToLocalDateConverter implements Converter<String, LocalDate> {

    private final DateTimeFormatter DATE_TIME_FORMATTER;

    public StringToLocalDateConverter(String pattern) {
        DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(pattern);
    }
    @Override
    public LocalDate convert(String source) {
        return  LocalDate.parse(source, DATE_TIME_FORMATTER);
    }
}
