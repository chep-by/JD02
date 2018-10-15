package by.itacademy.repositorytests;

import by.itacademy.repository.ChatLineRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ChatLinesRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private ChatLineRepository chatLineRepository;

    @Test
    public void findAllByUser_LoginTest() {
        List<ChatLine> adminChats = chatLineRepository.findAllByUserLogin("admin");

        Assert.assertEquals(adminChats.size(), 2);


    }
}
