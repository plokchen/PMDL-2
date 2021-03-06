package models;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Patrick on 10/15/2016.
 */
@Entity
public class User extends Model {

    @Id
    public Long id;

    @Constraints.Required
    public String password;

    @ManyToMany(mappedBy = "users")
    @JsonManagedReference
    public List<Task> tasks;

    @ManyToMany
    @JsonManagedReference
    public List<Title> titles;

    public static Finder<Long, User> find = new Finder<Long,User>(User.class);
}
