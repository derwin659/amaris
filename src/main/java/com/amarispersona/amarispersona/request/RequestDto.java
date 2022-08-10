package com.amarispersona.amarispersona.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@Getter
@Setter
@ToString
public class RequestDto implements Serializable {

    @NotBlank
    @NotNull
    @Length(max=1,message = "El caracter debe ser iguai a 1")
    private String typeDocument;

    @NotBlank
    @NotNull
    private String numberDocument;

    @NotBlank
    @NotNull
    private String firstName;

    @NotBlank
    @NotNull
    private String secondName;

    @NotBlank
    @NotNull
    private String firstLastName;

    @NotBlank
    @NotNull
    private String secondLastName;

    @NotBlank
    @NotNull
    private String phone;

    @NotBlank
    @NotNull
    private String address;

    @NotBlank
    @NotNull
    private String cityResidency;
}
