package org.simon.demo02;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @date 2020-11-11
 * @since 1.0.0
 */
@Data
@Accessors(chain = true)
public class User {
    private Long id;
    private String username;
    private String password; // 密码
    private Integer sex;  // 性别
    private LocalDate birthday; // 生日
    private LocalDateTime createTime; // 创建时间
    private String config; // 其他扩展信息，以JSON格式存储
    private String test; // 测试字段
}