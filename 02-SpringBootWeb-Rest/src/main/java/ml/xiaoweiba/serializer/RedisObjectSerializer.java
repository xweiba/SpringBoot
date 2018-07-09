package ml.xiaoweiba.serializer;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * @program: demo
 * @description: 实现对象序列化接口
 * @author: Mr.xweiba
 * @create: 2018-06-28 23:08
 **/

/*
* 除了String类型，实战中我们还经常会在Redis中存储对象，这时候我们就会想是否可以使用类似RedisTemplate<String, User>来初始化并进行操作。
* 但是Spring Boot并不支持直接使用，需要我们自己实现RedisSerializer<T>接口来对传入对象进行序列化和反序列化，下面我们通过一个实例来完成对象的读写操作。
* */


public class RedisObjectSerializer implements RedisSerializer<Object>{

    private Converter<Object, byte[]> serializer = new SerializingConverter();
    private Converter<byte[], Object>  deserializer = new DeserializingConverter();

    static final byte[] EMPTY_ARRAY = new byte[0];

    @Override
    public byte[] serialize(Object o) throws SerializationException {
        if (o == null){
            return EMPTY_ARRAY;
        }
        try {
            return serializer.convert(o);
        } catch (Exception ex) {
            return EMPTY_ARRAY;
        }
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (isEmpty(bytes)) {
            return null;
        }
        try {
            return deserializer.convert(bytes);
        } catch (Exception ex) {
            throw new SerializationException("Cannot deserializer", ex);
        }
    }

    private boolean isEmpty(byte[] data) {
        return (data == null || data.length == 0);
    }
}
