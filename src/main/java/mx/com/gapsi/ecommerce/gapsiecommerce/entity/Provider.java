package mx.com.gapsi.ecommerce.gapsiecommerce.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "provider")
public class Provider implements Serializable{

    public Provider(String name, String lastName, Date createAt, String businessName, String address){
        this.name = name;
        this.lastName = lastName;
        this.createAt = createAt;
        this.businessName = businessName;
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincrement
    private Long id;

    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "business_name", nullable = false)
    private String businessName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "create_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt; 

    @Column(name = "update_at", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt; 

    //If to know branch is neccesary
    @JoinColumn(name = "id_branch", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Branch branch;
}
