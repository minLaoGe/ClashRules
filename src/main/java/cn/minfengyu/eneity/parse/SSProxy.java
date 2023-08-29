package cn.minfengyu.eneity.parse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SSProxy extends BaseProxye {
    private String password;
    private String cipher;
}
