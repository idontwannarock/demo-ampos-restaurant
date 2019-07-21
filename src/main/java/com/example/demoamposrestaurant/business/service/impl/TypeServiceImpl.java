package com.example.demoamposrestaurant.business.service.impl;

import com.example.demoamposrestaurant.business.converter.TypeConverter;
import com.example.demoamposrestaurant.business.service.TypeService;
import com.example.demoamposrestaurant.persistent.repository.TypeRepository;
import com.example.demoamposrestaurant.presentation.payload.TypePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("typeService")
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private TypeConverter converter;

    @Override
    public List<TypePayload> getAllTypePayloads() {
        return typeRepository.findAll(Sort.by("id").ascending())
                .stream().map(converter::toPayload).collect(Collectors.toList());
    }
}
