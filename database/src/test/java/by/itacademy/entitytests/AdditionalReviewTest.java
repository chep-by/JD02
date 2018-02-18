package by.itacademy.entitytests;

import by.itacademy.entity.AdditionalReview;
import by.itacademy.repository.AdditionalReviewRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdditionalReviewTest extends BaseEntityTest {

    @Autowired
    private AdditionalReviewRepository additionalReviewRepository;

    @Test
    public void saveAdditionalReviewTest() {

        AdditionalReview one = additionalReviewRepository.findOne(1L);

        Assert.assertEquals(one.getReview().getUser().getLogin(), "max");
    }
}
