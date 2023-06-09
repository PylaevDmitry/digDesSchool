package com.digdes.java2023.dto.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Сотрудник. Данные на вход по операциям создания")
public class CreateEmployeeDto {

    @Schema(description = "Фамилия")
    private String lastName;

    @Schema(description = "Имя")
    private String name;

    @Schema(description = "Отчество")
    private String patronymic;

    @Schema(description = "Должность")
    private String position;

    @Schema(description = "Учетная запись сотрудника")
    private String account;

    @Schema(description = "Адрес электронной почты")
    private String email;

    @Schema(description = "Логин")
    private String username;

    @Schema(name = "Пароль")
    private String password;
}
