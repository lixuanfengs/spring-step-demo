package converter;
import com.cactusli.springframework.core.convert.converter.Converter;

/**
 * Created by cactusli on 2022/12/29 15:42
 */

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public class StringToIntegerConverter implements Converter<String, Integer> {

    @Override
    public Integer convert(String source) {
        return Integer.valueOf(source);
    }
}
