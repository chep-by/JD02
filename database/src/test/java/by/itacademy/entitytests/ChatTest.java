package by.itacademy.entitytests;

import by.itacademy.entity.Chat;
import by.itacademy.repository.ChatLineRepository;
import by.itacademy.repository.ChatRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ChatTest extends BaseEntityTest {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    ChatLineRepository chatLineRepository;

    @Test
    public void saveChatTest() {

        Chat findChat = chatRepository.findOne(1L);

        Assert.assertTrue(findChat.getId() == 1L);
    }

}
