package by.itacademy.entitytests;

import by.itacademy.repository.ChatLineRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ChatLinesTest extends BaseEntityTest {

    @Autowired
    private ChatLineRepository chatLineRepository;

    @Test
    public void saveTest() {

        ChatLine chatLine1 = chatLineRepository.findOne(1L);

        Assert.assertEquals(chatLine1.getChat().getId(), 1);
    }

}
