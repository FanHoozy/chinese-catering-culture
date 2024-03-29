package org.bearer.entity.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fyhz
 * @version 1.0
 * @date Created in 2023/10/20 12:54
 */
@Data
@ApiModel
public class TestDTO implements Serializable {

    private static final long serialVersionUID = -515825530386904864L;

    private Date date;
}
