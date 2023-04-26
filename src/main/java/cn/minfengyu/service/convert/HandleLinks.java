package cn.minfengyu.service.convert;

import cn.minfengyu.dto.ConvertDTO;
import cn.minfengyu.dto.ParseDTO;
import cn.minfengyu.result.BaseResult;

public interface HandleLinks {

    public BaseResult handleLinks(ParseDTO convertDTO);
}
