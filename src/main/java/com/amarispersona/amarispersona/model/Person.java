package com.amarispersona.amarispersona.model;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "tbl_persona")
public class Person extends BaseEntity{

    public Person(Long id) {
        super(id);
    }

    private static final String TYPE_DOCUMENT= "TYPE_DOCUMENT";
    private static final String NUMBER_DOCUMENT= "NUMBER_DOCUMENT";
    private static final String FIRST_NAME= "FIRST_NAME";
    private static final String SECOND_NAME= "SECOND_NAME";
    private static final String FIRST_LAST_NAME= "FIRST_LAST_NAME";
    private static final String SECOND_LAST_NAME= "SECOND_LAST_NAME";
    private static final String PHONE= "PHONE";
    private static final String ADDRESS= "ADDRESS";
    private static final String CITY_RESIDENCY= "CITY_RESIDENCY";



    @Column(name = TYPE_DOCUMENT)
    private String typeDocument;


    @Column(name = NUMBER_DOCUMENT,unique = true)
    private String numberDocument;


    @Column(name = FIRST_NAME)
    private String firstName;


    @Column(name = SECOND_NAME)
    private String secondName;


    @Column(name = FIRST_LAST_NAME)
    private String firstLastName;


    @Column(name = SECOND_LAST_NAME)
    private String secondLastName;


    @Column(name = PHONE)
    private String phone;


    @Column(name = ADDRESS)
    private String address;


    @Column(name = CITY_RESIDENCY)
    private String cityResidency;

    @Override
    public String toString() {
        return "Person{" +
                "typeDocument='" + typeDocument + '\'' +
                ", numberDocument='" + numberDocument + '\'' +
                ", firstDocument='" + firstName + '\'' +
                ", secondDocument='" + secondName + '\'' +
                ", firstLastName='" + firstLastName + '\'' +
                ", secondLastName='" + secondLastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", cityResidency='" + cityResidency + '\'' +
                '}';
    }
}
