package com.devgang.ojakgyo.controller;

import com.devgang.ojakgyo.model.CodeGroup;
import com.devgang.ojakgyo.service.CodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/code")
public class CodeController {
    private final CodeService codeService;
    /**
     * 코드 그룹 전체 조회
     * @return List<CodeGroupDTO>
     */
    @GetMapping("/listGroup.do")
    public List<CodeGroup> listGroup() {
        return codeService.listGroup();
    }
}
