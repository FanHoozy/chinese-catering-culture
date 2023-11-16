package org.bearer.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fyhz
 * @version 1.0
 * @date Created in 2023/10/18 14:08
 */
@Data
public class Ids implements Serializable {

    private static final long serialVersionUID = -4394553501686660633L;

    /**
     * id
     */
    private String id;

    /**
     * 用户id
     */
    private String userId;
}
