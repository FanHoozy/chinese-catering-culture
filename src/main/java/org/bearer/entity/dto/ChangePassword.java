package org.bearer.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fyhz
 * @version 1.0
 * @date Created in 2023/10/19 14:07
 */
@Data
public class ChangePassword implements Serializable {

    private static final long serialVersionUID = -4923055044725171844L;

    private String id;
    private String password;
    private String oldPassword;
}
