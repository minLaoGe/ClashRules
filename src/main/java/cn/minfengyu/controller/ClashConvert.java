package cn.minfengyu.controller;


import cn.minfengyu.dto.ConvertDTO;
import cn.minfengyu.dto.ParseDTO;
import cn.minfengyu.result.BaseResult;
import cn.minfengyu.service.convert.HandleLinks;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/convert")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClashConvert {

    private final HandleLinks handleLinks;



    @PostMapping("/parse")
    public BaseResult parseVlessConfig(@RequestBody ParseDTO convertDTO ) {
        return handleLinks.handleLinks(convertDTO);
        // 解析逻辑将在这里实现
    }

}
