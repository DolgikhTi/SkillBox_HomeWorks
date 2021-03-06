package entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "name", "registrationDate"})

@Entity
@Table(name = "Students")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String name;

    private int age;

    @NonNull
    @Column(name = "registration_date")
    @Temporal(TemporalType.TIMESTAMP)
    Date registrationDate;

    @ManyToMany(mappedBy = "students", fetch = FetchType.LAZY)
    private List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "sbsKey.student", fetch = FetchType.LAZY)
    private List<Subscription> subscriptions;

    @OneToMany(mappedBy = "pKey.student", fetch = FetchType.LAZY)
    private List<Purchase> purchases;

    @Override
    public String toString() {
        return "Student " + id + ". " + name;
    }
}
