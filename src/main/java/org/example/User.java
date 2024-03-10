package org.example;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private Long id;
    private String name;
    private String userRole;
}
