package by.itacademy.entitytests;

import by.itacademy.entity.Review;
import by.itacademy.repository.ReviewRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ReviewTest extends BaseEntityTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void saveTest() {

        Review reviewFind = reviewRepository.findOne(1L);

        Assert.assertEquals(reviewFind.getUser().getLogin(), "max");
    }

}
