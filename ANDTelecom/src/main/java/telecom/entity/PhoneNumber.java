package telecom.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numberId;

    @NotNull
    private String phoneNumber;

    @NotNull
    private Boolean activated;

    @ManyToOne
    private Customer customer;

    public Long getNumberId() {
        return numberId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public Customer getCustomer() {
        return customer;
    }
}
