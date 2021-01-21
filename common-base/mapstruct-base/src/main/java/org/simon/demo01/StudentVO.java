package org.simon.demo01;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 你搞忘写注释了
 *
 * @author zhang_zhang
 * @date 2020-11-11
 * @since 1.0.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentVO {
    private String name;
    private int age;
    private String gender;
    private Double height;
    private String birthday;
}