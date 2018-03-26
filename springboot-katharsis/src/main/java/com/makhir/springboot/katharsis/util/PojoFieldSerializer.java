package com.makhir.springboot.katharsis.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.makhir.springboot.katharsis.model.CustomerVo;

/**
 * This class is bean pojo serializer
 * 
 * */
public class PojoFieldSerializer extends SimpleBeanPropertyFilter {
	private static final Logger log = LoggerFactory.getLogger(PojoFieldSerializer.class);
	
	@Override
	protected boolean include(BeanPropertyWriter writer) {
		log.info("In PojoFieldSerializer.include()");
		log.info("### Writer Name BeanPropertyWriter : ---  {}", writer.getName());
		return true;
	}
	
	@Override
	protected boolean include(PropertyWriter writer) {
		log.info("In PojoFieldSerializer.include()");
		log.info("### Writer Name PropertyWriter : ---  {}", writer.getName());
		return true;
	}
	
	@Override
	public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer)
			throws Exception {
		log.info("Enter: PojoFieldSerializer.serializeAsField()");
		try {
			if(pojo instanceof CustomerVo){
				CustomerVo vo = (CustomerVo) pojo;
				
				if(vo.getOfficeAddress() == null)
					return;
				else
					//super.serializeAsField( pPojo, pJgen, pProvider, pWriter );
					super.serializeAsField(pojo, jgen, provider, writer);
			}
		} catch (Exception e) {
			log.error("serializeAsField --> exception : {}", e);
			e.printStackTrace();
		}
		
		finally {
			log.info("Exit: PojoFieldSerializer.serializeAsField()");
		}
	}
}
