package com.skse.utils;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

/**
 * @author sukang
 */
public class JacksonUtil {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	private static Logger logger = LoggerFactory.getLogger(JacksonUtil.class);

	static {
		JavaTimeModule javaTimeModule = new JavaTimeModule();

		OBJECT_MAPPER.setTimeZone(TimeZone.getTimeZone(OffsetDateTime.now().getOffset()));

		/* 序列化配置,针对java8 时间 */
		javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

		javaTimeModule.addSerializer(LocalDate.class, new com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer(
				DateTimeFormatter.ofPattern("yyyy-MM-dd")));

		javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(
				DateTimeFormatter.ofPattern("HH:mm:ss")));

		/* 反序列化配置,针对java8 时间 */
		javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

		javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(
				DateTimeFormatter.ofPattern("yyyy-MM-dd")));

		javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(
				DateTimeFormatter.ofPattern("HH:mm:ss")));

		OBJECT_MAPPER.registerModule(javaTimeModule);

	}

	public static <T> T fromStrToObj(String jsonStr,Class<T> clazz){
		try {
			return OBJECT_MAPPER.readValue(jsonStr,clazz);
		}catch (Exception e){
			logger.error("json转换异常",e);
		}
		return null;
	}

	public static byte[] fromObjToByte(Object object){
		try {
			return OBJECT_MAPPER.writeValueAsBytes(object);
		}catch (Exception e){
			logger.error("序列化异常",e);
		}
		return null;
	}



	public static String toJsonStr (Object object){
		try {
			return OBJECT_MAPPER.writeValueAsString(object);
		}catch (Exception e){
			logger.error("json转换异常",e);
		}
		return "";
	}


}
