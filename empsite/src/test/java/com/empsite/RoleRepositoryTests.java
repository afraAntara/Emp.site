package com.empsite;
        import static org.assertj.core.api.Assertions.assertThat;

        import java.util.List;

        import com.empsite.entities.Role;
        import com.empsite.repositories.RoleRepository;
        import org.junit.jupiter.api.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
        import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
        import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
        import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {

    @Autowired private RoleRepository repo;

    @Test
    public void testCreateRoles() {
        Role admin = new Role("Admin");
        Role user = new Role("User");
        Role company = new Role("Company");

        repo.saveAll(List.of(admin, user, company));

        List<Role> listRoles = repo.findAll();

        assertThat(listRoles.size()).isEqualTo(3);
    }

}