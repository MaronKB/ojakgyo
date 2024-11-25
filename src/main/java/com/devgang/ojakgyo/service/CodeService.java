package com.devgang.ojakgyo.service;

import com.devgang.ojakgyo.model.CodeGroup;
import com.devgang.ojakgyo.repository.CodeGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CodeService {
    private final CodeGroupRepository codeGroupRepository;

    public List<CodeGroup> listGroup() {
        return codeGroupRepository.findAll();
    }
}
