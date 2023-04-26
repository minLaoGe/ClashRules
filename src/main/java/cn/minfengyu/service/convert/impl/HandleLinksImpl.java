package cn.minfengyu.service.convert.impl;

import cn.minfengyu.dto.ConvertDTO;
import cn.minfengyu.dto.ParseDTO;
import cn.minfengyu.result.BaseResult;
import cn.minfengyu.service.convert.HandleLinks;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HandleLinksImpl implements HandleLinks {

    private final  ClashHandle clashHandle;


    @Override
    public BaseResult handleLinks(ParseDTO convertDTO) {
        switch (convertDTO.getType()){
            case  "clash":
                return  clashHandle.handleLinks(convertDTO);

            default:
                throw new RuntimeException("没有找到此类型");
        }
    }
}
