package com.snda.sysdev.gplusshop.web.util;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * @author liudong.leo
 * @since 2013-07-15 16:24
 */
public class CustomDateSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeString(DateUtil.format(value, DateUtil.C_TIME_PATTON_DEFAULT));
    }
}
