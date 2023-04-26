package cn.minfengyu.service.convert;

import cn.minfengyu.dto.ConvertDTO;
import cn.minfengyu.dto.ParseDTO;
import cn.minfengyu.result.BaseResult;

public interface Handle {

   BaseResult handleLinks(ParseDTO convertDTO);
}
