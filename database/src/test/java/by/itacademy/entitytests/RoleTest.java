package by.itacademy.entitytests;

import by.itacademy.repository.RoleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleTest extends BaseEntityTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void saveRoleTest() {

        Role role1 = roleRepository.findOne(1L);

        Assert.assertEquals(role1.getRole(), "admin");
    }

}
