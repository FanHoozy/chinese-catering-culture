package org.bearer.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fyhz
 * @version 1.0
 * @date Created in 2023/10/20 14:35
 */
@Data
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 2178865368810790727L;

    private UserInfo userInfo;

    private String rawData;

    private String sgnature;

    private String encryptedData;

    private String iv;

    private String cloudId;
}
