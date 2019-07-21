package com.example.demoamposrestaurant.business.converter;

import com.example.demoamposrestaurant.persistent.domain.Type;
import com.example.demoamposrestaurant.presentation.payload.TypePayload;
import org.springframework.stereotype.Component;

@Component
public class TypeConverter {

    public TypePayload toPayload(Type type) {
        TypePayload payload = new TypePayload();
        payload.setId(type.getId());
        payload.setName(type.getName());
        return payload;
    }
}
