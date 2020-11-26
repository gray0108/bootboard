package com.gray.bootboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing /* JPA Auditing 기능을 사용하기 위해 애너테이션 추가 */
@SpringBootApplication
public class BootboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootboardApplication.class, args);
    }

}
