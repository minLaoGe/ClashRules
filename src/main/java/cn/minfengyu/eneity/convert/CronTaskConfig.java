package cn.minfengyu.eneity.convert;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CronTaskConfig {
    String Name;
    String CronExp;
    String Path;
    Integer Timeout = 0;
}