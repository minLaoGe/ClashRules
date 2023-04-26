package cn.minfengyu.eneity.convert;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegexMatchConfig {
    private String match;
    private String replace;
    private String script;

}