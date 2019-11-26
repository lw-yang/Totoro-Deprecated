package converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Long 转 String类型JsonSerializer
 * @author lwyang  2019/11/26
 */
public class Long2StringSerialize extends JsonSerializer<Long> {

    /**
     * 重写serialize方法，将value转换为String类型
     *
     * @param value 待转换的数据
     * @param gen JsonGenerator
     * @param serializers SerializerProvider
     * @throws IOException  throw IOException
     */
    @Override
    public void serialize(Long value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(String.valueOf(value));
    }
}
