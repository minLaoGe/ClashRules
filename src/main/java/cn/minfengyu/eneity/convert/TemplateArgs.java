package cn.minfengyu.eneity.convert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateArgs {
    Map<String, String> globalVars=Settings.templateVars;
    Map<String, String> requestParams;
    Map<String, String> localVars;
    Map<String, String> nodeList;
}