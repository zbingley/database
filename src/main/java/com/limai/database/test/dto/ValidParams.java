package com.limai.database.test.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.List;

/**
 * @author Zhang bin
 * @version [版本号, 2020/6/1 11:27]
 */
@Data
public class ValidParams {
    private String value;

    @Range(min = 10, max = 10, message = "size只能为10")
//    @Max(value = 10,message = "100")
//    @Min(value = 10,message = "101")
    private int size;

    @NotNull
    @Size(min = 1, max = 2, message = "list数量不对")
    private List<Integer> list;

    @Pattern(regexp = "//d[5]", message = "regex不合法")
    private String regex;
}
