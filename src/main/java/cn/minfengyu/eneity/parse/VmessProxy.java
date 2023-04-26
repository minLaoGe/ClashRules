package cn.minfengyu.eneity.parse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VmessProxy extends BaseProxye {
    private Integer alterId;
    private String cipher;

}
