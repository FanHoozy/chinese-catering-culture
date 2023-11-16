package org.bearer.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fyhz
 * @version 1.0
 * @date Created in 2023/10/4 16:16
 */
@Data
public class SignUp implements Serializable {

    private static final long serialVersionUID = 262466067845685623L;

    private String username;
    private String password;
}
