package com.kolaysoft.proje._yonetimi.config;

import com.kolaysoft.proje._yonetimi.dto.ProjectDto;
import com.kolaysoft.proje._yonetimi.entity.Project;
import com.kolaysoft.proje._yonetimi.enums.ProjectStatus;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(ProjectDto.class, Project.class).addMappings(mapper ->
                mapper.map(dto -> {
                    String status = dto.getStatus();
                    return status != null ? ProjectStatus.valueOf(status.toUpperCase()) : null;
                }, Project::setStatus)
        );

        return modelMapper;
    }
}
