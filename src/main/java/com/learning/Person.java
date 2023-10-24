package com.learning;

import com.sun.istack.internal.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Person {

    @NonNull
    String name;

    @NonNull
    Gender gender;

    @NonNull
    int age;

    @NotNull
    int salary;


}
