package org.bearer.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fyhz
 * @version 1.0
 * @date Created in 2023/10/19 14:40
 */
@Data
public class PostId implements Serializable {

    private static final long serialVersionUID = -282418213157409325L;

    private String id;
}
