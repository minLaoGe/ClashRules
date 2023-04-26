package cn.minfengyu.dto;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConvertDTO {

    @NotBlank(message = "订阅类型不能为空=target")
    private String type;

    @NotEmpty(message = "链接地址不能为空=url")
    private List<String> links;


    private UnKnownEntityDto unKnownEntity=new UnKnownEntityDto();


    private String outConfig;
}
