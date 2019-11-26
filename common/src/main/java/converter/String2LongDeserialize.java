package converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * String转 Long类型JsonDeserializer
 *
 * @author lwyang  2019/11/26
 */
public class String2LongDeserialize extends JsonDeserializer<Long> {

    /**
     * 重写deserialize方法，将前端传入的数据转换为Long类型
     *
     * @param p JsonParser可以获取前端传入的数据
     * @param ctxt DeserializationContext上下文
     * @return 转换的Long类型数据
     * @throws IOException IOException
     * @throws JsonProcessingException JsonProcessingException
     */
    @Override
    public Long deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return Long.valueOf(p.getText());
    }
}
