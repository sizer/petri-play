/*
 * The MIT License
 *
 * Copyright 2015 shinse.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package mrdshinse.petri.web.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 *
 * @author mrdShinse
 */
public class JsonUtil {

    /**
     * Default constructor
     */
    private JsonUtil() {

    }

    /**
     * The Object Mapper
     */
    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        //not null option
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    /**
     * Transform JSON String to Bean(Type parameter).
     *
     * @param jsonStr JSON String
     * @param bean response bean
     * @param <T> The type of response bean
     * @return obj transformed JSON String.
     */
    public static <T> T transformToBean(String jsonStr, Class<T> bean) {
        T obj;
        try {
            obj = mapper.readValue(jsonStr, bean);
        } catch (IOException e) {
            //TODO dont return null. return Option class or throw Exception.
            obj = null;
        }
        return obj;
    }

}
